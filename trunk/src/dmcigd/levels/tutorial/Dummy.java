package dmcigd.levels.tutorial;

import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.monsters.*;

public class Dummy extends LethalityHandler implements SolidObject {
	
	public boolean isDestroyed() { return false; }
	
	public Dummy(int x, int y) {

		setX(x);
		setY(y);
		setWidth(24);
		setHeight(38);
		setImageWidth(24);
		setImageHeight(40);
		
		setSequence(0);
		setFrame(0);

		setFrameLimits(new int[] {2});
		setAnimationLoops(new boolean [] {true});
		setFrameSpeed(0.02f);
		
		setMaxHitpoints(50);
		setKnockback(true);
		
		setImagePath("objects/tutorial/dummy.gif");
		
	}
	
	public void step() {
		super.step();
		animate();
	}
	
}
