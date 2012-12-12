package dmcigd.levels.deer;

import java.net.URL;

import dmcigd.core.objects.regions.RoomWarp;
import dmcigd.core.objects.npc.GenericNpc;
import dmcigd.core.room.*;


public class Village extends Room implements Runnable{
	
	public Village(URL codebase) {
		super(codebase, "deer", "Village", "grassy");
	}
	
	public void initializeRoom() {
		
		addBackgroundObject(new House(34 * 32 - 8, 11 * 32 - 4, 0,
				304, 132, 1));
		addForegroundObject(new House(34 * 32 - 8, 11 * 32 - 4, 1,
				304, 132, 1));
		addRegion(new GenericNpc(36 * 32 - 4, 13 * 32 + 12,
				30, 54, 2, 0.007f, "deer/lumberjack.gif", "Lumberjack",
				"Deeper into the murk lies the abyss that is home to the terrors of the night.", getDialogueHandler()));
		addRegion(new GenericNpc(38 * 32 - 4, 13 * 32 + 22,
				22, 44, 2, 0.005f, "deer/lumberjackwife.gif", "Lumberjack's Wife",
				"The guardian will always protect us from the horrors! So long as we... maintain our covenant.", getDialogueHandler()));
		addRegion(new GenericNpc(42 * 32 - 14, 14 * 32 + 8,
				16, 26, 2, 0.009f, "deer/lumberjackson.gif", "Lumberjack's Son",
				"*sigh* \n When will my antlers grow?", getDialogueHandler()));
		
		
		addBackgroundObject(new House(57 * 32, 8 * 32 + 10, 0,
				250, 118, 2));
		
		addBackgroundObject(new House(69 * 32, 9 * 32 + 18, 0,
				248, 110, 3));
		
		addBackgroundObject(new House(81 * 32 + 12, 10 * 32 - 4, 0,
				284, 134, 4));
		addForegroundObject(new House(81 * 32 + 12, 10 * 32 - 4, 1,
				284, 134, 4));
		
		addRegion(new GenericNpc(85 * 32, 13 * 32 + 6,
				48, 28, 2, 0.006f, "deer/sickdeer.gif", "Sick Deer",
				"*cough* *cough*", getDialogueHandler()));
		
		addRegion(new GenericNpc(86 * 32 + 20, 13 * 32 + 6,
				24, 28, 2, 0.01f, "deer/cryingdeer.gif", "Crying Deer",
				"It's so horrible! M-my husband's fallen ill! There's a herb nearby that can cure him, but... oh, I can't leave his side! And what of the terrors of the night? Please, young one, won't you find the herb for me?", getDialogueHandler()));
		
		addRegion(new RoomWarp(114 * 32 + 16, 0, 32, 14 * 32, "deer.Three"));
	}
	
}
