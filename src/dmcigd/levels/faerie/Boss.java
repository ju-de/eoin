package dmcigd.levels.faerie;

import java.net.URL;

import dmcigd.core.room.Room;


public class Boss extends Room implements Runnable {

	public Boss(URL codeBase) {
		super(codeBase, "faerie", "Boss", "foresty");
	}
        
	public void initializeRoom() {

	}
}
