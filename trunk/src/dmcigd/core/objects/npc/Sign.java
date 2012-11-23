package dmcigd.core.objects.npc;

import dmcigd.core.objects.interfaces.*;
import dmcigd.core.room.*;

/**
 * Replace the words "new Sign" word for word with NPCGenerator.makeSign", and 
 * then the code can be one class lighter...but slightly more complicated.
 * @author filip
 * @deprecated
 */
@Deprecated
public class Sign extends GenericNPC implements Region {
	
	public Sign (int x, int y, int orientation, String name, String message, DialogueHandler dialogueHandler) {
		
		super();
                setX(x);
                setY(y);
                setInteraction(message, name, dialogueHandler);
            
		
		setHeight(32);
		setWidth(32);
		setImageHeight(32);
		setImageWidth(32);
		
		setSequence(5);
		setFrame(orientation-1);
		
		setImagePath("objects.gif");
		
	}
}
