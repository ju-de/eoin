package dmcigd.levels.deer;

import java.net.URL;

import dmcigd.core.room.*;
import dmcigd.core.objects.platforms.MovingPlatform;
import dmcigd.core.objects.blocks.TimedBlock;
import dmcigd.core.objects.npc.Sign;
import dmcigd.core.objects.regions.RoomWarp;
import dmcigd.levels.deer.mobs.SmallWolf;


public class Two extends Room implements Runnable{
	
	public Two(URL codeBase) {
		super(codeBase, "deer", "Two", "grassy");
	}
	
	public void initializeRoom() {
		
		addRegion(new Sign(87 * 32, 19 * 32, 3, "SIGN", "The guardian's domain lies ahead.", getDialogueHandler()));
		
		addSolidObject(new MovingPlatform(111 * 32, 22 * 32, 1, 4, 1, 8));
		addSolidObject(new MovingPlatform(119 * 32, 26 * 32, 0, 4, -1, -9));
		addSolidObject(new MovingPlatform(119 * 32, 28 * 32, 0, 4, 1, 9));
		addSolidObject(new MovingPlatform(129 * 32, 30 * 32, 0, 4, -1, -9));
		
		
		addSolidObject(new TimedBlock(153 * 32, 34 * 32, 2, 0, 150, 150));
		addSolidObject(new TimedBlock(157 * 32, 34 * 32, 2, 150, 150, 150));
		addSolidObject(new TimedBlock(161 * 32, 34 * 32, 2, 0, 150, 150));
		addSolidObject(new SmallWolf(154 * 32, 35 * 32, this));
		addSolidObject(new SmallWolf(160 * 32, 35 * 32, this));
		
		addSolidObject(new TimedBlock(175 * 32, 33 * 32, 1, 0, 150, 150));
		addSolidObject(new TimedBlock(178 * 32, 33 * 32, 2, 150, 150, 150));
		addSolidObject(new TimedBlock(182 * 32, 33 * 32, 1, 0, 150, 150));
		addSolidObject(new SmallWolf(176 * 32, 34 * 32, this));
		addSolidObject(new SmallWolf(180 * 32, 34 * 32, this));
		

		addSolidObject(new MovingPlatform(164 * 32, 24 * 32, 0, 2, -1, -3));
		addSolidObject(new MovingPlatform(159 * 32, 24 * 32, 0, 2, 1, 3));
		addSolidObject(new SmallWolf(165 * 32, 26 * 32, this));
		addSolidObject(new SmallWolf(159 * 32, 26 * 32, this));

		addSolidObject(new MovingPlatform(176 * 32, 26 * 32, 1, 2, -1, -2));
		addSolidObject(new MovingPlatform(179 * 32, 25 * 32, 1, 2, 1, 2));
		addSolidObject(new MovingPlatform(182 * 32, 26 * 32, 1, 2, -1, -2));
		addSolidObject(new SmallWolf(177 * 32, 27 * 32, this));
		addSolidObject(new SmallWolf(182 * 32, 27 * 32, this));
		
		addRegion(new RoomWarp(186 * 32 + 16, 0, 32, 14 * 32, "deer.Village"));
	}
	
}