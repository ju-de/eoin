package dmcigd.core.objects;

import dmcigd.core.enums.*;
import dmcigd.core.objects.interfaces.*;

public class Entity extends BlockMapCollider {
	
	private EntityType entityType;
	
	//Public getters
	public EntityType getEntityType() {
		return entityType;
	}
	
	//Public setters
	public void setEntityType(EntityType entityType) {
		this.entityType = entityType;
	}
	
	public boolean isDestroyed() {
		return isDestroyed;
	}
	
	//Checks for water
	public CollisionType backBlock;

	public void rest(CollisionType collisionType) {
		
		//Determine entity states based on resting block
		switch(collisionType) {
		
			case DESTROY:
				isDestroyed = true;
				break;
				
			case KILL:
				isDead = true;
		
			//On ground
			case PLATFORM:
			case SOLID:
			case SOLIDLADDER:
				hitGround = true;
				isFalling = false;
				break;
				
			//In air
			default:
				break;
		}
		
	}

	public void onPush(Entity entity, int v) {
		if(entity.getEntityType() == EntityType.MOVINGBLOCK) {
			addX(v);
		}
	}
	
	public void pushObject(SolidObject object, int v) {
		object.onPush(this, v);
	}
	
	public void move() {
		
		addAcceleration();
		
		int vx = getVX();
		int vy = getVY();
		
		if(restingBlock != null) {
			vx = vx + restingBlock.getDX();
			vy = vy + restingBlock.getDY();
		}
		
		if(restingBlock == null && inWater) {
			vy = (int) (vy / 2.2f); //If in water, divides falling or jumping speed by factor of 2.2
		}
		
		//Reset entity status
		inWater = false;
		hitGround = false;
		isFalling = false;
		
		restingBlockCheck = null;
		
		if(vy >= 0) {
			//Move Down
			checkBlockMapCollisionDown(vy);
		}else {
			//Move Up
			checkBlockMapCollision(vy, Direction.UP);
		}
		
		if(vx >= 0) {
			checkBlockMapCollision(vx, Direction.RIGHT);
		} else if (vx < 0) { 
			checkBlockMapCollision(vx, Direction.LEFT);
		}
		
		if(restingBlock != restingBlockCheck) {
			if(restingBlockCheck == null) {
				restingBlock.onUnrest(getEntityType());
				restingBlock = null;
			} else {
				restingBlock = restingBlockCheck;
				restingBlock.onRest(getEntityType());
			}
		}
		
		if(restingBlock != null) {
			rest(restingBlock.getCollisionType());
		}
		
		backBlock = blockMap.backBlock(getX(),getY(),getWidth(),getHeight());
		
		if(backBlock == CollisionType.WATER) {
			inWater = true;
			hitGround = true;
		}
	}
}
