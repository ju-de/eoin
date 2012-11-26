package dmcigd.core.objects.blocks;

import dmcigd.core.enums.*;
import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;

public class PushableBlock extends Entity implements RestableObject {
	
	public void onPush(Entity entity, float v) {
		if(entity.getEntityType() == EntityType.PLAYER) {
			if(getRestingBlock() != null) {
				setFX((v - getRestingBlock().getDX())/2);
			} else {
				setFX(v/2);
			}
		}
	}
	
	public boolean isDestroyed() { return false; }
	
	public PushableBlock(int x, int y, PhysicsHandler physicsHandler) {

		setX(x);
		setY(y);
		setDX(0);
		setDY(0);
		setHeight(28);
		setWidth(28);
		setImageHeight(32);
		setImageWidth(32);
		
		setSequence(4);
		setFrame(8);
		
		setImagePath("objects.gif");
		
		setCollisionType(CollisionType.SOLID);
		
		setPhysicsHandler(physicsHandler);
		setEntityType(EntityType.MOVINGBLOCK);
		setGravity();
	}
	
	public void step() {
		move();
	}
	
}
