package dmcigd.levels.lake;

import java.net.URL;

import dmcigd.core.room.*;
import dmcigd.core.objects.blocks.*;
import dmcigd.core.objects.items.*;
import dmcigd.core.objects.npc.*;
import dmcigd.core.objects.regions.*;
import dmcigd.levels.lake.mobs.*;

public class TwoB extends Room implements Runnable {
	
	public TwoB(URL codeBase) {
		super(codeBase, "lake", "TwoB", "rocky");
	}
	
	public void initializeRoom() {
	
	}
	
}