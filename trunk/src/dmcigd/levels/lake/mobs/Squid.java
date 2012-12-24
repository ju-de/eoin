package dmcigd.levels.lake.mobs;

import dmcigd.core.enums.CollisionType;
import dmcigd.core.enums.Direction;
import dmcigd.core.enums.EntityType;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.monsters.*;
import dmcigd.core.objects.player.*;
import dmcigd.core.objects.PhysicsHandler;

public class Squid extends HitpointHandler implements SolidObject {
	
	private boolean isJumping = false;
	
	private int deathClock = 0;
	private int deathClockLimit = 70;
	
	private int aiClock = 0;
	private int aiClockLimit = 80;
	
	private Player player;

	public Squid(int x, int y, PhysicsHandler physicsHandler, Player player) {
		
		setX(x);
		setY(y);
		setWidth(20);
		setHeight(26);
		setImageWidth(28);
		setImageHeight(34);
		
		setSequence(0);
		setFrame(0);
		
		setFrameSpeed(0.01f);
		setFrameLimits(new int[] {2,5,2,4});
		setAnimationLoops(new boolean[] {true, false, true, false});
		
		setMaxHitpoints(30);
		setKnockback(false);
		
		this.player = player;
		
		setPhysicsHandler(physicsHandler);
		setCollisionType(CollisionType.NONSOLID);
		setEntityType(EntityType.LETHALMONSTER);
		
		//Pseudogravity
		accelerate(0.2f, (float) 3, Direction.DOWN);
		
		setImagePath("objects/lake/squid.gif");
		
	}
	
	public boolean isDestroyed() {
		return deathClock >= deathClockLimit;
	}
	
	public int getFrame() {
		if(isInvincible() && isFlickering()) return 2;
		return super.getFrame();
	}
	
	public int getSequence() {
		if(isInvincible() && isFlickering()) return 0;
		return super.getSequence();
	}
	
	public void step() {
		super.step();
		move();
		
		if(isDestroyed) {
			
			if(deathClock == 0) {
				setSequence(3);
				setFrameSpeed(0.07f);
				accelerate(0.05f, (float) 1.5f, Direction.UP);
			}
			
			deathClock++;

	    	animate();
			
		} else if(!isInvincible()) {
			aiClock++;

			if(getVY() > 0.2f) {
				isJumping = false;
				setSequence(2);
				setFrameSpeed(0.03f);
			}else if(isJumping) {
				setSequence(1);
				if(getFrame() == 2) setVY(-3.5f);
				setFrameSpeed(0.05f);
			} else {
				setSequence(0);
				setFrameSpeed(0.01f);
			}
			
			if(aiClock >= aiClockLimit) {
				
				if(Math.random() >= 0.5f) isJumping = true;
				
		    	aiClock = 0;
			}
			
	    	animate();
	    	
			if(getBounds().intersects(player.getBounds())) {
				player.isDead = true;
			}
	    	
		}
	}
	
}
