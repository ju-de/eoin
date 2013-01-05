package dmcigd.levels.icecave;

import java.net.URL;

import dmcigd.core.objects.regions.*;
import dmcigd.core.room.*;

public class IceRoomBoss extends Room implements Runnable{
	
	
	public IceRoomBoss(URL codeBase) {
		super(codeBase, "icecave", "IceRoomBoss", "icy");
	}
	public void initializeRoom(){
		
		addSolidObject(new Boss(13 * 32, 18 * 32, this));
		addImageResource("objects/icecave/bossshards.gif");
		
		//INI game objects
		IcicleProjectile icicle1 = new IcicleProjectile(76 * 32, 16 * 32, getBlockMap(), getSolidObjects());
		addSolidObject(icicle1);
		addRegion(new IcicleTrigger(73 * 32, 22 * 32, 1, 1, icicle1));
		
		IcicleProjectile icicle2 = new IcicleProjectile(82 * 32, 15 * 32, getBlockMap(), getSolidObjects());
		addSolidObject(icicle2);
		addRegion(new IcicleTrigger(79 * 32, 22 * 32, 1, 1, icicle2));
		
		IcicleProjectile icicle3 = new IcicleProjectile(90 * 32, 15 * 32, getBlockMap(), getSolidObjects());
		addSolidObject(icicle3);
		addRegion(new IcicleTrigger(87 * 32, 22 * 32, 1, 1, icicle3));
		
		IcicleProjectile icicle4 = new IcicleProjectile(97 * 32, 15 * 32, getBlockMap(), getSolidObjects());
		addSolidObject(icicle4);
		addRegion(new IcicleTrigger(94 * 32, 22 * 32, 1, 1, icicle4));
		
		IcicleProjectile icicle5 = new IcicleProjectile(113 * 32, 16 * 32, getBlockMap(), getSolidObjects());
		addSolidObject(icicle5);
		addRegion(new IcicleTrigger(113 * 32, 20 * 32, 1, 3, icicle5));
		
		IcicleProjectile icicle6 = new IcicleProjectile(152 * 32, 17 * 32, getBlockMap(), getSolidObjects());
		addSolidObject(icicle6);
		addRegion(new IcicleTrigger(150 * 32, 20 * 32, 1, 3, icicle6));
		
		IcicleProjectile icicle7 = new IcicleProjectile(279 * 32, 18 * 32, getBlockMap(), getSolidObjects());
		addSolidObject(icicle7);
		addRegion(new IcicleTrigger(279 * 32, 20 * 32, 1, 5, icicle7));
		
		IcicleProjectile icicle8 = new IcicleProjectile(290 * 32, 17 * 32, getBlockMap(), getSolidObjects());
		addSolidObject(icicle8);
		addRegion(new IcicleTrigger(290 * 32, 19 * 32, 1, 5, icicle8));
		
		addRegion(new RoomWarp(388 * 32, 11 * 32, 1 * 32, 1 * 32, "cave.SegueRoom"));
	}
}