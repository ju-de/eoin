package dmcigd.core.objects;

import dmcigd.core.enums.*;

public class MovingObject extends ObjectCollision {
	
	//Initialize movement properties (position, velocity, and acceleration)
	private float vx,vy = 0;
	private float ax,ay = 0;
	private float tUp = 32;
	private float tDown = 32;
	private float tLeft = 32;
	private float tRight = 32;
	
	//Public getters
	public float getVX() {
		return vx;
	}
	public float getVY() {
		return vy;
	}
	public float getAX() {
		return ax;
	}
	public float getAY() {
		return ay;
	}
	
	//Public basic setters
	public void addX(float dx) {
		setX(getX() + dx);
	}
	public void addY(float dy) {
		setY(getY() + dy);
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
	
	//Create Acceleration Vector
	public void accelerateFrom(float speed1, float speed2, float rate, Direction direction) {
		
		if(speed1 > speed2) {
			//Deccelerate
			switch(direction) {
				case UP:
					setVY(-speed1);
					
					setTUp(speed1);
					setTDown(speed2);
					
					ay = rate;
					break;
				case DOWN:
					setVY(speed1);
					
					setTDown(speed1);
					setTUp(speed2);
					
					ay = -rate;
					break;
				case LEFT:
					setVX(-speed1);
					
					setTLeft(speed1);
					setTRight(speed2);
					
					ax = rate;
					break;
				case RIGHT:
					setVX(speed1);
					
					setTRight(speed1);
					setTLeft(speed2);
					
					ax = -rate;
					break;
			}
			
		} else {
			//Accelerate
			switch(direction) {
				case UP:
					setTDown(speed1);
					setVY(-speed1);
					break;
				case DOWN:
					setTUp(speed1);
					setVY(speed1);
					break;
				case LEFT:
					setTRight(speed1);
					setVX(-speed1);
					break;
				case RIGHT:
					setTLeft(speed1);
					setVX(speed1);
					break;
			}
			
			accelerate(rate, speed2, direction);
			
		}
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
	
	public void setGravity() {
		accelerate(0.4f, 5.0f, Direction.DOWN);
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
