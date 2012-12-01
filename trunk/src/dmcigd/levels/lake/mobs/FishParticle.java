package dmcigd.levels.lake.mobs;

import dmcigd.core.enums.*;
import dmcigd.core.objects.particles.*;

public class FishParticle extends Particle {
	
	private int type;
	private int centerRange,outerRange;
	private boolean isInvincible,isFlickering;

	public FishParticle(int x, int y, int type) {
		setX(x);
		setY(y);
		
		setImageHeight(10);
		setImageWidth(18);
		
		this.type = type;
		setAnimationProperties("objects/lake/fishparticle.gif",type,0, generator.nextFloat()/5,
				new boolean[] {true,true,true,true,false,false,false,false},
				new int[] {2,2,2,2,3,3,3,3});
		
		if(type < 2) {
			centerRange = 12;
			outerRange = 25;
		} else {
			centerRange = 9;
			outerRange = 17;
		}
	}
	
	public void moveRandomAngle(int xMultiplier, int yMultiplier, double speed) {
		
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
		
		accelerate(0.15f, (float) compX, directionX);
		accelerate(0.3f, (float) compY, directionY);
		
	}
	
	public void swarmThink(int x, int y, boolean isInvincible, boolean isFlickering) {
		//Determine distance from center
		double distance = Math.sqrt(Math.pow((getX() - x), 2) + Math.pow((getY() - y), 2));
		
		if(distance < centerRange) {
			//Repel from center
			//Probability of changing direction increases the closer the particle is to center
			if(generator.nextFloat() > distance / centerRange) {
				
				//Move in random direction
				int xMultiplier = Math.round(generator.nextFloat());
				int yMultiplier = Math.round(generator.nextFloat());
				
				moveRandomAngle(xMultiplier, yMultiplier, (centerRange+3-distance)/2);
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
				
				moveRandomAngle(xMultiplier, yMultiplier, distance/4);
				
			}
			
		}
		
		this.isInvincible = isInvincible;
		this.isFlickering = isFlickering;
		
	}
	
	public void kill() {
		setSequence(type + 4);
		setFrameSpeed(0.04f);
		
		//Stop
		accelerate(32,0,Direction.RIGHT);
		accelerate(32,0,Direction.DOWN);
		setVX(0);
		setVY(0);
	}

	public void move() {
    	addAcceleration();
    	if(getVX() > 0) {
    		flipped = true;
    	} else {
    		flipped = false;
    	}
    	addX(getVX());
    	addY(getVY());
    	if(isInvincible) {
    		if(isFlickering) {
    			setFrame(2);
    		}else{
    			setFrame(0);
    		}
    	} else {
    		animate();
    	}
	}

	public void updateLifeSpan() {
		if(getSequence() > 3 && getFrame() == 2) {
			isDestroyed = true;
		}
	}
	
}
