/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dmcigd.core.objects.particles;

import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.enums.*;
import dmcigd.core.room.Room;
import java.util.Random;

/**
 * Emits Particles. 
 * @author filip
 */
public abstract class ParticleEmitter {
    
    private Entity lockedOn = null;
    protected int x,y;
    
    public static Random generator = new Random();
    
    public Room room;
    
    // The delay between successive particle emission attempts
    private int delay = 3;
    
    private float lastFire = 0;
    
    // between 0-1, the likelihood that it will emit a particle next attempt.
    private float emissionChance = 1;
    
    
    public void step(){
        if (lockedOn != null){
            x = lockedOn.getX();
            y = lockedOn.getY();
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
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    
    /**
     * Spawns a new particle at the ParticleEmitter's location
     * @return 
     */
    public abstract Particle spawnParticle();
}
