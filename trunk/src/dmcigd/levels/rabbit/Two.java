package dmcigd.levels.rabbit;

import java.net.URL;

import dmcigd.core.room.Room;
import dmcigd.core.objects.platforms.*;
import dmcigd.core.objects.npc.*;

public class Two extends Room implements Runnable {
	
	public Two(URL codeBase) {
		super(codeBase, "rabbit", "Two", "grassy");
	}

	public void initializeSolidObjects() {
		addSolidObject(new MovingPlatform(69 * 32, 16 * 32, 0, 5, 1, 7));
		
		addSolidObject(new MovingPlatform(88 * 32 + 16, 17 * 32, 0, 5, 1, 10));
		
		addSolidObject(new MovingPlatform(149 * 32 + 16, 18 * 32, 0, 5, 1, 10));
		addSolidObject(new MovingPlatform(161 * 32, 19 * 32, 0, 5, -1, -10));
		addSolidObject(new MovingPlatform(162 * 32 + 16, 18 * 32, 0, 5, 1, 10));
	}

	public void initializeNonsolidObjects() {
		addRegion(new Sign(67 * 32, 15 * 32, 9, "SIGN", "Beware of thorns!", getDialogueHandler()));
		addRegion(new Sign(224 * 32, 20 * 32, 3, "SIGN", "Property of the Wiggleton Family", getDialogueHandler()));
	}
}
