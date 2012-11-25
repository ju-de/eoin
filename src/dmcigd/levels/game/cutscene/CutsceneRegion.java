package dmcigd.levels.game.cutscene;

import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.player.Player;

public class CutsceneRegion extends ObjectCollision implements Region {
	
	private int cutsceneSlide = 0;
	private int cutsceneSlideLimit;
	private String destinationRoom;
	
	public CutsceneRegion (String cutsceneImageName, int cutsceneSlideLimit, String destinationRoom) {
		
		setX(0);
		setY(0);
		setHeight(318);
		setWidth(640);
		setImageHeight(320);
		setImageWidth(640);
		
		setSequence(0);
		setFrame(0);
		
		setImagePath("cutscenes/"+cutsceneImageName);
		
		this.cutsceneSlideLimit = cutsceneSlideLimit;
		this.destinationRoom = destinationRoom;
	}

	public void step() { }

	public void onHover(Player player) { }

	public void interact(Player player) {
		if(cutsceneSlide >= cutsceneSlideLimit-1) {
			player.setRoom(destinationRoom);
		} else {
			cutsceneSlide++;
			setSequence(cutsceneSlide);
		}
	}

}
