package dmcigd.levels.icecave;

import java.net.URL;

import dmcigd.core.objects.blocks.LockedDoor;
import dmcigd.core.objects.items.DoorKey;
import dmcigd.core.objects.npc.Sign;
import dmcigd.core.objects.regions.*;
import dmcigd.core.room.*;

public class IceRoom2 extends Room implements Runnable{
	public IceRoom2(URL codeBase) {
		super(codeBase, "icecave", "IceRoom2", "icy");
	}
	public void initializeRoom(){
		//INI game objects
		IcicleProjectile icicle1 = new IcicleProjectile(77 * 32, 9 * 32, getBlockMap(), getSolidObjects());
		addSolidObject(icicle1);
		addRegion(new IcicleTrigger(74 * 32, 9 * 32, 1, 3, icicle1));
		
		IcicleProjectile icicle2 = new IcicleProjectile(95 * 32, 9 * 32, getBlockMap(), getSolidObjects());
		addSolidObject(icicle2);
		addRegion(new IcicleTrigger(93 * 32, 8 * 32, 1, 5, icicle2));
		
		IcicleProjectile icicle3 = new IcicleProjectile(180 * 32, 10 * 32, getBlockMap(), getSolidObjects());
		addSolidObject(icicle3);
		addRegion(new IcicleTrigger(176 * 32, 11 * 32, 1, 2, icicle3));
		
		addRegion(new Sign(30 * 32, 24 * 32, 5, "DANGER", "Beware of pitfalls and falling icicles!", getDialogueHandler()));
		addRegion(new Sign(55 * 32, 25 * 32, 9, "BEWARE", "Wolves below!", getDialogueHandler()));
		
		addItem(new DoorKey(96 * 32, 16 * 32, 1, getPhysicsHandler()));
		addSolidObject(new LockedDoor(160 * 32, 12 * 32, 1));
		
		addSolidObject(new IceWolf(58 * 32, 30 * 32, this));
		addSolidObject(new IceWolf(60 * 32, 30 * 32, this));
		addSolidObject(new IceWolf(63 * 32, 30 * 32, this));
		
		addSolidObject(new IceWolf(77 * 32, 29 * 32, this));
		addSolidObject(new IceWolf(81 * 32, 29 * 32, this));
		
		addSolidObject(new IceWolf(92 * 32, 30 * 32, this));
		addSolidObject(new IceWolf(94 * 32, 30 * 32, this));
		addSolidObject(new IceWolf(98 * 32, 30 * 32, this));
		
		addSolidObject(new IceWolf(108 * 32, 30 * 32, this));
		addSolidObject(new IceWolf(112 * 32, 30 * 32, this));
		
		addSolidObject(new IceWolf(117 * 32, 31 * 32, this));
		addSolidObject(new IceWolf(121 * 32, 31 * 32, this));
		
		addRegion(new RoomWarp(193 * 32, 13 * 32, 1 * 32, 2 * 32, "icecave.IceRoom3"));
	}
}
