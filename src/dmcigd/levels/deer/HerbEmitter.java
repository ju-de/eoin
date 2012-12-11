package dmcigd.levels.deer;

import dmcigd.core.objects.particles.*;

public class HerbEmitter extends BrownianEmitter {

    public Particle spawnParticle() {
        BrownianParticle p = new HerbParticle(x, y,stepSize, maxWalk, imagePath);
        return p;
    }
    
}
