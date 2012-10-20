package dmcigd.core.objects;

import java.awt.*;
import java.io.*;

import javax.imageio.ImageIO;

public class VisibleObject {
	
	private int sequence;
	private float frame;
	
	private int[] frameLimits;
	
	private Image spriteSheet;
	
	//Public Getters
	public int getSequence() {
		return sequence;
	}
	public int getFrame() {
		return (int) frame;
	}
	public Image getImage() {
		return spriteSheet;
	}
	
	//Public Setters
	public void setSequence(int sequence) {
		if(this.sequence != sequence) {
			frame = 0;
		}
		this.sequence = sequence;
	}
	public void setImage(String path) {
		try {
			spriteSheet = ImageIO.read(new File("../share/gfx/"+path));
		} catch (IOException e) {}
	}
	public void setFrameLimits(int[] frameLimits) {
		this.frameLimits = frameLimits;
	}
	
	//Animate
	public void animate() {
		if(frame + 0.05f < frameLimits[sequence]) {
			frame = frame + 0.05f;
		} else {
			frame = 0;
		}
	}
	
}
