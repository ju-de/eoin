package dmcigd.levels.ogre;

import dmcigd.core.objects.npc.Knight;
import dmcigd.core.objects.npc.Sign;
import dmcigd.core.objects.regions.RoomWarp;
import dmcigd.core.room.Room;
import dmcigd.levels.rabbit.Flag;

import java.net.URL;

public class One extends Room implements Runnable {

	public One(URL codeBase) {
		super(codeBase, "ogre", "One", "grassy");
	}

	public void initializeRoom() {
		
		addRegion(new Sign(26 * 32, 13 * 32, 9, "SIGN",
				"Lots of Ogres Ahead.\nWATCH YOUR STEP!",
				getDialogueHandler()));

		addBackgroundObject(new Flag(53 * 32 + 16, 19 * 32 + 2, 0));
		addRegion(new Knight(
				53 * 32 + 4,
				21 * 32,
				true,
				"Congratulations on getting past the first part of your quest! But we're still haven't reached the forest yet! We're going to have to make our way through the treacherous ogre camps to get there...",
				getDialogueHandler()));

		addBackgroundObject(new Flag(57 * 32 - 16, 19 * 32 + 2, 1));
		addRegion(new Knight(
				57 * 32 - 4,
				21 * 32,
				true,
				"Don't be fooled by their timid appearance, the ogres are a brutish and savage bunch, and they're only out for your flesh.",
				getDialogueHandler()));

		addRegion(new Knight(
				81 * 32,
				21 * 32,
				false,
				"Ogres lurk about - they may seem timid and frightened but they're really sly and cunning creatures. \nThe hole before you is an ogre trap - they set these up to catch their prey",
				getDialogueHandler()));

		addRegion(new Knight(
				109 * 32,
				17 * 32,
				false,
				"You must be very careful around these parts, for their traps are fairly wide - they were made for prey even larger than us! They're often much longer than a single bound",
				getDialogueHandler()));

		addRegion(new Knight(
				126 * 32,
				23 * 32,
				false,
				"If you're having trouble getting over these traps, it may help to get a running start.",
				getDialogueHandler()));
		
		//Trap Foliage
		addForegroundObject(new Foliage(84 * 32 - 16, 22 * 32, 0));
		addForegroundObject(new Foliage(85 * 32 - 16, 22 * 32, 2));
		addForegroundObject(new Foliage(86 * 32 - 16, 22 * 32, 1));
		
		addForegroundObject(new Foliage(112 * 32 - 16, 19 * 32 - 30, 1));
		addForegroundObject(new Foliage(113 * 32 - 16, 19 * 32 - 24, 0));
		addForegroundObject(new Foliage(114 * 32 - 16, 19 * 32 - 16, 2));
		addForegroundObject(new Foliage(115 * 32 - 16, 19 * 32 - 8, 0));
		addForegroundObject(new Foliage(116 * 32 - 16, 19 * 32, 1));

		addForegroundObject(new Foliage(129 * 32 - 16, 24 * 32, 2));
		addForegroundObject(new Foliage(130 * 32 - 16, 24 * 32, 1));
		addForegroundObject(new Foliage(131 * 32 - 16, 24 * 32, 0));
		addForegroundObject(new Foliage(132 * 32 - 16, 24 * 32, 2));
		addForegroundObject(new Foliage(133 * 32 - 16, 24 * 32, 0));
		addForegroundObject(new Foliage(134 * 32 - 16, 24 * 32, 1));
		addForegroundObject(new Foliage(135 * 32 - 16, 24 * 32, 2));
		
		addForegroundObject(new Foliage(150 * 32 - 16, 19 * 32, 0));
		addForegroundObject(new Foliage(151 * 32 - 16, 19 * 32, 2));
		addForegroundObject(new Foliage(152 * 32 - 16, 19 * 32, 1));
		addForegroundObject(new Foliage(153 * 32 - 16, 19 * 32, 0));
		addForegroundObject(new Foliage(154 * 32 - 16, 19 * 32, 1));
		addForegroundObject(new Foliage(155 * 32 - 16, 19 * 32, 0));
		addForegroundObject(new Foliage(156 * 32 - 16, 19 * 32, 2));
		
		addRegion(new RoomWarp(174 * 32+ 16, 0, 32, 640, "ogre.Two"));
	}
}