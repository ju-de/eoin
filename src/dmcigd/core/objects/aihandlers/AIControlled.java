/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dmcigd.core.objects.aihandlers;

/**
 * This interface is just a list of actions that all controlled entities 
 * (for example, the player, controlled by the keyboard, or an enemy, controlled 
 * by its own AI) can be told to do.
 * @author filip
 */
public interface AIControlled {
    
    public abstract void moveLeft();
    
    public abstract void moveRight();
    
    public abstract void jump();
    
    public abstract void climbUpLadder();
    
    public abstract void climbDownLadder();
    
    public abstract void attackLeft();
    
    public abstract void attackRight();
    
    public abstract void dropDownLedge();
    
    
}
