package dmcigd.core.objects.player;

import dmcigd.core.*;
import dmcigd.core.objects.*;

public class Player extends MovingObject {
	
	private int jumpState = 0;
	private int jumpDelay = 5;
	private boolean isWalking;
	private boolean sprint;
	
	public Player(int x, int  y, BlockLoader blockLoader) {
		setX(x);
		setY(y);
		setHeight(16);
		setWidth(16);
		setGravity();
		setBlockLoader(blockLoader);
	}
	
	//Movement commands
	public void walkLeft(boolean walking) {
		if(walking) {
			if(sprint) {
				accelerate(1.0f, 4.0f, Direction.LEFT);
			} else {
				accelerate(1.0f, 2.0f, Direction.LEFT);
			}
			isWalking = true;
		} else {
			accelerate(0.0f, 0.0f, Direction.LEFT);
			setVX(0);
			isWalking = false;
		}
	}
	
	public void walkRight(boolean walking) {
		if(walking) {
			if(sprint) {
				accelerate(1.0f, 4.0f, Direction.RIGHT);
			} else {
				accelerate(1.0f, 2.0f, Direction.RIGHT);
			}
			isWalking = true;
		} else {
			accelerate(0.0f, 0.0f, Direction.RIGHT);
			setVX(0);
			isWalking = false;
		}
	}
	
	public void setSprint(boolean sprint) {
		this.sprint = sprint;
		//If already moving, update terminal velocities
		if(isWalking) {
			if(sprint) {
				setTLeft(4.0f);
				setTRight(4.0f);
			} else {
				setTLeft(2.0f);
				setTRight(2.0f);
			}
		}
	}
	
	public void jump(boolean jumping) {
		if(jumping) {
			if(jumpState < 2 && jumpDelay == 0) {
				setVY(-8);
				jumpState++;
				jumpDelay = 5;
			}
		}else{
			if(getVY() < 0) {
				setVY(0);
			}
		}
	}
	
	public void step() {
		move();
		
		//Reset jump counter after player hits the ground
		if(hitGround) {
			jumpState = 0;
		}
		
		//Counts falling at terminal velocity as a jump
		//If falling, player should not be allowed to defy physics even further and jump a second time
		//Period of acceleration is given as a grace period to give player time to react
		if(isFalling && getVY() >= 5 && jumpState == 0) {
			jumpState = 1;
		}
		
		//Jump delay to prevent accidentally double jumping straight away
		if(jumpDelay > 0) {
			jumpDelay--;
		}
	}
}
