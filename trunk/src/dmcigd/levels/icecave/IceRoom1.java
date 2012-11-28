package dmcigd.levels.icecave;

import java.net.URL;

import dmcigd.core.objects.*;
import dmcigd.core.objects.npc.Sign;
import dmcigd.core.objects.regions.*;
import dmcigd.core.room.*;

public class IceRoom1 extends Room implements Runnable{
	public IceRoom1(URL codeBase) {
		super(codeBase, "icecave", "IceRoom1", "icy");
	}
	public void initializeRoom(){
		addRegion(new Sign(66 * 32, 33 * 32, 6, "Placeholder:", "Door Goes Here.", getDialogueHandler()));
	}
}
