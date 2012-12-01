package dmcigd.levels.ogre;

import dmcigd.core.objects.npc.Knight;
import dmcigd.core.objects.npc.Sign;
import dmcigd.core.room.Room;

import java.net.URL;

public class One extends Room implements Runnable{
	
	public One(URL codeBase) {
		super(codeBase, "ogre", "One", "grassy");
	}
	
	public void initializeRoom() {
		addRegion(new Sign(73 * 32, 21 * 32, 6, "SIGN", "Entering Ogre Territory.\nWATCH YOUR STEP!", getDialogueHandler()));
		
		addRegion(new Knight(50 * 32 - 4, 15 * 32, false, "Congratulations on getting past the first part of your quest - unfortunately, I have to notify you that our forces are more scattered around these parts.", getDialogueHandler()));
		addRegion(new Knight(142 * 32 - 4, 23 * 32, false, "Ogres lurk about - they may seem timid and frightened but they're really sly and cunning creatures. /nThe hole before you is an ogre trap - they set these up to catch their prey", getDialogueHandler()));
		addRegion(new Knight(162 * 32 - 4, 24 * 32, false, "How do Ogres remove their prey from their traps? Well, um. That is a very good question. /nWell, I suppose they're cunning enough to figure it out", getDialogueHandler()));
	}
}