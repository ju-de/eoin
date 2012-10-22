package dmcigd.core.objects;

import dmcigd.core.enums.*;

public class MovingObject extends VisibleObject {
	
	//Object Dimensions
	private int height = 32;
	private int width = 32;
	
	//Initialize position properties (position, velocity, and acceleration)
	private int x = 0;
	private int y = 0;
	private float vx = 0;
	private float vy = 2;
	private float ax = 0;
	private float ay = 0;
	private float tUp = 32;
	private float tDown = 32;
	private float tLeft = 32;
	private float tRight = 32;
	
	//Initialize collision property to be passed for child manipulation
	public boolean hitGround,isFalling,onLadder,isDead = false;
	
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
	public float getAY() {
		return ay;
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
	public void setAX(float ax) {
		this.ax = ax;
	}
	public void setAY(float ay) {
		this.ay = ay;
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
				ay = -rate;
				tUp = terminal;
				break;
			case DOWN:
				ay = rate;
				tDown = terminal;
				break;
			case LEFT:
				ax = -rate;
				tLeft = terminal;
				break;
			case RIGHT:
				ax = rate;
				tRight = terminal;
				break;
			default:
				break;
		}
	}
	
	public void move(boolean isClimbing) {
		
		//Calculate Acceleration
		vy = vy + ay;
		vx = vx + ax;
		
		//Cap all speeds at 30px per tick
		if(vy > tDown) {
			vy = tDown;
		}else if(vy < -tUp) {
			vy = -tUp;
		}
		if(vx > tRight) {
			vx = tRight;
		}else if(vx < -tLeft) {
			vx = -tLeft;
		}
		
		if((int) vy >= 0) {
			//Move Down
			
			int blockCollisionStatus = blockMap.collidesY(x, y, (int) vy, width, height, Direction.DOWN);
			
			switch(blockCollisionStatus) {
				case 4:
					isFalling = true;
					y = y + (int) vy;
					break;
				case 3:
					if(isClimbing) {
						y = y + (int) vy;
					} else {
						vy = 0;
					}
					break;
				case 1:
				default:
					y = blockMap.rowEdge(y, height, Direction.DOWN);
					vy = 0;
					break;
			}
			
		}else if((int) vy < 0) {
			//Move Up
			
			int blockCollisionStatus = blockMap.collidesY(x, y, (int) vy, width, height, Direction.UP);

			switch(blockCollisionStatus) {
				case 3:
				case 2:
				case 4:
					y = y + (int) vy;
					break;
				case 1:
					isDead = true;
				default:
					y = blockMap.rowEdge(y, height, Direction.UP);
					break;
			}
		}
		
		if((int) vx > 0) {
			//Move Right
			
			int blockCollisionStatus = blockMap.collidesX(x, y, (int) vx, width, height, Direction.RIGHT);
			
			switch(blockCollisionStatus) {
				case 3:
				case 2:
				case 4:
					x = x + (int) vx;
					break;
				case 1:
					isDead = true;
					break;
				default:
					x = blockMap.colEdge(x, width, Direction.RIGHT);
					break;
			}
			
		}else if((int) vx < 0) {
			//Move Left
			
			int blockCollisionStatus = blockMap.collidesX(x, y, (int) vx, width, height, Direction.LEFT);
			
			switch(blockCollisionStatus) {
				case 3:
				case 2:
				case 4:
					x = x + (int) vx;
					break;
				case 1:
					isDead = true;
					break;
				default:
					x = blockMap.colEdge(x, width, Direction.LEFT);
					break;
			}
			
		}
		
		//Determine resting block
		int restingBlock = blockMap.restingBlock(x,y,width,height);
		switch(restingBlock) {
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
	
	public void move() {
		move(false);
	}
}
