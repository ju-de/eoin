package dmcigd.levels.deer;

import java.net.URL;

import dmcigd.core.room.*;
import dmcigd.core.objects.npc.Knight;
import dmcigd.core.objects.npc.Sign;


public class Two extends Room implements Runnable{
	
	public Two(URL codeBase) {
		super(codeBase, "deer", "Two", "grassy");
	}
	
	public void initializeRoom() {
		addRegion(new Sign(164 * 32, 28 * 32, 6, "SIGN", "Deer Village", getDialogueHandler()));
		
		addRegion(new Knight(154 * 32, 24 * 32, true, "The deer village is just ahead. Remember your mission and try not to get too involved with their affairs... the deer people can be quite strange at times.", getDialogueHandler()));
	}
	
}