package dmcigd.core.objects.npc;

import dmcigd.core.*;
import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.player.*;

public class Sign extends ObjectCollision implements Region {

	private DialogueHandler dh;
	private String name,message;
	
	public Sign (int x, int y, int orientation, String name, String message, DialogueHandler dh) {
		
		setX(x);
		setY(y);
		setHeight(32);
		setWidth(32);
		setImageHeight(32);
		setImageWidth(32);
		
		setSequence(5);
		setFrame(orientation-1);
		
		setMapCode("`");
		setImagePath("objects.gif");
		
		this.dh = dh;
		this.name = name;
		this.message = message;
		
	}
	
	public void onHover(Player player) {}

	public void interact(Player player) {
		dh.setDialogue(new String[][] {{null, name, message}});
	}
	
	public void step() {}
}
