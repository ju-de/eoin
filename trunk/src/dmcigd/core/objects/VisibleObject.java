package dmcigd.core.objects;

public abstract class VisibleObject extends AnimationHandler {
	
	//Initialize displacement properties for resting objects
	private int dx,dy = 0;
	
	//Image information
	private String imagePath;
	
	//Object Positions
	private int x,y = 0;
	
	//Object Dimensions
	private int height,width = 0;
	private int imageHeight,imageWidth = 32;
	
	//Public Getters
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
	
	public int relX(int viewX, int viewY) {
		return x - viewX + 310 - ((imageWidth - width) / 2);
	}
	
	public int relY(int viewX, int viewY) {
		return y - viewY + 144 - ((imageHeight - height)  - 2);
	}
	
	public boolean isVisible(int viewX, int viewY) {
		
		int relX = relX(viewX, viewY);
		int relY = relY(viewX, viewY);
		
		if(relX + imageWidth >= 0 && relX <= 640 && relY + imageHeight >= 0 && relY <= 320) {
			return true;
		}else {
			return false;
		}
	}
	public ObjectImage getObjectImage(int viewX, int viewY) {
		return new ObjectImage(imagePath, relX(viewX, viewY), relY(viewX, viewY), x, y, width, height, imageWidth, imageHeight, getFrame(), getSequence(), flipped);
	}
	
	//Public Setters
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
	
}
