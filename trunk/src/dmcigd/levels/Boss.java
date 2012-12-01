package dmcigd.levels.deepforest;

import java.net.URL;

import dmcigd.core.room.Room;
import dmcigd.core.objects.npc.*;
import dmcigd.core.objects.regions.RoomWarp;
import dmcigd.levels.rabbit.mobs.*;

public class Boss extends Room implements Runnable {

	public Boss(URL codeBase) {
		super(codeBase, "deepforest", "Boss", "grassy");
	}
        
	public void initializeRoom() {

	}
}
