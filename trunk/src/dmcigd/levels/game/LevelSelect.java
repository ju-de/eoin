package dmcigd.levels.game;

import java.net.URL;

import dmcigd.core.objects.TextLabel;
import dmcigd.core.objects.regions.RoomPassage;
import dmcigd.core.room.*;
import dmcigd.levels.game.levelselect.*;

public class LevelSelect extends Room {

	Digit digit1 = new Digit(13 * 32, 6 * 32);
	Digit digit2 = new Digit(14 * 32, 6 * 32);
	Digit digit3 = new Digit(15 * 32, 6 * 32);
	Digit digit4 = new Digit(16 * 32, 6 * 32);
	Digit digit5 = new Digit(17 * 32, 6 * 32);
	Digit digit6 = new Digit(18 * 32, 6 * 32);
	Digit digit7 = new Digit(19 * 32, 6 * 32);
	Digit digit8 = new Digit(20 * 32, 6 * 32);
	Digit digit9 = new Digit(21 * 32, 6 * 32);
	
	DigitHandler digitHandler = new DigitHandler(new Digit[] {digit1, digit2, digit3,
			digit4, digit5, digit6, digit7, digit8, digit9}, this);

	public LevelSelect(URL codeBase) {
		super(codeBase, "game", "LevelSelect", "grassy");
	}

	public void initializeRoom() {
		addRegion(new RoomPassage(22 * 32, 9 * 32, "game.MainMenu"));
		addTextLabel(new TextLabel(22 * 32 - 6, 10 * 32 + 16, "Main Menu"));
		
		addRegion(new ClearLever(12 * 32, 9 * 32, digitHandler));
		addTextLabel(new TextLabel(12 * 32 - 6, 10 * 32 + 16, "Reset Code"));

		addRegion(new Button(14 * 32, 9 * 32, "R", digitHandler));
		addTextLabel(new TextLabel(14 * 32 + 10, 10 * 32 + 16, "RED"));
		addRegion(new Button(16 * 32, 9 * 32, "Y", digitHandler));
		addTextLabel(new TextLabel(16 * 32 + 2, 10 * 32 + 16, "YELLOW"));
		addRegion(new Button(18 * 32, 9 * 32, "G", digitHandler));
		addTextLabel(new TextLabel(18 * 32 + 5, 10 * 32 + 16, "GREEN"));
		addRegion(new Button(20 * 32, 9 * 32, "B", digitHandler));
		addTextLabel(new TextLabel(20 * 32 + 8, 10 * 32 + 16, "BLUE"));
		
		addForegroundObject(digit1);
		addForegroundObject(digit2);
		addForegroundObject(digit3);
		addForegroundObject(digit4);
		addForegroundObject(digit5);
		addForegroundObject(digit6);
		addForegroundObject(digit7);
		addForegroundObject(digit8);
		addForegroundObject(digit9);
		addTextLabel(new TextLabel(16 * 32 + 8, 6 * 32, "Save Code:", false));
		
		addTextLabel(new TextLabel(12 * 32 + 17, 11 * 32 + 20, "Press \"X\" while standing on the coloured buttons to input a save code digit"));
		addTextLabel(new TextLabel(12 * 32 + 33, 11 * 32 + 30, "You will be transfered to the level corresponding to your 9 digit code"));
	}

}
