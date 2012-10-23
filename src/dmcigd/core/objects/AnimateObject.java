package dmcigd.core.objects;

import dmcigd.core.enums.Direction;
import dmcigd.core.enums.CollisionType;
import dmcigd.core.objects.maps.BlockMap;

public class AnimateObject extends MovingObject {
	
	//Initialize blockmap
	private BlockMap blockMap;
	
	//Initialize collision properties to be passed for child manipulation
	public boolean hitGround,isFalling,onLadder,isClimbing,isDead,inWater = false;
	
	//Initialize collision properties for collision checks
	private int vx,vy,width,height;
	
	//Receive blockmap from subclass
	public void setBlockMap(BlockMap blockMap) {
		this.blockMap = blockMap;
	}
	
	public void move() {
		
		addAcceleration();
		
		vx = getVX();
		vy = getVY();
		width = getWidth();
		height = getHeight();
		
		if(inWater) {
			vy = (int) (vy / 2.2f); //If in water, divides falling or jumping speed by factor of 2.2
		}
		
		if(vy > 0) {
			
			//Move Down
			
			switch(blockMap.collidesY(getX(), getY(), vy, width, height, Direction.DOWN)) {
			
				//Fall down
				case NONSOLID:
				case WATER:
					isFalling = true;
					addY(vy);
					break;
					
				//Climb down
				case LADDER:
					if(isClimbing) {
						addY(vy);
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
			
		}else if(vy < 0) {
			
			//Move Up

			switch(blockMap.collidesY(getX(), getY(), vy, width, height, Direction.UP)) {
			
				//Move up
				case NONSOLID:
				case WATER:
				case LADDER:
				case PLATFORM:
					addY(vy);
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
		}
		
		if(vx != 0) {
			
			//Move Sideways
			
			Direction direction;
			if(vx > 0) {
				direction = Direction.RIGHT;
			} else {
				direction = Direction.LEFT;
			}
			
			switch(blockMap.collidesX(getX(), getY(), vx, width, height, direction)) {
			
				//Pass through
				case NONSOLID:
				case WATER:
				case LADDER:
				case PLATFORM:
					addX(vx);
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
		}
		
		//Determine resting block
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
	}
}
