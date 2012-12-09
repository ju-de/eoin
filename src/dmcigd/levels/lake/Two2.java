package dmcigd.levels.lake;

import java.net.URL;

import dmcigd.core.room.*;
import dmcigd.core.objects.blocks.*;
import dmcigd.core.objects.items.*;
import dmcigd.core.objects.npc.*;
import dmcigd.core.objects.regions.*;
import dmcigd.levels.lake.mobs.*;

public class Two2 extends Room implements Runnable {
	
	public Two2(URL codeBase) {
		super(codeBase, "lake", "Two2", "rocky");
	}
	
	public void initializeRoom() {
/*		addSolidObject(new FishMob(13 * 32, 9 * 32, getPhysicsHandler()));
		addSolidObject(new FishSchool(17 * 32, 14 * 32, this));
		addSolidObject(new FishMob(18 * 32, 17 * 32, getPhysicsHandler()));
		addSolidObject(new FishMob(18 * 32, 12 * 32, getPhysicsHandler()));
		addSolidObject(new Turtle(18 * 32, 18 * 32, this));
		addSolidObject(new Turtle(16 * 32, 18 * 32, this)); */
	}
}
