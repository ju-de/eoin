package dmcigd.levels.rabbit.npc;

import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.player.*;
import dmcigd.core.room.*;

public class MrScrufflebottom extends ObjectCollision implements Region {

	private DialogueHandler dialogueHandler;
	private String message;
	
	public MrScrufflebottom (int x, int y, String message, DialogueHandler dialogueHandler) {
		
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
		
		this.dialogueHandler = dialogueHandler;
		this.message = message;
		
	}
	
	public void onHover(Player player) {}

	public void interact(Player player) {
		dialogueHandler.setDialogue(new String[][] {{"Mr. ScruffleBottom", message}});
	}
	
	public void step() {
		animate();
	}

}
