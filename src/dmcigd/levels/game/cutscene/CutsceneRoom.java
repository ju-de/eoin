package dmcigd.levels.game.cutscene;

import java.net.URL;
import java.util.ArrayList;

import dmcigd.core.objects.TextLabel;
import dmcigd.core.objects.ObjectImage;
import dmcigd.core.room.*;

public class CutsceneRoom extends Room {
	
	private CutsceneRegion cutsceneRegion;
	
	public void fetchVisibleObjects() {
		
		visibleObjects = new ArrayList<ObjectImage>();
		
		ObjectImage cutsceneObjectImage = cutsceneRegion.getObjectImage(310, 144);
		cutsceneObjectImage.srcx2 *= 2;
		cutsceneObjectImage.srcy1 *= 2;
		cutsceneObjectImage.srcy2 *= 2;
		
		visibleObjects.add(cutsceneObjectImage);
	}

	public CutsceneRoom(URL codeBase, String cutsceneImagePath, int cutsceneSlides, String destinationRoom) {
		
		super(codeBase, "game", "CutsceneRoom", "grassy");
		
		cutsceneRegion = new CutsceneRegion(cutsceneImagePath, cutsceneSlides, destinationRoom);
		
	}

	public void initializeRoom() {
		addRegion(cutsceneRegion);
		addTextLabel(new TextLabel(470, 350, "Press \"X\" to continue", false));
	}

}
