package dmcigd.levels.lake;

import java.net.URL;

import dmcigd.core.room.*;
import dmcigd.core.objects.blocks.*;
import dmcigd.core.objects.items.*;
import dmcigd.core.objects.npc.*;
import dmcigd.levels.lake.mobs.*;

public class Three extends Room implements Runnable {
	
	public Three(URL codeBase) {
		super(codeBase, "lake", "Three", "rocky");
	}
	
	public void initializeRoom() {
		
		addRegion(new Sign(37 * 32, 20 * 32 , 5, "Tip", "It's all about the timing", getDialogueHandler()));
		
		//first hallway
		addSolidObject(new FishSchool(38 * 32, 19 * 32, this));
		addSolidObject(new FishMob(44 * 32, 18 * 32, getPhysicsHandler(),  getPlayer()));
		addSolidObject(new FishMob(60 * 32, 18 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(67 * 32, 20 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new Turtle(62 * 32, 22 * 32, this));
		addSolidObject(new Turtle(59 * 32, 22 * 32, this));
		
		//space, second right pertrudy arm thingy area
		addSolidObject(new FishSchool(59 * 32, 26 * 32, this));
		addSolidObject(new FishMob(69 * 32, 26 * 32, getPhysicsHandler(),  getPlayer()));
		addSolidObject(new FishMob(71 * 32, 26 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishSchool(77 * 32, 25 * 32, this));
		addSolidObject(new FishSchool(79 * 32, 25 * 32, this));
		addSolidObject(new Turtle(77 * 32, 26 * 32, this));
		addSolidObject(new Turtle(78 * 32, 26 * 32, this));
		addSolidObject(new Turtle(79 * 32, 26 * 32, this));
		addItem(new DoorKey(102 * 32, 22 * 32, 1, getPhysicsHandler()));
		addSolidObject(new LockedDoor(57 * 32, 28 * 32, 1));
		
		//second door
		addItem(new DoorKey(41 * 32, 19 * 32, 2, getPhysicsHandler()));
		addSolidObject(new LockedDoor(59 * 32, 30 * 32, 2));
		
		//third bit
		addSolidObject(new FishMob(76 * 32, 34 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishSchool(80 * 32, 36* 32, this));
		addSolidObject(new FishSchool(69 * 32, 37 * 32, this));
		addSolidObject(new FishSchool(56 * 32, 35 * 32, this));
		
		//down
		addSolidObject(new CrumblingBlock(46 * 32, 35 * 32, 0.15f, 500));
		addSolidObject(new CrumblingBlock(47 * 32, 35 * 32, 0.15f, 500));
		addSolidObject(new CrumblingBlock(46 * 32, 36 * 32, 0.15f, 500));
		addSolidObject(new CrumblingBlock(47 * 32, 36 * 32, 0.15f, 500));
		addSolidObject(new CrumblingBlock(46 * 32, 37 * 32, 0.15f, 500));
		addSolidObject(new CrumblingBlock(46 * 32, 38 * 32, 0.15f, 500));
		addSolidObject(new CrumblingBlock(46 * 32, 39 * 32, 0.15f, 500));
	
		//no turning back now C:
		addItem(new DoorKey(48 * 32, 36 * 32, 1, getPhysicsHandler()));
		addSolidObject(new LockedDoor(76 * 32, 51 * 32, 1));
		addItem(new DoorKey(58 * 32, 58 * 32, 2, getPhysicsHandler()));
		addSolidObject(new LockedDoor(77 * 32, 50 * 32, 2));
		
		addSolidObject(new FishSchool(53 * 32, 44 * 32, this));
		addSolidObject(new FishSchool(55 * 32, 45 * 32, this));
		
		addSolidObject(new FishMob(58 * 32, 45 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(43 * 32, 46 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(41 * 32, 47 * 32, getPhysicsHandler(), getPlayer()));
		
		addRegion(new Sign(47 * 32, 51 * 32 , 7, "Caution", "Use the turtles to your advantage", getDialogueHandler()));
		addSolidObject(new FishSchool(48 * 32, 50* 32, this));
		
		addSolidObject(new Turtle(44 * 32, 53 * 32,  this));
		addSolidObject(new Turtle(43 * 32, 53 * 32,  this));
		addSolidObject(new Turtle(41 * 32, 53 * 32,  this));
		addSolidObject(new Turtle(40 * 32, 53 * 32,  this));
		addSolidObject(new Turtle(38 * 32, 53 * 32,  this));
		addSolidObject(new Turtle(37 * 32, 53 * 32,  this));
		addSolidObject(new Turtle(35 * 32, 53 * 32,  this));
		addSolidObject(new Turtle(33 * 32, 53 * 32,  this));
		addSolidObject(new Turtle(32 * 32, 53 * 32,  this));
		
		
		//second key room
		addSolidObject(new FishSchool(56 * 32, 55* 32, this));
		addSolidObject(new FishSchool(56 * 32, 37 * 32, this));
		
		//turtlemass
		addRegion(new Sign(48 * 32, 62 * 32 , 7, "Carful.", "You arn't strong enough to push more than one turtle shell at a time.", getDialogueHandler()));
		addSolidObject(new Turtle(48 * 32, 70 * 32,  this));
		addSolidObject(new Turtle(51 * 32, 70 * 32,  this));
		addSolidObject(new Turtle(54 * 32, 70 * 32,  this));
		
		addSolidObject(new Turtle(62 * 32, 70 * 32,  this));
		addSolidObject(new Turtle(64 * 32, 70 * 32,  this));
		addSolidObject(new Turtle(66 * 32, 70 * 32,  this));
		addSolidObject(new Turtle(68 * 32, 70 * 32,  this));
		addSolidObject(new Turtle(73 * 32, 70 * 32,  this));
		addSolidObject(new Turtle(75 * 32, 70 * 32,  this));
		addSolidObject(new Turtle(86 * 32, 70 * 32,  this));
		addSolidObject(new Turtle(88 * 32, 70 * 32,  this));
		addSolidObject(new Turtle(90 * 32, 70 * 32,  this));
		
		// third key
		addItem(new DoorKey(108 * 32, 70 * 32, 3, getPhysicsHandler()));
		addSolidObject(new LockedDoor(117 * 32, 37 * 32, 3));
		
		


		
	}
}
