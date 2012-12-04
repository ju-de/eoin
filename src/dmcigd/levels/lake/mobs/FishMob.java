package dmcigd.levels.lake.mobs;

import dmcigd.core.enums.CollisionType;
import dmcigd.core.enums.Direction;
import dmcigd.core.enums.EntityType;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.monsters.*;
import dmcigd.core.objects.PhysicsHandler;
import dmcigd.core.objects.projectiles.BasicProjectileHandler;

public class FishMob extends LethalityHandler implements SolidObject {
	
	private int spawnX, spawnY, objectClock, deathClock;
	
	private int centerRange = 50;
	private int outerRange = 100;
	private double speed = 1.5;
	
	private int objectClockLimit = 30;
	private int deathClockLimit = 70;

	public FishMob(int x, int y, PhysicsHandler physicsHandler) {
		
		spawnX = x;
		spawnY = y;
		
		setX(x);
		setY(y);
		setWidth(20);
		setHeight(24);
		setImageWidth(28);
		setImageHeight(28);
		
		setSequence(0);
		setFrame(0);
		
		setFrameSpeed(0.015f);
		setFrameLimits(new int[] {2,3});
		setAnimationLoops(new boolean[] {true, false});
		
		setMaxHitpoints(30);
		setKnockback(true);
		setLethalOnPush(true);
		setLethalOnRest(true);
		
		setPhysicsHandler(new BasicProjectileHandler(physicsHandler.getBlockMap(), physicsHandler.getSolidObjects()));
		setCollisionType(CollisionType.NONSOLID);
		setEntityType(EntityType.LETHALMONSTER);
		
		setImagePath("objects/lake/fishmob.gif");
		
	}
	
	public boolean isDestroyed() {
		return deathClock >= deathClockLimit;
	}
	
	public void step() {
		super.step();
		move();
		
		if(isDestroyed) {
			
			if(deathClock == 0) {
				setSequence(1);
				setFrameSpeed(0.08f);
				accelerate(0.05f, (float) speed, Direction.UP);
			}
			
			deathClock++;

	    	animate();
			
		} else if(isInvincible()) {
    		if(isFlickering()) {
    			setFrame(2);
    		}else{
    			setFrame(0);
    		}
    	} else {
			objectClock++;
			if(objectClock >= objectClockLimit) {
		    	
				BasicSwarmThink.swarmThink(this, spawnX, spawnY, centerRange, outerRange, 0.05f, 0.01f, 1.5);
		    	
		    	if(getVX() <= 0) {
		    		flipped = true;
		    	} else {
		    		flipped = false;
		    	}
		    	
		    	objectClock = 0;
			}
			
	    	animate();
	    	
		}
	}
	
}
