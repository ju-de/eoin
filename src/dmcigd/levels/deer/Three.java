package dmcigd.levels.deer;

import java.net.URL;

import dmcigd.core.objects.blocks.LockedDoor;
import dmcigd.core.objects.blocks.PushableBlock;
import dmcigd.core.objects.items.DoorKey;
import dmcigd.core.objects.platforms.MovingPlatform;
import dmcigd.core.objects.regions.RoomWarp;
import dmcigd.core.objects.npc.*;
import dmcigd.core.room.*;
import dmcigd.levels.deer.mobs.*;

public class Three extends Room implements Runnable{
	
	public Three(URL codebase) {
		super(codebase, "deer", "Three", "grassy");
	}
	
	public void initializeRoom() {
		
		//Platform 1
		addSolidObject(new MovingPlatform(59 * 32, 18 * 32, 0, 4, -1.5f, -9));
		addSolidObject(new MovingPlatform(61 * 32, 17 * 32, 0, 4, 1.5f, 9));
		addSolidObject(new MovingPlatform(73 * 32, 16 * 32, 0, 4, -1.5f, -9));

		addSolidObject(new SmallWolf(89 * 32, 14 * 32, this));
		addSolidObject(new SmallWolf(94 * 32, 14 * 32, this));
		
		addSolidObject(new BigWolf(107 * 32, 11 * 32, this));
		addSolidObject(new BigWolf(110 * 32, 11 * 32, this));
		addSolidObject(new BigWolf(114 * 32, 11 * 32, this));
		
		//Platform 2
		addSolidObject(new PushableBlock(109 * 32, 25 * 32, getPhysicsHandler()));
		
		addSolidObject(new BigWolf(118 * 32, 24 * 32, this));
		addSolidObject(new BigWolf(123 * 32, 24 * 32, this));
		addSolidObject(new BigWolf(129 * 32, 24 * 32, this));
		
		//Dragon Rock
		addSolidObject(new BigWolf(147 * 32, 34 * 32, this));
		addSolidObject(new BigWolf(151 * 32, 34 * 32, this));
		addSolidObject(new BigWolf(155 * 32, 34 * 32, this));
		addSolidObject(new BigWolf(159 * 32, 34 * 32, this));
		
		addSolidObject(new SmallWolf(184 * 32, 34 * 32, this));

		addSolidObject(new SmallWolf(159 * 32, 27 * 32, this));
		addSolidObject(new SmallWolf(165 * 32, 27 * 32, this));
		addSolidObject(new SmallWolf(170 * 32, 27 * 32, this));
		
		addSolidObject(new BigWolf(162 * 32, 18 * 32, this));
		addSolidObject(new BigWolf(164 * 32, 18 * 32, this));
		addSolidObject(new BigWolf(169 * 32, 18 * 32, this));
		
		//Hidden area (Lion's Mouth)
		
		addItem(new DoorKey(47 * 32, 35 * 32, 2, getPhysicsHandler()));
		
		addSolidObject(new LockedDoor(38 * 32, 30 * 32, 2));
		addRegion(new DeerAncestor(42 * 32, 33 * 32, 1, false, "Find strength in yourself...", getDialogueHandler()));
		addRegion(new DeerAncestor(25 * 32, 29 * 32, 1, false, "You are wise, young one. Remember to never lose sight of who you are.", getDialogueHandler()));
		
		addSolidObject(new LockedDoor(39 * 32, 39 * 32, 2));
		addRegion(new DeerAncestor(42 * 32, 38 * 32, 0, false, "Find strength in the ones you love...", getDialogueHandler()));
		addRegion(new DeerAncestor(22 * 32, 41 * 32, 0, true, "A scorpion and a frog meet on the bank of a stream and the "
				+ "scorpion asks the frog to carry him across on its back. The "
				+ "frog asks, \"How do I know you won't sting me?\" The scorpion "
				+ "says, \"Because if I do, I will die too.\""
				+ "\n\n"
				+ "The frog is satisfied, and they set out, but in midstream,"
				+ "the scorpion stings the frog. The frog feels the onset of "
				+ "paralysis and starts to sink, knowing they both will drown,"
				+ "but has just enough time to gasp \"Why?\" "
				+ "\n\n"
				+ "Replies the scorpion \"Its my nature...\" ", getDialogueHandler()));
		
		addRegion(new RoomWarp(195 * 32 + 16, 0, 32, 20 * 32, "deer.BossRoom"));
	}
	
}
