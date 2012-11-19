package dmcigd.levels.rabbit;

import java.net.URL;

import dmcigd.core.room.Room;
import dmcigd.core.objects.blocks.*;
import dmcigd.core.objects.items.*;
import dmcigd.core.objects.npc.*;
import dmcigd.core.objects.regions.*;

public class One extends Room implements Runnable {
	
	public One(URL codeBase) {
		super(codeBase, "rabbit", "One", "grassy");
	}

	public void initializeSolidObjects() {
		addSolidObject(new LockedDoor(184 * 32, 14 * 32, 1));
	}

	public void initializeNonsolidObjects() {
		addItem(new DoorKey(186 * 32, 16 * 32, 1, getBlockMap(), getSolidObjects()));
		
		addRegion(new Sign(15 * 32, 13 * 32, 3, "SIGN", "Welcome to the Rabbit Hills.\nForest Ahead.", getDialogueHandler()));
		addRegion(new Sign(97 * 32, 22 * 32, 4, "SIGN", "Be careful of large falls!\nUse the ladder ahead to get back on track.", getDialogueHandler()));
		addRegion(new Sign(144 * 32, 12 * 32, 6, "SIGN", "Mr. Scrufflebottom's Abode just past the gap.", getDialogueHandler()));
		addRegion(new Sign(143 * 32, 28 * 32, 5, "SIGN", "DANGER!\nSTAY OUT!", getDialogueHandler()));
		
		addRegion(new RoomWarp(229 * 32+ 16, 0, 32, 640, "rabbit.Two"));
		
		addBackgroundObject(new HouseOne(170 * 32 - 8, 10 * 32 + 4, 0));
		addForegroundObject(new HouseOne(170 * 32 - 8, 10 * 32 + 4, 1));

		addBackgroundObject(new Furniture(177 * 32 + 12, 14 * 32, 1, 0, false));
		addBackgroundObject(new Furniture(178 * 32 + 16, 14 * 32, 0, 2, false));
		addBackgroundObject(new Furniture(182 * 32 + 4, 14 * 32, 1, 1, true));

		addBackgroundObject(new Furniture(177 * 32, 13 * 32, 2, 0, false));
		addBackgroundObject(new Furniture(178 * 32, 13 * 32, 2, 1, false));
		addBackgroundObject(new Furniture(179 * 32, 13 * 32, 2, 0, true));
		
		addBackgroundObject(new Furniture(178 * 32, 12 * 32, 3, 1, false));
		addBackgroundObject(new Furniture(179 * 32, 12 * 32, 3, 2, false));
		
		addBackgroundObject(new Furniture(176 * 32, 18 * 32, 0, 0, false));
		addBackgroundObject(new Furniture(177 * 32, 18 * 32, 0, 0, true));
		addBackgroundObject(new Furniture(176 * 32 + 16, 17 * 32 + 4, 3, 0, false));
		addBackgroundObject(new Furniture(178 * 32 + 6, 18 * 32, 1, 2, false));

		addBackgroundObject(new Furniture(175 * 32, 16 * 32, 3, 2, true));
		addBackgroundObject(new Furniture(174 * 32, 17 * 32, 2, 0, false));
		addBackgroundObject(new Furniture(175 * 32, 17 * 32, 2, 1, false));
		addBackgroundObject(new Furniture(176 * 32, 17 * 32, 2, 0, true));

		addBackgroundObject(new Furniture(179 * 32, 16 * 32, 3, 1, false));
		addBackgroundObject(new Furniture(178 * 32, 17 * 32, 2, 0, false));
		addBackgroundObject(new Furniture(179 * 32, 17 * 32, 2, 0, true));

		addBackgroundObject(new Furniture(186 * 32 + 4, 14 * 32, 1, 1, false));
		addBackgroundObject(new Furniture(187 * 32 + 24, 14 * 32, 1, 0, true));
		
		addBackgroundObject(new HouseTwo(193 * 32, 12 * 32 + 4, 0));
		addForegroundObject(new HouseTwo(193 * 32, 12 * 32 + 4, 1));
		
	}
}
