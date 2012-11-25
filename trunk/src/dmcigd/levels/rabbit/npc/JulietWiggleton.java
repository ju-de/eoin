package dmcigd.levels.rabbit.npc;

import dmcigd.core.objects.npc.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.room.*;

public class JulietWiggleton extends SimpleNpc implements Region {
        
	public JulietWiggleton (int x, int y, String message, DialogueHandler dialogueHandler) {
		
		super(x, y, "Juliet Wiggleton", message, dialogueHandler);
		
		setX(x);
		setY(y+6);
		setWidth(16);
		setHeight(26);
		setImageWidth(16);
		setImageHeight(28);
		
		setSequence(0);
		setFrame(0);
		
		setFrameLimits(new int[] {10});
		setAnimationLoops(new boolean[] {true});
		setFrameSpeed(0.03f);
		
		setImagePath("objects/rabbit/julietwiggleton.gif");
		
	}
	
	public void step() {
		animate();
	}

}
