package dmcigd.core.objects.items;

import java.util.ArrayList;

import dmcigd.core.enums.EntityType;
import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.maps.BlockMap;

public class DoorKey extends Entity implements Item {
	
	int type;
	
	boolean used = false;
	
	public boolean isUsed() {
		return used;
	}
	
	public void pushedObject(SolidObject object, int v) {
		if(object.getMapCode() == "`" && object.getSequence() == 4 && object.getFrame() == 9) {
			used = true;
		}
	}
	
	public DoorKey(int x, int y, int type, BlockMap blockMap, ArrayList<SolidObject> solidObjects) {
		
		setX(x + 6);
		setY(y);
		setDX(0);
		setDY(0);
		setHeight(24);
		setWidth(20);
		setImageHeight(32);
		setImageWidth(32);
		
		setSequence(4);
		setFrame(type + 3);
		
		setMapCode("`");
		setImagePath("demo/objects.gif");
		
		switch (type) {
			case 4:
				setEntityType(EntityType.KEY4);
				break;
			case 3:
				setEntityType(EntityType.KEY3);
				break;
			case 2:
				setEntityType(EntityType.KEY2);
				break;
			default:
				setEntityType(EntityType.KEY1);
				break;
		}
		
		setBlockMap(blockMap);
		setSolidObjects(solidObjects);
		setGravity();
		
		this.type = type;
		
	}
	
	public void step() {
		move();
		if(hitGround) {
			setVX(0);
		}
	}
}
