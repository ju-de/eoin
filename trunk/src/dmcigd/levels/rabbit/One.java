package dmcigd.levels.rabbit;

import java.net.URL;

import dmcigd.core.room.Room;
import dmcigd.core.objects.TextLabel;
import dmcigd.core.objects.blocks.*;
import dmcigd.core.objects.items.*;
import dmcigd.core.objects.npc.*;
import dmcigd.core.objects.regions.*;
import dmcigd.levels.rabbit.mobs.*;

public class One extends Room implements Runnable {
	
	public One(URL codeBase) {
		super(codeBase, "rabbit", "One", "grassy");
	}
        
	public void initializeRoom() {
		addSolidObject(new LockedDoor(184 * 32, 14 * 32, 1));
		
		addSolidObject(new SmallMob(38 * 32, 16 * 32, getPhysicsHandler()));
		addSolidObject(new SmallMob(40 * 32, 16 * 32, getPhysicsHandler()));
		addSolidObject(new SmallMob(42 * 32, 16 * 32, getPhysicsHandler()));
		
		addSolidObject(new SmallMob(53 * 32, 15 * 32, getPhysicsHandler()));
		addSolidObject(new SmallMob(56 * 32, 15 * 32, getPhysicsHandler()));
		
		addSolidObject(new SmallMob(65 * 32, 14 * 32, getPhysicsHandler()));
		addSolidObject(new SmallMob(67 * 32, 14 * 32, getPhysicsHandler()));
		addSolidObject(new SmallMob(69 * 32, 14 * 32, getPhysicsHandler()));
		
		addSolidObject(new SmallMob(135 * 32, 13 * 32, getPhysicsHandler()));
		addSolidObject(new SmallMob(139 * 32, 13 * 32, getPhysicsHandler()));
		
		addSolidObject(new SmallMob(71 * 32, 24 * 32, getPhysicsHandler()));
		
		addSolidObject(new SmallMob(80 * 32, 25 * 32, getPhysicsHandler()));
		
		addSolidObject(new SmallMob(163 * 32, 27 * 32, getPhysicsHandler()));
		addSolidObject(new SmallMob(166 * 32, 27 * 32, getPhysicsHandler()));
		
		addSolidObject(new SmallMob(174 * 32, 27 * 32, getPhysicsHandler()));
		
		addSolidObject(new SmallMob(209 * 32, 17 * 32, getPhysicsHandler()));
		addSolidObject(new SmallMob(211 * 32, 17 * 32, getPhysicsHandler()));
		addSolidObject(new SmallMob(213 * 32, 17 * 32, getPhysicsHandler()));
		addSolidObject(new SmallMob(215 * 32, 17 * 32, getPhysicsHandler()));
		
		addItem(new DoorKey(186 * 32, 16 * 32, 1, getPhysicsHandler()));
		
		addRegion(new Sign(15 * 32, 13 * 32, 3, "SIGN", "Welcome to the Rabbit Hills.\nForest Ahead.", getDialogueHandler()));
		addRegion(new Sign(97 * 32, 22 * 32, 4, "SIGN", "Be careful of large falls!\nUse the ladder ahead to get back on track.", getDialogueHandler()));
		addRegion(new Sign(164 * 32, 14 * 32, 6, "SIGN", "Mr. Scrufflebottom's Abode", getDialogueHandler()));
		addRegion(new Sign(143 * 32, 28 * 32, 5, "SIGN", "DANGER!\nSTAY OUT!", getDialogueHandler()));

		addBackgroundObject(new Flag(12 * 32 - 16, 10 * 32 + 2 ,0));
		addRegion(new Knight(12 * 32 - 4, 12 * 32, false, "Greetings! It's good that you've arrived. We, the royal knights will be guiding you through the unfamiliar territory along your quest.", getDialogueHandler()));
		addTextLabel(new TextLabel(12 * 32, 14 * 32 - 20, "Press"));
		addTextLabel(new TextLabel(12 * 32 - 2, 14 * 32 - 6, "\"X\"", false));

		addBackgroundObject(new Flag(17 * 32 + 16, 10 * 32 + 2 ,1));
		addRegion(new Knight(17 * 32 + 4, 12 * 32, true, "We have already begun to spread out. Time is of the essence, so you'd best be leaving immediately! Onwards!", getDialogueHandler()));
		addTextLabel(new TextLabel(17 * 32 + 8, 14 * 32 - 20, "Press"));
		addTextLabel(new TextLabel(17 * 32 + 6, 14 * 32 - 6, "\"X\"", false));
		
		addRegion(new Knight(33 * 32, 12 * 32, true, "Don't panic! These rabbits are mostly harmless, they couldn't even hurt you if they tried.", getDialogueHandler()));
		addRegion(new Knight(81 * 32, 14 * 32, false, "Try not to fall off these platforms! You never know what'll be waiting for you down below.", getDialogueHandler()));
		addRegion(new Knight(142 * 32, 12 * 32, true, "Mr. Scrufflebottom's home is just ahead. Maybe he knows something about the kidnapper!", getDialogueHandler()));
		
		addRegion(new Knight(71 * 32, 24 * 32, false, "The king will never find me down here!", getDialogueHandler()));
		addRegion(new Knight(135 * 32, 28 * 32, false, "I really wouldn't be down here if I were you...", getDialogueHandler()));
		addRegion(new Knight(138 * 32, 28 * 32, true, "W-what?! You shouldn't be down here! Get back on track!", getDialogueHandler()));
		
		addRegion(new GenericRabbit(180 * 32 - 4, 13 * 32 + 18,
				48, 48, 2, 0.01f, "mrscrufflebottom.gif", "Mr. Scrufflebottom",
				"Kidnapping? I've never heard of any kidnapping!\nNow where did I put my key again?", getDialogueHandler()));
		
		addRegion(new RoomWarp(229 * 32+ 16, 0, 32, 640, "rabbit.Two"));

		addBackgroundObject(new House(170 * 32 - 8, 10 * 32 + 4, 0,
				200, 160, 1));
		addForegroundObject(new House(170 * 32 - 8, 10 * 32 + 4, 1,
				200, 160, 1));
		
		addBackgroundObject(new House(193 * 32, 12 * 32 + 4, 0,
				96, 96, 2));
		addForegroundObject(new House(193 * 32, 12 * 32 + 4, 1,
				96, 96, 2));

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
		
	}
}
