package dmcigd.core.objects.npc;

import dmcigd.core.objects.interfaces.Region;
import dmcigd.core.room.DialogueHandler;

public class DeerAncestor extends SimpleNpc implements Region {
	
	public DeerAncestor (int x, int y, int type, boolean flipped, String message, DialogueHandler dialogueHandler) {
		
		super(x + 6, y-10, "DEER ANCESTOR", message, dialogueHandler);
		
		setWidth(32);
		setHeight(42);
		setImageWidth(50);
		setImageHeight(50);
		
		setSequence(type);
		setFrame(0);
		
		setFrameLimits(new int[] {2,2});
		setAnimationLoops(new boolean[] {true,true});
		setFrameSpeed(0.01f);
		
		setImagePath("deerancestor.gif");
		
		this.flipped = flipped;
		
	}
	
	public void step() {
		animate();
	}

}
