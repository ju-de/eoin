package dmcigd.core.objects.player;

import dmcigd.core.enums.*;
import dmcigd.core.objects.*;

public class Player extends AnimateObject {
	
	private int jumpState = 0;
	private int jumpDelay = 5;
	private int facing = 0;
	private boolean isWalking,sprint;
	private Direction walking,climbing;
	
	public Player(int x, int  y, BlockMap blockMap) {
		setX(x);
		setY(y);
		setHeight(30);
		setWidth(20);
		setGravity();
		setBlockMap(blockMap);
		
		//SpriteSheet organized as follows:
		//0: Idle Right [4] [Loops]
		//1: Idle Left [4] [Loops]
		//2: Falling Right [3] [One Shot]
		//3: Falling Left [3] [One Shot]
		//4: On Ladder [1] [One Shot]
		//5: Climbing [2] [Loops]
		int[] frameLimits = {4,4,3,3,1,2};
		setFrameLimits(frameLimits);
		
		boolean[] animationLoops = {true,true,false,false,false,true};
		setAnimationLoops(animationLoops);
		
		setSequence(0);
	}
	
	public void walk(boolean isWalking, Direction direction) {
		if(isWalking) {
			this.isWalking = true;  
			walking = direction;
			if(direction == Direction.RIGHT) {
				facing = 0;
			} else {
				facing = 1;
			}
		} else {
			//Smooths out controls in case of overlap with keypresses
			if(walking == direction) {
				this.isWalking = false;
				walking = null;
			}
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
		
		//Set movement vectors
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
		
		//Step
		move();
		
		animate();
		
		//Reset jump counter after player hits the ground
		if(hitGround || onLadder) {
			jumpState = 0;
		}
		
		if(isFalling) {
			setSequence(2+facing);
		} else if(jumpState > 0) {
			setSequence(0+facing);
		} else if (onLadder) {
			if(isClimbing) {
				setSequence(5);
			}else {
				setSequence(4);
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
