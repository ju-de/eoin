package dmcigd.levels.deer;

import java.net.URL;

import dmcigd.core.room.*;
import dmcigd.core.objects.npc.*;
import dmcigd.core.objects.blocks.TimedBlock;
import dmcigd.core.objects.regions.RoomWarp;
import dmcigd.core.objects.platforms.MovingPlatform;

import dmcigd.levels.deer.mobs.*;

public class One extends Room implements Runnable{
	
	public One(URL codeBase) {
		super(codeBase, "deer", "One", "grassy");
	}
	
	public void initializeRoom() {
		addRegion(new Sign(22 * 32 + 8, 33 * 32, 9, "SIGN", "Deer Village Ahead.\nBeware of Wolves!", getDialogueHandler()));
		
		//addRegion(new Knight(50 * 32, 24 * 32, false, "Careful! These wolves may look cute but they're far from harmless!", getDialogueHandler()));
		//addRegion(new Knight(113 * 32, 23 * 32, false, "Somedays, I like to run and jump through the air...\nIt's almost like I'm flying...", getDialogueHandler()));

		addSolidObject(new SmallWolf(28 * 32, 44 * 32, this));
		addSolidObject(new SmallWolf(31 * 32, 44 * 32, this));
		
		addSolidObject(new SmallWolf(43 * 32, 43 * 32, this));
		
		addSolidObject(new SmallWolf(57 * 32, 42 * 32, this));
		addSolidObject(new SmallWolf(59 * 32, 42 * 32, this));

		
		addSolidObject(new SmallWolf(76 * 32, 26 * 32, this));
		addSolidObject(new SmallWolf(78 * 32, 26 * 32, this));
		addSolidObject(new SmallWolf(80 * 32, 26 * 32, this));
		addSolidObject(new SmallWolf(84 * 32, 26 * 32, this));
		addSolidObject(new SmallWolf(88 * 32, 26 * 32, this));
		
		addSolidObject(new SmallWolf(126 * 32, 13 * 32, this));
		addSolidObject(new SmallWolf(130 * 32, 13 * 32, this));
		
		addSolidObject(new TimedBlock(87 * 32, 25 * 32, 1, 0, 150, 150));
		addSolidObject(new TimedBlock(82 * 32, 25 * 32, 1, 150, 150, 150));
		addSolidObject(new TimedBlock(77 * 32, 25 * 32, 1, 0, 150, 150));
		
		addSolidObject(new MovingPlatform(68 * 32, 21 * 32, 1, 2, -1.5f, -5));
		addSolidObject(new MovingPlatform(73 * 32, 18 * 32, 1, 2, 1.5f, 5));
		addSolidObject(new MovingPlatform(78 * 32, 21 * 32, 1, 2, -1.5f, -5));
		addSolidObject(new MovingPlatform(83 * 32, 18 * 32, 1, 2, 1.5f, 5));
		addSolidObject(new MovingPlatform(88 * 32, 21 * 32, 1, 2, -1.5f, -5));
		
		addRegion(new RoomWarp(147 * 32 + 16, 0, 32, 14 * 32, "deer.Two"));
	}
	
}
