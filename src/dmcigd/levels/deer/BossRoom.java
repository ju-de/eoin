package dmcigd.levels.deer;

import java.net.URL;

import dmcigd.core.room.*;

public class BossRoom extends Room implements Runnable{
	
	public HerbEmitter em;
	
	public BossRoom(URL codebase) {
		super(codebase, "deer", "BossRoom", "grassy");
	}
	
	public void initializeRoom() {
        addImageResource("objects/deer/medicine.gif");
		addRegion(new WitchDoctor(58 * 32, 25 * 32, this));
		
        addImageResource("objects/deer/herbparticles.gif");
        Herb herb = new Herb(58 * 32, 28 * 32, getPhysicsHandler());
        em = new HerbEmitter();
        em.lockTo(herb);
        em.xOffset = 10;
        em.yOffset = 7;
        em.imagePath = "objects/deer/herbparticles.gif";
        em.maxWalk = 70;
        em.stepSize = 1;
        em.delay = 4;
        em.emissionChance = 0.4f;
        
        addItem(herb);
        addParticleEmitter(em);
	}
	
}
