package dmcigd.core.objects;

import dmcigd.core.enums.Direction;
import dmcigd.core.objects.maps.BlockMap;
import dmcigd.core.objects.interfaces.*;

import java.util.*;
import java.awt.*;

public class AnimateObject extends MovingObject {
	
	//Initialize blockmap
	private BlockMap blockMap;
	
	//Initialize collision properties to be passed for child manipulation
	public boolean hitGround,isFalling,onLadder,isClimbing,isDead,inWater = false;
	
	//Initialize collision properties for collision checks
	private int vx,vy,width,height;
	
	//Initialize Resting Block
	private RestableObject restingBlock,restingBlockCheck;
	
	//Receive blockmap from subclass
	public void setBlockMap(BlockMap blockMap) {
		this.blockMap = blockMap;
	}
	
	public void checkSolidObjectCollision(ArrayList<SolidObject> solidObjects, int v, Direction direction) {
		
		boolean obstructMovement = false;
		Rectangle boundingBox;
		
		if(direction == Direction.DOWN || direction == Direction.UP) {
			//Checks block directly beneath you
			//Allows for negligible 1px overlap onto solid blocks
			boundingBox = getBounds(0, v + 1);
		} else {
			boundingBox = getBounds(v, 0);
		}
		
		//This code will be cleaned up after all the cases are coded in
		//For now just bear with me
		for (SolidObject i : solidObjects) {
			if(boundingBox.intersects(i.getBounds())) {
				switch (direction) {
					case DOWN:
						switch(i.getCollisionType()) {
							case PLATFORM:
								//Check if object is not inside of platform
								if(getY() + getHeight() <= i.getY()) {
									setY(i.getY() - getHeight());
									restingBlockCheck = (RestableObject) i;
									obstructMovement = true;
									setVY(0);
								}
								break;
							case SOLID:
								if(i.getY() > getY()) {
									setY(i.getY() - getHeight());
									restingBlockCheck = (RestableObject) i;
									obstructMovement = true;
									setVY(0);
								} else {
									setY(i.getY() + i.getHeight());
									obstructMovement = true;
								}
								break;
							default:
								break;
						}
						break;
					case UP:
						switch(i.getCollisionType()) {
							case PLATFORM:
								if(restingBlock != i) {
									break;
								}
							case SOLID:
								if(restingBlock == i) {
									setY(i.getY() - getHeight());
									restingBlockCheck = (RestableObject) i;
									obstructMovement = true;
									setVY(0);
								} else {
									setY(i.getY() + i.getHeight());
									obstructMovement = true;
								}
								break;
							default:
								break;
						}
						break;
					default:
						break;
				}
			}
		}
		
		if(!obstructMovement) {
			if(direction == Direction.DOWN || direction == Direction.UP) {
				addY(v);
			} else {
				addX(v);
			}
		}
	}
	
	public void checkBlockMapCollision(int v, ArrayList<SolidObject> solidObjects, Direction direction) {
		
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
						checkSolidObjectCollision(solidObjects, v, direction);
						break;
						
					//Climb down
					case LADDER:
						if(isClimbing) {
							checkSolidObjectCollision(solidObjects, v, direction);
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
						checkSolidObjectCollision(solidObjects, v, direction);
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
			default:
				
				switch(blockMap.collidesX(getX(), getY(), v, width, height, direction)) {
				
					//Pass through
					case NONSOLID:
					case WATER:
					case LADDER:
					case PLATFORM:
						checkSolidObjectCollision(solidObjects, v, direction);
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
	
	public void move(ArrayList<SolidObject> solidObjects) {
		
		
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
			checkBlockMapCollision(vy, solidObjects, Direction.DOWN);
		}else {
			//Move Up
			checkBlockMapCollision(vy, solidObjects, Direction.UP);
		}
		
		if(vx >= 0) {
			checkBlockMapCollision(vx, solidObjects, Direction.RIGHT);
		} else { 
			checkBlockMapCollision(vx, solidObjects, Direction.LEFT);
		}
		
		restingBlock = restingBlockCheck;
		
		if(restingBlock == null) {
			
			//Determine resting block on tilemap
			switch(blockMap.restingBlock(getX(),getY(),width,height)) {
			
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
			
		} else {
			
			//Treat resting blocks like solid ground
			inWater = false;
			onLadder = false;
			hitGround = true;
			isFalling = false;
			
		}
	}
}
