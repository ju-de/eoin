package dmcigd.core.objects;

import dmcigd.core.enums.*;
import dmcigd.core.objects.interfaces.*;

public class Entity extends MovingObject {
	
	private EntityType entityType;
	// handles all collision, and perhaps gravity and stuff too
        private PhysicsHandler physicsHandler;
        
	//Public getters
	public EntityType getEntityType() {
		return entityType;
	}
        
	public PhysicsHandler getPhysicsHandler(){
            return physicsHandler;
        }
        
        // sooner or later all of these methods duplicated by physicsHandler will be left up to it only
	public boolean isDestroyed() {
		return physicsHandler.isDestroyed;
	}
        
	//Public setters
	public void setEntityType(EntityType entityType) {
		this.entityType = entityType;
	}
	
        public void setPhysicsHandler(PhysicsHandler handler){
            this.physicsHandler = handler;
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
		physicsHandler.rest(collisionType);
	}
	
	public void pushObject(SolidObject object, int v) {
		physicsHandler.pushObject(object, v);
	}
	
	public void restObject() {
		physicsHandler.restObject();
	}
	
	public void unrestObject() {
            physicsHandler.unrestObject();
	}
	
	public void move() {
		
		//Reset velocity
		addAcceleration();
		
		int vx = getVX();
		int vy = getVY();
		
		if(physicsHandler.restingBlock != null) {
			//Adds displacement to velocity
			vx = vx + physicsHandler.restingBlock.getDX();
			vy = vy + physicsHandler.restingBlock.getDY();
		}else if(physicsHandler.inWater) {
			//If in water, divides falling or jumping speed by factor of 2.2
			vy = (int) (vy / 2.2f);
		}
		
		//Reset entity status
		physicsHandler.inWater = false;
		physicsHandler.hitGround = false;
		physicsHandler.isFalling = false;
		physicsHandler.restingBlockCheck = null;
		
		//Move Vertically
		if(vy >= 0) {
			//Move Down
			physicsHandler.checkBlockMapCollisionDown(vy);
		}else {
			//Move Up
			physicsHandler.checkBlockMapCollision(vy, Direction.UP);
		}
		
		//Move Horizontally
		if(vx >= 0) {
			//Move Right
			physicsHandler.checkBlockMapCollision(vx, Direction.RIGHT);
		} else if (vx < 0) { 
			//Move Left
			physicsHandler.checkBlockMapCollision(vx, Direction.LEFT);
		}
		
		//Applies restingBlockCheck
		if(physicsHandler.restingBlock != physicsHandler.restingBlockCheck) {
			if(physicsHandler.restingBlockCheck == null) {
				unrestObject();
			} else {
				restObject();
			}
		}
		
		//Calls rest method if resting on a non-blockMap object
		if(physicsHandler.restingBlock != null) {
			rest(physicsHandler.restingBlock.getCollisionType());
		}
		
		//Checks for water
		backBlock = physicsHandler.blockMap.backBlock(getX(),getY(),getWidth(),getHeight());
		
		if(backBlock == CollisionType.WATER) {
			physicsHandler.inWater = true;
			physicsHandler.hitGround = true;
		}
	}
}
