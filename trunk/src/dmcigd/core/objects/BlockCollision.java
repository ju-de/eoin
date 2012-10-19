package dmcigd.core.objects;

import java.util.Arrays;

public class BlockCollision {
	
	//Direction
	public enum Direction {
		LEFT, RIGHT, UP, DOWN
	}
	
	//Object Dimensions
	private int height = 32;
	private int width = 32;
	
	//Public Getters
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	
	//Public Setters
	public void setHeight(int height) {
		this.height = height;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	//Boolean Checks
	public boolean isSolid(char block) {
		if(Arrays.asList(' ', '1').contains(block)) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean betweenRows(int y) {
		if(y % 32 <= 32 - height) {
			return false;
		} else {
			return true;
		}
	}
	public boolean betweenCols(int x) {
		if(x % 32 <= 32 - width) {
			return false;
		} else {
			return true;
		}
	}
	
	//Tile math
	public int tileRow(int y, Direction direction) {
		if(direction == Direction.DOWN) {
			return (y + height - 1) / 32;
		} else {
			return y / 32;
		}
	}
	public int tileCol(int x, Direction direction) {
		if(direction == Direction.RIGHT) {
			return (x + width - 1) / 32;
		} else {
			return x / 32;
		}
	}

	public int rowEdge(int y, Direction direction) {
		if(direction == Direction.DOWN) {
			return y - (y % 32) + (32 - height);
		} else {
			return y - (y % 32);
		}
	}
	public int colEdge(int x, Direction direction) {
		if(direction == Direction.RIGHT) {
			return x - (x % 32) + (32 - width);
		} else {
			return x - (x % 32);
		}
	}
	
	
}
