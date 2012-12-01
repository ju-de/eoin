package dmcigd.levels.deepforest;

import java.net.URL;

import dmcigd.core.room.Room;
import dmcigd.core.objects.blocks.*;
import dmcigd.core.objects.items.*;
import dmcigd.core.objects.npc.*;
import dmcigd.core.objects.regions.RoomWarp;
import dmcigd.levels.rabbit.mobs.*;

public class Three extends Room implements Runnable {
	
	public Three(URL codeBase) {
		super(codeBase, "deepforest", "Three", "grassy");
	}

	public void initializeRoom() {
		
	}
}
