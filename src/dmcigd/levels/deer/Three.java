package dmcigd.levels.deer;

import java.net.URL;

import dmcigd.core.room.*;


public class Three extends Room implements Runnable{
	
	public Three(URL codebase) {
		super(codebase, "deer", "Three", "grassy");
	}
	
	public void initializeRoom() {
	}
	
}
