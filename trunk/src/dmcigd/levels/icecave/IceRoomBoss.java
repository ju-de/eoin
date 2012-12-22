package dmcigd.levels.icecave;

import java.net.URL;

import dmcigd.core.objects.regions.*;
import dmcigd.core.room.*;

public class IceRoomBoss extends Room implements Runnable{
	
	
	public IceRoomBoss(URL codeBase) {
		super(codeBase, "icecave", "IceRoomBoss", "icy");
	}
	public void initializeRoom(){
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
		
		addRegion(new RoomWarp(388 * 32, 11 * 32, 1 * 32, 1 * 32, "game.MainMenu"));
	}
}