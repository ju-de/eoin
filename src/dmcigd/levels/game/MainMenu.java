package dmcigd.levels.game;

import java.net.URL;

import dmcigd.core.objects.*;
import dmcigd.core.objects.regions.*;
import dmcigd.core.room.*;

public class MainMenu extends Room implements Runnable {
	
	public MainMenu(URL codeBase) {
		super(codeBase, "game", "MainMenu", "grassy");
	}
	
	public void initializeRoom() {
		
		addRegion(new RoomPassage(16 * 32, 10 * 32, "tutorial.Tutorial"));
		addTextLabel(new TextLabel(16 * 32 - 7, 11 * 32 + 16, "Start Game"));
		
		addRegion(new RoomPassage(12 * 32, 10 * 32, "rabbit.One"));
		addTextLabel(new TextLabel(12 * 32 - 10, 11 * 32 + 16, "Level Select"));
		
		addRegion(new RoomPassage(20 * 32, 10 * 32, "rabbit.BossRoom"));
		addTextLabel(new TextLabel(20 * 32 + 3, 11 * 32 + 16, "Credits"));
		
		addTextLabel(new TextLabel(15 * 32 - 11, 8 * 32, "UNTITLED GAME", false));
		
		addTextLabel(new TextLabel(14 * 32, 13 * 32, "PRESS \"X\" TO BEGIN", false));
		
		addTextLabel(new TextLabel(13 * 32 - 3, 14 * 32 + 5, "(C) 2012 - Don Mills C.I. Video Game Development Club"));
		addTextLabel(new TextLabel(12 * 32 - 13, 15 * 32 - 16, "This game is lisensed under GNU GPL v3 and Creative Commons 3.0 BY-SA"));
	}
	
}
