package dmcigd.levels.lake;

import java.net.URL;

import dmcigd.core.room.*;
import dmcigd.core.objects.blocks.*;
import dmcigd.core.objects.items.*;
import dmcigd.core.objects.npc.*;
import dmcigd.core.objects.regions.*;

public class Three extends Room implements Runnable {
	
	public Three(URL codeBase) {
		super(codeBase, "lake", "Three", "rocky");
	}
	
	public void initializeRoom() {
	}
}
