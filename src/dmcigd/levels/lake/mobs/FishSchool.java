package dmcigd.levels.lake.mobs;

import dmcigd.core.enums.CollisionType;
import dmcigd.core.enums.EntityType;
import dmcigd.core.objects.PhysicsHandler;
import dmcigd.core.objects.monsters.HitpointHandler;

public class FishSchool extends HitpointHandler {


	public FishSchool(int x, int y, PhysicsHandler physicsHandler) {

		setX(x);
		setY(y);
		setWidth(50);
		setHeight(50);
		setImageWidth(0);
		setImageHeight(0);
		
		setSequence(0);
		setFrame(0);
		
		setMaxHitpoints(50);
		setKnockback(true);
		
		setGravity();
		
		setPhysicsHandler(physicsHandler);
		setCollisionType(CollisionType.SOLID);
		setEntityType(EntityType.NONLETHALMONSTER);
		
		setImagePath("objects/lake/fishparticle.gif");
		
	}
		
	
}
