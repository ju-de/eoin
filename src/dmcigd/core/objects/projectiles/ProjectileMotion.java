package dmcigd.core.objects.projectiles;

import dmcigd.core.objects.*;

public class ProjectileMotion extends Entity {
	
	public void setProjectileMotion(float speed, int angle, boolean flipped) {
		
		//Flips angle if necessary, default facing right
		if(flipped) {
			angle = 180 - angle;
		}
		
		//Converts to radians
		double radians = Math.toRadians(angle);
		
		//Determines component vectors
		double vx = speed * Math.cos(radians);
		setVX((float) vx);
		
		double vy = -speed * Math.sin(radians);
		setVY((float) vy);
		
	}
	//Overloads method with flipped defaulted to false
	public void setProjectileMotion(float speed, int angle) {
		setProjectileMotion(speed, angle, false);
	}
}