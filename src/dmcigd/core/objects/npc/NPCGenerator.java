/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dmcigd.core.objects.npc;

import dmcigd.core.room.DialogueHandler;
import java.util.HashMap;

/**
 * The NPCGenerator, along with teh GenericNPC, will serve as replacement for 
 * many clone classes of similar but not exactly unique NPCs.
 * @author filip
 */
public class NPCGenerator {

    /**
     * This hashmap contains templates for all NPCs the generator can generate
     *  -- currently unused
     */
    public static HashMap<String, GenericNPC> npcTypes = new HashMap<String, GenericNPC>();

    public static GenericNPC makeKnight(int x, int y, boolean flipped, String message, DialogueHandler dialogueHandler) {

        GenericNPC knight = new GenericNPC();

        knight.setX(x + 6);
        knight.setY(y);
        knight.setWidth(20);
        knight.setHeight(32);
        knight.setImageWidth(20);
        knight.setImageHeight(34);

        knight.setSequence(0);
        knight.setFrame(0);

        knight.setFrameLimits(new int[]{2});
        knight.setAnimationLoops(new boolean[]{true});
        knight.setFrameSpeed(0.02f);

        knight.setImagePath("knight.gif");

        knight.setInteraction(message, "KNIGHT", dialogueHandler);

        return knight;
    }

    public static GenericNPC makeSign(int x, int y, int orientation, String name, String message, DialogueHandler dialogueHandler) {
        GenericNPC sign = new GenericNPC();

        sign.setX(x);
        sign.setY(y);
        sign.setHeight(32);
        sign.setWidth(32);
        sign.setImageHeight(32);
        sign.setImageWidth(32);

        sign.setSequence(5);
        sign.setFrame(orientation - 1);

        sign.setImagePath("objects.gif");
        sign.setInteraction(message, name, dialogueHandler);

        return sign;
    }
    
    public static GenericNPC make32x32(int x, int y, String imagePath, String name, String message, boolean imageFlipped, DialogueHandler dialogueHandler){
        GenericNPC npc = new GenericNPC();
        npc.setInteraction(message, name, dialogueHandler);
        npc.setImagePath(imagePath);
        npc.setImageHeight(32);
        npc.setImageWidth(32);
        npc.setWidth(26);
        npc.setHeight(26);
        npc.setX(x);
        npc.setY(y);
        npc.flipped = imageFlipped;
        return npc;
    }
    
    public static GenericNPC make48x48(int x, int y, String imagePath, String name, String message, boolean imageFlipped, DialogueHandler dialogueHandler){
        GenericNPC npc = new GenericNPC();
        npc.setInteraction(message, name, dialogueHandler);
        npc.setImagePath(imagePath);
        npc.setImageHeight(48);
        npc.setImageWidth(48);
        npc.setWidth(44);
        npc.setHeight(44);
        npc.setX(x);
        npc.setY(y);
        npc.flipped = imageFlipped;
        return npc;
    }
    
    public static GenericNPC make64x64(int x, int y, String imagePath, String name, String message, boolean imageFlipped, DialogueHandler dialogueHandler){
        GenericNPC npc = new GenericNPC();
        npc.setInteraction(message, name, dialogueHandler);
        npc.setImagePath(imagePath);
        npc.setImageHeight(64);
        npc.setImageWidth(64);
        npc.setWidth(52);
        npc.setHeight(52);
        npc.setSequence(0);
        npc.setFrame(0);
        npc.setX(x);
        npc.setY(y);
        npc.flipped = imageFlipped;
        return npc;
    }
    
    /**
     * Given an NPC, modifies it's 'extra' animation parameters (that is, not 
     * the image location, since that is always passed in to the factory method)
     * @param npc The GenericNPC to modify
     * @param sequence The sequence number of the npc's animation/sprite
     * @param frame The frame number of the npc's sprite within a particular sequence.
     * @param framelimits The something something dark side who nose?
     * @param animationLoops Does the animation loop?
     * @param frameSpeed How fast one frame leads on to the next (appears to be a delay length).
     * @return 
     */
    public static GenericNPC modifyAnimation(GenericNPC npc, int sequence, int frame, int[] framelimits, boolean[] animationLoops, float frameSpeed){
        npc.setSequence(sequence);
        npc.setFrame(frame);
        npc.setFrameLimits(framelimits);
        npc.setAnimationLoops(animationLoops);
        npc.setFrameSpeed(frameSpeed);
        return npc;
    }
}
