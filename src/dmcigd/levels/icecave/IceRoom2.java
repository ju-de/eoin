package dmcigd.levels.icecave;

import java.net.URL;

import dmcigd.core.objects.blocks.LockedDoor;
import dmcigd.core.objects.items.DoorKey;
import dmcigd.core.objects.npc.Sign;
import dmcigd.core.objects.regions.*;
import dmcigd.core.room.*;
import dmcigd.levels.rabbit.mobs.SmallMob;

public class IceRoom2 extends Room implements Runnable{
	public IceRoom2(URL codeBase) {
		super(codeBase, "icecave", "IceRoom2", "icy");
	}
	public void initializeRoom(){
		addRegion(new Sign(30 * 32, 24 * 32, 5, "DANGER", "Beware of pitfalls and falling icicles!", getDialogueHandler()));
		addRegion(new Sign(102 * 32, 17 * 32, 2, "placeholder", "meltable ice wall goes here to ceiling", getDialogueHandler()));
		addRegion(new Sign(55 * 32, 25 * 32, 9, "BEWARE", "Wolves below!", getDialogueHandler()));
		
		addItem(new DoorKey(96 * 32, 16 * 32, 1, getPhysicsHandler()));
		addSolidObject(new LockedDoor(160 * 32, 12 * 32, 1));
		
		addSolidObject(new SmallMob(58 * 32, 30 * 32, getPhysicsHandler()));
		addSolidObject(new SmallMob(59 * 32, 30 * 32, getPhysicsHandler()));
		addSolidObject(new SmallMob(60 * 32, 30 * 32, getPhysicsHandler()));
		addSolidObject(new SmallMob(61 * 32, 30 * 32, getPhysicsHandler()));
		addSolidObject(new SmallMob(63 * 32, 30 * 32, getPhysicsHandler()));
		
		addSolidObject(new SmallMob(77 * 32, 29 * 32, getPhysicsHandler()));
		addSolidObject(new SmallMob(79 * 32, 29 * 32, getPhysicsHandler()));
		addSolidObject(new SmallMob(81 * 32, 29 * 32, getPhysicsHandler()));
		
		addSolidObject(new SmallMob(92 * 32, 30 * 32, getPhysicsHandler()));
		addSolidObject(new SmallMob(94 * 32, 30 * 32, getPhysicsHandler()));
		addSolidObject(new SmallMob(96 * 32, 30 * 32, getPhysicsHandler()));
		addSolidObject(new SmallMob(98 * 32, 30 * 32, getPhysicsHandler()));
		
		addSolidObject(new SmallMob(108 * 32, 30 * 32, getPhysicsHandler()));
		addSolidObject(new SmallMob(110 * 32, 30 * 32, getPhysicsHandler()));
		addSolidObject(new SmallMob(112 * 32, 30 * 32, getPhysicsHandler()));
		
		addSolidObject(new SmallMob(117 * 32, 31 * 32, getPhysicsHandler()));
		addSolidObject(new SmallMob(119 * 32, 31 * 32, getPhysicsHandler()));
		addSolidObject(new SmallMob(121 * 32, 31 * 32, getPhysicsHandler()));
	}
}
