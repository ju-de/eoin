package dmcigd.levels.deer;

import dmcigd.core.objects.particles.*;

public class SickParticle extends BrownianParticle{

	public SickParticle(float x, float y, int stepSize, int maxWalk,
			String imagePath) {
		super(x, y, stepSize, maxWalk, imagePath);
		
		setImageHeight(10);
		setImageWidth(10);

		setFrameLimits(new int[] {4});
		setAnimationLoops(new boolean [] {true});
		setFrameSpeed(0.1f);
	}
	
	public void move () {
		super.move();
		animate();
	}

}
