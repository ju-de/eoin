package dmcigd.core.objects.blocks;

import dmcigd.core.enums.*;
import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;

public class CrumblingBlock extends ObjectCollision implements RestableObject {
	
	private int objectClock,clockReset = -1;
	private float crumbleSpeed;
	
	public void onRest(EntityType entityType) {
		objectClock = 0;
		setFrameSpeed(crumbleSpeed);
	}
	
	public void onUnrest(EntityType entityType) {}
	
	public void onPush(EntityType entityType, int v) {}
	
	public boolean isDestroyed() { return false; }
	
	public CrumblingBlock(int x, int y, float crumbleSpeed, int clockReset) {
		
		setX(x);
		setY(y);
		setDX(0);
		setDY(0);
		setHeight(30);
		setWidth(32);
		setImageHeight(32);
		setImageWidth(32);
		
		setSequence(3);
		setFrame(0);
		
		//Initiates an 7 frame one-shot animation for crumbling blocks at index 3
		//The animation itself is only 6 frames, but one blank frame is needed at the end
		setFrameLimits(new int[] {0,0,0,7});
		setAnimationLoops(new boolean[] {false,false,false,false});
		setFrameSpeed(0);
		
		setMapCode("`");
		setImagePath("demo/objects.gif");
		
		this.clockReset = clockReset;
		this.crumbleSpeed = crumbleSpeed;
		
		setCollisionType(CollisionType.SOLID);
		
	}
	
	public void step() {
		if(objectClock > -1) {
			animate();
			//Object becomes non-solid when block starts to crumble, not when animation ends
			if(getFrame() == 4) {
				setCollisionType(CollisionType.NONSOLID);
			}
			objectClock++;
			if(objectClock > clockReset) {
				objectClock = -1;
				setFrameSpeed(0);
				setFrame(0);
				setCollisionType(CollisionType.SOLID);
			}
		}
	}
}
