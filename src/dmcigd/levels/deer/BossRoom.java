package dmcigd.levels.deer;

import java.net.URL;

import dmcigd.core.objects.npc.Knight;
import dmcigd.core.objects.npc.Sign;
import dmcigd.core.room.*;

public class BossRoom extends Room implements Runnable{
	
	public HerbEmitter em;
	
	public BossRoom(URL codebase) {
		super(codebase, "deer", "BossRoom", "grassy");
	}
	
	public void initializeRoom() {
		
		addRegion(new Knight(43 * 32, 28 * 32, true, "This kidnapper is a true villain! Bah, taking our precious princess into such foul darkness like those caves...", getDialogueHandler()));
		
		//Medicine Quest
        addImageResource("objects/deer/medicine.gif");
		addRegion(new WitchDoctor(58 * 32, 25 * 32, this));
		addRegion(new Sign(62 * 32, 30 * 32, 6, "SIGN", "The Sacred Grove. Herbs for shamans' usage only.", getDialogueHandler()));

		
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
        
        //Boss
		addRegion(new Knight(116 * 32, 20 * 32, false, "Kill it! Kill it quickly! We must press forward, for the princess needs us!", getDialogueHandler()));

	}
	
}
