package dmcigd.levels.lake.mobs;

import dmcigd.core.enums.*;
import dmcigd.core.objects.monsters.BasicSwarmThink;
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
		
		BasicSwarmThink.swarmThink(this, x, y, centerRange, outerRange, 0.15f, 0.3f, 3, 2, 4);
		
		this.isInvincible = isInvincible;
		this.isFlickering = isFlickering;
		
	}
	
	public void kill() {
		setSequence(type + 4);
		setFrameSpeed(0.04f);
		
		//Float up
		setVY(0);
		accelerate(32,0,Direction.RIGHT);
		accelerate(0.01f,1f,Direction.UP);
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
