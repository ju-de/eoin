package dmcigd.core.objects;

public class ObjectImage {
	
	public int dstx1,dsty1,dstx2,dsty2,srcx1,srcy1,srcx2,srcy2;
	
	public ObjectImage(int viewX, int viewY, int x, int y, int width, int height, int imageWidth, int imageHeight, int frame, int sequence, boolean flipped) {
		
		//Get relative positions to screen
		int relX = viewX - x + 310;
		int relY = viewY - y + 144;
		
		//Centers bounding box inside of image
		relX = relX - ((imageWidth - width) / 2);
		
		//Adds 2px of padding to the image bottom for ground overlap
		relY = relY - ((imageHeight - height) - 2);
		
		//Flips dstx1 and dstx2 if image is flipped
		if(flipped) {
			dstx2 = relX;
			dstx1 = relX + imageWidth;
		} else {
			dstx1 = relX;
			dstx2 = relX + imageWidth;
		}
		
		//Assigns Y values to top and bottom of image
		dsty1 = relY;
		dsty2 = relY + imageHeight;
		
		//Get relative positions to spritesheet
		//Halves quantities to convert display pixels to image pixels
		srcx1 = (frame * imageWidth) / 2;
		srcx2 = srcx1 + (imageWidth / 2);
		
		srcy1 = (sequence * imageHeight) / 2;
		srcy2 = srcy1 + (imageHeight / 2);
		
	}
}
