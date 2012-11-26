/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dmcigd.core.objects.particles;

/**
 *
 * @author filip
 */
public class GravityParticle extends StraightLineParticle {
    
    public static float GRAVITY = 0.5f;
    
    public GravityParticle(float x, float y, float vx, float vy, int lifeTime, String imagePath){
        super(x, y, vx, vy, lifeTime, imagePath);
    }
    
    public void move(){
        x += vx;
        y += vy;
        vy += GRAVITY;
    }
}
