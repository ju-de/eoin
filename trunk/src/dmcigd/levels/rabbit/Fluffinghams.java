package dmcigd.levels.rabbit;

import dmcigd.core.objects.interfaces.Region;
import dmcigd.core.objects.npc.DialogueNpc;
import dmcigd.core.room.DialogueHandler;

public class Fluffinghams extends DialogueNpc implements Region {

	public Fluffinghams(int x, int y, String[][] dialogue, DialogueHandler dialogueHandler) {
		super(x, y, dialogue, dialogueHandler);
		
		setWidth(56);
		setHeight(34);
		setImageWidth(56);
		setImageHeight(36);
		
		setSequence(0);
		setFrame(0);
		
		setFrameLimits(new int[] {2});
		setAnimationLoops(new boolean[] {true});
		setFrameSpeed(0.02f);
		
		setImagePath("objects/rabbit/fluffinghams.gif");
	}
	
	public void step() {
		animate();
	}

}
