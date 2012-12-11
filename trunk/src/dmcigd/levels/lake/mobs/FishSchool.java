package dmcigd.levels.lake.mobs;

import dmcigd.core.enums.CollisionType;
import dmcigd.core.enums.EntityType;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.monsters.HitpointHandler;
import dmcigd.core.room.Room;

import java.util.LinkedList;

public class FishSchool extends HitpointHandler implements RestableObject {

	LinkedList<FishParticle> fishParticles = new LinkedList<FishParticle>();
	
	public FishSchool(int x, int y, Room room) {

		setX(x);
		setY(y);
		setDX(0);
		setDY(0);
		setWidth(40);
		setHeight(40);
		setImageWidth(0);
		setImageHeight(0);
		
		setSequence(0);
		setFrame(0);
		
		setMaxHitpoints(50);
		setKnockback(true);
		
		setGravity();
		
		setPhysicsHandler(room.getPhysicsHandler());
		setCollisionType(CollisionType.SOLID);
		setEntityType(EntityType.NONLETHALMONSTER);
		
		setImagePath("objects/lake/fishparticle.gif");
		
		//Add fish particles
		fishParticles.add(new FishParticle(x + 20, y + 20, 3));
		fishParticles.add(new FishParticle(x + 20, y + 20, 2));
		fishParticles.add(new FishParticle(x + 20, y + 20, 3));
		fishParticles.add(new FishParticle(x + 20, y + 20, 2));
		fishParticles.add(new FishParticle(x + 20, y + 20, 3));
		fishParticles.add(new FishParticle(x + 20, y + 20, 2));
		fishParticles.add(new FishParticle(x + 20, y + 20, 2));
		fishParticles.add(new FishParticle(x + 20, y + 20, 3));
		fishParticles.add(new FishParticle(x + 20, y + 20, 1));
		fishParticles.add(new FishParticle(x + 20, y + 20, 0));
		fishParticles.add(new FishParticle(x + 20, y + 20, 0));
		fishParticles.add(new FishParticle(x + 20, y + 20, 1));
		fishParticles.add(new FishParticle(x + 20, y + 20, 0));
		fishParticles.add(new FishParticle(x + 20, y + 20, 1));
		fishParticles.add(new FishParticle(x + 20, y + 20, 0));
		fishParticles.add(new FishParticle(x + 20, y + 20, 1));
		fishParticles.add(new FishParticle(x + 20, y + 20, 0));
		fishParticles.add(new FishParticle(x + 20, y + 20, 1));
		fishParticles.add(new FishParticle(x + 20, y + 20, 0));
		fishParticles.add(new FishParticle(x + 20, y + 20, 1));
		fishParticles.add(new FishParticle(x + 20, y + 20, 0));
		
		//Add particles to room
		for(FishParticle i: fishParticles) {
			room.addParticle(i);
		}
	}
	
	public boolean onAttack(int damage, boolean swordflipped) {
		
		//Kill all particles

		isDestroyed = super.onAttack(damage, swordflipped);
				
		if(isDestroyed) {
			for(FishParticle i: fishParticles) {
				i.kill();
			}
			return true;
		}
		
		return false;
	}
		
	public void step() {
		
		super.step();
		
		move();
		
		//setVX((float) Math.random() * 15 * (0.5f - (float) Math.random()));
		setVY((float) Math.random() * 15 * (0.5f - (float) Math.random()));
		
		for(FishParticle i: fishParticles) {
			i.swarmThink((int) getX() + 20, (int) getY() + 20, isInvincible(), isFlickering());
		}
	}
}
