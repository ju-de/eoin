package dmcigd.core.objects;

import dmcigd.core.*;

import java.util.*;
import java.io.*;

public class BlockMap extends BlockCollision {
	
	//Initialize buffered reader for maps
	private BufferedReader br;
	
	//Initialize mapping variables
	private List<String> blockMap = new ArrayList<String>();
	private int spawnX;
	private int spawnY;
	
	//Initialize object lists
	private char[][] immediateBlocks = new char[4][4];
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
		
		char[][] immediateBlocks = getImmediateBlocks(x,y);
		
		//Determine which column to check (left, center, right, or two blocks to the right)
		int col = tileCol(x + vx, width, direction) - tileCol(x, width, Direction.LEFT) + 1;

		//Check immediate cells in column of travel
		int tile1 = tileType(immediateBlocks[1][col]);
		int tile2 = tileType(immediateBlocks[2][col]);
		
		//If column is between rows, and other cell takes priority, return tile2
		if(!betweenRows(y, height) || tile1 < tile2) {
			return tile1;
		} else {
			return tile2;
		}
		
	}
	public int collidesY(int x, int y, int vy, int width, int height, Direction direction) {
		
		char[][] immediateBlocks = getImmediateBlocks(x,y);
		
		//Determine which row to check (top, center, bottom, or two blocks to the bottom)
		int row = tileRow(y + vy, height, direction) - tileRow(y, height, Direction.UP) + 1;
		
		//Check immediate cells in row of travel
		int tile1 = tileType(immediateBlocks[row][1]);
		int tile2 = tileType(immediateBlocks[row][2]);
		
		//If column is between columns, and other cell takes priority, return tile2
		if(!betweenCols(x, width) || tile1 < tile2) {
			return tile1;
		} else {
			return tile2;
		}
	}
	
	public char[][] getVisibleBlocks(int x, int y) {
		fetchVisibleBlocks(x, y);
		return visibleBlocks;
	}
	
	public char[][] getImmediateBlocks(int x, int y) {
		
		//Loop through Y axis
		for(int i=0; i<4; i++) {
			
			//Loop through X axis
			for(int j=0; j<4; j++) {
				
				//Checks block at given displacement from character sprite
				immediateBlocks[i][j] = blockMap.get((y/32)-1+i).charAt((x/32)-1+j);
			}
		}
		
		return immediateBlocks;
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
	
	public void loadBlockMap(String folderName) {
		
		//Create blockMap array
		try {
			
			//Load the textfile for blockmap
			br = new BufferedReader(new FileReader("../share/txt/levelmaps/"+folderName+"/blockmap.txt"));
			
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
			
		} catch (FileNotFoundException e) {}
		
		fetchVisibleBlocks(spawnX * 32, spawnY * 32);
	}
}
