package dmcigd.core.objects.npc;

import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.player.*;
import dmcigd.core.room.*;

public class DialogueNpc extends ObjectCollision implements Region {

	private DialogueHandler dialogueHandler;
	private String[][] dialogue;
	
	public DialogueNpc (int x, int y, String[][] dialogue, DialogueHandler dialogueHandler) {
		
		setX(x);
		setY(y);
		setImageHeight(32);
		setImageWidth(32);
		
		this.dialogueHandler = dialogueHandler;
		this.dialogue = dialogue;
		
	}
	
	public void onHover(Player player) {}

	public void interact(Player player) {
		dialogueHandler.setDialogue(dialogue);
	}
	
	public void step() {}

}