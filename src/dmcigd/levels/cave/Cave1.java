package dmcigd.levels.cave;

import dmcigd.core.objects.blocks.PushableBlock;
import dmcigd.core.objects.regions.RoomWarp;
import dmcigd.core.room.*;

import java.util.LinkedList;

import dmcigd.core.room.*;
import dmcigd.levels.cave.mobs.*;
import dmcigd.levels.lake.mobs.FishMob;
import dmcigd.levels.lake.mobs.FishSchool;

import java.net.URL;

public class Cave1 extends Room {

	public Cave1(URL codeBase) {
		super(codeBase, "cave", "Cave1", "rocky");
	}

	public void initializeRoom(){
		
		//knockback bats
		BatList batList1 = new BatList(28 * 32, 8 * 32, 100, 200);
		BatList batList2 = new BatList(24 * 32, 16 * 32, 100, 200);
		BatList batList3 = new BatList(78 * 32, 17 * 32, 100, 200);
		
		LinkedList<Bat> bats1 = new LinkedList<Bat>();
		LinkedList<Bat> bats2 = new LinkedList<Bat>();
		LinkedList<Bat> bats3 = new LinkedList<Bat>();
		
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
		}
		
		batList1.setBatList(bats1);
		batList2.setBatList(bats2);
		batList3.setBatList(bats3);
		
		//Boulders
		addSolidObject(new PushableBlock(22 * 32, 22 * 32, getPhysicsHandler()));
		addSolidObject(new PushableBlock(27 * 32, 22 * 32, getPhysicsHandler()));

		addSolidObject(new PushableBlock(52 * 32 + 16, 15 * 32, getPhysicsHandler()));

		addSolidObject(new PushableBlock(64 * 32 + 16, 13 * 32, getPhysicsHandler()));
		addSolidObject(new PushableBlock(65 * 32, 16 * 32, getPhysicsHandler()));
		addSolidObject(new PushableBlock(70 * 32, 17 * 32, getPhysicsHandler()));
		
		//Fish
		addSolidObject(new FishMob(40 * 32, 26 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishMob(46 * 32, 26 * 32, getPhysicsHandler(), getPlayer()));
		addSolidObject(new FishSchool(42 * 32, 27 * 32 - 16, this));

		//Room Warp
		addRegion(new RoomWarp (107*32 + 16, 0, 1*32, 640, "cave.Cave2"));
	}
}
