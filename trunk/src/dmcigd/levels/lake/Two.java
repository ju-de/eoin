package dmcigd.levels.lake;

import java.net.URL;

import dmcigd.core.room.*;
import dmcigd.core.objects.blocks.*;
import dmcigd.core.objects.items.*;
import dmcigd.core.objects.npc.*;
import dmcigd.core.objects.regions.*;
import dmcigd.levels.lake.mobs.*;

public class Two extends Room implements Runnable {
	
	public Two(URL codeBase) {
		super(codeBase, "lake", "Two", "rocky");
	}
	
	public void initializeRoom() {
		
		//top useless
		addSolidObject(new FishSchool(15 * 32, 4 * 32, this));
		
		addRegion(new Sign(30 * 32, 29 * 32 , 3, "Tip", "It's gonna be like a maze from here, follow the signs", getDialogueHandler()));
		addSolidObject(new FishSchool(26 * 32, 27 * 32, this));
		
		//room1 upper area for key
		addSolidObject(new FishMob(21 * 32, 45 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishSchool(42 * 32, 20 * 32, this));
		addSolidObject(new FishSchool(42 * 32, 22 * 32, this));
		addSolidObject(new FishSchool(43 * 32, 21 * 32, this));
		addSolidObject(new FishSchool(44 * 32, 14 * 32, this));
		addSolidObject(new FishSchool(40 * 32, 16 * 32, this));
		addSolidObject(new FishSchool(40 * 32, 19 * 32, this));
		addSolidObject(new FishSchool(43 * 32, 17 * 32, this));
		addSolidObject(new FishSchool(42 * 32, 22 * 32, this));
		addSolidObject(new Turtle(42 * 32, 27 * 32, this));
		addItem(new DoorKey(44 * 32, 15 * 32, 1, getPhysicsHandler()));
		addSolidObject(new LockedDoor(22 * 32, 43 * 32, 1));
		addItem(new DoorKey(41 * 32, 46 * 32, 1, getPhysicsHandler()));
		addSolidObject(new LockedDoor(20 * 32, 49 * 32, 1));
		addRegion(new Sign(29 * 32, 62 * 32, 5, "Tip", "Use your intuition! You don't need to go to all the rooms.", getDialogueHandler()));
		
		addSolidObject(new Turtle(32 * 32, 43 * 32, this));
		addRegion(new Sign(36 * 32, 54 * 32, 6, "Path", "Diver's Nightmare", getDialogueHandler()));
		
		//fall
		addSolidObject(new FishSchool(39 * 32, 40 * 32, this));
		addSolidObject(new FishSchool(38 * 32, 39 * 32, this));
		addSolidObject(new FishMob(36 * 32, 32 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(38 * 32, 38 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(37 * 32, 37 * 32, getPhysicsHandler(), getPlayer()));

		//spiketop room
		addSolidObject(new FishSchool(28 * 32, 48 * 32, this));
		addSolidObject(new FishSchool(33 * 32, 48 * 32, this));
		addSolidObject(new FishSchool(31 * 32, 49 * 32, this));
		addSolidObject(new FishSchool(29 * 32, 48 * 32, this));
		
		addSolidObject(new FishMob(34 * 32, 48 * 32, getPhysicsHandler(), getPlayer()));
		
		//spikeleft room
		addSolidObject(new FishSchool(17 * 32, 51 * 32, this));
		addSolidObject(new FishSchool(18 * 32, 52 * 32, this));
		addSolidObject(new FishMob(20 * 32, 52 * 32, getPhysicsHandler(), getPlayer()));
		
		addSolidObject(new FishSchool(17 * 32, 57 * 32, this));
		addSolidObject(new FishSchool(19 * 32, 58 * 32, this));
		addSolidObject(new FishMob(13 * 32, 59 * 32, getPhysicsHandler(), getPlayer()));
		
		addSolidObject(new FishSchool(35 * 32, 63 * 32, this));
		addSolidObject(new FishSchool(36 * 32, 64 * 32, this));
		addSolidObject(new FishSchool(35 * 32, 66 * 32, this));
		addSolidObject(new FishSchool(36 * 32, 67 * 32, this));
		addSolidObject(new Turtle(29 * 32, 62 * 32, this));
		
	//going down
		addSolidObject(new FishSchool(25 * 32, 73 * 32, this));
		addSolidObject(new FishSchool(26 * 32, 74 * 32, this));
		addSolidObject(new FishSchool(27 * 32, 75 * 32, this));
		addItem(new DoorKey(19 * 32, 77 * 32, 2, getPhysicsHandler()));
		addSolidObject(new LockedDoor(33 * 32, 86 * 32, 2));
		
		addSolidObject(new FishSchool(27 * 32, 78 * 32, this));
		addSolidObject(new FishSchool(28 * 32, 79 * 32, this));
		addSolidObject(new FishSchool(29 * 32, 80 * 32, this));
		
		addSolidObject(new FishMob(26 * 32, 86 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishSchool(27 * 32, 87 * 32, this));
		addSolidObject(new FishSchool(26 * 32, 88 * 32, this));
		addSolidObject(new FishSchool(21 * 32, 88 * 32, this));
		
		//after door
		addSolidObject(new FishSchool(38 * 32, 82 * 32, this));
		addSolidObject(new FishSchool(41 * 32, 78 * 32, this));
		addSolidObject(new Turtle(40 * 32, 79 * 32, this));
		addSolidObject(new Turtle(43 * 32, 79 * 32, this));
		addSolidObject(new Turtle(47 * 32, 81 * 32, this));
		addSolidObject(new Turtle(50 * 32, 81 * 32, this));
		addSolidObject(new Turtle(51 * 32, 81 * 32, this));
		addSolidObject(new Turtle(53 * 32, 80 * 32, this));
		
		//detour
		addSolidObject(new Turtle(63 * 32, 79 * 32, this));
		addSolidObject(new Turtle(73 * 32, 72 * 32, this));
		addSolidObject(new FishSchool(67 * 32, 77 * 32, this));
		addSolidObject(new FishSchool(68 * 32, 78 * 32, this));
		
	//going up
		addSolidObject(new FishMob(46 * 32, 46 * 32, getPhysicsHandler(), getPlayer()));
		
		addSolidObject(new FishSchool(43 * 32, 48 * 32, this));
		addSolidObject(new FishSchool(44 * 32, 49 * 32, this));
		addSolidObject(new FishSchool(45 * 32, 50 * 32, this));
		addSolidObject(new FishSchool(46 * 32, 51 * 32, this));
		addSolidObject(new FishSchool(47 * 32, 52 * 32, this));
		addSolidObject(new FishSchool(39 * 32, 51 * 32, this));
		addSolidObject(new FishSchool(40 * 32, 52 * 32, this));
		addSolidObject(new FishSchool(41 * 32, 53 * 32, this));
		addSolidObject(new FishSchool(42 * 32, 54 * 32, this));

		addSolidObject(new FishSchool(43 * 32, 48 * 32, this));
		addSolidObject(new FishSchool(44 * 32, 49 * 32, this));
		addSolidObject(new FishSchool(45 * 32, 50 * 32, this));
		addSolidObject(new FishSchool(46 * 32, 51 * 32, this));
		addSolidObject(new FishSchool(47 * 32, 52 * 32, this));
		addSolidObject(new FishSchool(39 * 32, 51 * 32, this));
		addSolidObject(new FishSchool(40 * 32, 52 * 32, this));
		addSolidObject(new FishSchool(41 * 32, 53 * 32, this));
		addSolidObject(new FishSchool(42 * 32, 54 * 32, this));
	
		addSolidObject(new FishSchool(43 * 32, 48 * 32, this));
		addSolidObject(new FishSchool(44 * 32, 49 * 32, this));
		addSolidObject(new FishSchool(45 * 32, 50 * 32, this));
		addSolidObject(new FishSchool(46 * 32, 51 * 32, this));
		addSolidObject(new FishSchool(47 * 32, 52 * 32, this));
		addSolidObject(new FishSchool(39 * 32, 51 * 32, this));
		addSolidObject(new FishSchool(40 * 32, 52 * 32, this));
		addSolidObject(new FishSchool(41 * 32, 53 * 32, this));
		addSolidObject(new FishSchool(42 * 32, 54 * 32, this));

		addSolidObject(new FishSchool(43 * 32, 48 * 32, this));
		addSolidObject(new FishSchool(44 * 32, 49 * 32, this));
		addSolidObject(new FishSchool(45 * 32, 50 * 32, this));
		addSolidObject(new FishSchool(46 * 32, 51 * 32, this));
		addSolidObject(new FishSchool(47 * 32, 52 * 32, this));
		addSolidObject(new FishSchool(39 * 32, 51 * 32, this));
		addSolidObject(new FishSchool(40 * 32, 52 * 32, this));
		addSolidObject(new FishSchool(41 * 32, 53 * 32, this));
		addSolidObject(new FishSchool(42 * 32, 54 * 32, this));
		
		//meet area
		
		addRegion(new RoomWarp(57 * 32, 0, 2 * 32, 101 * 32, "lake.TwoB"));
	}
}
