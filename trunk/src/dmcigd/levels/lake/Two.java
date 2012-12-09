package dmcigd.levels.lake;

import java.net.URL;

import dmcigd.core.room.*;
import dmcigd.core.objects.blocks.*;
import dmcigd.core.objects.items.*;
import dmcigd.core.objects.npc.*;
import dmcigd.core.objects.regions.*;

public class Two extends Room implements Runnable {
	
	public Two(URL codeBase) {
		super(codeBase, "lake", "Two", "rocky");
	}
	
	public void initializeRoom() {
		addRegion(new RoomWarp(119 * 32, 0, 2 * 32, 101 * 32, "lake.Two2"));
	}
}
