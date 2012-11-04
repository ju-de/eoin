package dmcigd.levels.game;

import java.net.URL;

import dmcigd.core.*;
import dmcigd.core.objects.*;
import dmcigd.core.objects.regions.*;

public class MainMenu extends Room implements Runnable {
	
	public MainMenu(URL codeBase) {
		super(codeBase, "game", "MainMenu", "grassy");
	}
	

	public void initializeNonsolidObjects() {
		
		regions.add(new RoomPathway(16 * 32, 10 * 32, "tutorial", "Tutorial"));
		textLabels.add(new TextLabel(16 * 32 - 7, 11 * 32 + 16, "Start Game"));
		
		regions.add(new Pathway(12 * 32, 10 * 32, 16 * 32, 10 * 32));
		textLabels.add(new TextLabel(12 * 32 - 10, 11 * 32 + 16, "Level Select"));
		
		regions.add(new Pathway(20 * 32, 10 * 32, 16 * 32, 10 * 32));
		textLabels.add(new TextLabel(20 * 32 + 3, 11 * 32 + 16, "Credits"));
		
		textLabels.add(new TextLabel(15 * 32 - 11, 8 * 32, "UNTITLED GAME", false));
		
		textLabels.add(new TextLabel(14 * 32, 13 * 32, "PRESS \"X\" TO BEGIN", false));
		
		textLabels.add(new TextLabel(13 * 32 - 3, 14 * 32 + 5, "(C) 2012 - Don Mills C.I. Video Game Development Club"));
		textLabels.add(new TextLabel(12 * 32 - 13, 15 * 32 - 16, "This game is lisensed under GNU GPL v3 and Creative Commons 3.0 BY-SA"));
	}
	
}
