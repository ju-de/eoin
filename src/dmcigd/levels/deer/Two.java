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
import dmcigd.core.objects.regions.RoomPassage;
import dmcigd.levels.deer.mobs.SmallWolf;


public class Two extends Room implements Runnable{
	
	public Two(URL codeBase) {
		super(codeBase, "deer", "Two", "grassy");
	}
	
	public void initializeRoom() {
		addSolidObject(new MovingPlatform(35 * 32, 10 * 32, 1, 3, 1.5f, 7));
		addSolidObject(new MovingPlatform(38 * 32, 10 * 32, 1, 3, 1, 6));
		addSolidObject(new MovingPlatform(41 * 32, 10 * 32, 1, 3, 2, 8));
		addSolidObject(new MovingPlatform(44 * 32, 10 * 32, 1, 3, 3, 14));
		addSolidObject(new MovingPlatform(47 * 32, 10 * 32, 1, 3, 0.5f, 15));
		addSolidObject(new MovingPlatform(50 * 32, 10 * 32, 1, 3, 1.25f, 14));
		addSolidObject(new MovingPlatform(53 * 32, 10 * 32, 1, 3, 2, 13));
		addSolidObject(new MovingPlatform(56 * 32, 10 * 32, 1, 3, 0.5f, 13));
		addSolidObject(new MovingPlatform(59 * 32, 10 * 32, 1, 3, 1.5f, 12));
		addSolidObject(new MovingPlatform(62 * 32, 10 * 32, 1, 3, 3, 12));
		addSolidObject(new MovingPlatform(65 * 32, 10 * 32, 1, 3, 2.5f, 13));
		addSolidObject(new MovingPlatform(68 * 32, 10 * 32, 1, 3, 1, 15));
		addSolidObject(new MovingPlatform(71 * 32, 10 * 32, 1, 3, 2, 7));
		
		addSolidObject(new TimedBlock(79 * 32, 16 * 32, 1, 0, 100, 200));
		addSolidObject(new TimedBlock(80 * 32, 16 * 32, 1, 0, 175, 200));
		addSolidObject(new TimedBlock(81 * 32, 16 * 32, 1, 0, 250, 200));
		addSolidObject(new TimedBlock(82 * 32, 16 * 32, 1, 0, 300, 200));
		addSolidObject(new TimedBlock(83 * 32, 16 * 32, 1, 0, 100, 200));
		addSolidObject(new TimedBlock(84 * 32, 16 * 32, 1, 0, 200, 200));
		addSolidObject(new TimedBlock(85 * 32, 16 * 32, 1, 0, 150, 200));
		addSolidObject(new TimedBlock(86 * 32, 16 * 32, 1, 0, 120, 200));
		addSolidObject(new TimedBlock(87 * 32, 16 * 32, 1, 0, 240, 200));
		addSolidObject(new TimedBlock(88 * 32, 16 * 32, 1, 0, 160, 200));
		addSolidObject(new TimedBlock(89 * 32, 16 * 32, 1, 0, 300, 200));
		addSolidObject(new TimedBlock(90 * 32, 16 * 32, 1, 0, 250, 200));
		addSolidObject(new TimedBlock(91 * 32, 16 * 32, 1, 0, 125, 200));
		addSolidObject(new TimedBlock(92 * 32, 16 * 32, 1, 0, 250, 200));
		addSolidObject(new TimedBlock(93 * 32, 16 * 32, 1, 0, 50, 200));
		addSolidObject(new TimedBlock(94 * 32, 16 * 32, 1, 0, 400, 200));
		addSolidObject(new TimedBlock(95 * 32, 16 * 32, 1, 0, 150, 200));
		addSolidObject(new TimedBlock(96 * 32, 16 * 32, 1, 0, 225, 200));
		
		addSolidObject(new PushableBlock(109 * 32, 15 * 32, getPhysicsHandler()));
		addSolidObject(new PushableBlock(108 * 32 - 8, 15 * 32, getPhysicsHandler()));
		addSolidObject(new PushableBlock(108 * 32 + 12, 14 * 32, getPhysicsHandler()));
		
		addItem(new DoorKey(125 * 32, 12 * 32, 1, getPhysicsHandler()));
		addItem(new DoorKey(98 * 32, 23 * 32, 1, getPhysicsHandler()));
		addSolidObject(new LockedDoor(130 * 32, 16 * 32, 1));
		
		addSolidObject(new SmallWolf(22 * 32, 16 * 32, this));
		addSolidObject(new SmallWolf(23 * 32, 16 * 32, this));
		addSolidObject(new SmallWolf(24 * 32, 16 * 32, this));
		
		addSolidObject(new SmallWolf(35 * 32, 16 * 32, this));
		addSolidObject(new SmallWolf(36 * 32, 16 * 32, this));
		
		addSolidObject(new SmallWolf(40 * 32, 16 * 32, this));
		addSolidObject(new SmallWolf(45 * 32, 20 * 32, this));
		
		addSolidObject(new SmallWolf(58 * 32, 18 * 32, this));
		
		addSolidObject(new SmallWolf(63 * 32, 18 * 32, this));
		addSolidObject(new SmallWolf(65 * 32, 20 * 32, this));
		addSolidObject(new SmallWolf(66 * 32, 20 * 32, this));
		
		addSolidObject(new SmallWolf(80 * 32, 17 * 32, this));
		addSolidObject(new SmallWolf(82 * 32, 17 * 32, this));
		addSolidObject(new SmallWolf(84 * 32, 17 * 32, this));
		addSolidObject(new SmallWolf(86 * 32, 17 * 32, this));
		addSolidObject(new SmallWolf(88 * 32, 17 * 32, this));
		addSolidObject(new SmallWolf(90 * 32, 17 * 32, this));
		addSolidObject(new SmallWolf(92 * 32, 17 * 32, this));
		addSolidObject(new SmallWolf(94 * 32, 17 * 32, this));
		
		addRegion(new Sign(147 * 32, 18 * 32, 5, "SIGN", "Deer Village Entrance", getDialogueHandler()));
		
		addRegion(new Knight(20 * 32, 15 * 32, false, "These wolves travel in such large packs, don't they?", getDialogueHandler()));
		addRegion(new Knight(142 * 32, 18 * 32, true, "The deer village is just on the other side of this cave. Remember your mission and try not to get too involved with their affairs... the deer people can be quite strange at times.", getDialogueHandler()));
		
		addRegion(new RoomPassage(152 * 32, 17 * 32, "deer.Three"));
	}
	
}