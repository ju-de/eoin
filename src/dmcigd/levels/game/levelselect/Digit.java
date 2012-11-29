package dmcigd.levels.game.levelselect;

import dmcigd.core.objects.VisibleObject;

public class Digit extends VisibleObject {
	
	private String value = " ";
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
		if(value == "R") {
			setFrame(0);
		} else if (value == "Y") {
			setFrame(1);
		} else if (value == "G") {
			setFrame(2);
		} else if (value == "B"){
			setFrame(3);
		} else {
			setFrame(4);
		}
	}
	
	public Digit(int x, int y) {
		setX(x);
		setY(y + 12);
		
		setWidth(32);
		setHeight(18);
		setImageWidth(36);
		setImageHeight(20);
		
		setSequence(0);
		setFrame(4);
		
		setImagePath("levelcode.gif");
	}
}
