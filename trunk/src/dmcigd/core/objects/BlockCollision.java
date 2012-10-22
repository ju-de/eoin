package dmcigd.core.objects;

import dmcigd.core.enums.*;

import java.util.*;

public class BlockCollision extends VisibleObject {

	public List<Character> death = Arrays.asList('^','>','<','V','*');				//Return 4
	public List<Character> platforms = Arrays.asList('i','o','O','p');		//Return 2
	public List<Character> ladders = Arrays.asList('g', 'h', 'j',			//Return 3
			'G', 'H', 'J', 'b', 'n', 'm', 'B','N', 'M', 'k', 'l', 'L');
	public List<Character> nonsolid = Arrays.asList(' ','1');				//Return 4
	
	//Tile checks
	public int tileType(char block) {
		if(nonsolid.contains(block)) {
			return 4;
		} else if(platforms.contains(block)) {
			return 2;
		} else if(ladders.contains(block)) {
			return 3;
		} else if(death.contains(block)) {
			return 1;
		}else{
			return 0;
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
