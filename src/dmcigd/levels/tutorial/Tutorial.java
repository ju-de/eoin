package dmcigd.levels.tutorial;

import java.net.URL;

import dmcigd.core.*;
import dmcigd.core.objects.*;
import dmcigd.core.objects.blocks.*;
import dmcigd.core.objects.platforms.*;
import dmcigd.core.objects.items.DoorKey;
import dmcigd.core.objects.npc.*;
import dmcigd.core.objects.regions.*;

public class Tutorial extends Room implements Runnable {
	
	public Tutorial(URL codeBase) {
		super(codeBase, "tutorial", "Tutorial", "castle");
	}
	
	public void initializeSolidObjects() {
		solidObjects.add(new MovingPlatform(105 * 32, 16 * 32, 1, 6, 1, 11));
		
		solidObjects.add(new TimedBlock(116 * 32, 15 * 32, 1, 0, 100, 100));
		
		solidObjects.add(new CrumblingBlock(125 * 32, 16 * 32, 0.15f, 500));
		solidObjects.add(new CrumblingBlock(126 * 32, 16 * 32, 0.15f, 500));
		solidObjects.add(new CrumblingBlock(127 * 32, 16 * 32, 0.15f, 500));
		
		solidObjects.add(new LockedDoor(114 * 32, 23 * 32, 2));
		solidObjects.add(new LockedDoor(118 * 32, 23 * 32, 1));
		
		solidObjects.add(new PushableBlock(128 * 32, 23 * 32, blockMap, solidObjects));
	}

	public void initializeNonsolidObjects() {
		textLabels.add(new TextLabel(10 * 32, 23 * 32, "Use your Arrow Keys", false));
		textLabels.add(new TextLabel(10 * 32, 23 * 32 + 20, "to move Left and Right", false));
		
		textLabels.add(new TextLabel(22 * 32, 27 * 32, "As well as climb", false));
		textLabels.add(new TextLabel(22 * 32, 27 * 32 + 20, "Up and Down Ladders", false));
		
		textLabels.add(new TextLabel(36 * 32, 27 * 32, "Press and hold the", false));
		textLabels.add(new TextLabel(36 * 32, 27 * 32 + 20, "\"Z\" key to jump", false));
		
		textLabels.add(new TextLabel(47 * 32, 23 * 32, "You can jump through", false));
		textLabels.add(new TextLabel(47 * 32, 23 * 32 + 20, "thinner platforms", false));
		
		textLabels.add(new TextLabel(47 * 32, 18 * 32, "And jump once midair", false));
		textLabels.add(new TextLabel(47 * 32, 18 * 32 + 20, "to get past taller obstacles", false));
		
		textLabels.add(new TextLabel(62 * 32, 18 * 32, "Hold the down arrow", false));
		textLabels.add(new TextLabel(62 * 32, 18 * 32 + 20, "key to sprint", false));
		
		textLabels.add(new TextLabel(86 * 32, 18 * 32, "Hold the down key and jump", false));
		textLabels.add(new TextLabel(86 * 32, 18 * 32 + 20, "to fall through platforms", false));
		
		textLabels.add(new TextLabel(96 * 32, 23 * 32, "Some blocks can move", false));
		textLabels.add(new TextLabel(96 * 32, 23 * 32 + 20, "and push you up with them", false));
		
		textLabels.add(new TextLabel(109 * 32, 18 * 32, "Others may turn", false));
		textLabels.add(new TextLabel(109 * 32, 18 * 32 + 20, "on and off", false));
		
		textLabels.add(new TextLabel(129 * 32, 14 * 32, "Press \"X\"", false));
		textLabels.add(new TextLabel(129 * 32, 14 * 32 + 20, "to read signs", false));
		textLabels.add(new TextLabel(123 * 32 + 8, 14 * 32 + 30, "Sign"));
		regions.add(new Sign(123 * 32, 15 * 32, 6, "SIGN", "Beware of cracked blocks! These will crumble beneath your feet.", dh));
		
		textLabels.add(new TextLabel(129 * 32, 20 * 32, "Or pick up items", false));
		
		items.add(new DoorKey(126 * 32, 20 * 32, 2, blockMap, solidObjects));
		
		regions.add(new Sign(121 * 32, 20 * 32, 4, "SIGN", "Keys can be thrown at locked doors of the corresponding colour to open them.", dh));
		
		items.add(new DoorKey(112 * 32, 23 * 32, 1, blockMap, solidObjects));

		textLabels.add(new TextLabel(113 * 32, 25 * 32, "While holding an item", false));
		textLabels.add(new TextLabel(113 * 32, 25 * 32 + 20, "press \"X\" again to throw it", false));

		textLabels.add(new TextLabel(126 * 32 - 16, 25 * 32, "Walk against boulders", false));
		textLabels.add(new TextLabel(126 * 32 - 16, 25 * 32 + 20, "to push them forward", false));

		textLabels.add(new TextLabel(141 * 32, 23 * 32 - 20, "At any point in the game", false));
		textLabels.add(new TextLabel(141 * 32, 23 * 32, "press \"P\" to pause", false));
		textLabels.add(new TextLabel(141 * 32, 23 * 32 + 20, "\"R\" to restart the level", false));
		textLabels.add(new TextLabel(141 * 32, 23 * 32 + 40, "or \"Q\" to quit the game", false));
		
		regions.add(new Sign(144 * 32, 20 * 32, 6, "SIGN", "Beware! Pointy spears ahead!", dh));

		textLabels.add(new TextLabel(150 * 32, 23 * 32, "It should be common sense to", false));
		textLabels.add(new TextLabel(150 * 32, 23 * 32 + 20, "avoid walking into sharp objects", false));
		
		regions.add(new Sign(163 * 32, 20 * 32, 9, "SIGN", "If you can't swim, just jump arond wildly and hope for the best.", dh));

		textLabels.add(new TextLabel(171 * 32, 28 * 32, "When in water, jump to stay afloat", false));

		textLabels.add(new TextLabel(188 * 32, 23 * 32, "Press \"X\" to attack", false));
		textLabels.add(new TextLabel(188 * 32, 23 * 32 + 20, "enemies with your sword", false));
	}
}

