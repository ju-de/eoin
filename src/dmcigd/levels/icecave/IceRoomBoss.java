package dmcigd.levels.icecave;

import java.net.URL;

import dmcigd.core.objects.regions.*;
import dmcigd.core.room.*;

public class IceRoomBoss extends Room implements Runnable{
	
	
	public IceRoomBoss(URL codeBase) {
		super(codeBase, "icecave", "IceRoomBoss", "icy");
	}
	public void initializeRoom(){
		
		
		//addRegion(new RoomWarp(388 * 32, 11 * 32, 1 * 32, 1 * 32, "nextlevel.NextLevel"));
	}
}