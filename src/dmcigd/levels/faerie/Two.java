package dmcigd.levels.faerie;

import java.net.URL;

import dmcigd.core.objects.blocks.*;
import dmcigd.core.objects.items.DoorKey;
import dmcigd.core.objects.npc.Sign;
import dmcigd.core.objects.regions.RoomWarp;
import dmcigd.core.room.*;


public class Two extends Room implements Runnable {
	
	public Two(URL codeBase) {
		super(codeBase, "faerie", "Two", "foresty");
	}
        
	public void initializeRoom() {
		
		addSolidObject(new CrumblingBlock(0, 14 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(1 * 32, 14 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(2 * 32, 14 * 32, 0.35f, 350));
		
		addSolidObject(new CrumblingBlock(15 * 32, 14 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(16 * 32, 14 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(17 * 32, 14 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(18 * 32, 14 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(19 * 32, 14 * 32, 0.35f, 350));
		
		addSolidObject(new CrumblingBlock(21 * 32, 14 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(22 * 32, 14 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(23 * 32, 14 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(24 * 32, 14 * 32, 0.35f, 350));
		
		addSolidObject(new CrumblingBlock(26 * 32, 14 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(27 * 32, 14 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(28 * 32, 14 * 32, 0.35f, 350));
		
		addSolidObject(new CrumblingBlock(30 * 32, 14 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(31 * 32, 14 * 32, 0.35f, 350));
		
		addSolidObject(new CrumblingBlock(33 * 32, 14 * 32, 0.35f, 350));
		
		addSolidObject(new CrumblingBlock(36 * 32, 11 * 32, 0.35f, 200));
		addSolidObject(new CrumblingBlock(37 * 32, 11 * 32, 0.35f, 200));
		addSolidObject(new CrumblingBlock(38 * 32, 11 * 32, 0.35f, 200));
		addSolidObject(new CrumblingBlock(39 * 32, 11 * 32, 0.35f, 200));
		addSolidObject(new CrumblingBlock(40 * 32, 11 * 32, 0.35f, 200));
		
		addSolidObject(new CrumblingBlock(33 * 32, 22 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(33 * 32, 23 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(33 * 32, 24 * 32, 0.35f, 1000000000));
		addSolidObject(new CrumblingBlock(33 * 32, 25 * 32, 0.35f, 1000000000));
		
		addSolidObject(new CrumblingBlock(61 * 32, 31 * 32, 0.2f, 350));
		addSolidObject(new CrumblingBlock(62 * 32, 31 * 32, 0.2f, 350));
		addSolidObject(new CrumblingBlock(63 * 32, 31 * 32, 0.2f, 350));
		
		addSolidObject(new CrumblingBlock(71 * 32, 33 * 32, 0.2f, 1000000000));
		
		addSolidObject(new CrumblingBlock(93 * 32, 31 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(94 * 32, 31 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(95 * 32, 31 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(96 * 32, 31 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(98 * 32, 31 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(99 * 32, 31 * 32, 0.35f, 350));
		addSolidObject(new CrumblingBlock(100 * 32, 31 * 32, 0.35f, 350));
		
		addItem(new DoorKey(59 * 32, 20 * 32, 1, getPhysicsHandler()));
		addSolidObject(new LockedDoor(59 * 32, 10 * 32, 1));
			
		addRegion(new Sign(77 * 32, 24 * 32, 5, "SIGN", "FNORD", getDialogueHandler()));
		addRegion(new Sign(91 * 32, 36 * 32, 5, "SIGN", "FNORD", getDialogueHandler()));
		
		addBackgroundObject(new Decoration(121 * 32 + 8, 10 * 32 - 2,0,
				244, 238, "treeentrance.gif"));
		addForegroundObject(new Decoration(121 * 32 + 8, 10 * 32 - 2,1,
				244, 238, "teeentrance.gif"));
		
		addForegroundObject(new Decoration(117 * 32 + 16, 16 * 32 - 8,0,
				116, 42, "root1.gif"));
		
		addBackgroundObject(new Decoration(115 * 32, 16 * 32 + 12,0,
				74, 22, "root2.gif"));
		
		addBackgroundObject(new Decoration(111 * 32, 17 * 32 + 10,0,
				48, 24, "root3.gif"));
				
		addRegion(new RoomWarp(127* 32, 0, 32, 95 * 32, "faerie.Three"));
		
	}
}
