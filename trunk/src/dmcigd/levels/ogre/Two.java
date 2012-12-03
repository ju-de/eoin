package dmcigd.levels.ogre;

import dmcigd.core.objects.blocks.CrumblingBlock;
import dmcigd.core.objects.blocks.LockedDoor;
import dmcigd.core.objects.items.DoorKey;
import dmcigd.core.room.Room;

import java.net.URL;

public class Two extends Room implements Runnable {

	public Two(URL codeBase) {
		super(codeBase, "ogre", "Two", "grassy");
	}

	public void initializeRoom() {
		
		addSolidObject(new LockedDoor(104 * 32, 25 * 32, 2));
		
		addItem(new DoorKey(72 * 32, 23 * 32, 2, getPhysicsHandler()));

	}
}