package dmcigd.levels.rabbit;

import java.net.URL;

import dmcigd.core.room.Room;
import dmcigd.core.objects.*;
import dmcigd.core.objects.blocks.*;
import dmcigd.core.objects.platforms.*;
import dmcigd.core.objects.regions.RoomWarp;
import dmcigd.core.objects.items.*;
import dmcigd.core.objects.npc.*;
import dmcigd.levels.rabbit.houses.*;

public class Two extends Room implements Runnable {
	
	//Initializes SwitchBlock to be passed on to the appropriate switch
	SwitchBlock switchBlock1 = new SwitchBlock(235 * 32, 20 * 32, 3);
	
	public Two(URL codeBase) {
		super(codeBase, "rabbit", "Two", "grassy");
	}

	public void initializeSolidObjects() {
		addSolidObject(new MovingPlatform(69 * 32, 16 * 32, 0, 5, 1, 5));
		
		addSolidObject(new MovingPlatform(83 * 32, 17 * 32, 0, 5, 1, 5));
		addSolidObject(new MovingPlatform(95 * 32 + 16, 17 * 32, 0, 5, -1, -5));
		
		addSolidObject(new MovingPlatform(143 * 32, 18 * 32, 0, 5, 1, 5));
		addSolidObject(new MovingPlatform(155 * 32 + 16, 18 * 32, 0, 5, -1, -5));
		addSolidObject(new MovingPlatform(163 * 32, 18 * 32, 0, 5, 1, 5));
		
		addSolidObject(new LockedDoor(232 * 32, 15 * 32, 1));
		
		addSolidObject(switchBlock1);
	}

	public void initializeNonsolidObjects() {
		addItem(new DoorKey(231 * 32, 17 * 32, 1, getPhysicsHandler()));
		
		addRegion(new Sign(67 * 32, 15 * 32, 9, "SIGN", "Beware of thorns!", getDialogueHandler()));
		addRegion(new Sign(216 * 32, 20 * 32, 3, "SIGN", "Property of the Wiggleton Family", getDialogueHandler()));
		
		addRegion(new Switch(220 * 32 - 4, 22 * 32 + 16, false, switchBlock1));
		addTextLabel(new TextLabel(219 * 32, 23 * 32 - 4, "Press"));
		addTextLabel(new TextLabel(219 * 32 - 2, 23 * 32 + 10, "\"X\"", false));
		
		addRegion(new RoomWarp(276 * 32+ 16, 0, 32, 640, "rabbit.Three"));
		
		addBackgroundObject(new HouseThree(218 * 32, 15 * 32 + 4, 0));
		addForegroundObject(new HouseThree(218 * 32, 15 * 32 + 4, 1));
		
		addBackgroundObject(new HouseFour(238 * 32 + 16, 13 * 32 + 4, 0));
		addForegroundObject(new HouseFour(238 * 32 + 16, 13 * 32 + 4, 1));
		
		addForegroundObject(new HouseFive(230 * 32, 9 * 32 + 4));
		
		addBackgroundObject(new Furniture(226 * 32 + 24, 19 * 32, 1, 1, true));
		addBackgroundObject(new Furniture(225 * 32 + 16, 19 * 32, 0, 2, false));
		
		addBackgroundObject(new Furniture(233 * 32, 19 * 32, 1, 2, false));

		addBackgroundObject(new Furniture(224 * 32 + 24, 15 * 32, 1, 1, false));
		addBackgroundObject(new Furniture(226 * 32 + 12, 14 * 32 + 4, 3, 0, false));
		addBackgroundObject(new Furniture(226 * 32 - 4, 15 * 32, 0, 0, false));
		addBackgroundObject(new Furniture(227 * 32 - 4, 15 * 32, 0, 0, true));
		addBackgroundObject(new Furniture(229 * 32 + 16, 15 * 32, 1, 0, true));
		
		addBackgroundObject(new Furniture(235 * 32 + 24, 15 * 32, 1, 1, true));

		addBackgroundObject(new Furniture(231 * 32 + 12, 22 * 32 + 4, 3, 0, true));
		addBackgroundObject(new Furniture(232 * 32 + 20, 22 * 32 + 4, 3, 0, false));
		addBackgroundObject(new Furniture(231 * 32, 23 * 32, 0, 0, false));
		addBackgroundObject(new Furniture(232 * 32, 23 * 32, 0, 1, false));
		addBackgroundObject(new Furniture(233 * 32, 23 * 32, 0, 0, true));
		addBackgroundObject(new Furniture(230 * 32, 23 * 32, 1, 0, false));
		addBackgroundObject(new Furniture(234 * 32, 23 * 32, 1, 0, true));
		
		addBackgroundObject(new Furniture(224 * 32, 13 * 32, 3, 1, false));
		addBackgroundObject(new Furniture(226 * 32 + 12, 13 * 32, 3, 2, false));
		addBackgroundObject(new Furniture(227 * 32 + 4, 13 * 32, 3, 1, false));
		
		addBackgroundObject(new Furniture(224 * 32, 14 * 32, 2, 0, false));
		addBackgroundObject(new Furniture(225 * 32, 14 * 32, 2, 1, false));
		addBackgroundObject(new Furniture(226 * 32, 14 * 32, 2, 1, false));
		addBackgroundObject(new Furniture(227 * 32, 14 * 32, 2, 0, true));
		
		addBackgroundObject(new Furniture(229 * 32 + 4, 13 * 32, 3, 2, true));
		
		addBackgroundObject(new Furniture(229 * 32, 14 * 32, 2, 0, false));
		addBackgroundObject(new Furniture(230 * 32, 14 * 32, 2, 0, true));
		
		addBackgroundObject(new Furniture(230 * 32 + 24, 21 * 32, 3, 1, true));
		
		addBackgroundObject(new Furniture(230 * 32, 22 * 32, 2, 0, false));
		addBackgroundObject(new Furniture(231 * 32, 22 * 32, 2, 0, true));
		
		addBackgroundObject(new Furniture(233 * 32 + 12, 21 * 32, 3, 2, true));
		addBackgroundObject(new Furniture(234 * 32 + 4, 21 * 32, 3, 1, true));
		
		addBackgroundObject(new Furniture(233 * 32, 22 * 32, 2, 0, false));
		addBackgroundObject(new Furniture(234 * 32, 22 * 32, 2, 0, true));
	}
}
