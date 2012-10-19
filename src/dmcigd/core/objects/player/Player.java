package dmcigd.core.objects.player;

import dmcigd.core.*;
import dmcigd.core.objects.*;

public class Player extends MovingObject {
	
	public Player(int x, int  y, BlockLoader blockLoader) {
		setX(x);
		setY(y);
		setHeight(16);
		setWidth(16);
		setBlockLoader(blockLoader);
	}
	
	public void step() {
		move();
	}
}
