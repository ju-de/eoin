package dmcigd.levels.lake;

import java.net.URL;

import dmcigd.core.room.*;
import dmcigd.core.objects.blocks.*;
import dmcigd.core.objects.items.*;
import dmcigd.core.objects.npc.*;
import dmcigd.core.objects.regions.*;

public class Bonus extends Room implements Runnable {
	
	public Bonus(URL codeBase) {
		super(codeBase, "lake", "Bonus", "fleshy");
	}
	
	public void initializeRoom() {
	}
}
