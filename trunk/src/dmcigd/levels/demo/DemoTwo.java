package dmcigd.levels.demo;

import java.net.URL;

import dmcigd.core.*;
import dmcigd.core.objects.regions.*;
import dmcigd.core.objects.npc.*;

public class DemoTwo extends Room implements Runnable {
	
	public DemoTwo(URL codeBase) {
		super(codeBase, "demo", "DemoTwo", "grassy");
	}
	
	public void initializeNonsolidObjects() {
		
		regions.add(new Sign(34 * 32, 12 * 32, 5, " ", "FNORD", dialogueHandler));
		
		regions.add(new RoomWarp(34 * 32, 12 * 32, 32, 32, "demo", "Demo"));
				
	}
	
	
}
