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
	public int getVX() {
		return (int) vx;
	}
	public int getVY() {
		return (int) vy;
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
	public void addX(int vx) {
		x = x + vx;
	}
	public void addY(int vy) {
		y = y + vy;
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
	
	public void addAcceleration() {
		
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
	}
}
