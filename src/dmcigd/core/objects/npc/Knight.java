package dmcigd.core.objects.npc;

import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.player.*;
import dmcigd.core.room.*;

public class Knight extends ObjectCollision implements Region {

	private DialogueHandler dialogueHandler;
	private String name,message;
	
	public Knight (int x, int y, boolean flipped, String name, String message, DialogueHandler dialogueHandler) {
		
		setX(x + 6);
		setY(y);
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
		
		this.dialogueHandler = dialogueHandler;
		this.name = name;
		this.message = message;
		this.flipped = flipped;
		
	}
	
	public void onHover(Player player) {}

	public void interact(Player player) {
		dialogueHandler.setDialogue(new String[][] {{name, message}});
	}
	
	public void step() {
		animate();
	}

}
