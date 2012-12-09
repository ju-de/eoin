package dmcigd.levels.icecave;

import dmcigd.core.enums.*;
import dmcigd.core.objects.Entity;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.projectiles.*;
import dmcigd.core.objects.maps.*;

import java.util.*;

public class IcicleProjectile extends ProjectileMotion implements SolidObject {
	
	public void fall(){
		setGravity();
	}
	
	public void rest(){ }
	
	public IcicleProjectile(int x, int y, BlockMap blockMap, ArrayList<SolidObject> solidObjects) {
		setPhysicsHandler(new BasicProjectileHandler(blockMap, solidObjects));
		
		setEntityType(EntityType.PROJECTILE);
		
		setX(x);
		setY(y);
		
		setHeight(32);
		setWidth(32);
		setImageHeight(32);
		setImageWidth(32);
		
		setSequence(1);
		setFrame(9);
		
		setImagePath("tilesheets/icy.gif");
		
		rest();
	}
	
	public void step() {
		move();
	}
	
}
