package dmcigd.levels.rabbit;

import java.net.URL;

import dmcigd.core.room.Room;
import dmcigd.core.objects.blocks.*;
import dmcigd.core.objects.items.*;
import dmcigd.core.objects.npc.*;
import dmcigd.core.objects.regions.RoomWarp;
import dmcigd.levels.rabbit.mobs.*;

public class Three extends Room implements Runnable {
	
	//Initializes SwitchBlock to be passed on to the appropriate switch
	SwitchBlock switchBlock1 = new SwitchBlock(116 * 32, 23 * 32, 3);
	SwitchBlock switchBlock2 = new SwitchBlock(121 * 32, 25 * 32, 3);
	
	public Three(URL codeBase) {
		super(codeBase, "rabbit", "Three", "grassy");
	}

	public void initializeRoom() {
		addSolidObject(new LockedDoor(126 * 32, 20 * 32, 1));
		addSolidObject(new LockedDoor(129 * 32, 16 * 32, 2));
		addSolidObject(new LockedDoor(113 * 32, 24 * 32, 3));
		
		addSolidObject(new LockedDoor(76 * 32, 35 * 32, 4));
		
		addSolidObject(switchBlock1);
		addSolidObject(switchBlock2);
		
		addSolidObject(new BigMob(32 * 32, 17 * 32, getPhysicsHandler()));
		addSolidObject(new BigMob(34 * 32, 17 * 32, getPhysicsHandler()));
		
		addSolidObject(new BigMob(60 * 32, 20 * 32, getPhysicsHandler()));
		addSolidObject(new MediumMob(62 * 32, 21 * 32, getPhysicsHandler()));
		addSolidObject(new MediumMob(64 * 32, 21 * 32, getPhysicsHandler()));
		
		addSolidObject(new MediumMob(33 * 32, 39 * 32, getPhysicsHandler()));
		
		addSolidObject(new MediumMob(95 * 32, 39 * 32, getPhysicsHandler()));
		
		addSolidObject(new BigMob(42 * 32, 38 * 32, getPhysicsHandler()));
		addSolidObject(new MediumMob(41 * 32, 39 * 32, getPhysicsHandler()));
		
		addSolidObject(new BigMob(58 * 32, 38 * 32, getPhysicsHandler()));
		addSolidObject(new BigMob(60 * 32, 38 * 32, getPhysicsHandler()));
		addSolidObject(new MediumMob(58 * 32, 39 * 32, getPhysicsHandler()));
		addSolidObject(new MediumMob(62 * 32, 39 * 32, getPhysicsHandler()));
		addSolidObject(new MediumMob(63 * 32, 39 * 32, getPhysicsHandler()));
		
		addSolidObject(new BigMob(84 * 32, 36 * 32, getPhysicsHandler()));
		addSolidObject(new MediumMob(83 * 32, 37 * 32, getPhysicsHandler()));
		addSolidObject(new MediumMob(82 * 32, 37 * 32, getPhysicsHandler()));
		
		addItem(new DoorKey(126 * 32, 23 * 32, 3, getPhysicsHandler()));
		addItem(new DoorKey(117 * 32, 22 * 32, 2, getPhysicsHandler()));
		addItem(new DoorKey(131 * 32, 15 * 32, 1, getPhysicsHandler()));
		
		addItem(new DoorKey(112 * 32, 13 * 32, 4, getPhysicsHandler()));
		
		addRegion(new Knight(26 * 32, 16 * 32, false, "Creepy as they look, those giant rabbits are totally harmless! In fact, they're pretty helpful. They don't seem to mind the thorns at all, and they're too dumb to notice if you hitch a ride on their backs.", getDialogueHandler()));
		
		addRegion(new Knight(42 * 32, 16 * 32, true, "Mind the gaps! It's awfully thorny down there!", getDialogueHandler()));
		addRegion(new Knight(36 * 32, 32 * 32, false, "Yeah, I’m just going to stay right here. Those guys freak me out! How do rabbits even get so large?", getDialogueHandler()));
		
		addRegion(new Knight(95 * 32, 31 * 32, true, "Isn't it weird how some bunnies talk, wear clothes, and live in houses, while others just hop around naked all day?", getDialogueHandler()));
		
		addRegion(new Knight(185 * 32, 20 * 32, false, "HOW IS THIS EVEN POSSIBLE? STOP BREAKING THE GAME!", getDialogueHandler()));
		
		addRegion(new RoomWarp(182 * 32+ 16, 0, 32, 840, "rabbit.BossRoom"));
		
		addRegion(new Sign(93 * 32, 20 * 32, 6, "SIGN", "The Fluffingham House", getDialogueHandler()));
		
		addRegion(new Fluffinghams(113 * 32, 20 * 32 - 2, new String[][] {
				{"Mrs. Fluffingham","Come here sweetie!"},
				{"Mr. Fluffingham","Stop it!"},
				{"Mrs. Fluffingham","Don't be shy!"},
				{"Mr. Fluffingham","NO MEANS NO!"}
				}, getDialogueHandler()));
		
		addRegion(new GenericRabbit(127 * 32 + 16, 24 * 32,
				16, 34, 9, 0.03f, "romeofluffingham.gif", "Romeo Fluffingham",
				"Why should I care about some princess when I'm not even allowed to see the girl next door?", getDialogueHandler()));
		
		addRegion(new GenericRabbit(81 * 32, 41 * 32,
				20, 32, 10, 0.03f, "mrfritzlepuff.gif", "Mr. Fritzlepuff",
				"Oh how I hate you king's men! Always unlocking doors and running amok like you own the place!", getDialogueHandler()));
		
		addRegion(new Switch(119 * 32 + 4, 23 * 32 + 16, true, switchBlock1));
		addRegion(new Switch(130 * 32 + 4, 27 * 32 + 16, true, switchBlock2));
		
		addBackgroundObject(new House(96 * 32 - 8, 16 * 32 + 4, 0,
				160, 160, 6));
		addForegroundObject(new House(96 * 32 - 8, 16 * 32 + 4, 1,
				160, 160, 6));
		
		addForegroundObject(new House(133 * 32 - 2, 15 * 32 + 12, 0,
				32, 96, 7));
		
		addForegroundObject(new House(110 * 32 + 18, 11 * 32 + 4, 0,
				128, 96, 8));
		
		
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
