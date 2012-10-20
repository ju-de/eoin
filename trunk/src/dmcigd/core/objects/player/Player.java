package dmcigd.core.objects.player;

import dmcigd.core.*;
import dmcigd.core.objects.*;

public class Player extends MovingObject {
	
	private int jumpState = 0;
	private int jumpDelay = 5;
	private int facing = 0;
	private boolean isWalking,isClimbing,sprint;
	private Direction walking,climbing;
	
	public Player(int x, int  y, BlockMap blockLoader) {
		setX(x);
		setY(y);
		setHeight(32);
		setWidth(20);
		setGravity();
		setBlockLoader(blockLoader);
		
		setImage("blocks/demo/playertemp.gif");
		
		//Spritesheet organized as follows:
		//0: Idle Right [4]
		//1: Idle Left [4]
		//2: Walk Right [8]
		//3: Walk Left [8]
		int[] frameLimits = {4,4};
		setFrameLimits(frameLimits);
		
		setSequence(0);
	}
	
	public void walk(boolean isWalking, Direction direction) {
		this.isWalking = isWalking;  
		if(isWalking) {
			walking = direction;
		} else {
			walking = null;
		}
		if(direction == Direction.RIGHT) {
			facing = 0;
		} else {
			facing = 1;
		}
	}
	
	public void climbUp(boolean isClimbing) {
		this.isClimbing = isClimbing;
		climbing = Direction.UP;
	}
	
	public void keyDown(boolean down) {
		this.sprint = down;
		isClimbing = down;
		climbing = Direction.DOWN;
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
		if(isWalking) {
			if(!sprint) {
				accelerate(1.0f, 2.0f, walking);
			} else {
				accelerate(1.0f, 4.0f, walking);
			}
		}else{
			accelerate(0.0f, 0.0f, Direction.RIGHT);
			setVX(0);
		}
		if(isClimbing && onLadder) {
			if(climbing == Direction.UP) {
				setVY(-2);
			}else {
				setVY(2);
			}
		}
		move(isClimbing);
		animate();
		
		//Reset jump counter after player hits the ground
		if(hitGround) {
			jumpState = 0;
		}
		
		if(isFalling) {
			setSequence(0+facing);
		} else if(jumpState > 0) {
			setSequence(0+facing);
		} else if (onLadder) {
			if(isClimbing) {
				setSequence(0+facing);
			}else {
				setSequence(0+facing);
			}
		} else if (isWalking) {
			setSequence(0+facing);
		} else {
			setSequence(0+facing);
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
