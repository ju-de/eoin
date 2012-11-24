package dmcigd.levels.rabbit;

import java.net.URL;

import dmcigd.core.room.Room;
import dmcigd.core.objects.blocks.*;
import dmcigd.core.objects.items.*;
import dmcigd.core.objects.npc.*;
import dmcigd.levels.rabbit.houses.*;

public class Three extends Room implements Runnable {
	
	//Initializes SwitchBlock to be passed on to the appropriate switch
	SwitchBlock switchBlock1 = new SwitchBlock(116 * 32, 23 * 32, 3);
	SwitchBlock switchBlock2 = new SwitchBlock(121 * 32, 25 * 32, 3);
	
	public Three(URL codeBase) {
		super(codeBase, "rabbit", "Three", "grassy");
	}

	public void initializeSolidObjects() {
		addSolidObject(new LockedDoor(126 * 32, 20 * 32, 1));
		addSolidObject(new LockedDoor(129 * 32, 16 * 32, 2));
		addSolidObject(new LockedDoor(113 * 32, 24 * 32, 3));
		
		addSolidObject(new LockedDoor(76 * 32, 35 * 32, 4));
		
		addSolidObject(switchBlock1);
		addSolidObject(switchBlock2);
		
		//FLUFFINGHAM FAMILY
		//MR. FRITZLEPUFF
	}

	public void initializeNonsolidObjects() {
		addItem(new DoorKey(126 * 32, 23 * 32, 3, getPhysicsHandler()));
		addItem(new DoorKey(117 * 32, 22 * 32, 2, getPhysicsHandler()));
		addItem(new DoorKey(131 * 32, 15 * 32, 1, getPhysicsHandler()));
		
		addItem(new DoorKey(112 * 32, 13 * 32, 4, getPhysicsHandler()));
		
		addRegion(new Knight(42 * 32, 16 * 32, true, "Mind the gaps! It's awfully thorny down there!", getDialogueHandler()));
		addRegion(new Knight(36 * 32, 32 * 32, false, "These rabbits freak me out! How do rabbits even get so large?", getDialogueHandler()));
		
		addRegion(new Switch(119 * 32 + 4, 23 * 32 + 16, true, switchBlock1));
		addRegion(new Switch(130 * 32 + 4, 27 * 32 + 16, true, switchBlock2));
		
		addBackgroundObject(new HouseSix(96 * 32 - 8, 16 * 32 + 4, 0));
		addForegroundObject(new HouseSix(96 * 32 - 8, 16 * 32 + 4, 1));
		
		addForegroundObject(new HouseSeven(133 * 32 - 2, 15 * 32 + 12));
		addForegroundObject(new HouseEight(110 * 32 + 18, 11 * 32 + 4));
		
		
		//Fourth Floor
		
		//  Shelves
		addBackgroundObject(new Furniture(123 * 32, 14 * 32, 3, 1, false));
		addBackgroundObject(new Furniture(124 * 32, 14 * 32, 3, 2, false));
		addBackgroundObject(new Furniture(122 * 32, 15 * 32, 2, 0, false));
		addBackgroundObject(new Furniture(123 * 32, 15 * 32, 2, 1, false));
		addBackgroundObject(new Furniture(124 * 32, 15 * 32, 2, 0, true));
		
		//  Chairs
		addBackgroundObject(new Furniture(125 * 32, 16 * 32, 1, 2, false));
		
		
		//Third Floor
		
		//  Shelves
		addBackgroundObject(new Furniture(110 * 32, 18 * 32, 3, 1, false));
		addBackgroundObject(new Furniture(112 * 32, 18 * 32, 3, 2, false));
		addBackgroundObject(new Furniture(113 * 32, 18 * 32, 3, 1, true));
		addBackgroundObject(new Furniture(110 * 32, 19 * 32, 2, 0, false));
		addBackgroundObject(new Furniture(111 * 32, 19 * 32, 2, 1, false));
		addBackgroundObject(new Furniture(112 * 32, 19 * 32, 2, 1, false));
		addBackgroundObject(new Furniture(113 * 32, 19 * 32, 2, 1, false));
		addBackgroundObject(new Furniture(114 * 32, 19 * 32, 2, 0, true));
		
		addBackgroundObject(new Furniture(116 * 32 + 16, 18 * 32, 3, 2, true));
		addBackgroundObject(new Furniture(116 * 32, 19 * 32, 2, 0, false));
		addBackgroundObject(new Furniture(117 * 32, 19 * 32, 2, 0, true));
		
		addBackgroundObject(new Furniture(119 * 32, 18 * 32, 3, 1, true));
		addBackgroundObject(new Furniture(120 * 32, 18 * 32, 3, 2, true));
		addBackgroundObject(new Furniture(119 * 32, 19 * 32, 2, 0, false));
		addBackgroundObject(new Furniture(120 * 32, 19 * 32, 2, 0, true));
		
		//  Tables
		addBackgroundObject(new Furniture(112 * 32, 20 * 32, 0, 2, false));
		
		addBackgroundObject(new Furniture(117 * 32, 19 * 32 + 4, 3, 0, false));
		addBackgroundObject(new Furniture(116 * 32, 20 * 32, 0, 0, false));
		addBackgroundObject(new Furniture(117 * 32, 20 * 32, 0, 1, false));
		addBackgroundObject(new Furniture(118 * 32, 20 * 32, 0, 0, true));
		
		addBackgroundObject(new Furniture(130 * 32, 20 * 32, 0, 2, false));
		
		//  Chairs
		addBackgroundObject(new Furniture(105 * 32, 20 * 32, 1, 1, true));
		
		addBackgroundObject(new Furniture(115 * 32, 20 * 32, 1, 0, false));
		addBackgroundObject(new Furniture(119 * 32, 20 * 32, 1, 1, true));
		
		addBackgroundObject(new Furniture(124 * 32, 20 * 32, 1, 0, true));
		
		addBackgroundObject(new Furniture(128 * 32, 20 * 32, 1, 1, false));
		
		
		//Second Floor
		
		//  Shelves

		addBackgroundObject(new Furniture(107 * 32, 22 * 32, 3, 1, false));
		addBackgroundObject(new Furniture(106 * 32, 23 * 32, 2, 0, false));
		addBackgroundObject(new Furniture(107 * 32, 23 * 32, 2, 1, false));
		addBackgroundObject(new Furniture(108 * 32, 23 * 32, 2, 0, true));
		
		
		//First Floor
		
		//  Shelves

		addBackgroundObject(new Furniture(110 * 32, 26 * 32, 3, 2, false));
		addBackgroundObject(new Furniture(111 * 32, 26 * 32, 3, 1, true));
		addBackgroundObject(new Furniture(109 * 32, 27 * 32, 2, 0, false));
		addBackgroundObject(new Furniture(110 * 32, 27 * 32, 2, 1, false));
		addBackgroundObject(new Furniture(111 * 32, 27 * 32, 2, 1, false));
		addBackgroundObject(new Furniture(112 * 32, 27 * 32, 2, 0, true));

		addBackgroundObject(new Furniture(118 * 32, 26 * 32, 3, 1, true));
		addBackgroundObject(new Furniture(119 * 32, 26 * 32, 3, 2, true));
		addBackgroundObject(new Furniture(116 * 32, 27 * 32, 2, 0, false));
		addBackgroundObject(new Furniture(117 * 32, 27 * 32, 2, 1, false));
		addBackgroundObject(new Furniture(118 * 32, 27 * 32, 2, 1, false));
		addBackgroundObject(new Furniture(119 * 32, 27 * 32, 2, 0, true));

		addBackgroundObject(new Furniture(124 * 32, 26 * 32, 3, 1, false));
		addBackgroundObject(new Furniture(124 * 32, 27 * 32, 2, 0, false));
		addBackgroundObject(new Furniture(125 * 32, 27 * 32, 2, 0, true));
	}
}
