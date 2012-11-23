package dmcigd.core.objects;

import dmcigd.core.enums.*;
import dmcigd.core.objects.interfaces.*;

public class Entity extends BlockMapCollider {
	
	private EntityType entityType;
	
	//Public getters
	public EntityType getEntityType() {
		return entityType;
	}
	
	public boolean isDestroyed() {
		return isDestroyed;
	}
	
	//Public setters
	public void setEntityType(EntityType entityType) {
		this.entityType = entityType;
	}
	
	//Checks for water
	public CollisionType backBlock;

	public void onPush(Entity entity, int v) {
		if(entity.getEntityType() == EntityType.MOVINGBLOCK) {
			addX(v);
		}
	}

	//Strictly handles collisionType, see restObject() for handling RestableObjects
	public void rest(CollisionType collisionType) {
		
		//Determine entity states based on resting block
		switch(collisionType) {
		
			case DESTROY:
				isDestroyed = true;
				break;
				
			case KILL:
				isDead = true;
				//Falls through so death blocks are treated like solid blocks
				
			//On ground
			case PLATFORM:
			case SOLID:
			case SOLIDLADDER:
				hitGround = true;
				isFalling = false;
				break;
				
			//Fall through
			default:
				break;
		}
		
	}
	
	public void pushObject(SolidObject object, int v) {
		object.onPush(this, v);
	}
	
	public void restObject() {
		restingBlock = restingBlockCheck;
		restingBlock.onRest(this);
	}
	
	public void unrestObject() {
		restingBlock.onUnrest(this);
		restingBlock = null;
	}
	
	public void move() {
		
		//Reset velocity
		addAcceleration();
		
		int vx = getVX();
		int vy = getVY();
		
		if(restingBlock != null) {
			//Adds displacement to velocity
			vx = vx + restingBlock.getDX();
			vy = vy + restingBlock.getDY();
		}else if(inWater) {
			//If in water, divides falling or jumping speed by factor of 2.2
			vy = (int) (vy / 2.2f);
		}
		
		//Reset entity status
		inWater = false;
		hitGround = false;
		isFalling = false;
		restingBlockCheck = null;
		
		//Move Vertically
		if(vy >= 0) {
			//Move Down
			checkBlockMapCollisionDown(vy);
		}else {
			//Move Up
			checkBlockMapCollision(vy, Direction.UP);
		}
		
		//Move Horizontally
		if(vx >= 0) {
			//Move Right
			checkBlockMapCollision(vx, Direction.RIGHT);
		} else if (vx < 0) { 
			//Move Left
			checkBlockMapCollision(vx, Direction.LEFT);
		}
		
		//Applies restingBlockCheck
		if(restingBlock != restingBlockCheck) {
			if(restingBlockCheck == null) {
				unrestObject();
			} else {
				restObject();
			}
		}
		
		//Calls rest method if resting on a non-blockMap object
		if(restingBlock != null) {
			rest(restingBlock.getCollisionType());
		}
		
		//Checks for water
		backBlock = blockMap.backBlock(getX(),getY(),getWidth(),getHeight());
		
		if(backBlock == CollisionType.WATER) {
			inWater = true;
			hitGround = true;
		}
	}
}
