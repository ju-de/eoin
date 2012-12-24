package dmcigd.levels.lake.mobs;

import dmcigd.core.enums.CollisionType;
import dmcigd.core.enums.EntityType;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.monsters.HitpointHandler;
import dmcigd.core.room.Room;

import java.util.LinkedList;

public class FishSchool extends HitpointHandler implements RestableObject {
	
	private int objectClock = 0;

	LinkedList<FishParticle> fishParticles = new LinkedList<FishParticle>();
	
	public FishSchool(int x, int y, Room room) {

		setX(x);
		setY(y);
		setDX(0);
		setDY(0);
		setWidth(50);
		setHeight(50);
		setImageWidth(0);
		setImageHeight(0);
		
		setSequence(0);
		setFrame(0);
		
		setMaxHitpoints(50);
		setKnockback(true);
		
		setPhysicsHandler(room.getPhysicsHandler());
		setCollisionType(CollisionType.SOLID);
		setEntityType(EntityType.NONLETHALMONSTER);
		
		setImagePath("objects/lake/fishparticle.gif");
		
		//Add fish particles
		fishParticles.add(new FishParticle(x + 25, y + 25, 3));
		fishParticles.add(new FishParticle(x + 25, y + 25, 2));
		fishParticles.add(new FishParticle(x + 25, y + 25, 3));
		fishParticles.add(new FishParticle(x + 25, y + 25, 2));
		fishParticles.add(new FishParticle(x + 25, y + 25, 3));
		fishParticles.add(new FishParticle(x + 25, y + 25, 2));
		fishParticles.add(new FishParticle(x + 25, y + 25, 2));
		fishParticles.add(new FishParticle(x + 25, y + 25, 3));
		fishParticles.add(new FishParticle(x + 25, y + 25, 1));
		fishParticles.add(new FishParticle(x + 25, y + 25, 0));
		fishParticles.add(new FishParticle(x + 25, y + 25, 0));
		fishParticles.add(new FishParticle(x + 25, y + 25, 1));
		fishParticles.add(new FishParticle(x + 25, y + 25, 0));
		fishParticles.add(new FishParticle(x + 25, y + 25, 1));
		fishParticles.add(new FishParticle(x + 25, y + 25, 0));
		fishParticles.add(new FishParticle(x + 25, y + 25, 1));
		fishParticles.add(new FishParticle(x + 25, y + 25, 0));
		fishParticles.add(new FishParticle(x + 25, y + 25, 1));
		fishParticles.add(new FishParticle(x + 25, y + 25, 0));
		fishParticles.add(new FishParticle(x + 25, y + 25, 1));
		fishParticles.add(new FishParticle(x + 25, y + 25, 0));
		
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
		
		objectClock++;
		if(objectClock == 6) {
		
			setVX((float) Math.random() * 8 * (0.5f - (float) Math.random()));
			setVY((float) Math.random() * 8 * (0.55f - (float) Math.random()));
			objectClock = 0;
		}
		
		for(FishParticle i: fishParticles) {
			i.swarmThink((int) getX() + 25, (int) getY() + 25, isInvincible(), isFlickering());
		}
	}
}
