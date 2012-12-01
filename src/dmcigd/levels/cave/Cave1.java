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
		addSolidObject(new LockedDoor(45*32, 34*32, 1));
		addSolidObject(new LockedDoor(75*32, 34*32, 1));
		
		//keys
		addItem(new DoorKey(56*32, 35*32, 1, getPhysicsHandler()));
		addItem(new DoorKey(62*32, 36*32, 2, getPhysicsHandler()));
		addItem(new DoorKey(74*32, 34*32, 1, getPhysicsHandler()));
		
		//signs
		addRegion(new Sign(13* 32, 7* 32, 9 , "SIGN", "Bat's Cave", getDialogueHandler()));
		
		addRegion(new RoomWarp (114*32, 4*32, 2*32, 1*32, "game.MainMenu"));
	}
}
