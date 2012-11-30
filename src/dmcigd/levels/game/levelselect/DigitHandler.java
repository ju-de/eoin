package dmcigd.levels.game.levelselect;

import dmcigd.core.objects.TextLabel;
import dmcigd.core.objects.player.*;
import dmcigd.core.room.*;

public class DigitHandler {

	private Digit[] digitList;
	private int digitCounter;
	private Room room;
	
	public DigitHandler(Digit[] digitList, Room room) {
		this.digitList = digitList;
		this.room = room;
	}
	
	public void setDigit(String value, Player player) {
		digitList[digitCounter].setValue(value);
		digitCounter++;
		if(digitCounter == 9) {
			String targetRoom = SaveCodeHandler.levelCodes.get(digitList[5].getValue()+digitList[6].getValue()+digitList[7].getValue()+digitList[8].getValue());
			if(targetRoom != null) {
				player.sword.addKillCount(SaveCodeHandler.killCount(
						digitList[0].getValue()+
						digitList[1].getValue()+
						digitList[2].getValue()+
						digitList[3].getValue()+
						digitList[4].getValue()
						));
				player.setRoom(targetRoom);
			} else {
				room.addTextLabel(new TextLabel(15 * 32, 13 * 32, "INCORRECT SAVE CODE", false));
				clearValues();
			}
		}
	}
	
	public void clearValues() {
		digitCounter = 0;
		digitList[0].setValue(" ");
		digitList[1].setValue(" ");
		digitList[2].setValue(" ");
		digitList[3].setValue(" ");
		digitList[4].setValue(" ");
		digitList[5].setValue(" ");
		digitList[6].setValue(" ");
		digitList[7].setValue(" ");
		digitList[8].setValue(" ");
	}
}
