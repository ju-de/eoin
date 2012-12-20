package dmcigd.levels.faerie;

import java.net.URL;

import dmcigd.core.objects.blocks.*;
import dmcigd.core.objects.npc.Knight;
import dmcigd.core.objects.regions.RoomWarp;
import dmcigd.core.room.*;


public class One2 extends Room implements Runnable {
	
	public One2(URL codeBase) {
		super(codeBase, "faerie", "One2", "foresty");
	}
        
	public void initializeRoom() {
		
		addSolidObject(new CrumblingBlock(1 * 32, 20 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(2 * 32, 19 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(3 * 32, 19 * 32, 0.18f, 500));
		
		addSolidObject(new CrumblingBlock(7 * 32, 17 * 32, 0.18f, 1000000000));
		addSolidObject(new CrumblingBlock(7 * 32, 18 * 32, 0.18f, 1000000000));
		
		addSolidObject(new CrumblingBlock(13 * 32, 15 * 32, 0.25f, 1000000000));
		addSolidObject(new CrumblingBlock(14 * 32, 15 * 32, 0.25f, 1000000000));
		addSolidObject(new CrumblingBlock(15 * 32, 15 * 32, 0.25f, 1000000000));
		addSolidObject(new CrumblingBlock(16 * 32, 15 * 32, 0.25f, 1000000000));
		addSolidObject(new CrumblingBlock(17 * 32, 15 * 32, 0.25f, 1000000000));
		
		addSolidObject(new CrumblingBlock(19 * 32, 15 * 32, 0.3f, 1000000000));
		addSolidObject(new CrumblingBlock(20 * 32, 14 * 32, 0.3f, 1000000000));
		addSolidObject(new CrumblingBlock(21 * 32, 14 * 32, 0.3f, 1000000000));
		addSolidObject(new CrumblingBlock(22 * 32, 14 * 32, 0.3f, 1000000000));
		addSolidObject(new CrumblingBlock(23 * 32, 14 * 32, 0.3f, 1000000000));
		
		addSolidObject(new CrumblingBlock(25 * 32, 14 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(26 * 32, 14 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(27 * 32, 13 * 32, 0.35f, 1000000000));
		
		addSolidObject(new CrumblingBlock(30 * 32, 13 * 32, 0.4f, 1000000000));
		addSolidObject(new CrumblingBlock(31 * 32, 13 * 32, 0.4f, 1000000000));
		addSolidObject(new CrumblingBlock(32 * 32, 13 * 32, 0.4f, 1000000000));
		
		addSolidObject(new CrumblingBlock(34 * 32, 12 * 32, 0.45f, 1000000000));
		addSolidObject(new CrumblingBlock(35 * 32, 12 * 32, 0.45f, 1000000000));
		
		addSolidObject(new CrumblingBlock(38 * 32, 11 * 32, 0.5f, 1000000000));
		
		addSolidObject(new CrumblingBlock(45 * 32, 10 * 32, 0.6f, 1000000000));
		
		addSolidObject(new CrumblingBlock(55 * 32, 8 * 32, 0.25f, 1000000000));
		addSolidObject(new CrumblingBlock(56 * 32, 7 * 32, 0.25f, 1000000000));
		
		addSolidObject(new CrumblingBlock(60 * 32, 6 * 32, 0.25f, 1000000000));
		addSolidObject(new CrumblingBlock(61 * 32, 6 * 32, 0.25f, 1000000000));
		addSolidObject(new CrumblingBlock(62 * 32, 6 * 32, 0.25f, 1000000000));
		
		addSolidObject(new CrumblingBlock(64 * 32, 5 * 32, 0.25f, 1000000000));
		addSolidObject(new CrumblingBlock(65 * 32, 5 * 32, 0.25f, 1000000000));
		addSolidObject(new CrumblingBlock(66 * 32, 5 * 32, 0.25f, 1000000000));
		
		addSolidObject(new CrumblingBlock(15 * 32, 21 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(29 * 32, 29 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(30 * 32, 31 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(30 * 32, 32 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(38 * 32, 38 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(46 * 32, 40 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(47 * 32, 40 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(48 * 32, 41 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(56 * 32, 43 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(60 * 32, 45 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(61 * 32, 45 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(70 * 32, 46 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(77 * 32, 47 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(78 * 32, 47 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(79 * 32, 47 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(86 * 32, 46 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(86 * 32, 47 * 32, 0.35f, 1000000000));
		
		addSolidObject(new CrumblingBlock(96 * 32, 53 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(97 * 32, 53 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(98 * 32, 53 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(99 * 32, 53 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(100 * 32, 53 * 32, 0.35f, 350));
		
		addSolidObject(new CrumblingBlock(105 * 32, 55 * 32, 0.35f, 1000000000));
		
		addSolidObject(new CrumblingBlock(110 * 32, 54 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(111 * 32, 54 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(112 * 32, 54 * 32, 0.35f, 350));
		
		addSolidObject(new CrumblingBlock(125 * 32, 54 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(126 * 32, 54 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(127 * 32, 54 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(128 * 32, 54 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(129 * 32, 54 * 32, 0.35f, 350));
		
		addSolidObject(new CrumblingBlock(131 * 32, 54 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(132 * 32, 54 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(133 * 32, 54 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(134 * 32, 54 * 32, 0.35f, 350));
		
		addSolidObject(new CrumblingBlock(136 * 32, 54 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(137 * 32, 54 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(138 * 32, 54 * 32, 0.35f, 350));
		
		addRegion(new Knight(12 * 32, 14 * 32, true, "Watch out! The bridge is broken. We're doing our best to fix it.", getDialogueHandler()));
		
		addRegion(new RoomWarp(124 * 32 + 16, 45 * 32, 32, 320, "faerie.Two"));
		
	}
}
