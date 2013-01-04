package dmcigd.levels.cave;

import java.net.URL;

import dmcigd.core.objects.regions.RoomWarp;
import dmcigd.core.room.*;

public class SegueRoom extends Room {

	public SegueRoom(URL codeBase) {
		super(codeBase, "cave", "SegueRoom", "rocky");
	}

	public void initializeRoom(){

		addRegion(new RoomWarp (25*32 + 16, 21 * 32 + 16, 384, 32, "lake.One"));
	}
}
