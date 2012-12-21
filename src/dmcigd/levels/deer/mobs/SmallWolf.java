package dmcigd.levels.deer.mobs;

import dmcigd.core.enums.*;
import dmcigd.core.room.Room;
import dmcigd.core.objects.interfaces.*;

public class SmallWolf extends WolfAI implements RestableObject {

	public void die() {
		setSequence(3);
		setFrameSpeed(0.2f);
		setCollisionType(CollisionType.NONSOLID);
	}

	public void moveLeft() {
		flipped = true;
		accelerate(0.5f, 3f, Direction.LEFT);
		setSequence(1);
		setFrameSpeed(0.12f);
	}

	public void moveRight() {
		flipped = false;
		accelerate(0.5f, 3f, Direction.RIGHT);
		setSequence(1);
		setFrameSpeed(0.12f);
	}
	
	public SmallWolf(int x, int y, Room room) {

		setX(x);
		setY(y);
		setWidth(36);
		setHeight(26);
		setImageWidth(48);
		setImageHeight(36);
		
		setSequence(0);
		setFrame(0);

		setFrameLimits(new int[] {2, 4, 5, 4});
		setAnimationLoops(new boolean [] {true, true, false, false});
		setFrameSpeed(0.02f);
		
		setMaxHitpoints(50);
		setKnockback(true);
		
		setDeathClockLimit(70);
		setAIClockReset(40);
		setRoom(room);
		
		setGravity();
		
		setPhysicsHandler(room.getPhysicsHandler());
		setCollisionType(CollisionType.SOLID);
		setEntityType(EntityType.NONLETHALMONSTER);
		
		setImagePath("objects/deer/smallwolf.gif");
	}
	public void step() {
		
		super.step();
		
		think();
		
		move();
		
		if(!isKnockedBack()) {
			animate();
		}
	}

}
