package dmcigd.levels.deer;

import java.net.URL;

import dmcigd.core.objects.platforms.MovingPlatform;
import dmcigd.core.objects.regions.RoomWarp;
import dmcigd.core.room.*;


public class Village extends Room implements Runnable{
	
	public Village(URL codebase) {
		super(codebase, "deer", "Village", "grassy");
	}
	
	public void initializeRoom() {
		
		addRegion(new RoomWarp(114 * 32 + 16, 0, 32, 14 * 32, "deer.Three"));
	}
	
}
