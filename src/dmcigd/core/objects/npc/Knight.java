package dmcigd.core.objects.npc;

import dmcigd.core.objects.interfaces.*;
import dmcigd.core.room.*;

public class Knight extends SimpleNpc implements Region {
	
	public Knight (int x, int y, boolean flipped, String message, DialogueHandler dialogueHandler) {
		
		super(x + 6, y, "KNIGHT", message, dialogueHandler);
		
		setWidth(20);
		setHeight(32);
		setImageWidth(20);
		setImageHeight(34);
		
		setSequence(0);
		setFrame(0);
		
		setFrameLimits(new int[] {2});
		setAnimationLoops(new boolean[] {true});
		setFrameSpeed(0.02f);
		
		setImagePath("knight.gif");
		
		this.flipped = flipped;
		
	}
	
	public void step() {
		animate();
	}

}