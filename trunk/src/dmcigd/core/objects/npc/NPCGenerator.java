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
        npc.setWidth(24);
        npc.setHeight(24);
        npc.setX(x);
        npc.setY(y);
        npc.flipped = imageFlipped;
        return npc;
    }
}
