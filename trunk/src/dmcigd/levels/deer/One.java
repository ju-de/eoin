package dmcigd.levels.deer;

import java.net.URL;

import dmcigd.core.room.*;
import dmcigd.core.objects.npc.Knight;
import dmcigd.core.objects.npc.Sign;


public class One extends Room implements Runnable{
	
	public One(URL codeBase) {
		super(codeBase, "deer", "One", "grassy");
	}
	
	public void initializeRoom() {
		addRegion(new Sign(24 * 32 + 8, 12 * 32, 6, "SIGN", "Deer Village Ahead.\nBEWARE THE WOLVES!", getDialogueHandler()));
		addRegion(new Sign(164 * 32, 28 * 32, 6, "SIGN", "Deer Village", getDialogueHandler()));
		
		addRegion(new Knight(50 * 32, 24 * 32, false, "Careful! These wolves may look cute but they're far from harmless!", getDialogueHandler()));
		addRegion(new Knight(113 * 32, 23 * 32, false, "Somedays, I like to run and jump through the air...\nIt's almost like I'm flying...", getDialogueHandler()));
		addRegion(new Knight(154 * 32, 24 * 32, true, "The deer village is just ahead. Remember your mission and try not to get too involved with their affairs... the deer people can be quite strange at times.", getDialogueHandler()));
	}
	
}
