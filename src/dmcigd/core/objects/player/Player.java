package dmcigd.core.objects.player;

import dmcigd.core.objects.*;

public class Player extends MovingObject {
	
	public Player(int x, int  y) {
		setX(x);
		setY(y);
		setHeight(16);
		setWidth(16);
	}
	
	public void step(char[][] immediateBlocks) {
		move(immediateBlocks);
	}
}