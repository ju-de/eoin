package dmcigd.levels.icecave;

import java.net.URL;

import dmcigd.core.objects.blocks.LockedDoor;
import dmcigd.core.objects.items.DoorKey;
import dmcigd.core.objects.regions.*;
import dmcigd.core.room.*;

public class IceRoom5 extends Room implements Runnable{
	
	
	public IceRoom5(URL codeBase) {
		super(codeBase, "icecave", "IceRoom5", "icy");
	}
	public void initializeRoom(){
		IcicleProjectile icicle1 = new IcicleProjectile(67 * 32, 37 * 32, getBlockMap(), getSolidObjects());
		addSolidObject(icicle1);
		addRegion(new IcicleTrigger(70 * 32, 39 * 32, 1, 1, icicle1));
		
		addSolidObject(new LockedDoor(90*32, 28*32, 1));
		addItem(new DoorKey(55*32, 39*32, 1, getPhysicsHandler()));
		
		addSolidObject(new BreakBlock(124 * 32, 23 * 32));
		
		addSolidObject(new BreakBlock(133 * 32, 20 * 32));
		
		addSolidObject(new LockedDoor(92*32, 10*32, 2));
		addItem(new DoorKey(108*32, 13*32, 2, getPhysicsHandler()));
		addSolidObject(new LockedDoor(93*32, 10*32, 3));
		addItem(new DoorKey(111*32, 13*32, 3, getPhysicsHandler()));
		
		addSolidObject(new BreakBlock(54 * 32, 10 * 32));
		
		addSolidObject(new LockedDoor(20*32, 15*32, 1));
		addItem(new DoorKey(52*32, 10*32, 1, getPhysicsHandler()));
		
	}
}
