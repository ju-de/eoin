package dmcigd.core.objects;

public abstract class AnimationHandler {
	
	//Animation Status
	private int sequence;
	private float frame;
	public boolean flipped;
	
	private int[] frameLimits;
	private float frameSpeed = 0.1f;
	private boolean[] animationLoops;
	
	//Public Getters
	public int getSequence() {
		return sequence;
	}
	public int getFrame() {
		return (int) frame;
	}
	
	//Public Setters
	public void setFrame(int frame) {
		this.frame = frame;
	}
	public void setSequence(int sequence) {
		if(this.sequence != sequence) {
			frame = 0;
                        this.sequence = sequence; // moved inside if statement (efficiency)
		}
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
