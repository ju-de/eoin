package dmcigd.core.objects.blocks;

import dmcigd.core.enums.CollisionType;
import dmcigd.core.enums.EntityType;
import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;

public class LockedDoor extends ObjectCollision implements RestableObject {
	
	private int type;
	
	private boolean unlocked = false;

	public void onPush(EntityType entityType, int v) {
		
		//These values just so happen to work out to be the 4 respective keys
		if(entityType.getCode() == -type) {
			
			setFrame(9);
			setCollisionType(CollisionType.NONSOLID);
			unlocked = true;
			
		}
		
	}

	public void onRest(EntityType entityType) {}

	public void onUnrest(EntityType entityType) {}
	
	public boolean isDestroyed() {
		return unlocked;
	}
	
	public LockedDoor(int x, int y, int type) {
		
		setX(x);
		setY(y);
		setDX(0);
		setDY(0);
		setHeight(30);
		setWidth(32);
		setImageHeight(32);
		setImageWidth(32);
		
		setSequence(4);
		setFrame(type-1);
		
		setMapCode("`");
		setImagePath("demo/objects.gif");
		
		setCollisionType(CollisionType.SOLID);
		
		this.type = type;
		
	}

	public void step() {}
}
