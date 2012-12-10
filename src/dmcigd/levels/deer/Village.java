package dmcigd.levels.deer;

import java.net.URL;

import dmcigd.core.objects.regions.RoomWarp;
import dmcigd.core.room.*;


public class Village extends Room implements Runnable{
	
	public Village(URL codebase) {
		super(codebase, "deer", "Village", "grassy");
	}
	
	public void initializeRoom() {
		
		addBackgroundObject(new House(34 * 32 - 8, 11 * 32 - 4, 0,
				304, 132, 1));
		addForegroundObject(new House(34 * 32 - 8, 11 * 32 - 4, 1,
				304, 132, 1));
		
		addBackgroundObject(new House(57 * 32, 8 * 32 + 10, 0,
				250, 118, 2));
		
		addBackgroundObject(new House(69 * 32, 9 * 32 + 18, 0,
				248, 110, 3));
		
		addBackgroundObject(new House(81 * 32 + 12, 10 * 32 - 4, 0,
				284, 134, 4));
		addForegroundObject(new House(81 * 32 + 12, 10 * 32 - 4, 1,
				284, 134, 4));
		
		addRegion(new RoomWarp(114 * 32 + 16, 0, 32, 14 * 32, "deer.Three"));
	}
	
}
