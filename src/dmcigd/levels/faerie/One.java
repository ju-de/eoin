package dmcigd.levels.faerie;

import java.net.URL;

import dmcigd.core.objects.blocks.*;
import dmcigd.core.objects.npc.Knight;
import dmcigd.core.objects.regions.RoomWarp;
import dmcigd.core.room.*;


public class One extends Room implements Runnable {
	
	public One(URL codeBase) {
		super(codeBase, "faerie", "One", "foresty");
	}
        
	public void initializeRoom() {
		
		
		addSolidObject(new CrumblingBlock(63 * 32, 9 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(66 * 32, 8 * 32, 0.25f, 1000000000));
		addSolidObject(new CrumblingBlock(70 * 32, 7 * 32, 0.1f, 250));
		addSolidObject(new CrumblingBlock(73 * 32, 7 * 32, 0.5f, 100));
		addSolidObject(new CrumblingBlock(79 * 32, 9 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(82 * 32, 8 * 32, 0.25f, 1000000000));
		
		addSolidObject(new CrumblingBlock(98 * 32, 9 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(99 * 32, 9 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(100 * 32, 9 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(101 * 32, 9 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(102 * 32, 9 * 32, 0.25f, 350));
		
		addSolidObject(new CrumblingBlock(117 * 32, 10 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(117 * 32, 11 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(117 * 32, 12 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(122 * 32, 12 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(122 * 32, 13 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(127 * 32, 12 * 32, 0.25f, 350));
		
		addSolidObject(new CrumblingBlock(145 * 32, 9 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(148 * 32, 10 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(150 * 32, 12 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(153 * 32, 14 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(160 * 32, 15 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(161 * 32, 15 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(162 * 32, 16 * 32, 0.25f, 350));
		
		addSolidObject(new CrumblingBlock(173 * 32, 18 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(174 * 32, 18 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(180 * 32, 18 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(181 * 32, 18 * 32, 0.25f, 350));
		
		addSolidObject(new CrumblingBlock(184 * 32, 17 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(185 * 32, 17 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(185 * 32, 16 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(185 * 32, 15 * 32, 0.18f, 500));

		addSolidObject(new CrumblingBlock(188 * 32, 16 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(189 * 32, 16 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(190 * 32, 16 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(189 * 32, 15 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(190 * 32, 15 * 32, 0.18f, 500));	
		addSolidObject(new CrumblingBlock(190 * 32, 14 * 32, 0.18f, 500));	
		addSolidObject(new CrumblingBlock(188 * 32, 13 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(189 * 32, 13 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(190 * 32, 13 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(191 * 32, 13 * 32, 0.18f, 500));
		
		addSolidObject(new CrumblingBlock(193 * 32, 16 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(194 * 32, 16 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(194 * 32, 17 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(195 * 32, 17 * 32, 0.18f, 500));
		
		addSolidObject(new CrumblingBlock(201 * 32, 17 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(201 * 32, 18 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(200 * 32, 18 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(201 * 32, 19 * 32, 0.18f, 500));
		
		addSolidObject(new CrumblingBlock(204 * 32, 20 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(205 * 32, 20 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(205 * 32, 19 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(206 * 32, 20 * 32, 0.18f, 500));
		
		addSolidObject(new CrumblingBlock(211 * 32, 20 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(212 * 32, 29 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(213 * 32, 19 * 32, 0.18f, 500));
		
		addSolidObject(new CrumblingBlock(217 * 32, 17 * 32, 0.18f, 1000000000));
		addSolidObject(new CrumblingBlock(217 * 32, 18 * 32, 0.18f, 1000000000));
		
		addSolidObject(new CrumblingBlock(223 * 32, 15 * 32, 0.25f, 1000000000));
		addSolidObject(new CrumblingBlock(224 * 32, 15 * 32, 0.25f, 1000000000));
		addSolidObject(new CrumblingBlock(225 * 32, 15 * 32, 0.25f, 1000000000));
		addSolidObject(new CrumblingBlock(226 * 32, 15 * 32, 0.25f, 1000000000));
		addSolidObject(new CrumblingBlock(227 * 32, 15 * 32, 0.25f, 1000000000));
		
		addSolidObject(new CrumblingBlock(229 * 32, 15 * 32, 0.3f, 1000000000));
		addSolidObject(new CrumblingBlock(230 * 32, 14 * 32, 0.3f, 1000000000));
		addSolidObject(new CrumblingBlock(231 * 32, 14 * 32, 0.3f, 1000000000));
		addSolidObject(new CrumblingBlock(232 * 32, 14 * 32, 0.3f, 1000000000));
		addSolidObject(new CrumblingBlock(233 * 32, 14 * 32, 0.3f, 1000000000));
		
		addSolidObject(new CrumblingBlock(235 * 32, 14 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(236 * 32, 14 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(237 * 32, 13 * 32, 0.35f, 1000000000));
		
		addSolidObject(new CrumblingBlock(225 * 32, 21 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(239 * 32, 29 * 32, 0.35f, 350));
		
		addRegion(new Knight(50 * 32, 7 * 32, true, "FNORD", getDialogueHandler()));
		addRegion(new Knight(79 * 32, 11 * 32, false, "I'm free! Let's get out before I get stuck again.", getDialogueHandler()));
		addRegion(new Knight(183 * 32, 17 * 32, true, "FNORD", getDialogueHandler()));
		addRegion(new Knight(222 * 32, 14 * 32, true, "Watch out! The bridge is broken. We're doing our best to fix it.", getDialogueHandler()));
				
		addRegion(new RoomWarp(221 * 32 + 16, 0, 32, 54 * 32, "faerie.One2"));
		
	}
}
