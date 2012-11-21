package dmcigd.levels.tutorial;

import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;

public class Dummy extends ObjectCollision implements SolidObject {
	
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
		
		setImagePath("objects/tutorial/dummy.gif");
		
	}
	
	public void step() {
		
		animate();
		
	}
	
}
