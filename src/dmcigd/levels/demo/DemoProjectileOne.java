package dmcigd.levels.demo;

import dmcigd.core.enums.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.projectiles.*;
import dmcigd.core.objects.maps.*;

import java.util.*;

public class DemoProjectileOne extends ProjectileMotion implements SolidObject {
	
	public DemoProjectileOne(int x, int y, int speed, int angle, BlockMap blockMap, ArrayList<SolidObject> solidObjects) {
		setPhysicsHandler(new SimpleProjectileHandler(blockMap, solidObjects));
		
		setProjectileMotion(speed, angle);
		
		setEntityType(EntityType.PROJECTILE);
		
		setX(x);
		setY(y);
		
		setHeight(28);
		setWidth(28);
		setImageHeight(32);
		setImageWidth(32);
		
		setSequence(4);
		setFrame(8);
		
		setImagePath("objects.gif");
	}
	
	public void step() {
		move();
	}
	
}
