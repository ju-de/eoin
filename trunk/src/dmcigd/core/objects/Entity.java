package dmcigd.core.objects;

import dmcigd.core.enums.*;
import dmcigd.core.objects.interfaces.*;

public class Entity extends MovingObject {
	
	private EntityType entityType;

	private RestableObject restingBlock;
	
	//Creates entity statuses for further manipulation
	public boolean hitGround,isFalling,isDead,isDestroyed,inWater = false;
	
    private PhysicsHandler physicsHandler;
        
	//Public getters
	public EntityType getEntityType() {
		return entityType;
	}
	public PhysicsHandler getPhysicsHandler(){
        return physicsHandler;
    }
	public RestableObject getRestingBlock() {
		return restingBlock;
	}
	public boolean isDestroyed() {
		return isDestroyed;
	}
        
	//Public setters
	public void setEntityType(EntityType entityType) {
		this.entityType = entityType;
	}
	
    public void setPhysicsHandler(PhysicsHandler physicsHandler){
        this.physicsHandler = physicsHandler;
    }
        
	//Checks for water
	public CollisionType backBlock;

	public void onPush(Entity entity, int v) {
		if(entity.getEntityType() == EntityType.MOVINGBLOCK) {
			addX(v);
		}
	}
	
    //Actions
    public void pushObject(SolidObject object, int v) {
        object.onPush(this, v);
    }
    public void restObject(RestableObject restingBlockCheck) {
    	if(restingBlock != null) {
    		unrestObject();
    	}
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
		
		//Move Vertically
		if(vy >= 0) {
			//Move Down
			physicsHandler.moveDown(this, vy);
		}else {
			//Move Up
			physicsHandler.moveUp(this, vy);
		}
		
		//Move Horizontally
		if(vx >= 0) {
			//Move Right
			physicsHandler.moveX(this, vx);
		} else if (vx < 0) { 
			//Move Left
			physicsHandler.moveX(this, vx);
		}
		
		//Checks for water
		backBlock = physicsHandler.getBlockMap().backBlock(getX(),getY(),getWidth(),getHeight());
		
		if(backBlock == CollisionType.WATER) {
			inWater = true;
			hitGround = true;
		}
	}
}