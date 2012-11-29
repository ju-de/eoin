package dmcigd.levels.game.levelselect;

import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.player.*;

public class ClearLever extends ObjectCollision implements Region {
	
	private DigitHandler digitHandler;
	private boolean hovering = false;
	
	public ClearLever(int x, int y, DigitHandler digitHandler) {
		this.digitHandler = digitHandler;
		
		setX(x);
		setY(y + 12);
		
		setWidth(32);
		setHeight(18);
		setImageWidth(36);
		setImageHeight(20);
		
		setSequence(1);
		setFrame(4);
		
		setImagePath("levelcode.gif");
	}

	public void step() {
		if(hovering) {
			setSequence(2);
		} else {
			setSequence(1);
		}
		setFrame(4);
		hovering = false;
	}

	public void onHover(Player player) {
		hovering = true;
	}

	public void interact(Player player) {
		digitHandler.clearValues();
	}

}
