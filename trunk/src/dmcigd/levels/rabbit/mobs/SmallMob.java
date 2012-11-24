package dmcigd.levels.rabbit.mobs;

import dmcigd.core.enums.*;
import dmcigd.core.objects.PhysicsHandler;
import dmcigd.core.objects.interfaces.*;

public class SmallMob extends RabbitAI implements SolidObject {

	public void die() {
		setSequence(3);
		setFrameSpeed(0.2f);
	}

	public void moveLeft() {
		flipped = true;
		setVY(-3);
		setVX(-1);
		setSequence(1);
		setFrameSpeed(0.4f);
	}

	public void moveRight() {
		flipped = false;
		setVY(-3);
		setVX(1);
		setSequence(1);
		setFrameSpeed(0.4f);
	}
	
	public SmallMob(int x, int y, PhysicsHandler physicsHandler) {

		setX(x);
		setY(y);
		setWidth(20);
		setHeight(16);
		setImageWidth(24);
		setImageHeight(24);
		
		setSequence(0);
		setFrame(0);

		setFrameLimits(new int[] {2, 3, 3, 3});
		setAnimationLoops(new boolean [] {true, false, false, false});
		setFrameSpeed(0.02f);
		
		setMaxHitpoints(30);
		setKnockback(true);
		
		setDeathClockLimit(70);
		setAIClockReset(100);

		//Faux Gravity (extra slow)
		accelerate(0.2f, 3.0f, Direction.DOWN);
		
		setPhysicsHandler(physicsHandler);
		setCollisionType(CollisionType.NONSOLID);
		setEntityType(EntityType.NONLETHALMONSTER);
		
		setImagePath("objects/rabbit/smallmob.gif");
		
	}
	
	public void step() {
		
		super.step();
		
		think();
		
		move();
		
		if(!isKnockedBack()) {
			
			if(!isDestroyed) {
			
				if(hitGround) {
					setVX(0);
				}
			
				if(isFalling) {
					setSequence(2);
					setFrameSpeed(0.2f);
				} else if (hitGround) {
					setSequence(0);
					setFrameSpeed(0.02f);
				}
			}
			
			animate();
		}
	}
	
}
