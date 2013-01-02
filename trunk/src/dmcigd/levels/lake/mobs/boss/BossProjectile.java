package dmcigd.levels.lake.mobs.boss;

import dmcigd.core.enums.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.projectiles.*;
import dmcigd.core.objects.particles.*;
import dmcigd.core.room.*;

import dmcigd.levels.deer.HerbParticle;

public class BossProjectile extends ProjectileMotion implements SolidObject {
	
	private Room room;
	
	public BossProjectile(float x, float y, int angle, Room room) {
		setPhysicsHandler(new SimpleProjectileHandler(room.getBlockMap(), room.getSolidObjects()));
		
		setProjectileMotion(6f, angle, true);
		
		setEntityType(EntityType.KNOCKBACK);
		
		setX(x);
		setY(y);
		
		setHeight(22);
		setWidth(22);
		setImageHeight(26);
		setImageWidth(26);
		
		setSequence(0);
		setFrame(0);
		setFrameSpeed(0.2f);
		setFrameLimits(new int[] {7});
		setAnimationLoops(new boolean[] {false});
		
		setImagePath("objects/lake/bossprojectile.gif");
		
		this.room = room;
	}
	
	public void step() {
		move();
		animate();
		
		if(Math.random() > 0.2f) {
			BrownianParticle projectileParticle = new HerbParticle(getX(), getY(), 1, 50, "objects/cave/bossprojectileparticle.gif");
			projectileParticle.setImageWidth(10);
			projectileParticle.setImageHeight(10);
			projectileParticle.setAnimationProperties("objects/lake/bossprojectileparticle.gif", 0, 0, 0.3f, new boolean[] {true}, new int[] {6});
			room.addParticle(projectileParticle);
		}
	}
	
}
