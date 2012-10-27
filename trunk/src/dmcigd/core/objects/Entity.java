package dmcigd.core.objects;

import dmcigd.core.enums.*;

public class Entity extends EntityBlockMapCollider {
	
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
		
		restingBlockCheck = null;
		
		if(vy >= 0) {
			//Move Down
			checkBlockMapCollisionDown(vy);
		}else {
			//Move Up
			checkBlockMapCollision(vy, Direction.UP);
		}
		
		if(vx > 0) {
			checkBlockMapCollision(vx, Direction.RIGHT);
		} else if (vx < 0) { 
			checkBlockMapCollision(vx, Direction.LEFT);
		} else {
			setDX(0);
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
		
		CollisionType restingBlockType;
		
		if(restingBlock == null) {
			restingBlockType = blockMap.restingBlock(getX(),getY(),getWidth(),getHeight());
		} else {
			restingBlockType = restingBlock.getCollisionType();
		}
			
		//Determine entity states based on resting block
		switch(restingBlockType) {
		
			//On ground
			case PLATFORM:
			case SOLID:
				inWater = false;
				onLadder = false;
				hitGround = true;
				isFalling = false;
				break;
			
			//On ladder
			case LADDER:
				inWater = false;
				onLadder = true;
				hitGround = false;
				isFalling = false;
				break;
			
			//In water
			case WATER:
				inWater = true;
				onLadder = false;
				hitGround = true;
				break;
				
			//In air
			default:
				inWater = false;
				onLadder = false;
				hitGround = false;
				break;
		}
	}
}
