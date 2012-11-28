package dmcigd.levels.deer;

import java.net.URL;

import dmcigd.core.room.*;

public class One extends Room implements Runnable{
	
	public One(URL codeBase) {
		super(codeBase, "deer", "One", "grassy");
	}
	
	public void initializeRoom() {
	}
	
}
