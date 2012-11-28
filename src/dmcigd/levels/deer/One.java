package dmcigd.levels.deer;

import java.net.URL;

import dmcigd.core.room.*;
import dmcigd.core.objects.npc.Sign;


public class One extends Room implements Runnable{
	
	public One(URL codeBase) {
		super(codeBase, "deer", "One", "grassy");
	}
	
	public void initializeRoom() {
		addRegion(new Sign(13 * 32, 11 * 32, 3, "SIGN", "Deer Village Ahead.\nBEWARE THE WOLVES!", getDialogueHandler()));
	}
	
}
