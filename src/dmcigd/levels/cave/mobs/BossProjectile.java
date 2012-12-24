package dmcigd.levels.cave.mobs;

import dmcigd.core.enums.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.projectiles.*;
import dmcigd.core.objects.particles.*;
import dmcigd.core.room.*;

import dmcigd.levels.deer.HerbParticle;

public class BossProjectile extends ProjectileMotion implements SolidObject {
	
	private int bounceCounter;
	
	private Room room;
	
	public BossProjectile(float x, float y, int angle, Room room) {
		setPhysicsHandler(new BasicProjectileHandler(room.getBlockMap(), room.getSolidObjects()));
		
		setProjectileMotion(4f, angle);
		
		setEntityType(EntityType.PROJECTILE);
		
		accelerate(0.1f, 5f, Direction.DOWN);
		
		setX(x);
		setY(y);
		
		setHeight(10);
		setWidth(10);
		setImageHeight(14);
		setImageWidth(14);
		
		setSequence(0);
		setFrame(0);
		setFrameSpeed(0.4f);
		setFrameLimits(new int[] {4});
		setAnimationLoops(new boolean[] {false});
		
		setImagePath("objects/cave/bossprojectile.gif");
		
		this.room = room;
	}
	
	public void step() {
		move();
		if(hitGround) {
			bounceCounter++;
			setVY(-4/bounceCounter);
		}
		isDestroyed = (getVX() == 0 || bounceCounter >= 10);
		animate();
		
		if(Math.random() > 0.2f) {
			BrownianParticle projectileParticle = new HerbParticle(getX(), getY(), 1, 50, "objects/cave/bossprojectileparticle.gif");
			projectileParticle.setImageWidth(6);
			projectileParticle.setImageHeight(6);
			projectileParticle.setAnimationProperties("objects/cave/bossprojectileparticle.gif", 0, 0, 0.3f, new boolean[] {true}, new int[] {7});
			room.addParticle(projectileParticle);
		}
	}

	
	
}
