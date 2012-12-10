package dmcigd.levels.ogre;

import dmcigd.core.room.Room;

import java.net.URL;

public class Three extends Room implements Runnable {

	public Three(URL codeBase) {
		super(codeBase, "ogre", "Three", "grassy");
	}

	public void initializeRoom() {

	}
}