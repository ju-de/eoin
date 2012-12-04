package dmcigd.core.objects.monsters;

import java.util.Random;

import dmcigd.core.enums.Direction;
import dmcigd.core.objects.MovingObject;

public class BasicSwarmThink {
	
	private static Random generator = new Random();
	
	public static void moveRandomAngle(MovingObject movingObject, int xMultiplier, int yMultiplier, float ax, float ay, double speed) {
		
		//Generates angle in radians
		double angle = generator.nextGaussian() * 1.57;
		
		//Determines component vectors
		double compX = Math.abs(speed * Math.cos(angle));
		double compY = Math.abs(speed * Math.sin(angle));
		
		//Creates acceleration vectors
		Direction directionX;
		Direction directionY;
		
		if(xMultiplier >= 0) {
			directionX = Direction.RIGHT;
		} else {
			directionX = Direction.LEFT;
		}
		if(yMultiplier >= 0) {
			directionY = Direction.DOWN;
		} else {
			directionY = Direction.UP;
		}
		
		movingObject.accelerate(ax, (float) compX, directionX);
		movingObject.accelerate(ay, (float) compY, directionY);
		
	}

	public static void swarmThink(MovingObject movingObject, int destX, int destY, int centerRange, int outerRange, float ax, float ay, double speed) {
		//Determine distance from center
		double distance = Math.sqrt(Math.pow((movingObject.getX() - destX), 2) + Math.pow((movingObject.getY() - destY), 2));
		
		if(distance < centerRange) {
			//Repel from center
			//Probability of changing direction increases the closer the particle is to center
			if(generator.nextFloat() > distance / centerRange) {
				
				//Move in random direction
				int xMultiplier = Math.round(generator.nextFloat());
				int yMultiplier = Math.round(generator.nextFloat());
				
				moveRandomAngle(movingObject, xMultiplier, yMultiplier, ax, ay, speed);
			}
		}else {
			//Move back to center
			//Probability of changing direction increases the further particle is to center
			if(generator.nextFloat() < distance / outerRange) {
				
				int xMultiplier;
				int yMultiplier;
				
				//Determine direction of motion
				if(movingObject.getX() > destX) {
					xMultiplier = -1;
				}else{
					xMultiplier = 1;
				}
				
				if(movingObject.getY() > destY) {
					yMultiplier = -1;
				} else {
					yMultiplier = 1;
				}
				
				moveRandomAngle(movingObject, xMultiplier, yMultiplier, ax, ay, speed);
				
			}
			
		}
		
	}
	
	public static void swarmThink(MovingObject movingObject, int destX, int destY, int centerRange, int outerRange, float ax, float ay, int constant, int innerCoefficient, int outerCoefficient) {
		//Overloads swarmThink method to account for dynamic speeds
		double speed, distance = Math.sqrt(Math.pow((movingObject.getX() - destX), 2) + Math.pow((movingObject.getY() - destY), 2));
		if(distance < centerRange) {
			speed = (centerRange+constant-distance)/innerCoefficient;
		} else {
			speed = distance/outerCoefficient;
		}
		swarmThink(movingObject, destX, destY, centerRange, outerRange, ax, ay, speed);
	}
	
}
