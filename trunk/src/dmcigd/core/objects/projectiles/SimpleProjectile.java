package dmcigd.core.objects.projectiles;

import java.util.ArrayList;

import dmcigd.core.enums.*;
import dmcigd.core.objects.Entity;
import dmcigd.core.objects.interfaces.SolidObject;
import dmcigd.core.objects.maps.BlockMap;

public abstract class SimpleProjectile extends BasicProjectile {
	
	//Destroys object on collision with anything solid
	public void blockMapCollision(int v, Direction direction) {
		super.blockMapCollision(v, direction);
		isDestroyed = true;
	}
	public void rest(CollisionType collisionType) {
		
		if(collisionType.getPriority() < 4) {
			isDestroyed = true;
		}
		
	}
	public void onPush(Entity entity, int v) {
		if(entity.getEntityType() == EntityType.MOVINGBLOCK) {
			isDestroyed = true;
		}
	}
	public void pushObject(SolidObject object, int v) {
		object.onPush(this, v);
		isDestroyed = true;
	}
	
	public SimpleProjectile(int x, int y, int speed, int angle, boolean flipped, BlockMap blockMap, ArrayList<SolidObject> solidObjects) {
		super(x, y, speed, angle, flipped, blockMap, solidObjects);
	}
	
	public SimpleProjectile(int x, int y, int speed, int angle, BlockMap blockMap, ArrayList<SolidObject> solidObjects) {
		super(x, y, speed, angle, blockMap, solidObjects);
	}

	public void step() {
		move();
	}
}
