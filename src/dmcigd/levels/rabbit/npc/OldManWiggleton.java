package dmcigd.levels.rabbit.npc;

import dmcigd.core.objects.npc.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.room.*;

public class OldManWiggleton extends SimpleNpc implements Region {
        
	public OldManWiggleton (int x, int y, String message, DialogueHandler dialogueHandler) {
		
		super(x, y, "Old Man Wiggleton", message, dialogueHandler);
		
		setX(x);
		setY(y);
		setWidth(24);
		setHeight(32);
		setImageWidth(24);
		setImageHeight(34);
		
		setSequence(0);
		setFrame(0);
		
		setFrameLimits(new int[] {8});
		setAnimationLoops(new boolean[] {true});
		setFrameSpeed(0.03f);
		
		setImagePath("objects/rabbit/oldmanwiggleton.gif");
		
	}
	
	public void step() {
		animate();
	}

}
