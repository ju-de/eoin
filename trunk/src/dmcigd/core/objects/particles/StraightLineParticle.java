/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dmcigd.core.objects.particles;

/**
 *
 * @author filip
 */
public class StraightLineParticle extends Particle {

    public float vx, vy;
    public int lifeTime = 100;
    private int age = 0;
    
    protected double x;
    protected double y;
    
    public int getX(){
        return (int) x;
    }
    public int getY(){
        return (int) y;
    }
    public void setX(int x){this.x = x;}
    public void setY(int y){this.y = y;}
    
    public StraightLineParticle(int x, int y, float vx, float vy, int lifeTime, String imagePath){
        this.vx = vx;
        this.vy = vy;
        this.lifeTime = lifeTime;
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
        x += vx;
        y += vy;
    }

    @Override
    public void updateLifeSpan() {
        age++;
        isDestroyed =  age > lifeTime;
    }
    
}
