package dmcigd.levels.deepforest;

import java.net.URL;

import dmcigd.core.room.Room;
import dmcigd.core.objects.*;
import dmcigd.core.objects.blocks.*;
import dmcigd.core.objects.platforms.*;
import dmcigd.core.objects.regions.RoomWarp;
import dmcigd.core.objects.items.*;
import dmcigd.core.objects.npc.*;
import dmcigd.levels.rabbit.mobs.*;

public class Two extends Room implements Runnable {
	
	public Two(URL codeBase) {
		super(codeBase, "deepforest", "Two", "grassy");
	}

	public void initializeRoom() {
		
	}
}
