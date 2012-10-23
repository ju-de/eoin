package dmcigd.core.objects;

import dmcigd.core.enums.*;

import java.util.*;

public class BlockCollision {
	
	public List<String> blockMap = new ArrayList<String>();

	public List<Character> death = Arrays.asList('^','>','<','V','*');				//Return 4
	public List<Character> platforms = Arrays.asList('i','o','O','p','_');			//Return 2
	public List<Character> ladders = Arrays.asList('g', 'h', 'j',					//Return 3
			'G', 'H', 'J', 'b', 'n', 'm', 'B','N', 'M', 'k', 'l', 'L');
	public List<Character> nonsolid = Arrays.asList(' ','1');						//Return 4
	
	//Collision checks
	public int collidesX(int x, int y, int vx, int width, int height, Direction direction) {
		
		int returnType = 4;
		int curType;
		
		//Determine blockMap positions
		int topRow = tileRow(y, height, Direction.UP); 
		int bottomRow = tileRow(y, height, Direction.DOWN);
		
		int destinationCol = tileCol(x + vx, width, direction);
		
		//Loop through rows to check destination blocks
		for(int i = topRow; i <= bottomRow; i++) {
			
			//Get block type
			curType = tileType(blockMap.get(i).charAt(destinationCol));
			
			//Return top priority block
			if(curType < returnType) {
				returnType = curType;
			}
		}
		
		return returnType;
		
	}
	public int collidesY(int x, int y, int vy, int width, int height, Direction direction) {
		
		int returnType = 4;
		int curType;
		
		//Determine blockMap positions
		int leftCol = tileCol(x, width, Direction.LEFT);
		int rightCol = tileCol(x, width, Direction.RIGHT);
		
		int destinationRow = tileRow(y + vy, height, direction);
		
		//Loop through columns to check destination blocks
		for(int i = leftCol; i <= rightCol; i++) {
			
			//Get block type
			curType = tileType(blockMap.get(destinationRow).charAt(i));
			
			//Checks for boundary case of falling in the middle of a platform
			if(curType == 2 && direction == Direction.DOWN) {
				if(destinationRow == tileRow(y, height, Direction.DOWN)) {
					curType = 4;
				}
			}
			
			//Return top priority block
			if(curType < returnType) {
				returnType = curType;
			}
		}
		
		return returnType;
	}
	
	public int restingBlock(int x, int y, int width, int height) {
		
		int returnType = 4;
		int curType, backType;
		
		//Determine resting row
		int restingRow = tileRow(y + 1, height, Direction.DOWN);
		int backRow = -1;
		
		//Only check back row if character is resting on a block
		if((y + height) % 32 == 0) {
			backRow = tileRow(y, height, Direction.DOWN);
		}
		
		//Determine resting columns
		int leftCol = tileCol(x, width, Direction.LEFT);
		int rightCol = tileCol(x, width, Direction.RIGHT);
		
		//Loop through resting columns
		for(int i = leftCol; i <= rightCol; i++) {
			curType = tileType(blockMap.get(restingRow).charAt(i));
			
			//Checks for special blocks like ladders or water
			if(backRow > -1 ) {
				backType = tileType(blockMap.get(backRow).charAt(i));
				
				//Check for ladder
				if(backType == 3) {
					curType = 3;
				}else if(curType == 3) {
					curType = 0;
				}
			}
			
			//Return top priority block
			if(curType < returnType) {
				returnType = curType;
			}
			
		}
		
		return returnType;
	}
	
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
