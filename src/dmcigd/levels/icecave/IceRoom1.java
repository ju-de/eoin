package dmcigd.levels.icecave;

import java.net.URL;

import dmcigd.core.objects.regions.*;
import dmcigd.core.room.*;

public class IceRoom1 extends Room implements Runnable{
	public IceRoom1(URL codeBase) {
		super(codeBase, "icecave", "IceRoom1", "icy");
	}
	public void initializeRoom(){
		addRegion(new RoomPassage(66 * 32, 33 * 32, "icecave.IceRoom2"));
	}
}
