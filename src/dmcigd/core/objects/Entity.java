package dmcigd.core.objects;

import dmcigd.core.enums.*;
import dmcigd.core.objects.maps.BlockMap;
import dmcigd.core.objects.interfaces.*;

import java.util.*;
import java.awt.*;

public class Entity extends MovingObject {
	
	//Initialize level objects
	private BlockMap blockMap;
	private ArrayList<SolidObject> solidObjects;
	
	private EntityType entityType;
	
	//Initialize collision properties to be passed for child manipulation
	public boolean hitGround,isFalling,onLadder,isClimbing,isDead,inWater = false;
	
	//Initialize collision properties for collision checks
	private int vx,vy,width,height;
	
	//Initialize Resting Block
	private RestableObject restingBlock,restingBlockCheck;
	
	//Public getters
	public EntityType getEntityType() {
		return entityType;
	}
	
	//Public setters
	public void setBlockMap(BlockMap blockMap) {
		this.blockMap = blockMap;
	}
	public void setSolidObjects(ArrayList<SolidObject> solidObjects) {
		this.solidObjects = solidObjects;
	}
	public void setEntityType(EntityType entityType) {
		this.entityType = entityType;
	}
	
	public boolean objectsCollide(Rectangle boundingBox, SolidObject object) {
		
		//Checks if objects overlap
		//And that player collided into object, object was not formed over player
		//Actions that take place when an object forms over the player should be handled
		//By the object itself, not in a collision check
		
		if(boundingBox.intersects(object.getBounds()) && (restingBlock == object || !getBounds().intersects(object.getBounds()))) {
			return true;
		} else {
			return false;
		}
	}
	
	public void checkSolidObjectCollisionDown(int v) {
		
		boolean obstructMovement = false;
		
		//Get bounding box of destination
		Rectangle boundingBox = getBounds(0, v+1);
		
		//Loop through all solid objects
		for (SolidObject i : solidObjects) {
			
			//Check for collision
			if(objectsCollide(boundingBox, i)) {
				
				//Determine collision type
				switch(i.getCollisionType()) {
				
					case PLATFORM:
						//Check if object is not inside of platform
						if(getY() + getHeight() > i.getY()) {
							break;
						}
					case SOLID:
						setY(i.getY() - getHeight());
						restingBlockCheck = (RestableObject) i;
						setVY(0);
						obstructMovement = true;
						break;
					default:
						//Advance object normally
						addY(v);
						break;
				}
			}
		}
		
		if(!obstructMovement) {
			//Advance normally
			addY(v);
		}
	}
	
	public void checkSolidObjectCollisionUp(int v) {
		
		boolean obstructMovement = false;
		
		//Get bounding box of destination
		Rectangle boundingBox = getBounds(0, v + 1);
		
		//Loop through all solid objects
		for (SolidObject i : solidObjects) {
			
			//Check for collision
			if(objectsCollide(boundingBox, i)) {
				
				//Determine collision type
				switch(i.getCollisionType()) {
					case PLATFORM:
						if(restingBlock != i) {
							break;
						}
					case SOLID:
						
						//Check if object is being pushed up by resting block
						if(restingBlock == i) {
							setY(i.getY() - getHeight() + 1);
							restingBlockCheck = (RestableObject) i;
							setVY(0);
						} else {
							//Otherwise, hit ceiling
							setY(i.getY() + i.getHeight());
							obstructMovement = true;
						}
						
						break;
					default:
						//Advance normally
						break;
				}
			}
		}
		
		if(!obstructMovement) {
			//Advance normally
			addY(v);
		}
	}
	
	public void checkSolidObjectCollisionX(int v) {
		
		boolean obstructMovement = false;
		
		//Get bounding box of destination
		Rectangle boundingBox = getBounds(v, 0);
		
		//Loop through all solid objects
		for (SolidObject i : solidObjects) {
			
			//Check for collision
			if(objectsCollide(boundingBox, i)) {
				
				//Push against block
				i.onPush(entityType, v);
				
				//Determine collision type
				switch (i.getCollisionType()) {
					case SOLID:
						if(v > 0) {
							//Push against left edge (if moving right)
							setX(i.getX() - getWidth());
						} else {
							//Push against right edge (if moving left)
							setX(i.getX() + i.getWidth());
						}
						obstructMovement = true;
						break;
					default:
						break;
				}
			}
		}
		
		if(!obstructMovement) {
			//Advance normally
			addX(v);
		}
	}
	
	public void checkBlockMapCollision(int v, Direction direction) {
		
		//Initialize variables
		width = getWidth();
		height = getHeight();
		
		//Check Collision
		switch (direction) {
			case DOWN:
				
				//Move Down
				switch(blockMap.collidesY(getX(), getY(), v, width, height, Direction.DOWN)) {
				
					//Fall down
					case NONSOLID:
					case WATER:
						isFalling = true;
						checkSolidObjectCollisionDown(v);
						break;
						
					//Climb down
					case LADDER:
						if(isClimbing) {
							checkSolidObjectCollisionDown(v);
						} else {
							setVY(0);
						}
						break;
						
					//Destroy
					case DESTROY:
						isDead = true;
						break;
						
					//Hit ground
					default:
						setY(blockMap.rowEdge(getY(), height, Direction.DOWN));
						setVY(0);
						break;
				}
				
				break;
				
			case UP:

				switch(blockMap.collidesY(getX(), getY(), v, width, height, Direction.UP)) {
				
					//Move up
					case NONSOLID:
					case WATER:
					case LADDER:
					case PLATFORM:
						checkSolidObjectCollisionUp(v);
						isFalling = false;
						break;
						
					//Destroy
					case DESTROY:
						isDead = true;
						
					//Hit ceiling
					default:
						setY(blockMap.rowEdge(getY(), height, Direction.UP));
						break;
				}
				
				break;
				
			default: //Moving left or right
				
				switch(blockMap.collidesX(getX(), getY(), v, width, height, direction)) {
				
					//Pass through
					case NONSOLID:
					case WATER:
					case LADDER:
					case PLATFORM:
						checkSolidObjectCollisionX(v);
						break;
						
					//Destroy
					case DESTROY:
						isDead = true;
						break;
						
					//Hit wall
					default:
						setX(blockMap.colEdge(getX(), width, direction));
						break;
				}
				
				break;
		}
	}
	
	public void move() {
		
		
		addAcceleration();
		
		vx = getVX();
		vy = getVY();
		width = getWidth();
		height = getHeight();
		
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
			checkBlockMapCollision(vy, Direction.DOWN);
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
				restingBlock.onUnrest(entityType);
				restingBlock = null;
			} else {
				restingBlock = restingBlockCheck;
				restingBlock.onRest(entityType);
			}
		}
		
		CollisionType restingBlockType;
		
		if(restingBlock == null) {
			restingBlockType = blockMap.restingBlock(getX(),getY(),width,height);
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
