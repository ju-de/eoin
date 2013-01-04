package dmcigd.levels.lake.mobs.boss;

import dmcigd.core.enums.*;
import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.room.*;

public class BossBase extends ObjectCollision implements SolidObject {
	
	private boolean isDead = false;
	private Room room;
	private BossEye bossEye;
	private BonusWarp bonusWarp;
	public BossJaw bossJaw;

	public boolean isDestroyed() {
		return false;
	}

	public BossBase(int x, int y, Room room) {
		
		setX(x);
		setY(y);
		setWidth(528);
		setHeight(294);
		setImageWidth(528);
		setImageHeight(296);
		
		setSequence(0);
		setFrame(0);
		
		this.room = room;
		
		bossEye = new BossEye(getX() + 226, getY() + 98);
		room.addForegroundObject(bossEye);
		
		bonusWarp = new BonusWarp((int) getX() + 192, (int) getY(), (int) getWidth(), (int) getHeight(), "lake.BonusRoom");
		room.addRegion(bonusWarp);
		
		bossJaw = new BossJaw(getX() + 64, getY() + 28);
		
		setCollisionType(CollisionType.NONSOLID);
		
		setImagePath("objects/lake/bossbase.gif");
		
		
	}
	
	public void die() {
		isDead = true;
		bossJaw.isDead = true;
		bossEye.setFrame(0);
		bonusWarp.triggered = true;
	}
	
	public void step() {
		if(!isDead) {
			if(!bossJaw.isAttacking && bossJaw.isInvincible()) {
				bossEye.setInvincibility(true);
			} else {
				bossEye.setInvincibility(false);
				
				if(bossJaw.isAttacking && Math.random() < 0.04f) {
					room.addProjectile(new BossProjectile(getX() + 300, getY() + 260, (int)(Math.random() * 50),room));
				}
			}
			
			if(!bossJaw.isAttacking && Math.random() < 0.005f) bossJaw.attack();
			if(bossJaw.isDestroyed) die();
		} else {
		}
	}
	
}
