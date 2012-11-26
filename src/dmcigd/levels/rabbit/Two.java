package dmcigd.levels.rabbit;

import java.net.URL;

import dmcigd.core.room.Room;
import dmcigd.core.objects.*;
import dmcigd.core.objects.blocks.*;
import dmcigd.core.objects.platforms.*;
import dmcigd.core.objects.regions.RoomWarp;
import dmcigd.core.objects.items.*;
import dmcigd.core.objects.npc.*;
import dmcigd.levels.rabbit.mobs.*;

public class Two extends Room implements Runnable {
	
	//Initializes SwitchBlock to be passed on to the appropriate switch
	SwitchBlock switchBlock1 = new SwitchBlock(235 * 32, 20 * 32, 3);
	
	public Two(URL codeBase) {
		super(codeBase, "rabbit", "Two", "grassy");
	}

	public void initializeRoom() {
		addSolidObject(new MediumMob(36 * 32, 16 * 32, getPhysicsHandler()));
		addSolidObject(new SmallMob(37 * 32, 16 * 32, getPhysicsHandler()));
		addSolidObject(new SmallMob(39 * 32, 16 * 32, getPhysicsHandler()));
		
		addSolidObject(new MediumMob(56 * 32, 15 * 32, getPhysicsHandler()));
		addSolidObject(new SmallMob(57 * 32, 15 * 32, getPhysicsHandler()));
		addSolidObject(new MediumMob(58 * 32, 15 * 32, getPhysicsHandler()));
		
		addSolidObject(new MediumMob(120 * 32, 15 * 32, getPhysicsHandler()));
		addSolidObject(new SmallMob(122 * 32, 15 * 32, getPhysicsHandler()));
		addSolidObject(new SmallMob(123 * 32, 15 * 32, getPhysicsHandler()));
		
		addSolidObject(new MediumMob(177 * 32, 17 * 32, getPhysicsHandler()));
		addSolidObject(new SmallMob(179 * 32, 17 * 32, getPhysicsHandler()));
		addSolidObject(new MediumMob(180 * 32, 17 * 32, getPhysicsHandler()));
		
		addSolidObject(new MediumMob(192 * 32, 18 * 32, getPhysicsHandler()));
		addSolidObject(new MediumMob(194 * 32, 18 * 32, getPhysicsHandler()));
		
		addSolidObject(new MediumMob(254 * 32, 18 * 32, getPhysicsHandler()));
		
		addSolidObject(new MediumMob(266 * 32, 17 * 32, getPhysicsHandler()));
		addSolidObject(new SmallMob(268 * 32, 17 * 32, getPhysicsHandler()));
		
		addSolidObject(new MovingPlatform(69 * 32, 16 * 32, 0, 5, 1, 5));
		
		addSolidObject(new MovingPlatform(83 * 32, 17 * 32, 0, 5, 1, 5));
		addSolidObject(new MovingPlatform(95 * 32 + 16, 17 * 32, 0, 5, -1, -5));
		
		addSolidObject(new MovingPlatform(143 * 32, 18 * 32, 0, 5, 1, 5));
		addSolidObject(new MovingPlatform(155 * 32 + 16, 18 * 32, 0, 5, -1, -5));
		addSolidObject(new MovingPlatform(163 * 32, 18 * 32, 0, 5, 1, 5));
		
		addSolidObject(new LockedDoor(232 * 32, 15 * 32, 1));
		
		addSolidObject(switchBlock1);
		
		addItem(new DoorKey(231 * 32, 17 * 32, 1, getPhysicsHandler()));
		
		addRegion(new Sign(67 * 32, 15 * 32, 9, "SIGN", "Beware of thorns!", getDialogueHandler()));
		addRegion(new Sign(216 * 32, 20 * 32, 3, "SIGN", "Property of the Wiggleton Family", getDialogueHandler()));
		
		addRegion(new Knight(112 * 32, 13 * 32, true, "I'll never understand why these rabbits chose to live in such thorny places!", getDialogueHandler()));
		addRegion(new Knight(201 * 32, 24 * 32, false, "I hear the rabbits might be hiding something in these caves! They don't seem very interested in the affairs of the princess though.", getDialogueHandler()));
		
		addRegion(new GenericRabbit(227 * 32, 19 * 32, 
				24, 34, 8, 0.03f, "oldmanwiggleton.gif", "Old Man Wiggleton",
				"How do you know it was a kidnapper? These youngings are always trying to run off on me with their shenanigans!", getDialogueHandler()));
		addRegion(new GenericRabbit(230 * 32, 19 * 32 + 6,
				16, 28, 10, 0.03f, "julietwiggleton.gif", "Juliet Wiggleton",
				"How would I know about any kidnapping? Grandpa doesn't even let me go next door!", getDialogueHandler()));

		addRegion(new Switch(220 * 32 - 4, 22 * 32 + 16, false, switchBlock1));
		addTextLabel(new TextLabel(219 * 32, 23 * 32 - 4, "Press"));
		addTextLabel(new TextLabel(219 * 32 - 2, 23 * 32 + 10, "\"X\"", false));
				
		addRegion(new RoomWarp(276 * 32+ 16, 0, 32, 640, "rabbit.Three"));
		
		addBackgroundObject(new House(218 * 32, 15 * 32 + 4, 0,
				180, 160, 3));
		addForegroundObject(new House(218 * 32, 15 * 32 + 4, 1,
				180, 160, 3));
		
		addBackgroundObject(new House(238 * 32 + 16, 13 * 32 + 4, 0,
				64, 96, 4));
		addForegroundObject(new House(238 * 32 + 16, 13 * 32 + 4, 1,
				64, 96, 4));
		
		addForegroundObject(new House(230 * 32, 9 * 32 + 4, 0,
				110, 96, 5));
		
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
