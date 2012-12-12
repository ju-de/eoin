package dmcigd.levels.icecave;

import java.net.URL;

import dmcigd.levels.deer.mobs.*;
import dmcigd.core.objects.blocks.LockedDoor;
import dmcigd.core.objects.items.DoorKey;
import dmcigd.core.objects.npc.Sign;
import dmcigd.core.objects.regions.*;
import dmcigd.core.room.*;

public class IceRoom3 extends Room implements Runnable{
	public IceRoom3(URL codeBase) {
		super(codeBase, "icecave", "IceRoom3", "icy");
	}
	public void initializeRoom(){
		//mobs
		addSolidObject(new BigWolf(23 * 32, 21 * 32, this));
		
		
		addSolidObject(new SmallWolf(81 * 32, 41 * 32, this));
		addSolidObject(new BigWolf(82 * 32, 39 * 32, this));
		
		addSolidObject(new SmallWolf(87 * 32, 40 * 32, this));
				
		addSolidObject(new SmallWolf(94 * 32, 39 * 32, this));
		
		addSolidObject(new BigWolf(105 * 32, 38 * 32, this));
		
		addSolidObject(new SmallWolf(119 * 32, 41 * 32, this));
		addSolidObject(new SmallWolf(118 * 32, 40 * 32, this));
		
		addSolidObject(new BigWolf(125 * 32, 40 * 32, this));
		
		//blocks
		addSolidObject(new BreakBlock(86 * 32, 26 * 32));
		
		addSolidObject(new BreakBlock(124 * 32, 24 * 32));
		addSolidObject(new BreakBlock(124 * 32, 25 * 32));
		
		addSolidObject(new BreakBlock(134 * 32, 34 * 32));
		addSolidObject(new BreakBlock(134 * 32, 35 * 32));
		
		addSolidObject(new LockedDoor(143*32, 35*32, 1));
		addSolidObject(new LockedDoor(151*32, 35*32, 2));
		addItem(new DoorKey(74*32, 24*32, 1, getPhysicsHandler()));
		addItem(new DoorKey(133*32, 24*32, 2, getPhysicsHandler()));
		
		addRegion(new Sign(125* 32, 35* 32, 6 , "RIGHT", "Tunnel Exit", getDialogueHandler()));
		addRegion(new Sign(123* 32, 35* 32, 1 , "UP", "Small Caverns", getDialogueHandler()));
		
		addRegion(new Sign(110* 32, 27* 32, 1 , "LEFT", "Cavern One", getDialogueHandler()));
		addRegion(new Sign(113* 32, 27* 32, 3 , "RIGHT", "Cavern Two", getDialogueHandler()));
	}
}
