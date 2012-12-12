package dmcigd.levels.icecave;

import dmcigd.core.enums.CollisionType;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.*;

public class SwitchBlock extends ObjectCollision implements RestableObject {

	public boolean isDestroyed() { return false; }
	
	public void on() {
		setCollisionType(CollisionType.SOLID);
		setSequence(1);
	}
	
	public void off() {
		setCollisionType(CollisionType.NONSOLID);
		setSequence(0);
	}
	
	public SwitchBlock(int x, int y, int width) {
		
		setX(x);
		setY(y);
		setDX(0);
		setDY(0);
		setHeight(14);
		setWidth(32 * width);
		setImageHeight(16);
		setImageWidth(32 * width);
		
		setFrame(0);
		
		setImagePath("objects/icecave/switchblock.gif");
		
		on();
	}

	public void step() { }

}
