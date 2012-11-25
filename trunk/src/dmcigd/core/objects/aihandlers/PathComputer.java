/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dmcigd.core.objects.aihandlers;

import dmcigd.core.enums.*;
import dmcigd.core.objects.player.Player;
import dmcigd.core.room.*;
import java.util.LinkedList;

/**
 * The PathComputer, the only thing which will ever tell you "nun shall pass". 
 * Avert your eyes, ye fools, lest ye lose yer sanity in gazing upon so eldritch 
 * a beast. No srsly, the algorithm is complicated.
 * 
 * @author filip
 */
public class PathComputer {
    
    private Room currentRoom;
    
    private static final float ROOT2 = (float) Math.sqrt(2);
    
    private float[][] distancesToPlayer = new float[12][22];
    
    public void floodFillDistancesToPlayer(){
        for (float[] ar : distancesToPlayer){
            for (int i = 0; i < ar.length;i++){
                ar[i] = 999;
            }
        }
        
        Player player  = currentRoom.getPlayer();
        int xMid = player.getX() / 32;
        int yMid = player.getY() / 32;
        
        LinkedList<Point> queue = new LinkedList<Point>();
        
        // add's player's location to queue
        queue.add(new Point(10, 5, 0));
        
        while (!queue.isEmpty()){
            // pop next location off queue
            Point p = queue.pop();
            
            // skip if off the edge
            if (p.x < 0) continue;
            if (p.x > 21) continue;
            if (p.y < 0) continue;
            if (p.y > 11) continue;
            
            // skip if in a solid block
            // note that this check must be made direction-dependent
            CollisionType collisionType = currentRoom.getBlockMap().tileType(
                    currentRoom.getBlockMap().getVisibleBlocks(xMid, yMid)
                        [p.y + yMid - 5]   // these numbers might be off
                        [p.x + xMid - 10] // 
                    );
            if (collisionType != CollisionType.NONSOLID && collisionType == CollisionType.NONSOLIDLADDER ){
                continue;
            }
            
            // skip if not minimum distance
            if (p.dist >= distancesToPlayer[p.y][p.x]) {
                continue; 
            }
            
            
            // update location with minimum
            distancesToPlayer[p.y][p.x] = p.dist;
            
            // add next points to queue
            queue.add(new Point(p.x - 1, p.y, p.dist + 1)); // von neumann neighbors
            queue.add(new Point(p.x + 1, p.y, p.dist + 1));
            queue.add(new Point(p.x, p.y - 1, p.dist + 1));
            queue.add(new Point(p.x, p.y + 1, p.dist + 1));
            
            queue.add(new Point(p.x + 1, p.y + 1, p.dist + ROOT2)); // these 4 not strictly necessary
            queue.add(new Point(p.x + 1, p.y - 1, p.dist + ROOT2)); // moore neighbors
            queue.add(new Point(p.x - 1, p.y + 1, p.dist + ROOT2));
            queue.add(new Point(p.x - 1, p.y - 1, p.dist + ROOT2));
            
        }
        
    }
    
}

class Point{
    public int x, y; public float dist;
    public Point(int x, int y, float dist){this.x = x; this.y = y; this.dist = dist;}
}