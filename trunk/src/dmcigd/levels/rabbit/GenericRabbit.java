package dmcigd.levels.rabbit;

import dmcigd.core.objects.interfaces.Region;
import dmcigd.core.objects.npc.SimpleNpc;
import dmcigd.core.room.DialogueHandler;

public class GenericRabbit extends SimpleNpc implements Region {
    
	public GenericRabbit (int x, int y, int width, int height, int frameLimit, float frameSpeed, String fileName, String name, String message, DialogueHandler dialogueHandler) {
		
		super(x, y, name, message, dialogueHandler);
		
		setWidth(width);
		setHeight(height-2);
		setImageWidth(width);
		setImageHeight(height);
		
		setSequence(0);
		setFrame(0);
		
		setFrameLimits(new int[] {frameLimit});
		setAnimationLoops(new boolean[] {true});
		setFrameSpeed(frameSpeed);
		
		setImagePath("objects/rabbit/"+fileName);
		
	}
	
	public void step() {
		animate();
	}
}
