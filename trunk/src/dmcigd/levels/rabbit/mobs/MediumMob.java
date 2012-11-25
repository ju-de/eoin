package dmcigd.levels.rabbit.mobs;

import dmcigd.core.enums.*;
import dmcigd.core.objects.PhysicsHandler;
import dmcigd.core.objects.interfaces.*;

public class MediumMob extends RabbitAI implements SolidObject {

	public void die() {
		setSequence(2);
		setFrameSpeed(0.2f);
	}

	public void moveLeft() {
		flipped = true;
		setVX(-1);
		setSequence(1);
		setFrameSpeed(0.12f);
	}

	public void moveRight() {
		flipped = false;
		setVX(1);
		setSequence(1);
		setFrameSpeed(0.12f);
	}
	
	public MediumMob(int x, int y, PhysicsHandler physicsHandler) {

		setX(x);
		setY(y);
		setWidth(32);
		setHeight(20);
		setImageWidth(32);
		setImageHeight(32);
		
		setSequence(0);
		setFrame(0);

		setFrameLimits(new int[] {2, 3, 3});
		setAnimationLoops(new boolean [] {true, true, false});
		setFrameSpeed(0.02f);
		
		setMaxHitpoints(50);
		setKnockback(true);
		
		setDeathClockLimit(70);
		setAIClockReset(40);
		
		setGravity();
		
		setPhysicsHandler(physicsHandler);
		setCollisionType(CollisionType.NONSOLID);
		setEntityType(EntityType.NONLETHALMONSTER);
		
		setImagePath("objects/rabbit/mediummob.gif");
		
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
