package dmcigd.core.objects.player;

import dmcigd.core.objects.*;
import java.util.Arrays;

public class Player extends MovingObject {
	
	public Player(int x, int  y) {
		setX(x);
		setY(y);
	}
	
	public void step(char[][] immediateBlocks) {
		move(immediateBlocks);
	}
}
