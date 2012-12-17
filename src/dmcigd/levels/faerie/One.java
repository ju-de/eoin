package dmcigd.levels.faerie;

import java.net.URL;

import dmcigd.core.objects.blocks.*;
import dmcigd.core.objects.items.DoorKey;
import dmcigd.core.objects.npc.Knight;
import dmcigd.core.objects.npc.Sign;
import dmcigd.core.objects.regions.RoomWarp;
import dmcigd.core.room.*;


public class One extends Room implements Runnable {
	
	public One(URL codeBase) {
		super(codeBase, "faerie", "One", "foresty");
	}
        
	public void initializeRoom() {
		
		
		addSolidObject(new CrumblingBlock(63 * 32, 49 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(66 * 32, 48 * 32, 0.25f, 1000000000));
		addSolidObject(new CrumblingBlock(70 * 32, 47 * 32, 0.1f, 250));
		addSolidObject(new CrumblingBlock(73 * 32, 47 * 32, 0.5f, 100));
		addSolidObject(new CrumblingBlock(79 * 32, 49 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(82 * 32, 48 * 32, 0.25f, 1000000000));
		
		addSolidObject(new CrumblingBlock(98 * 32, 49 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(99 * 32, 49 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(100 * 32, 49 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(101 * 32, 49 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(102 * 32, 49 * 32, 0.25f, 350));
		
		addSolidObject(new CrumblingBlock(117 * 32, 50 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(117 * 32, 51 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(117 * 32, 52 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(122 * 32, 52 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(122 * 32, 53 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(127 * 32, 52 * 32, 0.25f, 350));
		
		addSolidObject(new CrumblingBlock(145 * 32, 49 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(148 * 32, 50 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(150 * 32, 52 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(153 * 32, 54 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(160 * 32, 55 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(161 * 32, 55 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(162 * 32, 56 * 32, 0.25f, 350));
		
		addSolidObject(new CrumblingBlock(173 * 32, 58 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(174 * 32, 58 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(180 * 32, 58 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(181 * 32, 58 * 32, 0.25f, 350));
		
		addSolidObject(new CrumblingBlock(184 * 32, 57 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(185 * 32, 57 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(185 * 32, 56 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(185 * 32, 55 * 32, 0.18f, 500));

		addSolidObject(new CrumblingBlock(188 * 32, 56 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(189 * 32, 56 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(190 * 32, 56 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(189 * 32, 55 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(190 * 32, 55 * 32, 0.18f, 500));	
		addSolidObject(new CrumblingBlock(190 * 32, 54 * 32, 0.18f, 500));	
		addSolidObject(new CrumblingBlock(188 * 32, 53 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(189 * 32, 53 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(190 * 32, 53 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(191 * 32, 53 * 32, 0.18f, 500));
		
		addSolidObject(new CrumblingBlock(193 * 32, 56 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(194 * 32, 56 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(194 * 32, 57 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(195 * 32, 57 * 32, 0.18f, 500));
		
		addSolidObject(new CrumblingBlock(201 * 32, 57 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(201 * 32, 58 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(200 * 32, 58 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(201 * 32, 59 * 32, 0.18f, 500));
		
		addSolidObject(new CrumblingBlock(204 * 32, 60 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(205 * 32, 60 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(205 * 32, 59 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(206 * 32, 60 * 32, 0.18f, 500));
		
		addSolidObject(new CrumblingBlock(211 * 32, 60 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(212 * 32, 59 * 32, 0.18f, 500));
		addSolidObject(new CrumblingBlock(213 * 32, 59 * 32, 0.18f, 500));
		
		addSolidObject(new CrumblingBlock(217 * 32, 57 * 32, 0.18f, 1000000000));
		addSolidObject(new CrumblingBlock(217 * 32, 58 * 32, 0.18f, 1000000000));
		
		addSolidObject(new CrumblingBlock(223 * 32, 55 * 32, 0.25f, 1000000000));
		addSolidObject(new CrumblingBlock(224 * 32, 55 * 32, 0.25f, 1000000000));
		addSolidObject(new CrumblingBlock(225 * 32, 55 * 32, 0.25f, 1000000000));
		addSolidObject(new CrumblingBlock(226 * 32, 55 * 32, 0.25f, 1000000000));
		addSolidObject(new CrumblingBlock(227 * 32, 55 * 32, 0.25f, 1000000000));
		
		addSolidObject(new CrumblingBlock(229 * 32, 55 * 32, 0.3f, 1000000000));
		addSolidObject(new CrumblingBlock(230 * 32, 54 * 32, 0.3f, 1000000000));
		addSolidObject(new CrumblingBlock(231 * 32, 54 * 32, 0.3f, 1000000000));
		addSolidObject(new CrumblingBlock(232 * 32, 54 * 32, 0.3f, 1000000000));
		addSolidObject(new CrumblingBlock(233 * 32, 54 * 32, 0.3f, 1000000000));
		
		addSolidObject(new CrumblingBlock(235 * 32, 54 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(236 * 32, 54 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(237 * 32, 53 * 32, 0.35f, 1000000000));
		
		addSolidObject(new CrumblingBlock(240 * 32, 53 * 32, 0.4f, 1000000000));
		addSolidObject(new CrumblingBlock(241 * 32, 53 * 32, 0.4f, 1000000000));
		addSolidObject(new CrumblingBlock(242 * 32, 53 * 32, 0.4f, 1000000000));
		
		addSolidObject(new CrumblingBlock(244 * 32, 52 * 32, 0.45f, 1000000000));
		addSolidObject(new CrumblingBlock(245 * 32, 52 * 32, 0.45f, 1000000000));
		
		addSolidObject(new CrumblingBlock(248 * 32, 51 * 32, 0.5f, 1000000000));
		
		addSolidObject(new CrumblingBlock(255 * 32, 50 * 32, 0.6f, 1000000000));
		
		addSolidObject(new CrumblingBlock(265 * 32, 48 * 32, 0.25f, 1000000000));
		addSolidObject(new CrumblingBlock(266 * 32, 47 * 32, 0.25f, 1000000000));
		
		addSolidObject(new CrumblingBlock(270 * 32, 46 * 32, 0.25f, 1000000000));
		addSolidObject(new CrumblingBlock(271 * 32, 46 * 32, 0.25f, 1000000000));
		addSolidObject(new CrumblingBlock(272 * 32, 46 * 32, 0.25f, 1000000000));
		
		addSolidObject(new CrumblingBlock(274 * 32, 45 * 32, 0.25f, 1000000000));
		addSolidObject(new CrumblingBlock(275 * 32, 45 * 32, 0.25f, 1000000000));
		addSolidObject(new CrumblingBlock(276 * 32, 45 * 32, 0.25f, 1000000000));
		
		addSolidObject(new CrumblingBlock(225 * 32, 61 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(239 * 32, 69 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(240 * 32, 71 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(240 * 32, 72 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(248 * 32, 78 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(256 * 32, 80 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(257 * 32, 80 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(258 * 32, 81 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(266 * 32, 83 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(270 * 32, 85 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(271 * 32, 85 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(280 * 32, 86 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(287 * 32, 87 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(288 * 32, 87 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(289 * 32, 87 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(296 * 32, 86 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(296 * 32, 87 * 32, 0.35f, 1000000000));
		
		addSolidObject(new CrumblingBlock(306 * 32, 93 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(307 * 32, 93 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(308 * 32, 93 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(309 * 32, 93 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(310 * 32, 93 * 32, 0.35f, 350));
		
		addSolidObject(new CrumblingBlock(315 * 32, 95 * 32, 0.35f, 1000000000));
		
		addSolidObject(new CrumblingBlock(320 * 32, 94 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(321 * 32, 94 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(322 * 32, 94 * 32, 0.35f, 350));
		
		addSolidObject(new CrumblingBlock(335 * 32, 94 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(336 * 32, 94 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(337 * 32, 94 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(338 * 32, 94 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(339 * 32, 94 * 32, 0.35f, 350));
		
		addSolidObject(new CrumblingBlock(341 * 32, 94 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(342 * 32, 94 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(343 * 32, 94 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(344 * 32, 94 * 32, 0.35f, 350));
		
		addSolidObject(new CrumblingBlock(346 * 32, 94 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(347 * 32, 94 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(348 * 32, 94 * 32, 0.35f, 350));
		
		addSolidObject(new CrumblingBlock(350 * 32, 94 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(351 * 32, 94 * 32, 0.35f, 350));
		
		addSolidObject(new CrumblingBlock(353 * 32, 94 * 32, 0.35f, 350));
		
		addSolidObject(new CrumblingBlock(356 * 32, 91 * 32, 0.35f, 200));
		addSolidObject(new CrumblingBlock(357 * 32, 91 * 32, 0.35f, 200));
		addSolidObject(new CrumblingBlock(358 * 32, 91 * 32, 0.35f, 200));
		addSolidObject(new CrumblingBlock(359 * 32, 91 * 32, 0.35f, 200));
		addSolidObject(new CrumblingBlock(360 * 32, 91 * 32, 0.35f, 200));
		
		addSolidObject(new CrumblingBlock(353 * 32, 102 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(353 * 32, 103 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(353 * 32, 104 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(353 * 32, 105 * 32, 0.35f, 1000000000));
		
		addSolidObject(new CrumblingBlock(381 * 32, 111 * 32, 0.2f, 350));
		addSolidObject(new CrumblingBlock(382 * 32, 111 * 32, 0.2f, 350));
		addSolidObject(new CrumblingBlock(383 * 32, 111 * 32, 0.2f, 350));
		
		addSolidObject(new CrumblingBlock(391 * 32, 113 * 32, 0.2f, 1000000000));
		
		addSolidObject(new CrumblingBlock(413 * 32, 111 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(414 * 32, 111 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(415 * 32, 111 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(416 * 32, 111 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(418 * 32, 111 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(419 * 32, 111 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(420 * 32, 111 * 32, 0.35f, 350));
			
		addSolidObject(new CrumblingBlock(449 * 32, 95 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(450 * 32, 95 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(451 * 32, 95 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(452 * 32, 95 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(453 * 32, 95 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(454 * 32, 95 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(455 * 32, 95 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(456 * 32, 95 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(457 * 32, 95 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(458 * 32, 95 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(459 * 32, 95 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(460 * 32, 95 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(461 * 32, 95 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(462 * 32, 95 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(463 * 32, 95 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(464 * 32, 95 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(465 * 32, 95 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(466 * 32, 95 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(467 * 32, 95 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(468 * 32, 95 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(469 * 32, 95 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(470 * 32, 95 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(471 * 32, 95 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(472 * 32, 95 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(473 * 32, 95 * 32, 0.35f, 1000000000));
		
		addItem(new DoorKey(379 * 32, 100 * 32, 1, getPhysicsHandler()));
		addSolidObject(new LockedDoor(379 * 32, 90 * 32, 1));
		
		addRegion(new Knight(50 * 32, 47 * 32, true, "FNORD", getDialogueHandler()));
		addRegion(new Knight(79 * 32, 51 * 32, false, "I'm free! Let's get out before I get stuck again.", getDialogueHandler()));
		addRegion(new Knight(183 * 32, 57 * 32, true, "FNORD", getDialogueHandler()));
		addRegion(new Knight(222 * 32, 54 * 32, true, "Watch out! The bridge is broken. We're doing our best to fix it.", getDialogueHandler()));
		
		addRegion(new Sign(397 * 32, 104 * 32, 5, "SIGN", "FNORD", getDialogueHandler()));
		addRegion(new Sign(411 * 32, 116 * 32, 5, "SIGN", "FNORD", getDialogueHandler()));
		
		addRegion(new RoomWarp(221 * 32, 0, 32, 54 * 32, "faerie.Two"));
		
	}
}
