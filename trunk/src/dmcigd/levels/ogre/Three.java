package dmcigd.levels.ogre;

import dmcigd.core.room.Room;
import dmcigd.core.objects.blocks.PushableBlock;
import dmcigd.core.objects.regions.RoomWarp;

import java.net.URL;

public class Three extends Room implements Runnable {

	public Three(URL codeBase) {
		super(codeBase, "ogre", "Three", "grassy");
	}

	public void initializeRoom() {
		//Ogres
		addSolidObject(new OgreMob(79 * 32, 18 * 32, getPhysicsHandler()));
		addSolidObject(new OgreMob(82 * 32, 18 * 32, getPhysicsHandler()));
		addSolidObject(new OgreMob(87 * 32, 18 * 32, getPhysicsHandler()));
		
		addSolidObject(new OgreMob(99 * 32, 17 * 32, getPhysicsHandler()));
		addSolidObject(new OgreMob(104 * 32, 17 * 32, getPhysicsHandler()));
		
		addSolidObject(new OgreMob(115 * 32, 19 * 32, getPhysicsHandler()));
		addSolidObject(new OgreMob(120 * 32, 19 * 32, getPhysicsHandler()));
		
		addSolidObject(new OgreMob(186 * 32, 11 * 32, getPhysicsHandler()));
		addSolidObject(new OgreMob(189 * 32, 11 * 32, getPhysicsHandler()));
		addSolidObject(new OgreMob(191 * 32, 11 * 32, getPhysicsHandler()));
		
		addSolidObject(new OgreMob(202 * 32, 13 * 32, getPhysicsHandler()));
		addSolidObject(new OgreMob(206 * 32, 13 * 32, getPhysicsHandler()));
		
		addSolidObject(new OgreMob(224 * 32, 10 * 32, getPhysicsHandler()));
		addSolidObject(new OgreMob(226 * 32, 10 * 32, getPhysicsHandler()));
		addSolidObject(new OgreMob(230 * 32, 10 * 32, getPhysicsHandler()));
		
		//Boulders
		addSolidObject(new PushableBlock(37 * 32, 12 * 32, getPhysicsHandler()));
		
		addSolidObject(new PushableBlock(74 * 32, 16 * 32, getPhysicsHandler()));
		
		addSolidObject(new PushableBlock(69 * 32, 12 * 32, getPhysicsHandler()));
		addSolidObject(new PushableBlock(70 * 32, 12 * 32, getPhysicsHandler()));
		addSolidObject(new PushableBlock(69 * 32 + 12, 11 * 32, getPhysicsHandler()));
		
		addSolidObject(new PushableBlock(109 * 32, 16 * 32, getPhysicsHandler()));
		addSolidObject(new PushableBlock(110 * 32, 16 * 32, getPhysicsHandler()));
		addSolidObject(new PushableBlock(111 * 32, 16 * 32, getPhysicsHandler()));
		addSolidObject(new PushableBlock(109 * 32 + 16, 15 * 32, getPhysicsHandler()));
		addSolidObject(new PushableBlock(110 * 32 + 16, 15 * 32, getPhysicsHandler()));
		
		addSolidObject(new PushableBlock(122 * 32, 17 * 32, getPhysicsHandler()));
		
		addSolidObject(new PushableBlock(125 * 32, 17 * 32, getPhysicsHandler()));
		addSolidObject(new PushableBlock(125 * 32, 16 * 32, getPhysicsHandler()));
		
		addSolidObject(new PushableBlock(159 * 32, 14 * 32, getPhysicsHandler()));
		
		addSolidObject(new PushableBlock(171 * 32, 13 * 32, getPhysicsHandler()));
		addSolidObject(new PushableBlock(171 * 32 + 4, 12 * 32, getPhysicsHandler()));
		addSolidObject(new PushableBlock(171 * 32 - 10, 11 * 32, getPhysicsHandler()));
		addSolidObject(new PushableBlock(171 * 32 + 18, 11 * 32, getPhysicsHandler()));
		addSolidObject(new PushableBlock(171 * 32 - 4, 10 * 32, getPhysicsHandler()));
		
		addSolidObject(new PushableBlock(212 * 32, 12 * 32, getPhysicsHandler()));
		

		//Trap Foliage
		addForegroundObject(new Foliage(29 * 32 - 16, 16 * 32 - 34, 2));
		addForegroundObject(new Foliage(30 * 32 - 16, 16 * 32 - 28, 1));
		addForegroundObject(new Foliage(31 * 32 - 16, 16 * 32 - 16, 0));
		addForegroundObject(new Foliage(32 * 32 - 16, 16 * 32 - 8, 2));
		addForegroundObject(new Foliage(33 * 32 - 16, 16 * 32, 0));
		
		addForegroundObject(new Foliage(47 * 32 - 16, 10 * 32 - 27, 1));
		addForegroundObject(new Foliage(48 * 32 - 16, 10 * 32 - 21, 2));
		addForegroundObject(new Foliage(49 * 32 - 16, 10 * 32 - 15, 0));
		addForegroundObject(new Foliage(50 * 32 - 16, 10 * 32 - 10, 2));
		addForegroundObject(new Foliage(51 * 32 - 16, 10 * 32 - 5, 1));
		addForegroundObject(new Foliage(52 * 32 - 16, 10 * 32, 0));
		
		addForegroundObject(new Foliage(58 * 32 - 16, 10 * 32, 0));
		addForegroundObject(new Foliage(59 * 32 - 16, 10 * 32 - 8, 1));
		addForegroundObject(new Foliage(60 * 32 - 16, 10 * 32 - 16, 0));
		addForegroundObject(new Foliage(61 * 32 - 16, 10 * 32 - 22, 2));
		addForegroundObject(new Foliage(62 * 32 - 16, 10 * 32 - 28, 1));
		
		addForegroundObject(new Foliage(142 * 32 - 16, 16 * 32, 2));
		addForegroundObject(new Foliage(143 * 32 - 16, 16 * 32, 1));
		addForegroundObject(new Foliage(144 * 32 - 16, 16 * 32, 2));
		addForegroundObject(new Foliage(145 * 32 - 16, 16 * 32, 0));
		
		addForegroundObject(new Foliage(152 * 32 - 16, 16 * 32, 1));
		addForegroundObject(new Foliage(153 * 32 - 16, 16 * 32 - 8, 2));
		addForegroundObject(new Foliage(154 * 32 - 16, 16 * 32 - 16, 1));
		addForegroundObject(new Foliage(155 * 32 - 16, 16 * 32 - 28, 0));
		addForegroundObject(new Foliage(156 * 32 - 16, 16 * 32 - 34, 2));
		
		addForegroundObject(new Foliage(164 * 32 - 16, 15 * 32, 0));
		addForegroundObject(new Foliage(165 * 32 - 16, 15 * 32 - 8, 2));
		addForegroundObject(new Foliage(166 * 32 - 16, 15 * 32 - 16, 1));
		addForegroundObject(new Foliage(167 * 32 - 16, 15 * 32 - 22, 0));
		addForegroundObject(new Foliage(168 * 32 - 16, 15 * 32 - 28, 2));
		
		//Room Warp
		addRegion(new RoomWarp(247 * 32+ 16, 0, 32, 640, "ogre.BossRoom"));
	}
}