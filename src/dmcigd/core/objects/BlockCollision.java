package dmcigd.core.objects;

import dmcigd.core.*;
import java.util.Arrays;

public class BlockCollision extends VisibleObject {
	
	//Checks
	public int tileType(char block) {
		if(Arrays.asList(' ', '1', '^').contains(block)) {
			if(block == '^') {
				return 1;
			}else{
				return 2;
			}
		} else {
			return 0;
		}
	}
	public boolean isSolid(char block) {
		if(Arrays.asList(' ', '1', '^').contains(block)) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean betweenRows(int y, int height) {
		if(y % 32 <= 32 - height) {
			return false;
		} else {
			return true;
		}
	}
	public boolean betweenCols(int x, int width) {
		if(x % 32 <= 32 - width) {
			return false;
		} else {
			return true;
		}
	}
	
	//Tile math
	public int tileRow(int y, int height, Direction direction) {
		if(direction == Direction.DOWN) {
			return (y + height - 1) / 32;
		} else {
			return y / 32;
		}
	}
	public int tileCol(int x, int width, Direction direction) {
		if(direction == Direction.RIGHT) {
			return (x + width - 1) / 32;
		} else {
			return x / 32;
		}
	}

	public int rowEdge(int y, int height, Direction direction) {
		if(direction == Direction.DOWN) {
			return (y + height - 1) - ((y + height - 1) % 32) + (32 - height);
		} else {
			return y - (y % 32);
		}
	}
	public int colEdge(int x, int width, Direction direction) {
		if(direction == Direction.RIGHT) {
			return (x + width - 1) - ((x + width - 1) % 32) + (32 - width);
		} else {
			return x - (x % 32);
		}
	}
	
	
}
