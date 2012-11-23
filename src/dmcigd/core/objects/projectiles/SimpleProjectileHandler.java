package dmcigd.core.objects.projectiles;

import java.util.ArrayList;

import dmcigd.core.enums.*;
import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.SolidObject;
import dmcigd.core.objects.maps.BlockMap;

public class SimpleProjectileHandler extends BasicProjectileHandler {

	public SimpleProjectileHandler(BlockMap blockMap, ArrayList<SolidObject> solidObjects) {
		super(blockMap, solidObjects);
	}
	
	//Destroys object on collision with anything solid
	public void blockMapCollision(Entity entity, Direction direction) {
		super.blockMapCollision(entity, direction);
		entity.isDestroyed = true;
	}
	public void rest(Entity entity, CollisionType collisionType) {
		
		if(collisionType.getPriority() < 4) {
			entity.isDestroyed = true;
		}
		
	}
	public void pushObject(Entity entity, SolidObject object, int v) {
		super.pushObject(entity, object, v);
		//Please add some code here to only set isDestroyed to true
		//if the CollisionType is not NONSOLID or the object is an Entity (I can't figure out the entity part)
		//There should be a method to check if the object belongs to the Entity class, I just forgot what it was
		entity.isDestroyed = true;
	}
}
