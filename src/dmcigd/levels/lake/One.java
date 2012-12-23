package dmcigd.levels.lake;

import java.net.URL;

import dmcigd.core.room.*;
import dmcigd.core.objects.regions.*;
import dmcigd.levels.lake.mobs.*;

public class One extends Room implements Runnable {
	
	public One(URL codeBase) {
		super(codeBase, "lake", "One", "rocky");
	}
	
	public void initializeRoom() {
		//addSolidObject(new FishMob(91 * 32, 21 * 32, getPhysicsHandler(), getPlayer()));
		
		addSolidObject(new TurtleShell(64 * 32, 14 * 32, getPhysicsHandler(), false));
		
		addSolidObject(new FishSchool(73 * 32, 8 * 32, this));
		addSolidObject(new FishSchool(73 * 32, 12 * 32, this));
		addSolidObject(new FishSchool(76 * 32, 10 * 32, this));
		addSolidObject(new FishSchool(79 * 32, 8 * 32, this));
		addSolidObject(new FishSchool(79 * 32, 12 * 32, this));
		addSolidObject(new FishSchool(82 * 32, 10 * 32, this));
		addSolidObject(new FishSchool(85 * 32, 8 * 32, this));
		addSolidObject(new FishSchool(85 * 32, 12 * 32, this));
		
		addSolidObject(new FishSchool(132 * 32, 11 * 32, this));
		addSolidObject(new FishSchool(141 * 32, 14 * 32, this));
		addSolidObject(new FishSchool(154 * 32, 11 * 32, this));
		addSolidObject(new FishSchool(163 * 32, 15 * 32, this));
		
		addSolidObject(new Turtle(140 * 32, 19 * 32, this));
		addSolidObject(new Turtle(145 * 32, 19 * 32, this));
		
		addSolidObject(new Turtle(158 * 32, 20 * 32, this));
		addSolidObject(new Turtle(163 * 32, 20 * 32, this));
		
		addSolidObject(new FishMob(128 * 32, 13 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(134 * 32, 10 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(143 * 32, 15 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(146 * 32, 11 * 32, getPhysicsHandler(), getPlayer()));
		
		addSolidObject(new FishMob(153 * 32, 10 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(156 * 32, 15 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(167 * 32, 13 * 32, getPhysicsHandler(), getPlayer()));
		
		addRegion(new RoomWarp(208 * 32 + 16, 19 * 32 + 16, 5 * 32, 1 * 32, "game.MainMenu"));
	}
}
