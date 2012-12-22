package dmcigd.levels.icecave;

import java.net.URL;

import dmcigd.core.objects.regions.*;
import dmcigd.core.room.*;
import dmcigd.core.objects.blocks.*;
import dmcigd.core.objects.items.*;
import dmcigd.levels.lake.mobs.*;

public class IceRoom4 extends Room implements Runnable{
	
	public IceRoom4(URL codeBase) {
		super(codeBase, "icecave", "IceRoom4", "icy");
	}	
	
	public void initializeRoom(){
		// block ini
		SwitchBlock switchBlock1 = new SwitchBlock(82 * 32, 35 * 32, 8);
		SwitchWall switchBlock2 = new SwitchWall(92 * 32, 18 * 32);
		SwitchBlock switchBlock3 = new SwitchBlock(86 * 32, 15 * 32, 4);
		
		IcicleProjectile icicle1 = new IcicleProjectile(54 * 32, 22 * 32, getBlockMap(), getSolidObjects());
		addSolidObject(icicle1);
		addRegion(new IcicleTrigger(52 * 32, 23 * 32, 1, 3, icicle1));
		
		IcicleProjectile icicle2 = new IcicleProjectile(77 * 32, 36 * 32, getBlockMap(), getSolidObjects());
		addSolidObject(icicle2);
		addRegion(new IcicleTrigger(75 * 32, 38 * 32, 1, 4, icicle2));
		
		IcicleProjectile icicle3 = new IcicleProjectile(79 * 32, 6 * 32, getBlockMap(), getSolidObjects());
		addSolidObject(icicle3);
		addRegion(new IcicleTrigger(81 * 32, 7 * 32, 1, 3, icicle3));
		
		addSolidObject(switchBlock1);
		addRegion(new Switch(90 * 32, 40 * 32, true, switchBlock1));
		
		addSolidObject(switchBlock2);
		addRegion(new Switch(93 * 32, 23 * 32, false, switchBlock2));
		
		addSolidObject(switchBlock3);
		addRegion(new Switch(81 * 32, 18 * 32, false, switchBlock3));
		
		addSolidObject(new LockedDoor(84 * 32, 18 * 32, 1));
		addItem(new DoorKey(100 * 32, 16 * 32, 1, getPhysicsHandler()));
		
		addSolidObject(new FishMob(53 * 32, 35 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(61 * 32, 38 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishSchool(69 * 32, 40 * 32, this));
		addSolidObject(new FishSchool(85 * 32, 39 * 32, this));
		addSolidObject(new FishSchool(76 * 32, 40 * 32, this));
		
		addRegion(new RoomWarp(45 * 32, 6 * 32, 1 * 32, 2 * 32, "icecave.IceRoom5"));
	}
}
