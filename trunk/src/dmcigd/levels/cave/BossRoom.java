package dmcigd.levels.cave;

import java.net.URL;
import java.util.LinkedList;

import dmcigd.core.objects.blocks.TimedBlock;
import dmcigd.core.objects.regions.RoomWarp;
import dmcigd.core.room.*;
import dmcigd.levels.cave.mobs.*;

public class BossRoom extends Room {

	public BossRoom(URL codeBase) {
		super(codeBase, "cave", "BossRoom", "rocky");
	}

	public void initializeRoom(){
		//knockback bats
		BatList batList1 = new BatList(48 * 32, 10 * 32, 200, 400);
		BatList batList2 = new BatList(86 * 32, 11 * 32, 200, 400);
		BatList batList3 = new BatList(127 * 32, 11 * 32, 200, 400);
		BatList batList4 = new BatList(163 * 32, 10 * 32, 150, 300);
		BatList batList5 = new BatList(208 * 32, 10 * 32, 100, 200);
		
		LinkedList<Bat> bats1 = new LinkedList<Bat>();
		LinkedList<Bat> bats2 = new LinkedList<Bat>();
		LinkedList<Bat> bats3 = new LinkedList<Bat>();
		LinkedList<Bat> bats4 = new LinkedList<Bat>();
		LinkedList<Bat> bats5 = new LinkedList<Bat>();
		
		for(int i = 0; i < 6; i++) {
			Bat bat = new Bat(batList1, getPhysicsHandler());
			bats1.push(bat);
			addSolidObject(bat);
			
			bat = new Bat(batList2, getPhysicsHandler());
			bats2.push(bat);
			addSolidObject(bat);
			
			bat = new Bat(batList3, getPhysicsHandler());
			bats3.push(bat);
			addSolidObject(bat);
			
			bat = new Bat(batList4, getPhysicsHandler());
			bats4.push(bat);
			addSolidObject(bat);
			
			bat = new Bat(batList5, getPhysicsHandler());
			bats5.push(bat);
			addSolidObject(bat);
		}
		
		batList1.setBatList(bats1);
		batList2.setBatList(bats2);
		batList3.setBatList(bats3);
		batList4.setBatList(bats4);
		batList5.setBatList(bats5);
		
		//Bosses
		addImageResource("objects/cave/bossprojectile.gif");
		addImageResource("objects/cave/bossprojectileparticle.gif");
		addSolidObject(new BossBat(60 * 32, 10 * 32, this));
		addSolidObject(new BossBat(101 * 32, 10 * 32, this));
		addSolidObject(new BossBat(142 * 32, 9 * 32, this));
		addSolidObject(new BossBat(174 * 32, 10 * 32, this));
		
		//Bridge
		
		addSolidObject(new TimedBlock(226 * 32, 13 * 32, 1, 17 * 16, 32, 288));
		addSolidObject(new TimedBlock(227 * 32, 13 * 32, 1, 16 * 16, 32, 288));
		addSolidObject(new TimedBlock(228 * 32, 13 * 32, 1, 15 * 16, 32, 288));
		addSolidObject(new TimedBlock(229 * 32, 13 * 32, 1, 14 * 16, 32, 288));
		addSolidObject(new TimedBlock(230 * 32, 13 * 32, 1, 13 * 16, 32, 288));
		addSolidObject(new TimedBlock(231 * 32, 13 * 32, 1, 12 * 16, 32, 288));
		addSolidObject(new TimedBlock(232 * 32, 13 * 32, 1, 11 * 16, 32, 288));
		addSolidObject(new TimedBlock(233 * 32, 13 * 32, 1, 10 * 16, 32, 288));
		addSolidObject(new TimedBlock(234 * 32, 13 * 32, 1, 9 * 16, 32, 288));
		addSolidObject(new TimedBlock(235 * 32, 13 * 32, 1, 8 * 16, 32, 288));
		addSolidObject(new TimedBlock(236 * 32, 13 * 32, 1, 7 * 16, 32, 288));
		addSolidObject(new TimedBlock(237 * 32, 13 * 32, 1, 6 * 16, 32, 288));
		addSolidObject(new TimedBlock(238 * 32, 13 * 32, 1, 5 * 16, 32, 288));
		addSolidObject(new TimedBlock(239 * 32, 13 * 32, 1, 4 * 16, 32, 288));
		addSolidObject(new TimedBlock(240 * 32, 13 * 32, 1, 3 * 16, 32, 288));
		addSolidObject(new TimedBlock(241 * 32, 13 * 32, 1, 2 * 16, 32, 288));
		addSolidObject(new TimedBlock(242 * 32, 13 * 32, 1, 16, 32, 288));
		addSolidObject(new TimedBlock(243 * 32, 13 * 32, 1, 0, 32, 288));

		addRegion(new RoomWarp (227*32 + 16, 18 * 32 + 16, 1280, 640, "icecave.IceRoom1"));
	}
}
