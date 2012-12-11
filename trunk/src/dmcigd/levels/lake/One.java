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
		//intro to turtles
		addSolidObject(new Turtle(38* 32, 9 * 32, this));
		addSolidObject(new Turtle(37 * 32, 9 * 32, this));
		
		addRegion(new Sign(29 * 32, 9 * 32, 5, "Welcome", "So now you're underwater... So have fun, explore and enjoy swimming around. Also, who needs air?", getDialogueHandler()));
		addRegion(new Sign(55 * 32, 11 * 32, 3, "Warning", "Lake inhabitants include: Spikes... lots of them.", getDialogueHandler()));
		
		addSolidObject(new FishSchool(83 * 32, 14 * 32, this));
		addSolidObject(new FishSchool(83 * 32, 9 * 32, this));
		addSolidObject(new FishSchool(85 * 32, 7 * 32, this));
		
		//need to kill turtle to get key
		addRegion(new Sign(85 * 32, 17 * 32, 9, "Warning", "Little fish aren't the problem...", getDialogueHandler()));
		addSolidObject(new Turtle(73 * 32, 15 * 32, this));
		addSolidObject(new Turtle(73 * 32, 15 * 32, this));
		
		addItem(new DoorKey(74 * 32, 15 * 32, 1, getPhysicsHandler()));
		addSolidObject(new LockedDoor(87 * 32, 17 * 32, 1));
		
		//inside training area
		addSolidObject(new FishSchool(102 * 32, 19 * 32, this));
		addSolidObject(new FishSchool(93 * 32, 20* 32, this));
		addSolidObject(new FishSchool(97 * 32, 20 * 32, this));
		addSolidObject(new Turtle(95 * 32, 17 * 32, this));
		addSolidObject(new Turtle(86 * 32, 22 * 32, this));
		addSolidObject(new FishMob(91 * 32, 20 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(97 * 32, 22 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(102 * 32, 21 * 32, getPhysicsHandler(), getPlayer()));
		
		//spike guards
		addSolidObject(new FishSchool(119 * 32, 17 * 32, this));
		addSolidObject(new FishSchool(122 * 32, 17 * 32, this));
		addSolidObject(new FishMob(115 * 32, 19 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(132 * 32, 19 * 32, getPhysicsHandler(), getPlayer()));
		
		//battle area
		addSolidObject(new FishSchool(151 * 32, 21 * 32, this));
		addSolidObject(new FishSchool(143 * 32, 17 * 32, this));
		addSolidObject(new FishMob(147 * 32, 19 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(162 * 32, 21 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(150 * 32, 21 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(142 * 32, 21 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(97 * 32, 20 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(153* 32, 20 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(149 * 32, 16 * 32, getPhysicsHandler(), getPlayer()));
		
		//falling
		addSolidObject(new FishSchool(181 * 32, 36 * 32, this));
		addSolidObject(new FishSchool(182 * 32, 43 * 32, this));
		addSolidObject(new FishSchool(184 * 32, 47 * 32, this));
		addSolidObject(new FishSchool(183 * 32, 48* 32, this));
		
		addRegion(new RoomWarp(0, 49 * 32, 216 * 32, 2 * 32, "lake.Two"));
	}
}
