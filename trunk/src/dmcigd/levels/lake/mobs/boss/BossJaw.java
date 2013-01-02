package dmcigd.levels.lake.mobs.boss;

import dmcigd.core.enums.CollisionType;
import dmcigd.core.objects.monsters.*;
import dmcigd.core.objects.interfaces.*;

public class BossJaw extends HitpointHandler implements SolidObject {
	
	public boolean isAttacking;

	public boolean isDestroyed() {
		return false;
	}
	
	public void attack() {
		isAttacking = true;
		setInvincibilityCounterReset(200);
		setInvincibility(true);
	}

	public BossJaw(float x, float y) {
		
		setX(x);
		setY(y);
		setWidth(254);
		setHeight(266);
		setImageWidth(382);
		setImageHeight(268);
		
		setMaxHitpoints(250);
		setInvincibilityCounterReset(30);
		
		setSequence(0);
		setFrame(0);
		
		setFrameSpeed(0.3f);
		setFrameLimits(new int[] {5});
		setAnimationLoops(new boolean[] {false});
		
		setCollisionType(CollisionType.SOLID);
		
		setImagePath("objects/lake/bossjaw.gif");
		
		
	}
	
	public void step() {
		super.step();
		if(isDead) {
			isAttacking = false;
			setCollisionType(CollisionType.NONSOLID);
			animate();
		} else if(isAttacking){
			setCollisionType(CollisionType.NONSOLID);
			animate();
			if(!isInvincible()) {
				isAttacking = false;
				setInvincibilityCounterReset(40);
			}
		} else {
			setCollisionType(CollisionType.SOLID);
			setFrame(0);
		}
	}
	
}
