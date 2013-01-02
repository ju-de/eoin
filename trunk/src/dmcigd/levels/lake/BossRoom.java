package dmcigd.levels.lake;

import java.net.URL;

import dmcigd.core.room.*;
import dmcigd.core.objects.blocks.PushableBlock;
import dmcigd.core.objects.regions.*;
import dmcigd.levels.lake.mobs.*;
import dmcigd.levels.lake.mobs.boss.*;

public class BossRoom extends Room implements Runnable {
	
	public BossRoom(URL codeBase) {
		super(codeBase, "lake", "BossRoom", "rocky");
	}
	
	public void initializeRoom() {
		
		addSolidObject(new Squid(33 * 32, 11 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new Squid(36 * 32, 8 * 32, getPhysicsHandler(), getPlayer()));
		
		addSolidObject(new HorizontalUrchin(29 * 32, 14 * 32, 8, false, getPlayer()));
		
		addSolidObject(new HorizontalUrchin(34 * 32, 13 * 32, 2, true, getPlayer()));
		addSolidObject(new HorizontalUrchin(37 * 32, 10 * 32, 2, true, getPlayer()));
		
		addSolidObject(new PushableBlock(9 * 32, 8 * 32 + 16, getPhysicsHandler()));
		addSolidObject(new PushableBlock(10 * 32, 8 * 32 + 16, getPhysicsHandler()));
		
		BossBase bossBase = new BossBase(40 * 32, 6 * 32 - 8, this);
		addSolidObject(bossBase);
		addSolidObject(bossBase.bossJaw);
		
		addImageResource("objects/lake/bossprojectile.gif");
		addImageResource("objects/lake/bossprojectileparticle.gif");
		
		addRegion(new RoomWarp(46 * 32 + 16, 6 * 32, 32, 9 * 32, "faerie.One"));
	}
}
