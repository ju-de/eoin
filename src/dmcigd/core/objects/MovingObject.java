package dmcigd.core.objects;

import java.util.Arrays;

public class MovingObject {
	
	//Initialize position properties (position, velocity, and acceleration)
	private int x = 0;
	private int y = 0;
	private int vx = 0;
	private int vy = 2;
	private int ax = 0;
	private int ay = 0;
	
	//Public position getters (if level needs to check for position or speed)
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getVX() {
		return vx;
	}
	
	public int getVY() {
		return vy;
	}
	
	//Public position setters (if level needs to move player around dynamically)
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setVX(int vx) {
		this.vx = vx;
	}
	
	public void setVY(int vy) {
		this.vy = vy;
	}
	
	public void setAX(int ax) {
		this.ax = ax;
	}
	
	public void setAY(int ay) {
		this.ay = ay;
	}
	
	private boolean isSolid(char block) {
		if(Arrays.asList(' ', '1').contains(block)) {
			return false;
		} else {
			return true;
		}
	}
	
	public void move(char[][] immediateBlocks) {
		
		//Calculate Acceleration
		vx = vx + ax;
		vy = vy + ay;
		
		//Cap all speeds at 32px per tick
		if(vx > 32) {
			vx = 32;
			ax = 0;
		}else if(vx < -32) {
			vx = -32;
			ax = 0;
		}
		if(vy > 32) {
			vy = 32;
			ay = 0;
		}else if(vy < -32) {
			vy = -32;
			ay = 0;
		}
		
		if(vx > 0) {
			//Move Right
			//If not crossing a tile, move over
			if(((x-1)/32) == (x-1 + vx)/32) {
				x = x + vx;
			} else {
				int column = 3;
				if(x % 32 == 0) {
					column = 2;
				}
				//Check if tile to the immediate right is clear
				if(!isSolid(immediateBlocks[1][column])) {
					//If sitting perfectly in tile, move
					if(y % 32 == 0) {
						x = x + vx;
					} else {
						//If sitting between tiles, if tile to bottom right is also clear, move
						if(!isSolid(immediateBlocks[2][column])) {
							x = x + vx;
						} else {
							x = (x + vx) / 32 * 32;
							vx = 0;
							ax = 0;
						}
					}
				} else {
					x = (x + vx) / 32 * 32;
					vx = 0;
					ax = 0;
				}
			}
			
		}else if(vx < 0) {
			//Move left
			//If not crossing a tile, move over
			if(((x)/32) == (x-1 + vx)/32) {
				x = x + vx;
			} else {
				//Check if tile to the immediate left is clear
				if(!isSolid(immediateBlocks[1][0])) {
					//If sitting perfectly in tile, move
					if(y % 32 == 0) {
						x = x + vx;
					} else {
						//If sitting between tiles, if tile to bottom left is also clear, move
						if(!isSolid(immediateBlocks[2][0])) {
							x = x + vx;
						} else {
							x = x / 32 * 32;
						}
					}
				} else {
					x = x / 32 * 32;
				}
			}
		}
		
		if(vy > 0) {
			//Move Down
			if(((y-1)/32) == (y-1 + vy)/32) {
				y = y + vy;
			} else {
				int row = 3;
				if(y % 32 == 0) {
					row = 2;
				}
				//Check if tile to the immediate bottom is clear
				if(!isSolid(immediateBlocks[row][1])) {
					//If sitting perfectly in tile, move
					if(x % 32 == 0) {
						y = y + vy;
					} else {
						//If sitting between tiles, if tile to bottom right is also clear, move
						if(!isSolid(immediateBlocks[row][2])) {
							y = y + vy;
						} else {
							y = (y + vy) / 32 * 32;
						}
					}
				} else {
					y = (y + vy) / 32 * 32;
				}
			}
		}else if(vy < 0) {
			//Move Up
			if(((y)/32) == (y + vy)/32) {
				y = y + vy;
			} else {
				//Check if tile to the immediate top is clear
				if(!isSolid(immediateBlocks[0][1])) {
					//If sitting perfectly in tile, move
					if(x % 32 == 0) {
						y = y + vy;
					} else {
						//If sitting between tiles, if tile to top right is also clear, move
						if(!isSolid(immediateBlocks[0][2])) {
							y = y + vy;
						} else {
							y = y / 32 * 32;
						}
					}
				} else {
					y = y / 32 * 32;
				}
			}
		}
	}
}
