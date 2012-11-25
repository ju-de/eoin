package dmcigd.levels.rabbit.npc;

import dmcigd.core.objects.npc.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.room.*;

public class MrFritzlepuff extends SimpleNpc implements Region {
        
	public MrFritzlepuff (int x, int y, String message, DialogueHandler dialogueHandler) {
		
		super(x, y, "Mr. Fritzlepuff", message, dialogueHandler);
		
		setX(x);
		setY(y);
		setWidth(20);
		setHeight(30);
		setImageWidth(20);
		setImageHeight(32);
		
		setSequence(0);
		setFrame(0);
		
		setFrameLimits(new int[] {10});
		setAnimationLoops(new boolean[] {true});
		setFrameSpeed(0.03f);
		
		setImagePath("objects/rabbit/mrfritzlepuff.gif");
		
	}
	
	public void step() {
		animate();
	}

}
