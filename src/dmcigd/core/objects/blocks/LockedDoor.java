package dmcigd.core.objects.blocks;

import dmcigd.core.enums.CollisionType;
import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;

public class LockedDoor extends ObjectCollision implements RestableObject {
	
	private int type;
	
	private boolean unlocked = false;

	public void onPush(Entity entity, float v) {
		
		//These values just so happen to work out to be the 4 respective keys
		if(entity.getEntityType().getCode() == -type) {
			
			setFrame(9);
			setCollisionType(CollisionType.NONSOLID);
			unlocked = true;
			
			entity.isDestroyed = true;
			
		}
		
	}
	
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
		
		setImagePath("objects.gif");
		
		setCollisionType(CollisionType.SOLID);
		
		this.type = type;
		
	}

	public void step() {}
}
