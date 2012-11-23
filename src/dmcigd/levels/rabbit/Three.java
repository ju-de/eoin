package dmcigd.levels.rabbit;

import java.net.URL;

import dmcigd.core.room.Room;
//import dmcigd.core.objects.*;
import dmcigd.core.objects.blocks.*;
import dmcigd.core.objects.items.*;
//import dmcigd.core.objects.npc.*;
import dmcigd.levels.rabbit.houses.*;

public class Three extends Room implements Runnable {
	
	//Initializes SwitchBlock to be passed on to the appropriate switch
	SwitchBlock switchBlock1 = new SwitchBlock(116 * 32, 23 * 32, 3);
	SwitchBlock switchBlock2 = new SwitchBlock(121 * 32, 25 * 32, 3);
	
	public Three(URL codeBase) {
		super(codeBase, "rabbit", "Three", "grassy");
	}

	public void initializeSolidObjects() {
		addSolidObject(new LockedDoor(126 * 32, 20 * 32, 1));
		addSolidObject(new LockedDoor(129 * 32, 16 * 32, 2));
		addSolidObject(new LockedDoor(113 * 32, 24 * 32, 3));
		
		addSolidObject(switchBlock1);
		addSolidObject(switchBlock2);
	}

	public void initializeNonsolidObjects() {
		addItem(new DoorKey(126 * 32, 23 * 32, 3, getPhysicsHandler()));
		addItem(new DoorKey(117 * 32, 22 * 32, 2, getPhysicsHandler()));
		addItem(new DoorKey(131 * 32, 15 * 32, 1, getPhysicsHandler()));
		
		addRegion(new Switch(119 * 32 + 4, 23 * 32 + 16, true, switchBlock1));
		addRegion(new Switch(130 * 32 + 4, 27 * 32 + 16, true, switchBlock2));
		
		addBackgroundObject(new HouseSix(96 * 32 - 8, 16 * 32 + 4, 0));
		addForegroundObject(new HouseSix(96 * 32 - 8, 16 * 32 + 4, 1));
	}
}
