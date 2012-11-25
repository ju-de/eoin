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
		
		addSolidObject(new PushableBlock(128 * 32, 23 * 32, getPhysicsHandler()));
		
		addSolidObject(new Dummy(198 * 32, 19 * 32 + 24));
		addSolidObject(new Dummy(201 * 32, 19 * 32 + 24));
		addSolidObject(new Dummy(204 * 32, 19 * 32 + 24));
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
		
		addTextLabel(new TextLabel(62 * 32, 18 * 32, "Hold down the shift", false));
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
		
		addItem(new DoorKey(126 * 32, 20 * 32, 2, getPhysicsHandler()));
		
		addRegion(new Sign(126 * 32, 20 * 32, 4, "SIGN", "Keys can be thrown at locked doors of the corresponding colour to open them.", getDialogueHandler()));
		
		addRegion(new Passage(120 * 32, 20 * 32, 116 * 32, 20 * 32));
		addRegion(new Passage(116 * 32, 20 * 32, 120 * 32, 20 * 32));
		
		addTextLabel(new TextLabel(120 * 32, 22 * 32, "And go through passages", false));
		
		addItem(new DoorKey(112 * 32, 23 * 32, 1, getPhysicsHandler()));

		addTextLabel(new TextLabel(113 * 32, 25 * 32, "While holding an item", false));
		addTextLabel(new TextLabel(113 * 32, 25 * 32 + 20, "press \"X\" again to throw it", false));

		addTextLabel(new TextLabel(126 * 32 - 16, 25 * 32, "Walk against boulders", false));
		addTextLabel(new TextLabel(126 * 32 - 16, 25 * 32 + 20, "to push them forward", false));

		addTextLabel(new TextLabel(141 * 32, 23 * 32 - 20, "At any point in the game", false));
		addTextLabel(new TextLabel(141 * 32, 23 * 32, "press \"P\" to pause", false));
		addTextLabel(new TextLabel(141 * 32, 23 * 32 + 20, "\"R\" to restart the level", false));
		addTextLabel(new TextLabel(141 * 32, 23 * 32 + 40, "or \"Q\" to quit the game", false));
		
		addRegion(new Sign(144 * 32, 20 * 32, 6, "WARNING:", "Pointy spears ahead!\nWatch where you step!", getDialogueHandler()));

		addTextLabel(new TextLabel(152 * 32, 23 * 32, "Sharp objects hurt", false));
		addTextLabel(new TextLabel(152 * 32, 23 * 32 + 20, "Try to avoid them", false));
		
		addRegion(new Sign(163 * 32, 20 * 32, 9, "SIGN", "Please wait 30-60 minutes after eating before entering pool.", getDialogueHandler()));

		addTextLabel(new TextLabel(171 * 32, 28 * 32, "When in water, jump to stay afloat", false));

		addTextLabel(new TextLabel(188 * 32, 23 * 32, "Press \"X\" to attack", false));
		addTextLabel(new TextLabel(188 * 32, 23 * 32 + 20, "enemies with your sword", false));
		
		addRegion(new RoomWarp(195 * 32, 0, 32, 35 * 32, "game.CutsceneOne"));
		
		//Add flags and banners
		addBackgroundObject(new Flag(19 * 32, 22 * 32 + 6, 4));
		
		addBackgroundObject(new Flag(29 * 32, 22 * 32 + 6, 4));
		
		addBackgroundObject(new Flag(33 * 32, 22 * 32 + 6, 4));
		
		addBackgroundObject(new Flag(43 * 32, 13 * 32 + 6, 4));
		
		addBackgroundObject(new Flag(57 * 32 + 8, 16 * 32 + 16, 1));
		addBackgroundObject(new Flag(58 * 32 + 16, 16 * 32 + 16, 0));
		addBackgroundObject(new Flag(59 * 32 + 24, 16 * 32 + 16, 1));
		
		addBackgroundObject(new Flag(68 * 32 + 8, 16 * 32 + 16, 1));
		addBackgroundObject(new Flag(69 * 32 + 16, 16 * 32 + 16, 2));
		addBackgroundObject(new Flag(70 * 32 + 24, 16 * 32 + 16, 1));
		
		addBackgroundObject(new Flag(79 * 32 + 8, 16 * 32 + 16, 1));
		addBackgroundObject(new Flag(80 * 32 + 16, 16 * 32 + 16, 0));
		addBackgroundObject(new Flag(81 * 32 + 24, 16 * 32 + 16, 1));
		
		addBackgroundObject(new Flag(96 * 32, 13 * 32 + 6, 3));
		addBackgroundObject(new Flag(96 * 32, 18 * 32 + 6, 5));
		
		addBackgroundObject(new Flag(106 * 32, 13 * 32 + 6, 5));
		addBackgroundObject(new Flag(106 * 32, 18 * 32 + 6, 3));
		
		addBackgroundObject(new Flag(126 * 32, 13 * 32 + 6, 3));
		addBackgroundObject(new Flag(126 * 32, 18 * 32 + 6, 5));
	}
}

