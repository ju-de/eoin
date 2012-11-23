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
    
    public EnvironmentMap(){
        environmentMap.add(" "); // prevents bothersome load-time nullpointers
    }

    public void fetchVisibleEnvironment(int x, int y) {
        int blockY = 0;
        int blockX = 0;
        int xlim = environmentMap.get(0).length();
        int ylim = environmentMap.size();

        //Loop through Y axis
        for (int i = 0; i < 12; i++) {
            // limit the environment lookups to within range
            blockY = (y / 32) - 5 + i;
            blockY = blockY < 0? 0: blockY;
            blockY = blockY >= ylim? ylim-1:blockY;
            //Loop through X axis
            for (int j = 0; j < 22; j++) {
                blockX = (x / 32) - 10 + j;
                blockX = blockX < 0? 0:blockX;
                blockX = blockX >= xlim? xlim-1:blockX;
                //Checks block at given displacement from character sprite
                visibleEnvironment[i][j] = environmentMap.get(blockY).charAt(blockX);
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
            br = new BufferedReader(new InputStreamReader(new URL(codeBase, "../share/txt/maps/" + levelName + "/" + roomName + "/environmentmap.txt").openStream()));

            try {

                //Loop through lines in textfile
                String line;

                while ((line = br.readLine()) != null) {

                    environmentMap.add(line);

                }

                br.close();

            } catch (IOException e) {
            }

        } catch (FileNotFoundException e1) {
        } catch (MalformedURLException e2) {
        } catch (IOException e3) {
        }
    }
}
