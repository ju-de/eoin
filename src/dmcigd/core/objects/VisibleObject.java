package dmcigd.core.objects;

public class VisibleObject {
	
	//Object Positions
	private int x = 0;
	private int y = 0;
	
	//Object Dimensions
	private int height = 32;
	private int width = 32;
	private int imageHeight = 32;
	private int imageWidth = 32;
	
	//Animation Status
	private int sequence;
	private float frame;
	public boolean flipped;
	
	private int[] frameLimits;
	private float frameSpeed = 0.1f;
	private boolean[] animationLoops;
	
	//Public Getters
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	public int getImageHeight() {
		return imageHeight;
	}
	public int getImageWidth() {
		return imageWidth;
	}
	
	public int getSequence() {
		return sequence;
	}
	public int getFrame() {
		return (int) frame;
	}
	
	//Public Setters
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void addX(int vx) {
		x = x + vx;
	}
	public void addY(int vy) {
		y = y + vy;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setImageHeight(int imageHeight) {
		this.imageHeight = imageHeight;
	}
	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}
	
	
	public void setFrame(int frame) {
		this.frame = frame;
	}
	public void setSequence(int sequence) {
		if(this.sequence != sequence) {
			frame = 0;
		}
		this.sequence = sequence;
	}
	
	public void setFrameLimits(int[] frameLimits) {
		this.frameLimits = frameLimits;
	}
	public void setFrameSpeed(float frameSpeed) {
		this.frameSpeed = frameSpeed;
	}
	public void setAnimationLoops(boolean[] animationLoops) {
		this.animationLoops = animationLoops;
	}
	
	//Animate
	public void animate() {
		if(frame + frameSpeed < frameLimits[sequence]) {
			frame = frame + frameSpeed;
		} else if (animationLoops[sequence]) {
			frame = 0;
		}
	}
	
}
