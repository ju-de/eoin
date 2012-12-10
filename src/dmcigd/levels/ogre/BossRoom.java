package dmcigd.levels.ogre;

import dmcigd.core.room.Room;

import java.net.URL;

public class BossRoom extends Room implements Runnable {

	public BossRoom(URL codeBase) {
		super(codeBase, "ogre", "BossRoom", "grassy");
	}

	public void initializeRoom() {

	}
}