package dmcigd.levels.cave.mobs;

import dmcigd.core.enums.*;
import dmcigd.core.objects.Entity;
import dmcigd.core.objects.PhysicsHandler;
import dmcigd.core.objects.monsters.*;
import dmcigd.core.objects.player.*;
import dmcigd.core.objects.interfaces.SolidObject;

public class Bat extends HitpointHandler implements SolidObject {
	
	private int centerRange,outerRange;
	private double speed = 3;
	
	private int objectClock = 0;
	private int deathClock = 0;
	private int objectClockLimit = 30;
	private int deathClockLimit = 60;
	
	private BatList batList;
	
	public Bat(BatList batList, PhysicsHandler physicsHandler) {
		this.batList = batList;
		
		setX(batList.getX() + 5 - (int) (10 * Math.random()));
		setY(batList.getY() + 5 - (int) (10 * Math.random()));
		
		centerRange = batList.getCenterRange();
		outerRange = batList.getOuterRange();
		
		setWidth(30);
		setHeight(18);
		setImageWidth(40);
		setImageHeight(24);
		
		setSequence(0);
		setFrame(0);
		
		setFrameSpeed(0.1f);
		setFrameLimits(new int[] {2,3});
		setAnimationLoops(new boolean[] {true, false});
		
		setMaxHitpoints(1);
		setKnockback(true);
		
		setPhysicsHandler(physicsHandler);
		setCollisionType(CollisionType.NONSOLID);
		setEntityType(EntityType.NONLETHALMONSTER);
		
		setImagePath("objects/cave/bat.gif");
	}
	
	public boolean isDestroyed() {
		return deathClock >= deathClockLimit;
	}
	
	public void onPush(Entity entity, float v) {
		
		try {
			Player player = (Player) entity;
			if(!isDestroyed && !isInvincible()) {
				if(v >= 0) {
					player.knockback(7, 0, 0.7f, Direction.LEFT,15);
				} else {
					player.knockback(7, 0, 0.7f, Direction.RIGHT,15);
				}
			}
		} catch(Exception e) {
			//Do nothing
		}
		
	}
	
	public void pushObject(SolidObject object, float v) {
		
		super.pushObject(object, v);
		
		try {
			onPush((Entity) object, -v);
		} catch(Exception e) {
			//Do nothing
		}
	}
	
	public void step() {
		super.step();
		
		move();
		
		if(isDestroyed) {
			
			if(deathClock == 0) {
				setSequence(1);
				setFrameSpeed(0.08f);
				setGravity();
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
				BasicSwarmThink.swarmThink(this, batList.getAverageX(), batList.getAverageY(), centerRange, outerRange, 0.3f, 0.5f, speed);
				objectClock = 0;
			}

	    	
	    	if(getVX() < 0) {
	    		flipped = true;
	    	} else if (getVX() > 0) {
	    		flipped = false;
	    	}
	    	
	    	animate();
    	}
	}
}
