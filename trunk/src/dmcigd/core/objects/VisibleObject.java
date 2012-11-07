package dmcigd.core.objects;

public abstract class VisibleObject implements Cloneable {
	
	//Initialize displacement properties for resting objects
	private int dx,dy = 0;
	
	//Image information
	private String mapCode;
	private String imagePath;
	
	//Object Positions
	private int x,y = 0;
	
	//Object Dimensions
	private int height,width = 32;
	private int imageHeight,imageWidth = 32;
	
	//Animation Status
	private int sequence;
	private float frame;
	public boolean flipped;
	
	private int[] frameLimits;
	private float frameSpeed = 0.1f;
	private boolean[] animationLoops;
	
	//Public Getters
	
	public String getMapCode() {
		return mapCode;
	}
	public String getImagePath() {
		return imagePath;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getDX() {
		return dx;
	}
	public int getDY() {
		return dy;
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
	
	public boolean isVisible(int viewX, int viewY) {
		
		int relX = x - viewX + 310 - ((imageWidth - width) / 2);
		int relY = y - viewY + 144 - ((imageHeight - height)  - 2);
		
		if(relX + imageWidth >= 0 && relX <= 640 && relY + imageHeight >= 0 && relY <= 320) {
			return true;
		}else {
			return false;
		}
	}
	public ObjectImage getObjectImage(int viewX, int viewY) {
		return new ObjectImage(mapCode, viewX, viewY, x, y, width, height, imageWidth, imageHeight, (int) frame, sequence, flipped);
	}
	
	//Public Setters
	public void setMapCode(String mapCode) {
		this.mapCode = mapCode;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public void setX(int x) {
		dx = x - this.x;
		this.x = x;
	}
	public void setY(int y) {
		dy = y - this.y;
		this.y = y;
	}
	public void addX(int vx) {
		dx = vx;
		x = x + vx;
	}
	public void addY(int vy) {
		dy = vy;
		y = y + vy;
	}
	public void setDX(int dx) {
		this.dx = dx;
	}
	public void setDY(int dy) {
		this.dy = dy;
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
