package dmcigd.levels.game.levelselect;

import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.player.*;

public class Button extends ObjectCollision implements Region {
	
	private DigitHandler digitHandler;
	private String value;
	private int frame;
	private boolean hovering = false;
	
	public Button(int x, int y, String value, DigitHandler digitHandler) {
		this.digitHandler = digitHandler;
		this.value = value;
		
		if(value == "R") {
			frame = 0;
		} else if (value == "Y") {
			frame = 1;
		} else if (value == "G") {
			frame = 2;
		} else {
			frame = 3;
		}
		
		setX(x);
		setY(y + 12);
		
		setWidth(32);
		setHeight(18);
		setImageWidth(36);
		setImageHeight(20);
		
		setSequence(1);
		setFrame(frame);
		
		setImagePath("levelcode.gif");
	}

	public void step() {
		if(hovering) {
			setSequence(2);
		} else {
			setSequence(1);
		}
		setFrame(frame);
		hovering = false;
	}

	public void onHover(Player player) {
		hovering = true;
	}

	public void interact(Player player) {
		digitHandler.setDigit(value, player);
	}

}
