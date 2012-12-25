package dmcigd.levels.swamp;

import dmcigd.core.enums.CollisionType;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.*;

public class SwitchBlock extends ObjectCollision implements RestableObject {

	public boolean isDestroyed() { return false; }
	
	public void on() {
		setCollisionType(CollisionType.SOLID);
		setSequence(2);
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
		setHeight(30);
		setWidth(32 * width);
		setImageHeight(32);
		setImageWidth(32 * width);
		
		setFrame(0);
		
		setImagePath("objects.gif");
		
		on();
	}

	public void step() { }

}
