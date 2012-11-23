/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dmcigd.core.objects.npc;

import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.player.Player;
import dmcigd.core.room.*;


/**
 *
 * @author filip
 */
public class GenericNPC extends ObjectCollision implements Region {
    
    
	private DialogueHandler dialogueHandler;
	private String message;
        private String npcName;
	
        public GenericNPC(){}
        
        
	public GenericNPC (String message, String npcName, DialogueHandler dialogueHandler) {
		
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
		this.message = message;
		this.npcName= npcName;
	}
        
        
        
        
        public void setInteraction(String message, String name, DialogueHandler dialogueHandler){
            this.message = message;
            this.npcName = name;
            this.dialogueHandler = dialogueHandler;
        }
        
	
	public void onHover(Player player) {}

	public void interact(Player player) {
		dialogueHandler.setDialogue(new String[][] {{npcName, message}});
	}
	
	public void step() {
		animate();
	}

}
