package dmcigd.core.objects.player;

import dmcigd.core.*;
import dmcigd.core.objects.*;

public class Player extends MovingObject {
	
	private int jumpState = 0;
	
	public Player(int x, int  y, BlockLoader blockLoader) {
		setX(x);
		setY(y);
		setHeight(16);
		setWidth(16);
		setGravity();
		setBlockLoader(blockLoader);
	}
	
	public void walkLeft(boolean walking) {
		if(walking) {
			accelerate(1.0f, 2.0f, Direction.LEFT);
		} else {
			accelerate(1.0f, 0.0f, Direction.RIGHT);
		}
	}
	
	public void walkRight(boolean walking) {
		if(walking) {
			accelerate(1.0f, 2.0f, Direction.RIGHT);
		} else {
			accelerate(1.0f, 0.0f, Direction.LEFT);
		}
	}
	
	public void jump(boolean jumping) {
		if(jumping) {
			if(jumpState < 2) {
				setVY(-8);
				jumpState++;
			}
		}else{
			if(getVY() < 0) {
				setVY(0);
			}
		}
	}
	
	public void step() {
		move();
		if(hitGround) {
			jumpState = 0;
		}
		if(isFalling && jumpState == 0) {
			jumpState = 1;
		}
	}
}
