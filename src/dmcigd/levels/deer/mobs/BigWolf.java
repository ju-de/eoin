package dmcigd.levels.deer.mobs;

import dmcigd.core.enums.*;
import dmcigd.core.room.Room;
import dmcigd.core.objects.interfaces.*;

public class BigWolf extends WolfAI implements RestableObject {

	public void die() {
		setSequence(2);
		setFrameSpeed(0.1f);
		setCollisionType(CollisionType.NONSOLID);
	}

	public void moveLeft() {
		flipped = true;
		accelerate(0.3f, 1f, Direction.LEFT);
		setSequence(1);
		setFrameSpeed(0.12f);
	}

	public void moveRight() {
		flipped = false;
		accelerate(0.3f, 1f, Direction.RIGHT);
		setSequence(1);
		setFrameSpeed(0.12f);
	}
	
	public void attack() {
		//Overrides attack with idling (big wolf has no attack)
		idle();
	}
	public BigWolf(int x, int y, Room room) {

		setX(x);
		setY(y);
		setWidth(52);
		setHeight(74);
		setImageWidth(72);
		setImageHeight(84);
		
		setSequence(0);
		setFrame(0);

		setFrameLimits(new int[] {2, 4, 5});
		setAnimationLoops(new boolean [] {true, true, false});
		setFrameSpeed(0.02f);
		
		setMaxHitpoints(70);
		setKnockback(true);
		
		setDeathClockLimit(100);
		setAIClockReset(40);
		setRoom(room);
		
		setGravity();
		
		setPhysicsHandler(room.getPhysicsHandler());
		setCollisionType(CollisionType.PLATFORM);
		setEntityType(EntityType.NONLETHALMONSTER);
		
		setImagePath("objects/deer/bigwolf.gif");
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
