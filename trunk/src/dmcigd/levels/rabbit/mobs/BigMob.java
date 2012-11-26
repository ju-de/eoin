package dmcigd.levels.rabbit.mobs;

import dmcigd.core.enums.*;
import dmcigd.core.objects.PhysicsHandler;
import dmcigd.core.objects.interfaces.*;

public class BigMob extends RabbitAI implements RestableObject {

	public void die() {
		setImageWidth(66);
		setCollisionType(CollisionType.NONSOLID);
		setSequence(2);
		setFrameSpeed(0.15f);
	}

	public void moveLeft() {
		flipped = true;
		setVX(-0.5f);
		setSequence(1);
		setFrameSpeed(0.06f);
	}

	public void moveRight() {
		flipped = false;
		setVX(0.5f);
		setSequence(1);
		setFrameSpeed(0.06f);
	}
	
	public BigMob(int x, int y, PhysicsHandler physicsHandler) {

		setX(x);
		setY(y);
		setWidth(38);
		setHeight(52);
		setImageWidth(50);
		setImageHeight(64);
		
		setSequence(0);
		setFrame(0);

		setFrameLimits(new int[] {2, 4, 3});
		setAnimationLoops(new boolean [] {true, true, false});
		setFrameSpeed(0.02f);
		
		setMaxHitpoints(100);
		setKnockback(true);
		
		setDeathClockLimit(100);
		setAIClockReset(50);
		
		setGravity();
		
		setPhysicsHandler(physicsHandler);
		setCollisionType(CollisionType.PLATFORM);
		setEntityType(EntityType.NONLETHALMONSTER);
		
		setImagePath("objects/rabbit/bigmob.gif");
		
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
