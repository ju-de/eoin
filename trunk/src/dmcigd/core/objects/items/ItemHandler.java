package dmcigd.core.objects.items;

import dmcigd.core.objects.Entity;

public class ItemHandler extends Entity {
	
	private boolean held = false;
	
	public void setHeld(boolean held) {
		this.held = held;
	}

	
	public void step() {
		if(!held) {
			move();
			if(hitGround) {
				setVX(0);
			}
		}
	}
}
