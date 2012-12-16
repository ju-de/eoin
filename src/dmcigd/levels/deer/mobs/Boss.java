package dmcigd.levels.deer.mobs;

import dmcigd.core.enums.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.*;
import dmcigd.core.objects.monsters.*;

import dmcigd.levels.deer.*;

public class Boss extends HitpointHandler implements RestableObject {
	private boolean isAttacking = false;
	private boolean isAggressive = false;
	private BossRoom room;
	private int deathClock = 0;
	private int aiClock = 0;
	private int deathClockLimit = 250;
	private int aiClockReset = 60;
	
	public Boss(int x, int y, BossRoom room) {
	
		setX(x);
		setY(y);
		setWidth(80);
		setHeight(190);
		setImageWidth(160);
		setImageHeight(192);
		
		setSequence(0);
		setFrame(0);
	
		setFrameLimits(new int[] {2, 4, 8, 8});
		setAnimationLoops(new boolean [] {true, true, false, false});
		setFrameSpeed(0.02f);
		
		setMaxHitpoints(150);
		setKnockback(true);
		
		this.room = room;
		
		setGravity();
		
		setPhysicsHandler(room.getPhysicsHandler());
		setCollisionType(CollisionType.SOLID);
		setEntityType(EntityType.NONLETHALMONSTER);
		
		setImagePath("objects/deer/boss.gif");
		
	}
	
	public int getSequence() {
		if(isFlickering()) {
			return 0;
		}
		return super.getSequence();
	}
	
	public int getFrame() {
		if(isFlickering()) {
			return 2;
		}
		return super.getFrame();
	}

	public void attack() {
		flipped = true;
		setSequence(2);
		setFrame(0);
		setFrameSpeed(0.12f);
		accelerate(0.1f, 0.3f, Direction.LEFT);
		isAttacking = true;
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
		setFrameSpeed(0.03f);
		accelerate(32, 0, Direction.RIGHT);
		setVX(0);
	}
	
	public void moveLeft() {
		flipped = true;
		accelerate(0.1f, 1f, Direction.LEFT);
		setSequence(1);
		setFrameSpeed(0.08f);
	}
	
	public void moveRight() {
		flipped = false;
		accelerate(0.1f, 1f, Direction.RIGHT);
		setSequence(1);
		setFrameSpeed(0.08f);
	}

	public void die() {
		setSequence(3);
		setFrameSpeed(0.07f);
		setCollisionType(CollisionType.NONSOLID);
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
		} else if(isAttacking) {
			aiClock++;
			if(aiClock == 55) {
				//Create attack projectile
				int x = (int) getX() - 4;
				room.addProjectile(new AttackProjectile(x, (int) getY(), getHeight(), room, 10));
			} else if(aiClock >= 65) {
				isAttacking = false;
			}
		} else {
			aiClock++;
			if(aiClock >= aiClockReset) {
				aiClock = 0;
				
				if (getX() <= 120 * 32) {
						moveRight();
				} else if(getX() - room.getPlayer().getX() <= 24) {
					attack();
				} else {

					//Makes a random decision
					int decision = (int) (Math.random() * 10);
					
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
			}
		}
	}
	
	public void step() {
		
		if(isAggressive) {
			
			super.step();
			
			think();
			
			move();
			
			if(!isKnockedBack()) {
				animate();
			}
		} else {
			animate();
		}
	}
	
	public void onPush(Entity entity, float v) {
		super.onPush(entity, v);
		if(entity.getEntityType() == EntityType.QUESTITEM2) {
			//Trigger apology dialogue
			room.getDialogueHandler().setDialogue(new String[][] {
					{"The Guardian", "I apologize young one, for I was consumed with the illness. You may enter as you please, however I cannot ensure your safe return. Great evil is known to emerge from those caves, young one."}
			});
			
			entity.isDestroyed = true;
			
			room.bem.sickStatus = false;
			room.bem.imagePath = "objects/deer/herbparticles.gif";
			
			setSequence(0);
			setFrameSpeed(0.03f);
			setCollisionType(CollisionType.NONSOLID);
			isAggressive = false;
		}
	}
	
	public void triggerIntroDialogue() {
		room.getDialogueHandler().setDialogue(new String[][] {
				{"KNIGHT", "Kill it! Kill it quickly! We must press forward, for the princess needs us!"},
				{"The Guardian", "Grawwrhr!"}
		});
		isAggressive = true;
	}
	
}
