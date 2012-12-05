package dmcigd.levels.deer;

import java.net.URL;

import dmcigd.core.room.*;


public class Village extends Room implements Runnable{
	
	public Village(URL codebase) {
		super(codebase, "deer", "Village", "grassy");
	}
	
	public void initializeRoom() {
	}
	
}
