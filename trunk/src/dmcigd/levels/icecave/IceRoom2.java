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
		addRegion(new Sign(30 * 32, 24 * 32, 5, "DANGER", "Beware of pitfalls and falling icicles!", getDialogueHandler()));
		addRegion(new Sign(102 * 32, 19 * 32, 2, "placeholder", "meltable ice wall goes here to ceiling", getDialogueHandler()));
		
		addItem(new DoorKey(96 * 32, 19 * 32, 1, getPhysicsHandler()));
		addSolidObject(new LockedDoor(160 * 32, 12 * 32, 1));
	}
}
