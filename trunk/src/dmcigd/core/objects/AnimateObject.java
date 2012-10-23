package dmcigd.core.objects;

import dmcigd.core.enums.Direction;

public class AnimateObject extends MovingObject {
	
	//Initialize blockmap
	private BlockMap blockMap;
	
	//Initialize collision properties to be passed for child manipulation
	public boolean hitGround,isFalling,onLadder,isClimbing,isDead = false;
	
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
		
		if(vy > 0) {
			
			//Move Down
			
			switch(blockMap.collidesY(getX(), getY(), vy, width, height, Direction.DOWN)) {
				case 4:
					isFalling = true;
					addY(vy);
					break;
				case 3:
					if(isClimbing) {
						addY(vy);
					} else {
						setVY(0);
					}
					break;
				case 1:
				default:
					setY(blockMap.rowEdge(getY(), height, Direction.DOWN));
					setVY(0);
					break;
			}
			
		}else if(vy < 0) {
			
			//Move Up

			switch(blockMap.collidesY(getX(), getY(), vy, width, height, Direction.UP)) {
				case 3:
				case 2:
				case 4:
					addY(vy);
					isFalling = false;
					break;
				case 1:
					isDead = true;
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
				case 3:
				case 2:
				case 4:
					addX(vx);
					break;
				case 1:
					isDead = true;
					break;
				default:
					setX(blockMap.colEdge(getX(), width, direction));
					break;
			}
		}
		
		//Determine resting block
		switch(blockMap.restingBlock(getX(),getY(),width,height)) {
			case 1:
				isDead = true;
				break;
			case 3:
				onLadder = true;
				hitGround = false;
				isFalling = false;
				break;
			case 2:
			case 0:
				onLadder = false;
				hitGround = true;
				isFalling = false;
				break;
			default:
				onLadder = false;
				hitGround = false;
				break;
		}
	}
}
