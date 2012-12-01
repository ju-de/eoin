package dmcigd.levels.deer;

import java.net.URL;

import dmcigd.core.room.*;
import dmcigd.core.objects.platforms.MovingPlatform;
import dmcigd.core.objects.blocks.CrumblingBlock;
import dmcigd.core.objects.blocks.LockedDoor;
import dmcigd.core.objects.blocks.PushableBlock;
import dmcigd.core.objects.items.DoorKey;
import dmcigd.core.objects.npc.Knight;
import dmcigd.core.objects.npc.Sign;
import dmcigd.core.objects.regions.RoomWarp;


public class Two extends Room implements Runnable{
	
	public Two(URL codeBase) {
		super(codeBase, "deer", "Two", "grassy");
	}
	
	public void initializeRoom() {
		addSolidObject(new MovingPlatform(41 * 32, 29 * 32, 1, 4, (float)0.6, 7));
		addSolidObject(new MovingPlatform(81 * 32, 5 * 32, 0, 3, 2, 18));
		
		addSolidObject(new CrumblingBlock(78 * 32, 34 * 32, (float)0.1, 500));
		addSolidObject(new CrumblingBlock(79 * 32, 34 * 32, (float)0.1, 500));
		addSolidObject(new CrumblingBlock(80 * 32, 34 * 32, (float)0.1, 500));
		addSolidObject(new CrumblingBlock(81 * 32, 34 * 32, (float)0.1, 500));
		addSolidObject(new CrumblingBlock(82 * 32, 34 * 32, (float)0.1, 500));
		addSolidObject(new CrumblingBlock(83 * 32, 34 * 32, (float)0.1, 500));
		addSolidObject(new CrumblingBlock(84 * 32, 34 * 32, (float)0.1, 500));
		
		addSolidObject(new PushableBlock(109 * 32, 3 * 32, getPhysicsHandler()));
		
		addItem(new DoorKey(92 * 32, 44 * 32, 1, getPhysicsHandler()));
		addSolidObject(new LockedDoor(117 * 32, 10 * 32, 1));
		
		addItem(new DoorKey(119 * 32, 10 * 32, 2, getPhysicsHandler()));
		addSolidObject(new LockedDoor(130 * 32, 36 * 32, 2));
		
		addRegion(new Sign(148 * 32, 38 * 32, 5, "SIGN", "Deer Village", getDialogueHandler()));
		
		addRegion(new Knight(53 * 32, 35 * 32, false, "These wolves travel in such large packs, don't they?", getDialogueHandler()));
		addRegion(new Knight(102 * 32, 36 * 32, true, "Strange... it felt like a rock just fell on my head...", getDialogueHandler()));
		addRegion(new Knight(125 * 32, 36 * 32, false, "Hmm... I thought I might've seen a flash of metal on the side of this cliff. Could it have been the key?", getDialogueHandler()));
		addRegion(new Knight(138 * 32, 37 * 32, true, "The deer village is just ahead. Remember your mission and try not to get too involved with their affairs... the deer people can be quite strange at times.", getDialogueHandler()));
		
		addRegion(new RoomWarp(151 * 32, 0, 32, 40 * 32, "deer.Three"));
	}
	
}