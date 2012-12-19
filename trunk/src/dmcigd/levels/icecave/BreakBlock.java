package dmcigd.levels.icecave;

import dmcigd.core.enums.*;
import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;

public class BreakBlock extends Entity implements RestableObject {
	
	private int objectClock = -3;
	private int invincibilityClock;
	
	public boolean onAttack(int damage, boolean flipped) {
		if(invincibilityClock == 0) {
			objectClock++;
			setFrame(getFrame()+1);
			invincibilityClock = 15;
			if(objectClock == -1) {
				setGravity();
				setEntityType(EntityType.DESTROYANIMATION);
			}
		}
		return false;
	}
	
	public boolean isDestroyed() { return false; }
	
	public BreakBlock(int x, int y, PhysicsHandler physicsHandler) {
		
		setX(x);
		setY(y);
		setDX(0);
		setDY(0);
		setHeight(30);
		setWidth(32);
		setImageHeight(32);
		setImageWidth(32);
		
		setSequence(0);
		setFrame(0);
		
		setFrameLimits(new int[] {8});
		setAnimationLoops(new boolean[] {false});
		setFrameSpeed(0.15f);
		
		setImagePath("objects/icecave/icecube.gif");
		
		setCollisionType(CollisionType.SOLID);
		setEntityType(EntityType.SOLIDBLOCK);
		setPhysicsHandler(physicsHandler);
		
	}
	
	public void step() {
		if(objectClock > -1) {
			move();
			animate();
			if(getFrame() == 3) {
				setCollisionType(CollisionType.NONSOLID);
			}
		} else  if(invincibilityClock > 0) {
			invincibilityClock--;
		}
	}
}