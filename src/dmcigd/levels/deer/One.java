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
		addRegion(new Sign(125 * 32, 36 * 32, 5, "SIGN", "Beware the terrors of the night", getDialogueHandler()));
		
		addRegion(new Knight(14 * 32, 31 * 32, false, "These parts are wild and primal. Be mindful of your footing.", getDialogueHandler()));
		addRegion(new Knight(19 * 32 - 12, 32 * 32, true, "A deer village lies ahead. They're a very spiritual people, and pay great attention to their traditional rituals and medicine.", getDialogueHandler()));
		addRegion(new Knight(22 * 32, 33 * 32, false, "If you run into any of those deer, pay them no attention. They'll probably try to warn you of their superstitions, but it's all baloney.", getDialogueHandler()));

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
