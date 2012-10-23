package dmcigd.core.objects;

import java.io.*;
import java.net.*;

public class BlockMap extends BlockCollision {
	
	//Initialize buffered reader for maps
	private BufferedReader br;
	
	//Initialize mapping variables
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
