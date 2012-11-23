package dmcigd.levels.rabbit.npc;

import dmcigd.core.objects.npc.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.room.*;

public class MrScrufflebottom extends SimpleNpc implements Region {
	
	public MrScrufflebottom (int x, int y, String message, DialogueHandler dialogueHandler) {
		
		super(x, y, "Mr. Scrufflebottom", message, dialogueHandler);
		
		setX(x);
		setY(y);
		setWidth(48);
		setHeight(46);
		setImageWidth(48);
		setImageHeight(48);
		
		setSequence(0);
		setFrame(0);
		
		setFrameLimits(new int[] {2});
		setAnimationLoops(new boolean[] {true});
		setFrameSpeed(0.01f);
		
		setImagePath("objects/rabbit/mrscrufflebottom.gif");
		
	}
	
	public void step() {
		animate();
	}

}
