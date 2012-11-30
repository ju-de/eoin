package dmcigd.levels.rabbit;

import java.net.URL;

import dmcigd.core.room.Room;
import dmcigd.core.objects.npc.*;
import dmcigd.core.objects.regions.RoomWarp;
import dmcigd.levels.rabbit.mobs.*;

public class BossRoom extends Room implements Runnable {
	
	//Initializes SwitchBlock to be passed on to the appropriate switch
	SwitchBlock switchBlock1 = new SwitchBlock(116 * 32, 23 * 32, 3);
	SwitchBlock switchBlock2 = new SwitchBlock(121 * 32, 25 * 32, 3);
	
	public BossRoom(URL codeBase) {
		super(codeBase, "rabbit", "BossRoom", "grassy");
	}
        
	public void initializeRoom() {
        addImageResource("objects/rabbit/sparkle.gif");
        Boss boss = new Boss(24 * 32, 11 * 32 + 26, getPhysicsHandler(), getDialogueHandler());
        BossEmitter em = new BossEmitter();
        em.lockTo(boss);
        em.xOffset = 32;
        em.yOffset = 32;
        em.imagePath = "objects/rabbit/sparkle.gif";
        em.maxWalk = 400;
        em.stepSize = 2;
        em.delay = 4;
        em.emissionChance = 0.7f;
        
        addSolidObject(boss);
        addParticleEmitter(em);
		
		addRegion(new Knight(20 * 32, 13 * 32, false, "Don't worry about him! He's just as harmless as the rest of the rabbits. You can just jump right over him if you want.", getDialogueHandler()));
		
		addRegion(new RoomWarp(47 * 32+ 16, 0, 32, 640, "ogre.One"));

	}
}
