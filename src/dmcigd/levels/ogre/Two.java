package dmcigd.levels.ogre;

import dmcigd.core.objects.blocks.LockedDoor;
import dmcigd.core.objects.items.DoorKey;
import dmcigd.core.objects.regions.RoomWarp;
import dmcigd.core.objects.npc.GenericNpc;
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
		
		//Abandoned village
		addForegroundObject(new EnvironmentalSprite(190 * 32,13 * 32 + 10,64,24,"campfire"));
		addForegroundObject(new EnvironmentalSprite(192 * 32 + 16,9 * 32 + 6,128,160,"tent1"));
		addBackgroundObject(new EnvironmentalSprite(185 * 32 + 16,9 * 32 + 12,104,152,"tent2"));
		addBackgroundObject(new EnvironmentalSprite(196 * 32, 12 * 32 + 6,222,60,"tent3"));
		addForegroundObject(new EnvironmentalSprite(181 * 32 - 12, 11 * 32 + 18,186,82,"tent4"));
		
		addRegion(new GenericNpc(188 * 32 + 8, 13 * 32,
				30, 34, 2, 0.015f, "ogre/ogrebaby.gif", "Lost Ogre Baby",
				"Herpa derp key in the river.", getDialogueHandler()));
		

		//Underground village
		addRegion(new GenericNpc(169 * 32, 27 * 32 + 2,
				46, 62, 2, 0.01f, "ogre/ogreman.gif", "Ogre",
				"FNORD", getDialogueHandler()));

		
		addRegion(new GenericNpc(200 * 32 + 20, 26 * 32 + 4,
				52, 60, 2, 0.013f, "ogre/ogrewoman.gif", "Ogress",
				"FNORD", getDialogueHandler()));

		
		addRegion(new GenericNpc(184 * 32, 28 * 32 + 2,
				66, 62, 2, 0.018f, "ogre/ogrefarmer.gif", "Ogre Farmer",
				"FNORD", getDialogueHandler()));
		
		//Trap Foliage
		addForegroundObject(new Foliage(35 * 32 - 16, 19 * 32 - 28, 0));
		addForegroundObject(new Foliage(36 * 32 - 16, 19 * 32 - 26, 2));
		addForegroundObject(new Foliage(37 * 32 - 16, 19 * 32 - 22, 1));
		addForegroundObject(new Foliage(38 * 32 - 16, 19 * 32 - 18, 0));
		addForegroundObject(new Foliage(39 * 32 - 16, 19 * 32 - 13, 1));
		addForegroundObject(new Foliage(40 * 32 - 16, 19 * 32 - 9, 2));
		addForegroundObject(new Foliage(41 * 32 - 16, 19 * 32 - 4, 1));
		addForegroundObject(new Foliage(42 * 32 - 16, 19 * 32, 0));
		
		addForegroundObject(new Foliage(48 * 32 - 16, 20 * 32 - 30, 1));
		addForegroundObject(new Foliage(49 * 32 - 16, 20 * 32 - 27, 2));
		addForegroundObject(new Foliage(50 * 32 - 16, 20 * 32 - 24, 0));
		addForegroundObject(new Foliage(51 * 32 - 16, 20 * 32 - 20, 1));
		addForegroundObject(new Foliage(52 * 32 - 16, 20 * 32 - 16, 0));
		addForegroundObject(new Foliage(53 * 32 - 16, 20 * 32 - 12, 2));
		addForegroundObject(new Foliage(54 * 32 - 16, 20 * 32 - 8, 1));
		addForegroundObject(new Foliage(55 * 32 - 16, 20 * 32 - 4, 0));
		addForegroundObject(new Foliage(56 * 32 - 16, 20 * 32, 2));
		
		addRegion(new RoomWarp(230 * 32+ 16, 0, 32, 640, "ogre.Three"));

	}
}