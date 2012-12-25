package dmcigd.levels.swamp;

import dmcigd.core.room.*;
import dmcigd.core.objects.*;
import dmcigd.core.objects.npc.Sign;
import dmcigd.levels.swamp.Switch;
import dmcigd.levels.swamp.SwitchBlock;

import java.net.URL;

public class Two extends Room {

	public Two(URL codeBase) {
		super(codeBase, "swamp", "Two", "foresty");
	}

	public void initializeRoom(){
		
		addRegion(new Sign(494 * 32, 41 * 32, 5, "SIGN", "There's a switch behind you.", getDialogueHandler()));
		
		SwitchBlock switchBlock1 = new SwitchBlock(453 * 32, 37 * 32, 3);
		
		addSolidObject(switchBlock1);
		addRegion(new Switch(510 * 32 - 4, 43 * 32 + 16, true, switchBlock1));
		
	}
}
