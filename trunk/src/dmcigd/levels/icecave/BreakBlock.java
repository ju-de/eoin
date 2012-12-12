package dmcigd.levels.icecave;

import dmcigd.core.enums.*;
import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;

public class BreakBlock extends ObjectCollision implements RestableObject {
	
	private int objectClock = -3;
	private int invincibilityClock;
	
	public boolean onAttack(int damage, boolean flipped) {
		if(invincibilityClock == 0) {
			objectClock++;
			setFrame(getFrame()+1);
			invincibilityClock = 15;
		}
		return false;
	}
	
	public boolean isDestroyed() { return false; }
	
	public BreakBlock(int x, int y) {
		
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
		
	}
	
	public void step() {
		if(objectClock > -1) {
			animate();
			if(getFrame() == 3) {
				setCollisionType(CollisionType.NONSOLID);
			}
		} else  if(invincibilityClock > 0) {
			invincibilityClock--;
		}
	}
}