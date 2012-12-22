package dmcigd.levels.cave;

import java.net.URL;
import java.util.LinkedList;

import dmcigd.core.room.*;
import dmcigd.core.objects.TextLabel;
import dmcigd.core.objects.blocks.LockedDoor;
import dmcigd.core.objects.items.DoorKey;
import dmcigd.core.objects.regions.RoomWarp;
import dmcigd.core.objects.npc.*;
import dmcigd.levels.cave.mobs.*;

public class Cave2 extends Room {

	public Cave2(URL codeBase) {
		super(codeBase, "cave", "Cave2", "rocky");
	}

	public void initializeRoom(){
		//locked doors
		addSolidObject(new LockedDoor(44*32, 37*32, 1));
		addSolidObject(new LockedDoor(82*32, 38*32, 1));
		addSolidObject(new LockedDoor(57*32, 11*32, 2));
		
		//keys
		addItem(new DoorKey(45*32, 37*32, 1, getPhysicsHandler()));
		addItem(new DoorKey(69*32, 40*32, 2, getPhysicsHandler()));
		addItem(new DoorKey(81*32, 38*32, 1, getPhysicsHandler()));
		
		//knockback bats
		BatList batList1 = new BatList(102 * 32, 30 * 32, 300, 600);
		BatList batList2 = new BatList(97 * 32, 19 * 32, 300, 600);
		BatList batList3 = new BatList(72 * 32, 11 * 32, 300, 600);
		BatList batList4 = new BatList(26 * 32, 20 * 32, 100, 300);
		BatList batList5 = new BatList(26 * 32, 30 * 32, 100, 300);
		
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
		
		//Hidden Area
		addForegroundObject(new SecretRoom(40 * 32 + 4, 9 * 32 + 20));
		addRegion(new GenericNpc(45 * 32, 13 * 32 + 8,
				74, 24, 1, 0, "cave/cauldron.gif", "Cauldron Inscription",
				"FNORD", getDialogueHandler()));
		
		addTextLabel(new TextLabel(45 * 32 + 16, 15 * 32 - 20, "Press"));
		addTextLabel(new TextLabel(45 * 32 + 14, 15 * 32 - 6, "\"X\"", false));
		
		//Room Warp
		addRegion(new RoomWarp (127*32 + 16, 8*32, 2*32, 2*32, "cave.Cave3"));
	}
}
