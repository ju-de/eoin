package dmcigd.levels.cave;

import java.net.URL;
import java.util.LinkedList;

import dmcigd.core.objects.blocks.LockedDoor;
import dmcigd.core.objects.blocks.PushableBlock;
import dmcigd.core.objects.items.DoorKey;
import dmcigd.core.objects.regions.RoomWarp;
import dmcigd.core.room.*;
import dmcigd.levels.cave.mobs.Bat;
import dmcigd.levels.cave.mobs.BatList;

public class Cave3 extends Room {

	public Cave3(URL codeBase) {
		super(codeBase, "cave", "Cave3", "rocky");
	}

	public void initializeRoom(){
		
		//knockback bats
		BatList batList1 = new BatList(51 * 32, 8 * 32, 150, 300);
		BatList batList2 = new BatList(44 * 32, 34 * 32, 100, 200);
		BatList batList3 = new BatList(66 * 32, 31 * 32, 100, 200);
		
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
		
		addSolidObject(new LockedDoor(28*32, 16*32, 1));
		addItem(new DoorKey(40*32, 21*32, 1, getPhysicsHandler()));

		addSolidObject(new PushableBlock(32 * 32, 21 * 32, getPhysicsHandler()));
		addSolidObject(new PushableBlock(40 * 32 + 4, 22 * 32, getPhysicsHandler()));
		addSolidObject(new PushableBlock(36 * 32, 16 * 32, getPhysicsHandler()));
		
		addSolidObject(new PushableBlock(61 * 32, 17 * 32, getPhysicsHandler()));
		addSolidObject(new PushableBlock(63 * 32, 20 * 32, getPhysicsHandler()));
		addSolidObject(new PushableBlock(62 * 32, 23 * 32, getPhysicsHandler()));
		
		addSolidObject(new PushableBlock(48 * 32 + 4, 27 * 32, getPhysicsHandler()));
		addSolidObject(new PushableBlock(46 * 32, 27 * 32, getPhysicsHandler()));
		
		addSolidObject(new PushableBlock(85 * 32, 27 * 32, getPhysicsHandler()));
		addSolidObject(new PushableBlock(85 * 32 + 4, 26 * 32, getPhysicsHandler()));
		addSolidObject(new PushableBlock(85 * 32 - 14, 25 * 32, getPhysicsHandler()));
		addSolidObject(new PushableBlock(85 * 32 + 14, 25 * 32, getPhysicsHandler()));
		
		addSolidObject(new PushableBlock(78 * 32 , 21 * 32, getPhysicsHandler()));
		addSolidObject(new PushableBlock(81 * 32 , 17 * 32, getPhysicsHandler()));

		//Room Warp
		addRegion(new RoomWarp (110*32 + 16, 128, 1*32, 640, "cave.BossRoom"));
	}
}
