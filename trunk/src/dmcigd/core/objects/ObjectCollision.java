package dmcigd.core.objects;

import dmcigd.core.enums.*;

import java.awt.*;

public abstract class ObjectCollision extends VisibleObject {
	
	CollisionType collisionType = CollisionType.NONSOLID;
	
	//Collision Checks
	public Rectangle getBounds(float vx, float vy) {
		return new Rectangle((int) (getX() + vx), (int) (getY() + vy), getWidth(), getHeight());
	}
	//Overrides getBounds with default of no velocity
	public Rectangle getBounds() {
		return getBounds(0,0);
	}
	
	public CollisionType getCollisionType() {
		return collisionType;
	}
	
	public void setCollisionType(CollisionType collisionType) {
		this.collisionType = collisionType;
	}

	//Collision Events
	public void onRest(Entity entity) {}
	
	public void onUnrest(Entity entity) {}
	
	public void onPush(Entity entity, float v) {}
	
	public boolean onAttack(int damage, boolean flipped) { return false; }

}
