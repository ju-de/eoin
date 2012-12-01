package dmcigd.levels.ogre;

import dmcigd.core.objects.npc.Sign;
import dmcigd.core.room.Room;

import java.net.URL;

public class One extends Room implements Runnable{
	
	public One(URL codeBase) {
		super(codeBase, "ogre", "One", "grassy");
	}
	
	public void initializeRoom() {
		addRegion(new Sign(35 * 15, 35 * 15, 3, "SIGN", "Entering Ogre Territory.\nWATCH YOUR STEP!", getDialogueHandler()));
	}
}