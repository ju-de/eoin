package dmcigd.levels.rabbit;

import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.player.Player;
import dmcigd.core.objects.*;

public class Switch extends ObjectCollision implements Region {
	
	private int state;
	private SwitchBlock targetBlock;

	public Switch(int x, int y, boolean flipped, SwitchBlock targetBlock) {
		setX(x);
		setY(y);
		setHeight(32);
		setWidth(32);
		setImageHeight(32);
		setImageWidth(32);
		
		setSequence(0);
		setFrame(state);
		
		setImagePath("objects/rabbit/switch.gif");
		
		this.flipped = flipped;
		this.targetBlock = targetBlock;
	}
	
	public void step() { }

	public void onHover(Player player) { }

	public void interact(Player player) {
		if(state == 0) {
			//Switch Off
			state = 1;
			targetBlock.off();
		} else {
			//Switch On
			state = 0;
			targetBlock.on();
		}
		setFrame(state);
	}

}
