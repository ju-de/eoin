package dmcigd.levels.faerie;

import java.net.URL;

import dmcigd.core.objects.blocks.*;
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
		
		addSolidObject(new CrumblingBlock(222 * 32, 55 * 32, 0.25f, 1000000000));
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
		
		addSolidObject(new CrumblingBlock(225 * 32, 61 * 32, 0.25f, 1000000000));
		addSolidObject(new CrumblingBlock(239 * 32, 69 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(240 * 32, 71 * 32, 0.25f, 1000000000));
		addSolidObject(new CrumblingBlock(240 * 32, 72 * 32, 0.25f, 1000000000));
		addSolidObject(new CrumblingBlock(248 * 32, 78 * 32, 0.25f, 1000000000));
		addSolidObject(new CrumblingBlock(256 * 32, 80 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(257 * 32, 45 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(258 * 32, 81 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(266 * 32, 83 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(270 * 32, 85 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(271 * 32, 85 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(280 * 32, 86 * 32, 0.25f, 350));
		addSolidObject(new CrumblingBlock(296 * 32, 87 * 32, 0.25f, 350));
		
		
		
		
		
		
		
		
		
		
	}
}
