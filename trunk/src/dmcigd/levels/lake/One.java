package dmcigd.levels.lake;

import java.net.URL;

import dmcigd.core.room.*;
import dmcigd.core.objects.blocks.*;
import dmcigd.core.objects.items.*;
import dmcigd.core.objects.npc.*;
import dmcigd.core.objects.regions.*;
import dmcigd.levels.lake.mobs.*;

public class One extends Room implements Runnable {
	
	public One(URL codeBase) {
		super(codeBase, "lake", "One", "rocky");
	}
	
	public void initializeRoom() {
		
		//Welcome to Level
		addRegion(new Sign(25 * 32, 10 * 32, 5, "Welcome", "So now you're underwater... So have fun, explore, and enjoy swimming around", getDialogueHandler()));
		
		//Introduction to turtles
		addRegion(new Sign(27 * 32, 9 * 32, 6, "Notice", "These are turtles; their shells act as movable objects upon death", getDialogueHandler()));
		addSolidObject(new Turtle(38 * 32, 9 * 32, this));
		addSolidObject(new Turtle(34 * 32, 9 * 32, this));
		
		//Spike Warning
		addRegion(new Sign(55 * 32, 11 * 32, 3, "Warning", "Lake inhabitants include: Spikes... lots of them", getDialogueHandler()));
		
		//Non-aggressive fish
		addRegion(new Sign(74 * 32, 13 * 32, 3, "Notice", "Protect wildlife! Don't kill the little fishies, they don't bite", getDialogueHandler()));
		addSolidObject(new FishSchool(83 * 32, 14 * 32, this));
		addSolidObject(new FishSchool(83 * 32, 9 * 32, this));
		
		//The turtles need to be moved to pick up key
		addSolidObject(new Turtle(72 * 32, 15 * 32, this));
		addSolidObject(new Turtle(75 * 32, 15 * 32, this));
		addItem(new DoorKey(74 * 32, 15 * 32, 1, getPhysicsHandler()));
		addSolidObject(new LockedDoor(87 * 32, 17 * 32, 1));
		
		//Training arena
		addRegion(new Sign(85 * 32, 20 * 32, 9, "Danger", "Train how to fight or dodge the red fish! They aren't as friendly", getDialogueHandler()));
		addSolidObject(new FishSchool(87 * 32, 21 * 32, this));
		addSolidObject(new FishSchool(100 * 32, 20 * 32, this));
		addSolidObject(new Turtle(80 * 32, 20 * 32, this));
		addSolidObject(new Turtle(91 * 32, 28 * 32, this));
		addSolidObject(new FishMob(91 * 32, 21 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(97 * 32, 22 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(105 * 32, 20 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(89 * 32, 24 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(95 * 32, 25 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(100 * 32, 25 * 32, getPhysicsHandler(), getPlayer()));
		
		//Open area
		addSolidObject(new Turtle(114 * 32, 22 * 32, this));
		addSolidObject(new Turtle(120 * 32, 22 * 32, this));
		addSolidObject(new Turtle(167 * 32, 20 * 32, this));
		addSolidObject(new Turtle(174 * 32, 20 * 32, this));
		addSolidObject(new Turtle(149 * 32, 22 * 32, this));
		addSolidObject(new Turtle(160 * 32, 22 * 32, this));
		addSolidObject(new FishSchool(116 * 32, 18 * 32, this));
		addSolidObject(new FishSchool(126 * 32, 17 * 32, this));
		addSolidObject(new FishSchool(133 * 32, 20 * 32, this));
		addSolidObject(new FishSchool(136 * 32, 22 * 32, this));
		addSolidObject(new FishSchool(166 * 32, 18 * 32, this));
		addSolidObject(new FishSchool(174 * 32, 18 * 32, this));
		addSolidObject(new FishMob(143 * 32, 16 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(148 * 32, 16 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(142 * 32, 19 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(143 * 32, 21 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(154 * 32, 20 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(117 * 32, 21 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(124 * 32, 19 * 32, getPhysicsHandler(), getPlayer()));
		addItem(new DoorKey(107 * 32, 13 * 32, 2, getPhysicsHandler()));
		addSolidObject(new LockedDoor(166 * 32, 22 * 32, 2));
		
		//Falling
		addSolidObject(new FishSchool(181 * 32, 36 * 32, this));
		addSolidObject(new FishSchool(182 * 32, 43 * 32, this));
		addSolidObject(new FishSchool(187 * 32, 47 * 32, this));
		addSolidObject(new FishSchool(183 * 32, 48* 32, this));
		
		addRegion(new RoomWarp(0, 49 * 32, 216 * 32, 2 * 32, "lake.Two"));
	}
}
