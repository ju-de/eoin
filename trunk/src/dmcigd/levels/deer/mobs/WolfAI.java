package dmcigd.levels.deer.mobs;

import dmcigd.core.enums.Direction;
import dmcigd.core.room.Room;
import dmcigd.core.objects.monsters.*;

abstract class WolfAI extends HitpointHandler {

	//Very similar to to the rabbit AI. There's probably a better way to abstract
	//"dumb" AI.
	
	private boolean isAggravated,isAttacking;
	private Room room;
	private int deathClock, deathClockLimit, aiClock, aiClockReset;
	
	abstract void die();
	
	abstract void moveLeft();
	abstract void moveRight();

	public void attack() {
		setSequence(2);
		isAttacking = true;
		accelerate(32, 0, Direction.RIGHT);
		setFrameSpeed(0.12f);
		setVX(0);
	}
	
	public void flicker(boolean flicker) {
		setSequence(0);
		if(flicker) {
			setFrame(0);
		}else{
			setFrame(2);
		}
	}
	
	public void idle() {
		setSequence(0);
		setFrameSpeed(0.02f);
		accelerate(32, 0, Direction.RIGHT);
		setVX(0);
	}
	
	public boolean onAttack(int damage, boolean swordflipped) {
		flipped = !swordflipped;
		isAggravated = true;
		return super.onAttack(damage, swordflipped);
	}
	
	public void setRoom(Room room) {
		this.room = room;
	}
	
	public void setDeathClockLimit(int deathClockLimit) {
		this.deathClockLimit = deathClockLimit;
	}
	
	public void setAIClockReset(int aiClockReset) {
		this.aiClockReset = aiClockReset;
	}
	
	public boolean isDestroyed() {
		if(isDestroyed && deathClock >= deathClockLimit) {
			return true;
		}
		return false;
	}
	
	public void think() {
		
		if(isDestroyed) {
			//Increment death animation timer
			if(deathClock == 0) {
				die();
			}
			deathClock++;
		} else if(isInvincible()) {
			//Flinch (overrides usual timer)
			if(isKnockedBack()) {
				flicker(isFlickering());
			} else {
				idle();
			}
			aiClock = 0;
			isAttacking = false;
		} else if(isAttacking) {
			aiClock++;
			if(aiClock == 16) {
				//Create attack projectile
				int x = (int) getX();
				if(!flipped) {
					x += getWidth();
				} else {
					x -= 4;
				}
				room.addProjectile(new AttackProjectile(x, (int) getY(), getHeight(), room, 10));
			}
			if(getFrame() == 4) {
				isAttacking = false;
			}
		} else {
			//Proceeds with typical AI
			aiClock++;
			if(aiClock >= aiClockReset) {
				//Makes a random decision
				int decision = (int) (Math.random() * 10);
				
				if(isAggravated) {
					//Pursue player
					if(decision < 3) {
						attack();
					} else {
						if(room.getPlayer().getX() > getX()) {
							moveRight();
						} else {
							moveLeft();
						}
					}
				} else {
					//Wander
					if(decision < 2) {
						moveRight();
					}else if(decision < 4) {
						moveLeft();
					}else if(decision < 8) {
						attack();
					}else {
						idle();
					}
				}
				
				aiClock = 0;
			}
		}
		
	}
	
}
