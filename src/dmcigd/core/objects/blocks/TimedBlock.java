package dmcigd.core.objects.blocks;

import dmcigd.core.enums.CollisionType;
import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;

public class TimedBlock extends ObjectCollision implements RestableObject {
	
	private int objectClock,changeState,clockReset = 0;
	
	public boolean isDestroyed() { return false; }
	
	public void setState() {
		if(objectClock < changeState) {
			//On State
			setCollisionType(CollisionType.SOLID);
			setSequence(2);
		} else {
			//Off State
			setCollisionType(CollisionType.NONSOLID);
			setSequence(0);
		}
	}
	
	public TimedBlock(int x, int y, int width, int phase, int timeOn, int timeOff) {
		
		setX(x);
		setY(y);
		setDX(0);
		setDY(0);
		setHeight(30);
		setWidth(32 * width);
		setImageHeight(32);
		setImageWidth(32 * width);
		
		setFrame(0);
		
		setMapCode("`");
		setImagePath("objects.gif");
		
		objectClock = phase;
		changeState = timeOn;
		clockReset = timeOn + timeOff;
		
		setState();
		
	}
	
	public void step() {
		
		if(objectClock < clockReset) {
			objectClock++;
		} else {
			objectClock = 0;
		}
		setState();
	}
}
