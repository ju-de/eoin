package dmcigd.levels.rabbit;

import dmcigd.core.objects.interfaces.Region;
import dmcigd.core.objects.npc.DialogueNpc;
import dmcigd.core.room.DialogueHandler;

public class Wiggletons extends DialogueNpc implements Region {

	public Wiggletons(int x, int y, String[][] dialogue, DialogueHandler dialogueHandler) {
		super(x, y, dialogue, dialogueHandler);
		
		setWidth(68);
		setHeight(32);
		setImageWidth(68);
		setImageHeight(48);
		
		setSequence(0);
		setFrame(0);
		
		setFrameLimits(new int[] {10});
		setAnimationLoops(new boolean[] {true});
		setFrameSpeed(0.07f);
		
		setImagePath("objects/rabbit/wiggletons.gif");
	}
	
	public void step() {
		animate();
	}

}
