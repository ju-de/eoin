package dmcigd.levels.ogre;

import dmcigd.core.objects.blocks.CrumblingBlock;
import dmcigd.core.room.Room;

import java.net.URL;

public class Two extends Room implements Runnable {

	public Two(URL codeBase) {
		super(codeBase, "ogre", "Two", "grassy");
	}

	public void initializeRoom() {

	}
}