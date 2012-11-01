package dmcigd.core.objects.maps;

import java.io.*;
import java.net.*;
import java.util.*;

public class EnvironmentMap {
	
	//Initialize buffered reader for maps
	private BufferedReader br;
	
	//Initialize object lists
	private char[][] visibleEnvironment = new char[12][22];
	
	public List<String> environmentMap = new ArrayList<String>();
	
	public void fetchVisibleEnvironment(int x, int y) {
		//Loop through Y axis
		for(int i=0; i<12; i++) {
			//Loop through X axis
			for(int j=0; j<22; j++) {
				//Checks block at given displacement from character sprite
				visibleEnvironment[i][j] = environmentMap.get((y/32)-5+i).charAt((x/32)-10+j);
			}
		}
	}
	
	public char[][] getVisibleEnvironment(int x, int y) {
		fetchVisibleEnvironment(x, y);
		return visibleEnvironment;
	}
	
	public void loadEnvironmentMap(URL codeBase, String levelName, String roomName) {
		
		//Create environment map array
		try {
			
			//Load the textfile for environment map
			br = new BufferedReader(new InputStreamReader(new URL(codeBase, "../share/txt/maps/"+levelName+"/"+roomName+"/environmentmap.txt").openStream()));
			
			try {
				
				//Loop through lines in textfile
				String line;
				
				while((line = br.readLine()) != null) {
					
					environmentMap.add(line);
					
				}
				
				br.close();
				
			} catch(IOException e) {}
			
		} catch (FileNotFoundException e) { }
		catch (MalformedURLException e1) { }
		catch (IOException e1) { }
	}
}
