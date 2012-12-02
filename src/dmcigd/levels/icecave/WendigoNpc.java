package dmcigd.levels.icecave;

import dmcigd.core.objects.interfaces.Region;
import dmcigd.core.objects.npc.SimpleNpc;
import dmcigd.core.room.DialogueHandler;

public class WendigoNpc extends SimpleNpc implements Region {
    
	public WendigoNpc (int x, int y, String name, String message, DialogueHandler dialogueHandler) {
		
		super(x, y, name, message, dialogueHandler);
		
		setWidth(24);
		setHeight(32);
		setImageWidth(24);
		setImageHeight(34);
		
		setSequence(0);
		setFrame(0);
		
		setFrameLimits(new int[] {2});
		setAnimationLoops(new boolean[] {true});
		setFrameSpeed(0.02f);
		
		setImagePath("objects/icecave/wendigo.gif");
		
		flipped = true;
		
	}
	
	public void step() {
		animate();
	}
}
