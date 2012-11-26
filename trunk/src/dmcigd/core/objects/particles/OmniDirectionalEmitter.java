/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dmcigd.core.objects.particles;

/**
 *
 * @author filip
 */
public class OmniDirectionalEmitter extends ParticleEmitter {
    
    public int maxSpeed = 2;
    public int lifeTime = 50;
    
    @Override
    public Particle spawnParticle() {
        float vx = (float)(generator.nextGaussian() * maxSpeed * 2 ); // all directions equally likely with gaussian x&y
        float vy = (float)(generator.nextGaussian() * maxSpeed * 2 ); 
        //Particle p = new StraightLineParticle(this.x, this.y, vx, vy, lifeTime, imagePath);
        Particle p = new GravityParticle(this.x, this.y, vx, vy, lifeTime, imagePath); // switch the two constructors for funses
        return p;
    }
    
}
