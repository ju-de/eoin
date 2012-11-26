package dmcigd.levels.demo;

import java.net.URL;

import dmcigd.core.objects.regions.*;
import dmcigd.core.room.*;

public class DemoTwo extends Room implements Runnable {
	
	public DemoTwo(URL codeBase) {
		super(codeBase, "demo", "DemoTwo", "grassy");
	}
	
	public void initializeRoom() {
		
		addRegion(new RoomPassage(34 * 32, 12 * 32, "demo.Demo"));
		
		addRegion(new Warp(11 * 32, 13 * 32, 32, 32, 13 * 32, 7 * 32));
				
	}
	
	
}
