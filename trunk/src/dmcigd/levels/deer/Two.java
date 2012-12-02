package dmcigd.levels.deer;

import java.net.URL;

import dmcigd.core.room.*;
import dmcigd.core.objects.platforms.MovingPlatform;
import dmcigd.core.objects.blocks.TimedBlock;
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
		addSolidObject(new MovingPlatform(56 * 32, 13 * 32, 1, 2, 1, 3));
		addSolidObject(new MovingPlatform(59 * 32, 12 * 32, 1, 2, (float)1.5, 4));
		addSolidObject(new MovingPlatform(62 * 32, 12 * 32, 1, 2, 2, 4));
		addSolidObject(new MovingPlatform(65 * 32, 13 * 32, 1, 2, (float)0.5, 3));
		
		addSolidObject(new TimedBlock(77 * 32, 16 * 32, 1, 0, 250, 250));
		addSolidObject(new TimedBlock(78 * 32, 16 * 32, 1, 0, 250, 250));
		addSolidObject(new TimedBlock(79 * 32, 16 * 32, 1, 0, 250, 250));
		addSolidObject(new TimedBlock(80 * 32, 16 * 32, 1, 0, 250, 250));
		addSolidObject(new TimedBlock(81 * 32, 16 * 32, 1, 0, 250, 250));
		addSolidObject(new TimedBlock(82 * 32, 16 * 32, 1, 0, 250, 250));
		addSolidObject(new TimedBlock(83 * 32, 16 * 32, 1, 0, 250, 250));
		addSolidObject(new TimedBlock(84 * 32, 16 * 32, 1, 0, 250, 250));
		addSolidObject(new TimedBlock(85 * 32, 16 * 32, 1, 0, 250, 250));
		addSolidObject(new TimedBlock(86 * 32, 16 * 32, 1, 0, 250, 250));
		
		addSolidObject(new PushableBlock(113 * 32, 6 * 32, getPhysicsHandler()));
		
		addItem(new DoorKey(125 * 32, 12 * 32, 1, getPhysicsHandler()));
		addSolidObject(new LockedDoor(130 * 32, 16 * 32, 1));
		
		addRegion(new Sign(147 * 32, 18 * 32, 5, "SIGN", "Deer Village", getDialogueHandler()));
		
		addRegion(new Knight(20 * 32, 15 * 32, false, "These wolves travel in such large packs, don't they?", getDialogueHandler()));
		addRegion(new Knight(142 * 32, 18 * 32, true, "The deer village is just ahead. Remember your mission and try not to get too involved with their affairs... the deer people can be quite strange at times.", getDialogueHandler()));
		
		addRegion(new RoomWarp(150 * 32, 13 * 32, 32, 8 * 32, "deer.Three"));
	}
	
}