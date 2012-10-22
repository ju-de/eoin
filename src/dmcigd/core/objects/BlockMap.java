package dmcigd.core.objects;

import dmcigd.core.enums.*;

import java.util.*;
import java.io.*;
import java.net.*;

public class BlockMap extends BlockCollision {
	
	//Initialize buffered reader for maps
	private BufferedReader br;
	
	//Initialize mapping variables
	private List<String> blockMap = new ArrayList<String>();
	private int spawnX;
	private int spawnY;
	
	//Initialize object lists
	private char[][] visibleBlocks = new char[12][22];
	
	public int getSpawnX() {
		return spawnX;
	}
	
	public int getSpawnY() {
		return spawnY;
	}
	
	public List<String> getBlockMap() {
		return blockMap;
	}
	
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
	
	public char[][] getVisibleBlocks(int x, int y) {
		fetchVisibleBlocks(x, y);
		return visibleBlocks;
	}
	
	public void fetchVisibleBlocks(int x, int y) {
		
		//Loop through Y axis
		for(int i=0; i<12; i++) {
			
			//Loop through X axis
			for(int j=0; j<22; j++) {
				
				//Checks block at given displacement from character sprite
				visibleBlocks[i][j] = blockMap.get((y/32)-5+i).charAt((x/32)-10+j);
			}
		}
	}
	
	public void loadBlockMap(URL codeBase, String folderName) {
		
		//Create blockMap array
		try {
			
			//Load the textfile for blockmap
			br = new BufferedReader(new InputStreamReader(new URL(codeBase, "../share/txt/levelmaps/"+folderName+"/blockmap.txt").openStream()));
			
			try {
				
				//Loop through lines in textfile
				String line;
				int i = 0;
				while((line = br.readLine()) != null) {
					
					blockMap.add(line);
					
					//Search for spawn block
					if(line.contains("1")) {
						spawnX = line.indexOf("1");
						spawnY = i;
					}
					
					i++;
					
				}
				
				br.close();
				
			} catch(IOException e) {}
			
		} catch (FileNotFoundException e) { }
		catch (MalformedURLException e1) { }
		catch (IOException e1) { }
		
		fetchVisibleBlocks(spawnX * 32, spawnY * 32);
	}
}
