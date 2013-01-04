package dmcigd.levels.lake;

import java.net.URL;

import dmcigd.core.room.*;
import dmcigd.core.objects.blocks.PushableBlock;
import dmcigd.core.objects.regions.*;
import dmcigd.levels.lake.mobs.*;
import dmcigd.levels.lake.mobs.boss.*;

public class BonusRoom extends Room implements Runnable {
	
	public BonusRoom(URL codeBase) {
		super(codeBase, "lake", "BonusRoom", "fleshy");
	}
	
	public void initializeRoom() {
		
	}
}
