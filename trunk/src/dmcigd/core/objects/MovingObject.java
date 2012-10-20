package dmcigd.core.objects;

import dmcigd.core.*;

public class MovingObject extends VisibleObject {
	
	//Object Dimensions
	private int height = 32;
	private int width = 32;
	
	//Initialize position properties (position, velocity, and acceleration)
	private int x = 0;
	private int y = 0;
	private float vx = 0;
	private float vy = 2;
	private float aUp = 0;
	private float aDown = 0;
	private float aLeft = 0;
	private float aRight = 0;
	private float tUp = 32;
	private float tDown = 32;
	private float tLeft = 32;
	private float tRight = 32;
	
	//Initialize hitGround and isFalling property to be passed for child manipulation
	public boolean hitGround,isFalling;
	
	//Initialize blockLoader
	private BlockMap blockMap;
	
	//Public getters
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public float getVX() {
		return vx;
	}
	public float getVY() {
		return vy;
	}
	
	//Public setters
	public void setHeight(int height) {
		this.height = height;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setVX(float vx) {
		this.vx = vx;
	}
	public void setVY(float vy) {
		this.vy = vy;
	}
	public void setAUp(float aUp) {
		this.aUp = aUp;
	}
	public void setADown(float aDown) {
		this.aDown = aDown;
	}
	public void setALeft(float aLeft) {
		this.aLeft = aLeft;
	}
	public void setARight(float aRight) {
		this.aRight = aRight;
	}
	public void setTUp(float tUp) {
		this.tUp = tUp;
	}
	public void setTDown(float tDown) {
		this.tDown = tDown;
	}
	public void setTLeft(float tLeft) {
		this.tLeft = tLeft;
	}
	public void setTRight(float tRight) {
		this.tRight = tRight;
	}
	public void setBlockLoader(BlockMap blockMap) {
		this.blockMap = blockMap;
	}
	public void setGravity() {
		accelerate(0.4f, 5.0f, Direction.DOWN);
	}
	public void accelerate(float rate, float terminal, Direction direction) {
		switch(direction) {
			case UP:
				aUp = rate;
				tUp = terminal;
				break;
			case DOWN:
				aDown = rate;
				tDown = terminal;
				break;
			case LEFT:
				aLeft = rate;
				tLeft = terminal;
				break;
			case RIGHT:
				aRight = rate;
				tRight = terminal;
				break;
			default:
				break;
		}
	}
	
	public void move() {
		
		hitGround = false;
		isFalling = false;
		
		char[][] immediateBlocks = blockMap.getImmediateBlocks(x,y);
		
		//Calculate Acceleration
		vx = vx + aRight - aLeft;
		vy = vy + aDown - aUp;
		
		//Cap all speeds at 30px per tick
		if(vx + aRight - aLeft > tRight) {
			vx = tRight;
		}else if(vx + aRight - aLeft < -tLeft) {
			vx = -tLeft;
		}
		if(vy + aDown - aUp > tDown) {
			vy = tDown;
		}else if(vy + aDown - aUp < -tUp) {
			vy = -tUp;
		}
		
		if((int) vx > 0) {
			//Move Right
			
			int blockCollisionStatus = blockMap.collidesX(x, y, (int) vx, width, height, Direction.RIGHT);
			
			switch(blockCollisionStatus) {
				case 2:
					x = x + (int) vx;
					break;
				case 1:
					System.out.println("Oh dear, you are dead!");
					break;
				default:
					x = blockMap.colEdge(x, width, Direction.RIGHT);
					break;
			}
			
		}else if((int) vx < 0) {
			//Move Left
			
			int blockCollisionStatus = blockMap.collidesX(x, y, (int) vx, width, height, Direction.LEFT);
			
			switch(blockCollisionStatus) {
				case 2:
					x = x + (int) vx;
					break;
				case 1:
					System.out.println("Oh dear, you are dead!");
					break;
				default:
					x = blockMap.colEdge(x, width, Direction.LEFT);
					break;
			}
			
		}
		
		if((int) vy >= 0) {
			//Move Down
			
			int blockCollisionStatus = blockMap.collidesY(x, y, (int) vy, width, height, Direction.DOWN);
			
			switch(blockCollisionStatus) {
				case 2:
					y = y + (int) vy;
					isFalling = true;
					break;
				case 1:
					System.out.println("Oh dear, you are dead!");
					break;
				default:
					y = blockMap.rowEdge(y, height, Direction.DOWN);					hitGround = true;
					hitGround = true;
					break;
			}
			
		}else if((int) vy < 0) {
			//Move Up
			
			int blockCollisionStatus = blockMap.collidesY(x, y, (int) vy, width, height, Direction.UP);

			switch(blockCollisionStatus) {
				case 2:
					y = y + (int) vy;
					break;
				case 1:
					System.out.println("Oh dear, you are dead!");
					break;
				default:
					y = blockMap.rowEdge(y, height, Direction.UP);
					break;
			}
		}
		
		if(hitGround) {
			vy = 0;
		}
	}
}
