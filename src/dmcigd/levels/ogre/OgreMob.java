package dmcigd.levels.ogre;

import dmcigd.core.enums.CollisionType;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.PhysicsHandler;
import dmcigd.levels.rabbit.mobs.BigMob;

public class OgreMob extends BigMob implements SolidObject {

	//This monster is nothing more than a reskin of the gorilla bunny in
	//the previous level, but now SOLID instead of PLATFORM

	public void die() {
		super.die();
		setImageWidth(90);
	}
	
	public OgreMob(int x, int y, PhysicsHandler physicsHandler) {
		super(x, y, physicsHandler);
		
		setWidth(50);
		setHeight(56);
		setImageWidth(70);
		setImageHeight(70);
		
		setCollisionType(CollisionType.SOLID);
		
		setImagePath("objects/ogre/ogremob.gif");
	}
	
}
