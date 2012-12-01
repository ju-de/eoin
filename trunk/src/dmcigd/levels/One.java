package dmcigd.levels.deepforest;

import java.net.URL;

import dmcigd.core.room.Room;
import dmcigd.core.objects.TextLabel;
import dmcigd.core.objects.blocks.*;
import dmcigd.core.objects.items.*;
import dmcigd.core.objects.npc.*;
import dmcigd.core.objects.regions.*;
import dmcigd.levels.rabbit.mobs.*;

public class One extends Room implements Runnable {
	
	public One(URL codeBase) {
		super(codeBase, "deepforest", "One", "grassy");
	}
        
	public void initializeRoom() {

	}
}
