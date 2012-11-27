package dmcigd.core.objects.player;

import dmcigd.core.objects.particles.*;

public class JumpParticle extends Particle {
	
	public JumpParticle(float x, float y, boolean flipped) {
		setX(x - 6);
		setY(y + 16);
		this.flipped = flipped;
		
		setWidth(32);
		setHeight(14);
		setImageWidth(32);
		setImageHeight(16);
		
		setSequence(0);
		setFrame(0);
		
		setImagePath("playerjump.gif");
		
		setFrameSpeed(0.2f);
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
