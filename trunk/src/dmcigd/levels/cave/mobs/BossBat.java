package dmcigd.levels.cave.mobs;

import dmcigd.core.enums.*;
import dmcigd.core.objects.monsters.*;
import dmcigd.core.objects.interfaces.SolidObject;
import dmcigd.core.room.*;

public class BossBat extends HitpointHandler implements SolidObject {
	
	private boolean isAttacking = false;
	
	private int aiClock = 0;
	private int deathClock = 0;
	private int aiClockReset = 50;
	private int deathClockLimit = 120;
	
	private Room room;
	
	public BossBat(int x, int y, Room room) {
		
		setX(x);
		setY(y);
		
		setWidth(60);
		setHeight(70);
		setImageWidth(142);
		setImageHeight(86);
		
		setSequence(0);
		setFrame(0);
		
		setFrameSpeed(0.1f);
		setFrameLimits(new int[] {4, 13, 6});
		setAnimationLoops(new boolean[] {true, false, false});
		
		setMaxHitpoints(50);
		setKnockback(true);
		
		setPhysicsHandler(room.getPhysicsHandler());
		setCollisionType(CollisionType.NONSOLID);
		setEntityType(EntityType.NONLETHALMONSTER);
		
		setImagePath("objects/cave/boss.gif");
		
		this.room = room;
		
	}
	
	public int getSequence() {
		if(isFlickering()) return 0;
		return super.getSequence();
	}
	
	public int getFrame() {
		if(isFlickering()) return 5;
		return super.getFrame();
	}
	
	public boolean isDestroyed() {
		return deathClock >= deathClockLimit;
	}
	
	public void die() {
		setSequence(2);
		setFrameSpeed(0.1f);
		setVY(0.5f);
		setVX(3);
	}
	
	public void attack() {
		setSequence(1);
		setFrameSpeed(0.1f);
		setFrame(0);
		setVX(0);
		setVY(0);
		isAttacking = true;
	}
	
	public void fly() {
		setSequence(0);
		setFrameSpeed(0.1f);
		
		if(Math.random() > 0.5f) {
			accelerate(0.1f,2,Direction.RIGHT);
		} else {
			accelerate(0.1f,2,Direction.LEFT);
		}
		
		if(Math.random() > 0.3f) {
			accelerate(0.1f,1.2f,Direction.UP);
		} else {
			accelerate(0.1f,1.2f,Direction.DOWN);
		}
	}
	
	public void step() {
		
		super.step();
		
		if(isDestroyed) {
			if(deathClock == 0) {
				die();
			}
			deathClock++;
		} else if (isAttacking) {
			aiClock++;
			if(aiClock == 70) {
				room.addProjectile(new BossProjectile(getX() - 20, getY() + 12, 170, room));
				room.addProjectile(new BossProjectile(getX() - 10, getY() + 16, 220, room));
				room.addProjectile(new BossProjectile(getX(), getY() + 20, 260, room));

				room.addProjectile(new BossProjectile(getX() + 60, getY() + 20, -60, room));
				room.addProjectile(new BossProjectile(getX() + 70, getY() + 16, -20, room));
				room.addProjectile(new BossProjectile(getX() + 80, getY() + 12, 10, room));
			} else if(aiClock == 130) {
				isAttacking = false;
			}
		} else {
			aiClock++;
			if(aiClock >= aiClockReset) {
				aiClock = 0;
				if(Math.random() < 0.2f) {
					attack();
				} else {
					fly();
				}
			}
		}
		
		move();
		animate();
	}

}
