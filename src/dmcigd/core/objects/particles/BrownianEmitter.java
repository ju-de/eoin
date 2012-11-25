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
    public String imagePath;

    @Override
    public Particle spawnParticle() {
        return new BrownianParticle(x, y,stepSize, maxWalk, imagePath);
    }
}
