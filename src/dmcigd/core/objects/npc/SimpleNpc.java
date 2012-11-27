package dmcigd.core.objects.npc;

import dmcigd.core.objects.interfaces.*;
import dmcigd.core.room.*;

public class SimpleNpc extends DialogueNpc implements Region {
	
	public SimpleNpc (int x, int y, String name, String message, DialogueHandler dialogueHandler) {
		
		super(x, y, new String[][]{{name,message}}, dialogueHandler);
		
	}

}