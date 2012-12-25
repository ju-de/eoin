package dmcigd.levels.lake;

import java.net.URL;

import dmcigd.core.room.*;
import dmcigd.core.objects.blocks.PushableBlock;
import dmcigd.core.objects.regions.*;
import dmcigd.levels.lake.mobs.*;

public class Three extends Room implements Runnable {
	
	public Three(URL codeBase) {
		super(codeBase, "lake", "Three", "rocky");
	}
	
	public void initializeRoom() {
		addSolidObject(new LinearTurtle(40 * 32, 22 * 32, 0.5f, 4, this));
		
		addSolidObject(new LinearTurtle(53 * 32, 22 * 32, -0.5f, -4, this));
		
		addSolidObject(new LinearTurtle(58 * 32, 22 * 32, 0.5f, 3, this));
		addSolidObject(new LinearTurtle(65 * 32, 22 * 32, -0.5f, -3, this));
		
		addSolidObject(new HorizontalUrchin(74 * 32, 27 * 32, 5, false, getPlayer()));
		
		addSolidObject(new FishMob(72 * 32, 21 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(78 * 32, 25 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(87 * 32, 22 * 32, getPhysicsHandler(), getPlayer()));
		
		addSolidObject(new LinearTurtle(70 * 32, 15 * 32, 0.5f, 3, this));
		addSolidObject(new LinearTurtle(77 * 32, 15 * 32, -0.5f, -3, this));
		
		addSolidObject(new LinearTurtle(57 * 32, 15 * 32, 0.5f, 3, this));
		addSolidObject(new LinearTurtle(66 * 32, 15 * 32, -0.5f, -3, this));
		
		addSolidObject(new LinearTurtle(42 * 32, 15 * 32, 0.5f, 3, this));
		addSolidObject(new LinearTurtle(49 * 32, 15 * 32, -0.5f, -3, this));
		addSolidObject(new LinearTurtle(50 * 32, 15 * 32, 0.5f, 3, this));
		
		addSolidObject(new Squid(21 * 32, 17 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new Squid(23 * 32, 17 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new Squid(25 * 32, 17 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new Squid(27 * 32, 17 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new Squid(29 * 32, 17 * 32, getPhysicsHandler(), getPlayer()));
		
		addSolidObject(new HorizontalUrchin(26 * 32, 7 * 32, 14, false, getPlayer()));
		
		addSolidObject(new Squid(29 * 32, 7 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new Squid(30 * 32, 7 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new Squid(32 * 32, 7 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new Squid(33 * 32, 7 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new Squid(35 * 32, 7 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new Squid(36 * 32, 7 * 32, getPhysicsHandler(), getPlayer()));
		
		addSolidObject(new LinearTurtle(46 * 32, 7 * 32, 0.5f, 3, this));
		addSolidObject(new LinearTurtle(53 * 32, 7 * 32, -0.5f, -3, this));
		addSolidObject(new LinearTurtle(54 * 32, 7 * 32, 0.5f, 3, this));
		
		addSolidObject(new LinearTurtle(60 * 32, 7 * 32, 0.5f, 4, this));
		addSolidObject(new LinearTurtle(71 * 32, 7 * 32, -0.5f, -4, this));
		addSolidObject(new LinearTurtle(74 * 32, 7 * 32, 0.5f, 4, this));
		
		addSolidObject(new VerticalUrchin(91 * 32, 11 * 32, 2, true, getPlayer()));
		
		addSolidObject(new VerticalUrchin(93 * 32, 8 * 32, 3, false, getPlayer()));
		addSolidObject(new VerticalUrchin(94 * 32, 12 * 32, 3, true, getPlayer()));
		
		addSolidObject(new VerticalUrchin(96 * 32, 9 * 32, 4, false, getPlayer()));
		addSolidObject(new VerticalUrchin(97 * 32, 10 * 32, 2, true, getPlayer()));
		
		addSolidObject(new VerticalUrchin(101 * 32, 22 * 32, 3, true, getPlayer()));
		addSolidObject(new HorizontalUrchin(104 * 32, 16 * 32, 3, false, getPlayer()));
		addSolidObject(new VerticalUrchin(110 * 32, 19 * 32, 3, false, getPlayer()));
		addSolidObject(new HorizontalUrchin(107 * 32, 25 * 32, 3, true, getPlayer()));
		
		addSolidObject(new FishMob(105 * 32, 19 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(106 * 32, 22 * 32, getPhysicsHandler(), getPlayer()));
		
		addSolidObject(new VerticalUrchin(111 * 32, 17 * 32, 3, true, getPlayer()));
		addSolidObject(new HorizontalUrchin(114 * 32, 11 * 32, 3, false, getPlayer()));
		addSolidObject(new VerticalUrchin(120 * 32, 14 * 32, 3, false, getPlayer()));
		addSolidObject(new HorizontalUrchin(117 * 32, 20 * 32, 3, true, getPlayer()));
		
		addSolidObject(new FishMob(115 * 32, 14 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(116 * 32, 17 * 32, getPhysicsHandler(), getPlayer()));
		
		addSolidObject(new PushableBlock(138 * 32, 12 * 32, getPhysicsHandler()));
		addSolidObject(new PushableBlock(139 * 32, 12 * 32, getPhysicsHandler()));
		
		addRegion(new RoomWarp(146 * 32, 18 * 32, 32, 32, "game.MainMenu"));
	}
}
