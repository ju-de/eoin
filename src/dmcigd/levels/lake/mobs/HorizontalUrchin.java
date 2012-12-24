package dmcigd.levels.lake.mobs;

import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.player.Player;

public class HorizontalUrchin extends Urchin implements SolidObject {

	public HorizontalUrchin(int x, int y, int distance, boolean upsideDown, Player player) {
		super(x, y, distance, player);
		
		setWidth(28);
		setHeight(16);
		setImageWidth(32);
		setImageHeight(20);
		
		setImagePath("objects/lake/horizontalurchin.gif");
		
		if(upsideDown) {
			setVX(-1);
			setSequence(1);
		} else {
			addY(16);
			setVX(1);
			setSequence(0);
		}
	}

}
