package dmcigd.levels.tutorial;

import java.net.URL;

import dmcigd.core.objects.*;
import dmcigd.core.objects.blocks.*;
import dmcigd.core.objects.platforms.*;
import dmcigd.core.objects.items.DoorKey;
import dmcigd.core.objects.npc.*;
import dmcigd.core.objects.regions.*;
import dmcigd.core.room.*;

public class Tutorial extends Room implements Runnable {
	
	public Tutorial(URL codeBase) {
		super(codeBase, "tutorial", "Tutorial", "castle");
	}
	
	public void initializeSolidObjects() {
		
		addSolidObject(new MovingPlatform(105 * 32, 16 * 32, 1, 6, 1, 11));
		
		addSolidObject(new TimedBlock(116 * 32, 15 * 32, 1, 0, 100, 100));
		
		addSolidObject(new CrumblingBlock(125 * 32, 16 * 32, 0.15f, 500));
		addSolidObject(new CrumblingBlock(126 * 32, 16 * 32, 0.15f, 500));
		addSolidObject(new CrumblingBlock(127 * 32, 16 * 32, 0.15f, 500));
		
		addSolidObject(new LockedDoor(114 * 32, 23 * 32, 2));
		addSolidObject(new LockedDoor(118 * 32, 23 * 32, 1));
		
		addSolidObject(new PushableBlock(128 * 32, 23 * 32, getBlockMap(), getSolidObjects()));

		addSolidObject(new TestMonster(190 * 32, 18 * 32, getBlockMap(), getSolidObjects()));
		addSolidObject(new TestMonster(193 * 32, 18 * 32, getBlockMap(), getSolidObjects()));
		
		addSolidObject(new TestMonster(199 * 32, 18 * 32, getBlockMap(), getSolidObjects()));
	}

	public void initializeNonsolidObjects() {
		addTextLabel(new TextLabel(10 * 32, 23 * 32, "Use your Arrow Keys", false));
		addTextLabel(new TextLabel(10 * 32, 23 * 32 + 20, "to move Left and Right", false));
		
		addTextLabel(new TextLabel(22 * 32, 27 * 32, "As well as climb", false));
		addTextLabel(new TextLabel(22 * 32, 27 * 32 + 20, "Up and Down Ladders", false));
		
		addTextLabel(new TextLabel(36 * 32, 27 * 32, "Press and hold the", false));
		addTextLabel(new TextLabel(36 * 32, 27 * 32 + 20, "\"Z\" key to jump", false));
		
		addTextLabel(new TextLabel(47 * 32, 23 * 32, "You can jump through", false));
		addTextLabel(new TextLabel(47 * 32, 23 * 32 + 20, "thinner platforms", false));
		
		addTextLabel(new TextLabel(47 * 32, 18 * 32, "And jump once midair", false));
		addTextLabel(new TextLabel(47 * 32, 18 * 32 + 20, "to get past taller obstacles", false));
		
		addTextLabel(new TextLabel(62 * 32, 18 * 32, "Hold the down arrow", false));
		addTextLabel(new TextLabel(62 * 32, 18 * 32 + 20, "key to sprint", false));
		
		addTextLabel(new TextLabel(86 * 32, 18 * 32, "Hold the down key and jump", false));
		addTextLabel(new TextLabel(86 * 32, 18 * 32 + 20, "to fall through platforms", false));
		
		addTextLabel(new TextLabel(96 * 32, 23 * 32, "Some blocks can move", false));
		addTextLabel(new TextLabel(96 * 32, 23 * 32 + 20, "and push you up with them", false));
		
		addTextLabel(new TextLabel(109 * 32, 18 * 32, "Others may turn", false));
		addTextLabel(new TextLabel(109 * 32, 18 * 32 + 20, "on and off", false));
		
		addTextLabel(new TextLabel(129 * 32, 14 * 32, "Press \"X\"", false));
		addTextLabel(new TextLabel(129 * 32, 14 * 32 + 20, "to read signs", false));
		addTextLabel(new TextLabel(123 * 32 + 8, 14 * 32 + 30, "Sign"));
		addRegion(new Sign(123 * 32, 15 * 32, 6, "SIGN", "Beware of cracked blocks! These will crumble beneath your feet.", getDialogueHandler()));
		
		addTextLabel(new TextLabel(129 * 32, 20 * 32, "Or pick up items", false));
		
		addItem(new DoorKey(126 * 32, 20 * 32, 2, getBlockMap(), getSolidObjects()));
		
		addRegion(new Sign(126 * 32, 20 * 32, 4, "SIGN", "Keys can be thrown at locked doors of the corresponding colour to open them.", getDialogueHandler()));
		
		addRegion(new Passage(120 * 32, 20 * 32, 116 * 32, 20 * 32));
		addRegion(new Passage(116 * 32, 20 * 32, 120 * 32, 20 * 32));
		
		addTextLabel(new TextLabel(120 * 32, 22 * 32, "And go through passages", false));
		
		addItem(new DoorKey(112 * 32, 23 * 32, 1, getBlockMap(), getSolidObjects()));

		addTextLabel(new TextLabel(113 * 32, 25 * 32, "While holding an item", false));
		addTextLabel(new TextLabel(113 * 32, 25 * 32 + 20, "press \"X\" again to throw it", false));

		addTextLabel(new TextLabel(126 * 32 - 16, 25 * 32, "Walk against boulders", false));
		addTextLabel(new TextLabel(126 * 32 - 16, 25 * 32 + 20, "to push them forward", false));

		addTextLabel(new TextLabel(141 * 32, 23 * 32 - 20, "At any point in the game", false));
		addTextLabel(new TextLabel(141 * 32, 23 * 32, "press \"P\" to pause", false));
		addTextLabel(new TextLabel(141 * 32, 23 * 32 + 20, "\"R\" to restart the level", false));
		addTextLabel(new TextLabel(141 * 32, 23 * 32 + 40, "or \"Q\" to quit the game", false));
		
		addRegion(new Sign(144 * 32, 20 * 32, 6, "SIGN", "Beware! Pointy spears ahead!", getDialogueHandler()));

		addTextLabel(new TextLabel(150 * 32, 23 * 32, "It should be common sense to", false));
		addTextLabel(new TextLabel(150 * 32, 23 * 32 + 20, "avoid walking into sharp objects", false));
		
		addRegion(new Sign(163 * 32, 20 * 32, 9, "SIGN", "If you can't swim, just jump arond wildly and hope for the best.", getDialogueHandler()));

		addTextLabel(new TextLabel(171 * 32, 28 * 32, "When in water, jump to stay afloat", false));

		addTextLabel(new TextLabel(188 * 32, 23 * 32, "Press \"X\" to attack", false));
		addTextLabel(new TextLabel(188 * 32, 23 * 32 + 20, "enemies with your sword", false));
		
		addRegion(new RoomWarp(195 * 32, 0, 32, 35 * 32, "demo.Demo"));
	}
}

