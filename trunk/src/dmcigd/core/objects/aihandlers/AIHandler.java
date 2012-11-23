/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dmcigd.core.objects.aihandlers;

/**
 * This class serves as the gateway between the main game code and AI.
 * Every object that wants AI decisions made will contain one of these, 
 * it's own connection to the AI thread.
 * 
 * 
 * @author filip
 */
public class AIHandler {
    
    /**
     * The entity which requires AI, asking for results through this AIHandler
     */
    private AIControlled controlled_entity; 
    
    
    
    
}
