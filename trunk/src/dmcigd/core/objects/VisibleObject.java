package dmcigd.core.objects;

public class VisibleObject {
	
	//Image Loader
	
	private int sequence;
	private float frame;
	
	private int[] frameLimits;
	private boolean[] animationLoops;
	
	//Public Getters
	public int getSequence() {
		return sequence;
	}
	public int getFrame() {
		return (int) frame;
	}
	
	//Public Setters
	public void setSequence(int sequence) {
		if(this.sequence != sequence) {
			frame = 0;
		}
		this.sequence = sequence;
	}
	public void setFrameLimits(int[] frameLimits) {
		this.frameLimits = frameLimits;
	}
	public void setAnimationLoops(boolean[] animationLoops) {
		this.animationLoops = animationLoops;
	}
	
	//Animate
	public void animate() {
		if(frame + 0.05f < frameLimits[sequence]) {
			frame = frame + 0.05f;
		} else if (animationLoops[sequence]) {
			frame = 0;
		}
	}
	
}
