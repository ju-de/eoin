/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dmcigd.core.objects.particles;

/**
 *
 * @author filip
 */
public class BrownianEmitter extends ParticleEmitter {

    public int stepSize;
    public int maxWalk;

    @Override
    public Particle spawnParticle() {
        BrownianParticle p = new BrownianParticle(x, y,stepSize, maxWalk, imagePath);
        return p;
    }
}
