package dmcigd.core;

import java.util.*;
import java.io.*;

public class BlockLoader {
	
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
