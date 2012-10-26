package dmcigd.core.objects.blocks;

import dmcigd.core.enums.*;
import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;

public class CrumblingBlock extends ObjectCollision implements RestableObject {
	
	private int objectClock,clockReset = -1;
	
	//Interface Getters
	
	public int getDX() {
		return 0;
	}
	public int getDY() {
		return 0;
	}
	
	public CrumblingBlock(int x, int y) {
		
		setX(x);
		setY(y);
		setHeight(30);
		setWidth(32);
		setImageHeight(32);
		setImageWidth(32);
		
		setSequence(3);
		setFrame(0);
		
		setMapCode("`");
		setImagePath("demo/objects.gif");
		
		setCollisionType(CollisionType.SOLID);
		
	}
	
	public void step() {
		if(objectClock > -1) {
			animate();
			if(getFrame() == 7) {
				setCollisionType(CollisionType.NONSOLID);
			}
			objectClock++;
			if(objectClock > clockReset) {
				objectClock = -1;
				setCollisionType(CollisionType.SOLID);
			}
		}
	}
}
