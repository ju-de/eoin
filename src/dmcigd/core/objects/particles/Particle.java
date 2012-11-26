/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dmcigd.core.objects.particles;

import dmcigd.core.objects.*;
import java.util.Random;

/**
 *
 * @author filip
 */
public abstract class Particle  extends VisibleObject{
    
    protected boolean isDestroyed = false;
    protected static Random generator = new Random();
    
    
    public final void step(){
        move();
        updateLifeSpan();
    }
    
    /**
     * Moves the particle around.
     */
    public abstract void move();
    
    /**
     * sets isDestroyed based on something (be it lifespan, distance moved, etc).
     */
    public abstract void updateLifeSpan();
    
    public boolean isDestroyed(){
        return isDestroyed;
    }
    
    /**
     * Set all of those pesky animation properties.
     * @param imagePath
     * @param sequence
     * @param frame
     * @param frameSpeed
     * @param animationLoops
     * @param frameLimits 
     */
    public void setAnimationProperties(String imagePath, int sequence, int frame, float frameSpeed, boolean[] animationLoops, int[] frameLimits ){
        this.setImagePath(imagePath);
        this.setAnimationLoops(animationLoops);
        this.setSequence(sequence);
        this.setFrame(frame);
        this.setFrameLimits(frameLimits);
        this.setFrameSpeed(frameSpeed);
    }
    
    
    /**
     * Returns a particle lifespan with given 
     * @param average The average lifespan a particle should have.
     * @param stdev A measure of the 'width' of the probability curve used.
     * @return 
     */
    public static double gaussianLifeSpan(float average, float stdev){
        return generator.nextGaussian() * stdev * 3 + average - (stdev * 3 / 2);
    }
    
    
}
