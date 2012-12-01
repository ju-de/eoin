package dmcigd.levels.ogre;

import dmcigd.core.objects.blocks.CrumblingBlock;
import dmcigd.core.objects.npc.Knight;
import dmcigd.core.objects.npc.Sign;
import dmcigd.core.room.Room;
import dmcigd.levels.rabbit.Flag;

import java.net.URL;

public class One extends Room implements Runnable{
	
	public One(URL codeBase) {
		super(codeBase, "ogre", "One", "grassy");
	}
	
	public void initializeRoom() {
		addRegion(new Sign(26 * 32, 13 * 32, 9, "SIGN", "Entering Ogre Territory.\nWATCH YOUR STEP!", getDialogueHandler()));
		
		addBackgroundObject(new Flag(53 * 32 + 16, 19 * 32 + 2 ,0));
		addRegion(new Knight(53 * 32 + 4, 21 * 32, true, "Congratulations on getting past the first part of your quest! But we're still haven't reached the forest yet! We're going to have to make our way through the treacherous ogre camps to get there...", getDialogueHandler()));
		
		addBackgroundObject(new Flag(57 * 32 - 16, 19 * 32 + 2 ,1));
		addRegion(new Knight(57 * 32 - 4, 21 * 32, true, "Don't be fooled by their timid appearance, the ogres are a brutish and savage bunch, and they're only out for your flesh.", getDialogueHandler()));
		
		addRegion(new Knight(81 * 32, 21 * 32, false, "Ogres lurk about - they may seem timid and frightened but they're really sly and cunning creatures. \nThe hole before you is an ogre trap - they set these up to catch their prey", getDialogueHandler()));
		
		addRegion(new Knight(109 * 32, 17 * 32, false, "You must be very careful around these parts, for their traps are fairly wide - they were made for prey even larger than us! They're often much longer than a single bound", getDialogueHandler()));
		
		addSolidObject(new CrumblingBlock(132 * 32, 25 * 32, 0.2f, 500));
		addRegion(new Knight(126 * 32, 23 * 32, false, "If you're having trouble getting over these traps, it may help to get a running start.", getDialogueHandler()));
	}
}