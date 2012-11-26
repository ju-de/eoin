/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dmcigd.core.objects.particles;

/**
 *
 * @author filip
 */
public class BrownianParticle extends Particle{

    public int stepSize = 3;
    public int maxWalk = 100;
    private int walked = 0;
    
    public BrownianParticle(float x, float y, int stepSize, int maxWalk, String imagePath){
        this.stepSize = stepSize;
        this.maxWalk = maxWalk;
        this.setImagePath(imagePath);
        this.setImageHeight(16);
        this.setImageWidth(16);
        setSequence(0);
        setFrame(0);
        this.setX(x);
        this.setY(y);
    }
    
    @Override
    public void move() {
        int xdist = (int) (generator.nextGaussian() * stepSize * 2 ); // all directions equally likely with gaussian x&y
        int ydist = (int) (generator.nextGaussian() * stepSize * 2 ); 
        walked += (xdist > 0? xdist : -xdist) + (ydist > 0? ydist:-ydist); // manhattan distance
        this.setX(this.getX() + xdist);
        this.setY(this.getY() + ydist);
    }

    @Override
    public void updateLifeSpan() {
        isDestroyed = walked > maxWalk;
    }
    
}
