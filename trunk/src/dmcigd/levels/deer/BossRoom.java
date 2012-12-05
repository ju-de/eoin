package dmcigd.levels.deer;

import java.net.URL;

import dmcigd.core.room.*;

public class BossRoom extends Room implements Runnable{
	
	public BossRoom(URL codebase) {
		super(codebase, "deer", "BossRoom", "grassy");
	}
	
	public void initializeRoom() {
	}
	
}
