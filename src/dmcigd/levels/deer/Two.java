package dmcigd.levels.deer;

import java.net.URL;

import dmcigd.core.room.*;
import dmcigd.core.objects.platforms.MovingPlatform;
import dmcigd.core.objects.blocks.PushableBlock;
import dmcigd.core.objects.npc.Knight;
import dmcigd.core.objects.npc.Sign;


public class Two extends Room implements Runnable{
	
	public Two(URL codeBase) {
		super(codeBase, "deer", "Two", "grassy");
	}
	
	public void initializeRoom() {
		addSolidObject(new MovingPlatform(41 * 32, 29 * 32, 1, 4, (float)0.6, 6));
		addSolidObject(new MovingPlatform(81 * 32, 5 * 32, 0, 3, 2, 18));
		
		addSolidObject(new PushableBlock(109 * 32, 3 * 32, getPhysicsHandler()));
		
		addRegion(new Sign(164 * 32, 28 * 32, 6, "SIGN", "Deer Village", getDialogueHandler()));
		
		addRegion(new Knight(53 * 32, 35 * 32, false, "These wolves travel in such large packs, don't they?", getDialogueHandler()));
		addRegion(new Knight(102 * 32, 36 * 32, true, "Strange... it felt like a rock just fell on my head...", getDialogueHandler()));
		addRegion(new Knight(154 * 32, 24 * 32, true, "The deer village is just ahead. Remember your mission and try not to get too involved with their affairs... the deer people can be quite strange at times.", getDialogueHandler()));
	}
	
}