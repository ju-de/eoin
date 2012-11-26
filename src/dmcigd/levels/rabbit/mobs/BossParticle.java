package dmcigd.levels.rabbit.mobs;

import dmcigd.core.objects.particles.*;

public class BossParticle extends BrownianParticle {

	public BossParticle(float x, float y, int stepSize, int maxWalk,
			String imagePath) {
		super(x, y, stepSize, maxWalk, imagePath);
		
		setImageHeight(14);
		setImageWidth(14);

		setFrameLimits(new int[] {6});
		setAnimationLoops(new boolean [] {true});
		setFrameSpeed(0.1f);
	}
	
	public void move () {
		super.move();
		animate();
	}

}
