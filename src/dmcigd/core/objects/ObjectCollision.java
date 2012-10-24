package dmcigd.core.objects;

import dmcigd.core.enums.*;

import java.awt.*;

public class ObjectCollision extends VisibleObject {
	
	CollisionType collisionType = CollisionType.NONSOLID;
	
	public Rectangle getBounds(int vx, int vy) {
		return new Rectangle(getX() + vx, getY() + vy, getWidth(), getHeight());
	}
	
	public Rectangle getBounds() {
		return getBounds(0,0);
	}
	
	public CollisionType getCollisionType() {
		return collisionType;
	}
	
	public void setCollisionType(CollisionType collisionType) {
		this.collisionType = collisionType;
	}

}
