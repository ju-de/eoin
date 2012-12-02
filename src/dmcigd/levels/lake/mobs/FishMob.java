package dmcigd.levels.lake.mobs;

import dmcigd.core.enums.CollisionType;
import dmcigd.core.enums.Direction;
import dmcigd.core.enums.EntityType;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.monsters.LethalityHandler;
import dmcigd.core.objects.PhysicsHandler;
import dmcigd.core.objects.projectiles.BasicProjectileHandler;

import java.util.Random;

public class FishMob extends LethalityHandler implements SolidObject {
	
	private int spawnX, spawnY, objectClock, deathClock;
	
	private int centerRange = 50;
	private int outerRange = 100;
	private double speed = 1.5;
	
	private int objectClockLimit = 30;
	private int deathClockLimit = 70;
	
	private static Random generator = new Random();

	public FishMob(int x, int y, PhysicsHandler physicsHandler) {
		
		spawnX = x;
		spawnY = y;
		
		setX(x);
		setY(y);
		setDX(0);
		setDY(0);
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
		    	
		    	swarmThink(spawnX, spawnY);
		    	
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
	
	//Fish mob move as 1 monster swarms (randomly orbiting around their spawn point)
	
	public void moveRandomAngle(int xMultiplier, int yMultiplier) {
		
		//Generates angle in radians
		double angle = generator.nextGaussian() * 1.57;
		
		//Determines component vectors
		double compX = Math.abs(speed * Math.cos(angle));
		double compY = Math.abs(speed * Math.sin(angle));
		
		//Creates acceleration vectors
		Direction directionX;
		Direction directionY;
		
		if(xMultiplier >= 0) {
			directionX = Direction.RIGHT;
		} else {
			directionX = Direction.LEFT;
		}
		if(yMultiplier >= 0) {
			directionY = Direction.DOWN;
		} else {
			directionY = Direction.UP;
		}
		
		accelerate(0.05f, (float) compX, directionX);
		accelerate(0.01f, (float) compY, directionY);
		
	}
	
	public void swarmThink(int x, int y) {
		//Determine distance from center
		double distance = Math.sqrt(Math.pow((getX() - x), 2) + Math.pow((getY() - y), 2));
		
		if(distance < centerRange) {
			//Repel from center
			//Probability of changing direction increases the closer the particle is to center
			if(generator.nextFloat() > distance / centerRange) {
				
				//Move in random direction
				int xMultiplier = Math.round(generator.nextFloat());
				int yMultiplier = Math.round(generator.nextFloat());
				
				moveRandomAngle(xMultiplier, yMultiplier);
			}
		}else {
			//Move back to center
			//Probability of changing direction increases the further particle is to center
			if(generator.nextFloat() < distance / outerRange) {
				
				int xMultiplier;
				int yMultiplier;
				
				//Determine direction of motion
				if(getX() > x) {
					xMultiplier = -1;
				}else{
					xMultiplier = 1;
				}
				
				if(getY() > y) {
					yMultiplier = -1;
				} else {
					yMultiplier = 1;
				}
				
				moveRandomAngle(xMultiplier, yMultiplier);
				
			}
			
		}
		
	}
	
}
