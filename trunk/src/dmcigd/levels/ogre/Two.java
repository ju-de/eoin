package dmcigd.levels.ogre;

import dmcigd.core.objects.blocks.LockedDoor;
import dmcigd.core.objects.items.DoorKey;
import dmcigd.core.objects.regions.RoomWarp;
import dmcigd.core.room.Room;

import java.net.URL;

public class Two extends Room implements Runnable {

	public Two(URL codeBase) {
		super(codeBase, "ogre", "Two", "grassy");
	}

	public void initializeRoom() {
		
		addSolidObject(new LockedDoor(160 * 32, 25 * 32, 2));
		addItem(new DoorKey(139 * 32 - 16, 30 * 32, 2, getPhysicsHandler()));
		
		addSolidObject(new LockedDoor(213 * 32, 22 * 32, 2));
		addItem(new DoorKey(212 * 32, 22 * 32, 2, getPhysicsHandler()));
		
		addSolidObject(new OgreMob(63 * 32, 17 * 32, getPhysicsHandler()));
		addSolidObject(new OgreMob(65 * 32, 17 * 32, getPhysicsHandler()));
		
		addSolidObject(new OgreMob(76 * 32, 18 * 32, getPhysicsHandler()));
		addSolidObject(new OgreMob(78 * 32, 18 * 32, getPhysicsHandler()));
		addSolidObject(new OgreMob(81 * 32, 18 * 32, getPhysicsHandler()));
		
		addSolidObject(new OgreMob(93 * 32, 20 * 32, getPhysicsHandler()));
		addSolidObject(new OgreMob(95 * 32, 20 * 32, getPhysicsHandler()));
		
		addRegion(new RoomWarp(230 * 32+ 16, 0, 32, 640, "ogre.Three"));

	}
}