package dmcigd.core.objects.projectiles;

import dmcigd.core.enums.*;
import dmcigd.core.objects.Entity;
import dmcigd.core.objects.interfaces.SolidObject;

public class SimpleProjectile extends BasicProjectile {
	
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
	
	public SimpleProjectile(int x, int y, int speed, int angle, boolean flipped) {
		super(x, y, speed, angle, flipped);
	}
	
	public SimpleProjectile(int x, int y, int speed, int angle) {
		super(x, y, speed, angle);
	}

	public void step() {
		move();
	}
}
