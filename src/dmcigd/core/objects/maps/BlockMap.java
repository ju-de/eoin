package dmcigd.core.objects.maps;

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
    
    public BlockMap(){
        blockMap.add(" "); // this keeps those pesk nullpointers from erupting when the game tries to start a map before loading.
    }
    
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

    /**
     * empties the visible blocks -- sets all chars to ' '. Used inside
     * fetchVisibleBlocks to avoid null errors
     */
    private void clearVisibleBlocks() {
        for (int i = 0;i< 12;i++){
            for (int j=0;j < 22; j++){
                visibleBlocks[i][j] = ' ';
            }
        }
    }

    public void fetchVisibleBlocks(int x, int y) {
        clearVisibleBlocks();
        int blockY = 0;
        int blockX = 0;
        int xlim = blockMap.get(0).length();
        int ylim = blockMap.size();
        //Loop through Y axis
        for (int i = 0; i < 12; i++) {
            // limit the block lookups to within range
            blockY = (y / 32) - 5 + i;
            blockY = blockY < 0? 0: blockY;
            blockY = blockY >= ylim? ylim-1:blockY;
            //Loop through X axis
            for (int j = 0; j < 22; j++) {
                blockX = (x / 32) - 10 + j;
                blockX = blockX < 0? 0:blockX;
                blockX = blockX >= xlim? xlim-1:blockX;
                //Checks block at given displacement from character sprite
                visibleBlocks[i][j] = blockMap.get(blockY).charAt(blockX);
            }
        }
    }

    public void loadBlockMap(URL codeBase, String levelName, String roomName) {

        //Create blockMap array
        try {

            //Load the textfile for blockmap
            br = new BufferedReader(new InputStreamReader(new URL(codeBase, "../share/txt/maps/" + levelName + "/" + roomName + "/blockmap.txt").openStream()));

            try {

                //Loop through lines in textfile
                String line;
                int i = 0;
                while ((line = br.readLine()) != null) {

                    blockMap.add(line);

                    //Search for spawn block
                    if (line.contains("1")) {
                        spawnX = line.indexOf("1");
                        spawnY = i;
                    }

                    i++;

                }

                br.close();

            } catch (IOException e) {
            }

        } catch (FileNotFoundException e) {
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
    }
}
