package dmcigd.levels.icecave;

import java.net.URL;

import dmcigd.core.objects.regions.*;
import dmcigd.core.room.*;
import dmcigd.core.objects.*;
import dmcigd.core.objects.blocks.*;
import dmcigd.core.objects.platforms.*;
import dmcigd.core.objects.items.*;
import dmcigd.levels.lake.mobs.*;
import dmcigd.levels.rabbit.Switch;
import dmcigd.levels.rabbit.SwitchBlock;

public class IceRoom4 extends Room implements Runnable{
	
	SwitchBlock switchBlock1 = new SwitchBlock(82 * 32, 35 * 32, 8);
	SwitchBlock switchBlock2 = new SwitchBlock(92 * 32, 18 * 32, 1);
	SwitchBlock switchBlock3 = new SwitchBlock(86 * 32, 15 * 32, 4);
	
	public IceRoom4(URL codeBase) {
		super(codeBase, "icecave", "IceRoom4", "icy");
	}	
	
	public void initializeRoom(){
		
		addSolidObject(switchBlock1);
		addRegion(new Switch(90 * 32, 40 * 32, true, switchBlock1));
		
		addSolidObject(switchBlock2);
		addRegion(new Switch(93 * 32, 23 * 32, false, switchBlock2));
		
		addSolidObject(switchBlock3);
		addRegion(new Switch(81 * 32, 18 * 32, false, switchBlock3));
		
		addSolidObject(new LockedDoor(84 * 32, 18 * 32, 1));
		addItem(new DoorKey(100 * 32, 16 * 32, 1, getPhysicsHandler()));
		
		addSolidObject(new FishMob(53 * 32, 35 * 32, getPhysicsHandler()));
		addSolidObject(new FishMob(61 * 32, 38 * 32, getPhysicsHandler()));
		addSolidObject(new FishSchool(69 * 32, 40 * 32, this));
		addSolidObject(new FishSchool(85 * 32, 39 * 32, this));
		addSolidObject(new FishSchool(76 * 32, 40 * 32, this));
	}
}
