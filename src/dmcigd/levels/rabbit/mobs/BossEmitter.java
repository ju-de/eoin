package dmcigd.levels.rabbit.mobs;

import dmcigd.core.objects.particles.*;

public class BossEmitter extends BrownianEmitter {

    public Particle spawnParticle() {
        BrownianParticle p = new BossParticle(x, y,stepSize, maxWalk, imagePath);
        return p;
    }
    
}
