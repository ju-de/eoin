package dmcigd.core.objects.player;

import dmcigd.core.objects.particles.*;

public class RunParticle extends Particle {
	
	public RunParticle(float x, float y, boolean flipped) {
		if(flipped) {
			setX(x + 10);
		} else {
			setX(x - 10);
		}
		setY(y + 16);
		this.flipped = flipped;
		
		setWidth(16);
		setHeight(14);
		setImageWidth(16);
		setImageHeight(16);
		
		setSequence(0);
		setFrame(0);
		
		setImagePath("playerrun.gif");
		
		setFrameSpeed(generator.nextFloat()/3 + 0.3f);
		setFrameLimits(new int[] {5});
		setAnimationLoops(new boolean[] {false});
	}

	public void move() {
		animate();
	}

	public void updateLifeSpan() {
		isDestroyed = getFrame() == 4;
	}

}
