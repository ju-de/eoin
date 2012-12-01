package dmcigd.levels.cave;

import java.net.URL;

import dmcigd.core.room.*;
import dmcigd.core.objects.blocks.LockedDoor;
import dmcigd.core.objects.items.DoorKey;
import dmcigd.core.objects.npc.Sign;
import dmcigd.core.objects.regions.RoomWarp;

public class Cave1 extends Room {

	public Cave1(URL codeBase) {
		super(codeBase, "cave", "Cave1", "rocky");
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
		
		//signs
		addRegion(new Sign(20* 32, 11* 32, 9 , "SIGN", "Bat's Cave", getDialogueHandler()));
		
		//knockback bats
		
		//
		
		addRegion(new RoomWarp (127*32 + 16, 8*32, 2*32, 1*32, "game.MainMenu"));
	}
}
