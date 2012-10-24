package dmcigd.core.objects.platforms;

import dmcigd.core.enums.CollisionType;
import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;

public class MovingPlatform extends MovingObject implements RestableObject {
	
	//NOTE:
	//It wasn't worth making an enumerator for a two-value integer
	//That only exists for this class
	
	//Type 0: Horizontal movement
	//Type 1: Vertical movement
	
	private int objectClock,clockReset = 0;
	
	//Interface Getters
	
	public int getDX() {
		return getVX();
	}
	public int getDY() {
		return getVY();
	}
	
	public MovingPlatform(int x, int y, int type, int width, int speed, int travelDistance) {
		
		setX(x);
		setY(y);
		setHeight(24);
		setWidth(width * 16);
		setImageHeight(24);
		setImageWidth(width * 16);
		
		setSequence(0);
		setFrame(0);
		
		setCollisionType(CollisionType.PLATFORM);
		
		if(type == 0) {
			setVX(speed);
		} else {
			setVY(speed);
		}
		
		setMapCode("o");
		setImagePath("demo/movingplatform.gif");
		
		clockReset = travelDistance * 16 / speed;
	}
	
	public void step() {
		
		if(objectClock < clockReset) {
			objectClock++;
		} else {
			setVX(-getVX());
			setVY(-getVY());
			objectClock = 0;
		}
		
		addX(getVX());
		addY(getVY());
		
	}
}
