package dmcigd.core.objects.npc;

import dmcigd.core.objects.interfaces.*;
import dmcigd.core.room.*;

public class Sign extends SimpleNpc implements Region {
	
	public Sign (int x, int y, int orientation, String name, String message, DialogueHandler dialogueHandler) {
		
		super(x, y, name, message, dialogueHandler);
		
		setHeight(32);
		setWidth(32);
		setImageHeight(32);
		setImageWidth(32);
		
		setSequence(5);
		setFrame(orientation-1);
		
		setImagePath("objects.gif");
		
	}
}
