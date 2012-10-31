package dmcigd.core.objects.projectiles;

import dmcigd.core.enums.EntityType;
import dmcigd.core.objects.*;

public class BasicProjectile extends Entity {

	public BasicProjectile(int x, int y, int speed, int angle, boolean flipped) {
		
		setX(x);
		setY(y);
		
		//Flips angle if necessary, default facing right
		if(flipped) {
			angle = 180 - angle;
		}
		
		//Converts to radians
		double radians = Math.toRadians(angle);
		
		//Determines component vectors
		double vx = speed * Math.cos(radians);
		setVX((float) vx);
		
		double vy = speed * Math.sin(radians);
		setVY((float) vy);
		
		//If specific collision attributes are necessary, override the EntityType in the constructor
		setEntityType(EntityType.PROJECTILE);
			
	}
	
	public BasicProjectile(int x, int y, int speed, int angle) {
		this(x,y,speed,angle,false);
	}
	
	public void step() {
		move();
	}
}
