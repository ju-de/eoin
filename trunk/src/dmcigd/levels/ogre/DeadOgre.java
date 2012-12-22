package dmcigd.levels.ogre;

import dmcigd.core.objects.interfaces.Region;
import dmcigd.core.objects.npc.DialogueNpc;
import dmcigd.core.room.DialogueHandler;

public class DeadOgre extends DialogueNpc implements Region {

	public DeadOgre(int x, int y, String[][] dialogue, DialogueHandler dialogueHandler) {
		super(x, y, dialogue, dialogueHandler);
		
		setWidth(108);
		setHeight(64);
		setImageWidth(108);
		setImageHeight(66);
		
		setSequence(0);
		setFrame(0);
		
		setFrameLimits(new int[] {2});
		setAnimationLoops(new boolean[] {true});
		setFrameSpeed(0.02f);
		
		setImagePath("objects/ogre/deadogre.gif");
	}
	
	public void step() {
		animate();
	}

}
