package dmcigd.levels.lake;

import java.net.URL;

import dmcigd.core.room.*;
import dmcigd.core.objects.blocks.*;
import dmcigd.core.objects.items.*;
import dmcigd.core.objects.npc.*;
import dmcigd.core.objects.regions.*;

public class One extends Room implements Runnable {
	
	public One(URL codeBase) {
		super(codeBase, "lake", "One", "rocky");
	}
	
	public void initializeRoom() {
	}
}