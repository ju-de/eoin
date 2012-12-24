package dmcigd.levels.lake;

import java.net.URL;

import dmcigd.core.room.*;
import dmcigd.core.objects.blocks.LockedDoor;
import dmcigd.core.objects.items.DoorKey;
import dmcigd.core.objects.regions.*;
import dmcigd.levels.lake.mobs.*;

public class Two extends Room implements Runnable {
	
	public Two(URL codeBase) {
		super(codeBase, "lake", "Two", "rocky");
	}
	
	public void initializeRoom() {
		
		addSolidObject(new FishMob(34 * 32, 15 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(37 * 32, 19 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(42 * 32, 26 * 32, getPhysicsHandler(), getPlayer()));
		
		addSolidObject(new HorizontalUrchin(37 * 32, 27 * 32, 8, false, getPlayer()));
		
		addSolidObject(new VerticalUrchin(48 * 32, 26 * 32, 4, true, getPlayer()));
		addSolidObject(new VerticalUrchin(50 * 32, 22 * 32, 4, false, getPlayer()));
		addSolidObject(new VerticalUrchin(51 * 32, 24 * 32, 5, true, getPlayer()));
		
		addSolidObject(new HorizontalUrchin(59 * 32, 21 * 32, 5, false, getPlayer()));
		addSolidObject(new HorizontalUrchin(65 * 32, 20 * 32, 8, true, getPlayer()));

		addSolidObject(new FishSchool(77 * 32, 24 * 32, this));
		addSolidObject(new FishSchool(83 * 32, 24 * 32, this));
		addSolidObject(new FishSchool(89 * 32, 27 * 32, this));
		
		addSolidObject(new Squid(85 * 32, 17 * 32, getPhysicsHandler(), getPlayer()));
		
		addSolidObject(new Squid(74 * 32, 18 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new Squid(76 * 32, 18 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new Squid(78 * 32, 18 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new Squid(80 * 32, 18 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new Squid(82 * 32, 18 * 32, getPhysicsHandler(), getPlayer()));
		
		addSolidObject(new HorizontalUrchin(73 * 32, 18 * 32, 10, false, getPlayer()));
		
		addSolidObject(new Squid(114 * 32, 10 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new Squid(115 * 32, 10 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new Squid(116 * 32, 10 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new Squid(117 * 32, 10 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new Squid(118 * 32, 11 * 32, getPhysicsHandler(), getPlayer()));
		
		addSolidObject(new FishMob(107 * 32, 17 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(114 * 32, 15 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(120 * 32, 17 * 32, getPhysicsHandler(), getPlayer()));

		addItem(new DoorKey(61*32, 17*32, 1, getPhysicsHandler()));
		addSolidObject(new LockedDoor(103*32, 19*32, 1));
		
		addRegion(new RoomWarp(95 * 32 + 16, 8 * 32 + 16, 6 * 32, 1 * 32, "game.MainMenu"));
	}
}
