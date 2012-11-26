package dmcigd.core.objects.maps;

import dmcigd.core.enums.Direction;
import dmcigd.core.enums.CollisionType;

import java.util.*;

abstract class BlockCollision {
	
	public List<String> blockMap = new ArrayList<String>();

	public List<Character> death = Arrays.asList('^','>','<','V');
	public List<Character> platforms = Arrays.asList('i','o','O','p','_');
	public List<Character> solidladders = Arrays.asList('g', 'h', 'j',
			'G', 'H', 'J', 'b', 'n', 'm', 'B','N', 'M', 'k');
	public List<Character> nonsolidladders = Arrays.asList('l', 'L');
	public List<Character> water = Arrays.asList('@');
	public List<Character> nonsolid = Arrays.asList(' ','1');
	
	//Collision checks
	public CollisionType collidesX(float x, float y, float vx, int width, int height, Direction direction) {

		CollisionType returnType = CollisionType.NONSOLID;
		CollisionType curType;
		
		//Determine blockMap positions
		int topRow = tileRow(y, height, Direction.UP); 
		int bottomRow = tileRow(y - 1, height, Direction.DOWN);
		
		int destinationCol = tileCol(x + vx, width, direction);
		
		//Loop through rows to check destination blocks
		for(int i = topRow; i <= bottomRow; i++) {
			
			//Get block type
			curType = tileType(blockMap.get(i).charAt(destinationCol));
			
			//Return top priority block
			if(curType.getPriority() < returnType.getPriority()) {
				returnType = curType;
			}
		}
		
		return returnType;
		
	}
	public CollisionType collidesY(float x, float y, float vy, int width, int height, Direction direction) {

		CollisionType returnType = CollisionType.NONSOLID;
		CollisionType curType;
		
		//Determine blockMap positions
		int leftCol = tileCol(x, width, Direction.LEFT);
		int rightCol = tileCol(x, width, Direction.RIGHT);
		
		int destinationRow = tileRow(y + vy, height, direction);
		
		//Loop through columns to check destination blocks
		for(int i = leftCol; i <= rightCol; i++) {
			
			//Get block type
			curType = tileType(blockMap.get(destinationRow).charAt(i));
			
			//Checks for boundary case of falling in the middle of a platform
			if(curType == CollisionType.PLATFORM && direction == Direction.DOWN) {
				if(destinationRow == tileRow(y - 1, height, Direction.DOWN)) {
					curType = CollisionType.NONSOLID;
				}
			}
			
			//Return top priority block
			if(curType.getPriority() < returnType.getPriority()) {
				returnType = curType;
			}
		}
		
		return returnType;
	}
	
	public CollisionType backBlock(float x, float y, int width, int height) {
		
		CollisionType returnType = CollisionType.NONSOLID;
		CollisionType curType;
		
		//Determine back row
		int backRow = tileRow(y - 1, height, Direction.DOWN);
		
		//Determine back columns
		int leftCol = tileCol(x, width, Direction.LEFT);
		int rightCol = tileCol(x, width, Direction.RIGHT);
		
		//Loop through back columns
		for(int i = leftCol; i <= rightCol; i++) {
			
			curType = tileType(blockMap.get(backRow).charAt(i));
			
			//Return top priority block
			if(curType.getPriority() < returnType.getPriority()) {
				returnType = curType;
			}
			
		}
		
		return returnType;
	}
	
	//Tile checks
	public CollisionType tileType(char block) {
		if(nonsolid.contains(block)) {
			return CollisionType.NONSOLID;
		} else if(water.contains(block)) {
			return CollisionType.WATER;
		} else if(nonsolidladders.contains(block)) {
			return CollisionType.NONSOLIDLADDER;
		} else if(solidladders.contains(block)) {
			return CollisionType.SOLIDLADDER;
		} else if(platforms.contains(block)) {
			return CollisionType.PLATFORM;
		} else if(death.contains(block)) {
			return CollisionType.KILL;
		} else if(block == '*') {
			return CollisionType.DESTROY;
		} else {
			return CollisionType.SOLID;
		}
	}
	
	//Tile math
	public int tileRow(float y, int height, Direction direction) {
		if(direction == Direction.DOWN) {
			return (int) (y + height) / 32;
		} else {
			return (int) y / 32;
		}
	}
	public int tileCol(float x, int width, Direction direction) {
		if(direction == Direction.RIGHT) {
			return (int) (x + width - 1) / 32;
		} else {
			return (int) x / 32;
		}
	}

	public int rowEdge(float y, int height, Direction direction) {
		if(direction == Direction.DOWN) {
			return (int) ((y + height - 1) - ((y + height - 1) % 32) + (32 - height));
		} else {
			return (int) (y - (y % 32));
		}
	}
	public int colEdge(float x, int width, Direction direction) {
		if(direction == Direction.RIGHT) {
			return (int) ((x + width - 1) - ((x + width - 1) % 32) + (32 - width));
		} else {
			return (int) (x - (x % 32));
		}
	}
	
	
}
