package dmcigd.levels.ogre;

import dmcigd.core.objects.npc.Knight;
import dmcigd.core.objects.regions.RoomWarp;
import dmcigd.core.room.Room;

import java.net.URL;

public class BossRoom extends Room implements Runnable {

	public BossRoom(URL codeBase) {
		super(codeBase, "ogre", "BossRoom", "grassy");
	}

	public void initializeRoom() {
		
		//Deer Level
		addRegion(new RoomWarp(88 * 32, 23 * 32 + 16, 320, 32, "deer.One"));

		addRegion(new Knight(89 * 32, 28 * 32, false, "These parts are wild and primal. Be mindful of your footing.", getDialogueHandler()));
		addRegion(new Knight(94 * 32 - 12, 29 * 32, true, "A deer village lies ahead. They're a very spiritual people, and pay great attention to their traditional rituals and medicine.", getDialogueHandler()));
	}
}