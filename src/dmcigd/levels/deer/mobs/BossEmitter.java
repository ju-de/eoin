package dmcigd.levels.deer.mobs;

import dmcigd.core.objects.particles.BrownianEmitter;
import dmcigd.core.objects.particles.BrownianParticle;
import dmcigd.core.objects.particles.Particle;
import dmcigd.levels.deer.SickParticle;
import dmcigd.levels.deer.HerbParticle;

public class BossEmitter extends BrownianEmitter {
	
	public boolean sickStatus = true;

    public Particle spawnParticle() {
    	BrownianParticle p;
    	if(sickStatus) {
           p = new SickParticle(x, y,stepSize, maxWalk, imagePath);
    	} else {
           p = new HerbParticle(x, y,stepSize, maxWalk, imagePath);
    	}
        return p;
    }
}
