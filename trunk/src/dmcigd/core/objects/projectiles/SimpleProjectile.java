package dmcigd.core.objects.projectiles;

import java.util.ArrayList;

import dmcigd.core.enums.*;
import dmcigd.core.objects.interfaces.SolidObject;
import dmcigd.core.objects.maps.BlockMap;

public abstract class SimpleProjectile extends BasicProjectile {
	
	//Destroys object on collision with anything solid
	public void blockMapCollision(Direction direction) {
		super.blockMapCollision(direction);
		isDestroyed = true;
	}
	public void rest(CollisionType collisionType) {
		
		if(collisionType.getPriority() < 4) {
			isDestroyed = true;
		}
		
	}
	public void pushObject(SolidObject object, int v) {
		super.pushObject(object, v);
		//Please add some code here to only set isDestroyed to true
		//if the CollisionType is not NONSOLID or the object is an Entity (I can't figure out the entity part)
		//There should be a method to check if the object belongs to the Entity class, I just forgot what it was
		isDestroyed = true;
	}
	
	public SimpleProjectile(int x, int y, int speed, int angle, boolean flipped, BlockMap blockMap, ArrayList<SolidObject> solidObjects) {
		super(x, y, speed, angle, flipped, blockMap, solidObjects);
	}
	
	public SimpleProjectile(int x, int y, int speed, int angle, BlockMap blockMap, ArrayList<SolidObject> solidObjects) {
		super(x, y, speed, angle, blockMap, solidObjects);
	}
}
