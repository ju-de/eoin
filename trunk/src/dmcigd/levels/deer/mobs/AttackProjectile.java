package dmcigd.levels.deer.mobs;

import dmcigd.core.enums.CollisionType;
import dmcigd.core.enums.EntityType;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.projectiles.*;
import dmcigd.core.room.*;

public class AttackProjectile extends ProjectileMotion implements SolidObject {
	
	private int objectClock, objectClockReset;
	
	public boolean isDestroyed() {
		return objectClock >= objectClockReset;
	}
	
	public AttackProjectile(int x, int y, int height, Room room, int objectClockReset) {

		setX(x);
		setY(y);
		setWidth(4);
		setHeight(height-2);
		setImageWidth(0);
		setImageHeight(0);
		
		setVX(0);
		
		setPhysicsHandler(new BasicProjectileHandler(room.getBlockMap(), room.getSolidObjects()));
		setCollisionType(CollisionType.NONSOLID);
		setEntityType(EntityType.PROJECTILE);
		
		setImagePath("objects.gif");
		
		this.objectClockReset = objectClockReset;
	}
	
	public void step() {
		move();
		objectClock++;
	}
	
}
