package dmcigd.core;

import java.util.*;
import java.io.*;
import java.net.URL;

public class MapLoader {
	
	private boolean ready = false;
	
	//Initialize object lists
	private char[][] visibleBlocks;
	
	//Initialize buffered reader for maps
	private BufferedReader br;
	
	//Initialize mapping variables
	private List<String> blockMap = new ArrayList<String>();
	private int spawnX;
	private int spawnY;
	
	public int demoX;
	public int demoY;
	public int demoDX;
	public int demoDY;
	
	public boolean isReady() {
		return ready;
	}
	
	public void setReady(boolean setReady) {
		ready = setReady;
	}
	
	public char[][] getVisibleBlocks() {
		return visibleBlocks;
	}
	
	public void fetchVisibleBlocks() {
		
		//Loop through Y axis
		for(int i=0; i<11; i++) {
			
			//Loop through X axis
			for(int j=0; j<21; j++) {
				
				//Checks block at given displacement from character sprite
				//REMEMBER TO REPLACE DEMO VARIABLE WITH PLAYER POSITION
				visibleBlocks[i][j] = blockMap.get((demoY/32)-5+i).charAt((demoX/32)-10+j);
			}
		}
	}
	
	public void loadMap(String folderName) {
		
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
		
		//Set character position
		//REMEMBER TO REPLACE DEMO VARIABLE WITH PLAYER POSITION
		demoX = spawnX * 32;
		demoY = spawnY * 32;
		
		visibleBlocks = new char[11][21];
		
		fetchVisibleBlocks();
	}
}
