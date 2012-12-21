package dmcigd.levels.icecave;

import dmcigd.core.enums.CollisionType;
import dmcigd.core.enums.Direction;
import dmcigd.core.enums.EntityType;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.room.Room;
import dmcigd.core.objects.monsters.*;
import dmcigd.levels.deer.mobs.AttackProjectile;

public class IceWolf extends HitpointHandler implements RestableObject {
	
	private boolean isAttacking,isJumping;
	private Room room;
	private int deathClock = 0;
	private int aiClock = 0;
	private int deathClockLimit = 70;
	private int aiClockReset = 40;

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
	
	public void moveLeft() {
		flipped = true;
		accelerate(0.3f, 2.4f, Direction.LEFT);
		setSequence(1);
		setFrameSpeed(0.12f);
		if(Math.random() < 0.3f) {
			setVY(-5.6f);
			isJumping = true;
		}
	}
	
	public void moveRight() {
		flipped = false;
		accelerate(0.3f, 2.4f, Direction.RIGHT);
		setSequence(1);
		setFrameSpeed(0.12f);
		if(Math.random() < 0.3f) {
			setVY(-5.6f);
			isJumping = true;
		}
	}

	public void die() {
		setSequence(3);
		setFrameSpeed(0.2f);
		setCollisionType(CollisionType.NONSOLID);
	}
	
	public boolean isDestroyed() {
		if(isDestroyed && deathClock >= deathClockLimit) {
			return true;
		}
		return false;
	}

	public IceWolf(int x, int y, Room room) {
	
		setX(x);
		setY(y);
		setWidth(36);
		setHeight(26);
		setImageWidth(48);
		setImageHeight(36);
		
		setSequence(0);
		setFrame(0);
	
		setFrameLimits(new int[] {2, 4, 5, 4});
		setAnimationLoops(new boolean [] {true, true, false, false});
		setFrameSpeed(0.02f);
		
		setMaxHitpoints(40);
		setKnockback(true);
		
		this.room = room;
		
		setGravity();
		
		setPhysicsHandler(room.getPhysicsHandler());
		setCollisionType(CollisionType.SOLID);
		setEntityType(EntityType.NONLETHALMONSTER);
		
		setImagePath("objects/icecave/icewolf.gif");
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
		} else if(isJumping) {
			if(hitGround) {
				isJumping = false;
			}
		} else {
			//Proceeds with typical AI
			aiClock++;
			if(aiClock >= aiClockReset) {
				//Makes a random decision
				int decision = (int) (Math.random() * 10);
				//Player Distance
				float playerDistance = room.getPlayer().getX() - getX();
				if(playerDistance < 400 && playerDistance > - 400) {
					//Pursue player
					if(decision < 3) {
						attack();
					} else {
						if(playerDistance >= 0) {
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
	
	public void step() {
		
		super.step();
		
		think();
		
		move();
		
		if(!isKnockedBack()) {
			animate();
		}
	}

}
