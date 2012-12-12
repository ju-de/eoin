package dmcigd.levels.icecave;

import dmcigd.core.enums.*;
import dmcigd.core.objects.Entity;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.projectiles.*;
import dmcigd.core.objects.maps.*;

import java.util.*;

public class IcicleProjectile extends Entity implements SolidObject {
	
	int fallTimer = -1;
	
	public void fall(){
		setGravity();
		fallTimer = 0;
	}
	
	public IcicleProjectile(int x, int y, BlockMap blockMap, ArrayList<SolidObject> solidObjects) {
		setPhysicsHandler(new BasicProjectileHandler(blockMap, solidObjects));
		
		setEntityType(EntityType.PROJECTILE);
		
		setX(x);
		setY(y);
		
		setHeight(34);
		setWidth(16);
		setImageHeight(52);
		setImageWidth(22);
		
		setSequence(0);
		setFrame(0);

		setFrameLimits(new int[] {5,5});
		setAnimationLoops(new boolean [] {false,false});
		setFrameSpeed(0.15f);
		
		setImagePath("objects/icecave/icicle.gif");
	}
	
	public void step() {
		move();
		
		if(fallTimer >= 0) {
			if(hitGround) {
				setSequence(1);
				setEntityType(EntityType.DESTROYANIMATION);
				fallTimer++;
				if(fallTimer >= 40) {
					isDestroyed = true;
				}
			}
			animate();
		}
	}
	
}
