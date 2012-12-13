/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dmcigd.core.objects.particles;

import dmcigd.core.objects.*;
import dmcigd.core.room.GameObjectHandler;
import java.util.Random;

/**
 * Emits Particles. 
 * @author filip
 */
public abstract class ParticleEmitter {
    
    private Entity lockedOn = null;
    protected float x,y;
    public int xOffset, yOffset;
    
    public static Random generator = new Random();
    
    public GameObjectHandler room;
    
    // The delay between successive particle emission attempts
    public int delay = 3;
    
    public float lastFire = 0;
    
    // between 0-1, the likelihood that it will emit a particle next attempt.
    public float emissionChance = 1;
    
    public String imagePath;
    
    public void step(){
        if (lockedOn != null){
            x = lockedOn.getX() + xOffset;
            y = lockedOn.getY() + yOffset;
        }
        if (lastFire <= 0 && generator.nextFloat() < emissionChance){
            room.addParticle(spawnParticle());
            lastFire = delay;
        }
        lastFire--;
    }
    
    /**
     * Attaches the emitter to the given entity.
     * @param e 
     */
    public void lockTo(Entity e){
        lockedOn = e;
    }
    public boolean isDestroyed(){
        if (lockedOn != null) return lockedOn.isDestroyed();
        return false;
    }
    
    public void setX(float x){
        this.x = x;
    }
    public void setY(float y){
        this.y = y;
    }
    public float getX(){ return x;}
    public float getY(){ return y;}
    
    
    /**
     * Spawns a new particle at the ParticleEmitter's location
     * @return 
     */
    public abstract Particle spawnParticle();
}
