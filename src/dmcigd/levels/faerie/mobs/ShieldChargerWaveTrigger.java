package dmcigd.levels.faerie.mobs;

import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.player.Player;
import dmcigd.core.room.*;

public class ShieldChargerWaveTrigger extends ObjectCollision implements Region {
	
	private boolean triggered = false;
	private Room room;
	private String[] waveShape;
	
	public ShieldChargerWaveTrigger(int y, String[] waveShape, Room room) {
		
		setX(1248);
		setY(y);
		setHeight(1);
		setWidth(672);
		setImageHeight(0);
		setImageWidth(0);
		
		setSequence(0);
		setFrame(0);
		
		setImagePath("objects/faerie/shieldcharger.gif");
		
		this.room = room;
		this.waveShape = waveShape;
		
	}

	public void step() {}

	public void onHover(Player player) {
		if(!triggered) {
			triggered = true;
			
			for(int i = waveShape.length - 1; i > -1; i--) {
				int yPos = (int) getY() - 480 + (i*2*32);
				for(int j = 0; j < 11; j++) {
					if(waveShape[i].charAt(j) == 'm') {
						int xPos = (44 + j) * 32 + 2;
						boolean side = false;
						if(j > 4) {
							side = true;
						}
						
						room.addSolidObject(new ShieldCharger(xPos, yPos, side, room.getPhysicsHandler()));
					}
				}
			}
		}
	}

	public void interact(Player player) {}

}
