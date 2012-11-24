package dmcigd.core.objects.npc;

import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.player.*;
import dmcigd.core.room.*;

public class SimpleNpc extends ObjectCollision implements Region {

	private DialogueHandler dialogueHandler;
	private String name,message;
	
	public SimpleNpc (int x, int y, String name, String message, DialogueHandler dialogueHandler) {
		
		setX(x);
		setY(y);
		setImageHeight(32);
		setImageWidth(32);
		
		this.dialogueHandler = dialogueHandler;
		this.name = name;
		this.message = message;
		
	}
	
	public void onHover(Player player) {}

	public void interact(Player player) {
		dialogueHandler.setDialogue(new String[][] {{name, message}});
	}
	
	public void step() {}

}