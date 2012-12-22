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
		//INI game objects
		IcicleProjectile icicle1 = new IcicleProjectile(45 * 32, 15 * 32, getBlockMap(), getSolidObjects());
		addSolidObject(icicle1);
		addRegion(new IcicleTrigger(42 * 32, 18 * 32, 1, 4, icicle1));
		
		IcicleProjectile icicle2 = new IcicleProjectile(49 * 32, 16 * 32, getBlockMap(), getSolidObjects());
		addSolidObject(icicle2);
		addRegion(new IcicleTrigger(43 * 32, 18 * 32, 1, 4, icicle2));
		
		IcicleProjectile icicle3 = new IcicleProjectile(84 * 32, 33 * 32, getBlockMap(), getSolidObjects());
		addSolidObject(icicle3);
		addRegion(new IcicleTrigger(81 * 32, 37 * 32, 1, 1, icicle3));
		
		IcicleProjectile icicle4 = new IcicleProjectile(87 * 32, 33 * 32, getBlockMap(), getSolidObjects());
		addSolidObject(icicle4);
		addRegion(new IcicleTrigger(86 * 32, 36 * 32, 1, 1, icicle4));
		
		IcicleProjectile icicle5 = new IcicleProjectile(104 * 32, 33 * 32, getBlockMap(), getSolidObjects());
		addSolidObject(icicle5);
		addRegion(new IcicleTrigger(102 * 32, 34 * 32, 1, 3, icicle5));
		
		//mobs
		addSolidObject(new BigWolf(23 * 32, 21 * 32, this));
		
		addSolidObject(new IceWolf(81 * 32, 41 * 32, this));
		addSolidObject(new BigWolf(82 * 32, 39 * 32, this));
		
		addSolidObject(new IceWolf(87 * 32, 40 * 32, this));
				
		addSolidObject(new IceWolf(94 * 32, 39 * 32, this));
		
		addSolidObject(new BigWolf(105 * 32, 38 * 32, this));
		
		addSolidObject(new IceWolf(119 * 32, 41 * 32, this));
		addSolidObject(new IceWolf(118 * 32, 40 * 32, this));
		
		addSolidObject(new BigWolf(125 * 32, 40 * 32, this));
		
		//blocks
		addSolidObject(new BreakBlock(86 * 32, 26 * 32, getPhysicsHandler()));
		
		addSolidObject(new BreakBlock(124 * 32, 24 * 32, getPhysicsHandler()));
		addSolidObject(new BreakBlock(124 * 32, 25 * 32, getPhysicsHandler()));
		
		addSolidObject(new BreakBlock(134 * 32, 34 * 32, getPhysicsHandler()));
		addSolidObject(new BreakBlock(134 * 32, 35 * 32, getPhysicsHandler()));
		
		addSolidObject(new LockedDoor(143*32, 35*32, 1));
		addSolidObject(new LockedDoor(151*32, 35*32, 2));
		addItem(new DoorKey(74*32, 24*32, 1, getPhysicsHandler()));
		addItem(new DoorKey(133*32, 24*32, 2, getPhysicsHandler()));
		
		addRegion(new Sign(125* 32, 35* 32, 6 , "RIGHT", "Tunnel Exit", getDialogueHandler()));
		addRegion(new Sign(123* 32, 35* 32, 1 , "UP", "Small Caverns", getDialogueHandler()));
		
		addRegion(new Sign(110* 32, 27* 32, 1 , "LEFT", "Cavern One", getDialogueHandler()));
		addRegion(new Sign(113* 32, 27* 32, 3 , "RIGHT", "Cavern Two", getDialogueHandler()));
		
		addRegion(new RoomWarp(159 * 32, 34 * 32, 1 * 32, 3 * 32, "icecave.IceRoom4"));
	}
}
