package dmcigd.levels.lake;

import java.net.URL;

import dmcigd.core.room.*;
import dmcigd.core.objects.regions.*;
import dmcigd.levels.lake.mobs.*;

public class One extends Room implements Runnable {
	
	public One(URL codeBase) {
		super(codeBase, "lake", "One", "rocky");
	}
	
	public void initializeRoom() {
		//Sample Implementation
		//addSolidObject(new FishSchool(100 * 32, 20 * 32, this));
		//addSolidObject(new Turtle(80 * 32, 20 * 32, this));
		//addSolidObject(new FishMob(91 * 32, 21 * 32, getPhysicsHandler(), getPlayer()));
	}
}
