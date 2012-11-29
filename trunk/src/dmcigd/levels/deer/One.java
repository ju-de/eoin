package dmcigd.levels.deer;

import java.net.URL;

import dmcigd.core.room.*;
import dmcigd.core.objects.npc.Sign;


public class One extends Room implements Runnable{
	
	public One(URL codeBase) {
		super(codeBase, "deer", "One", "grassy");
	}
	
	public void initializeRoom() {
		addRegion(new Sign(24 * 32, 12 * 32, 9, "SIGN", "Deer Village Ahead.\nBEWARE THE WOLVES!", getDialogueHandler()));
	}
	
}
