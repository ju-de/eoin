package dmcigd.core.objects.interfaces;

import dmcigd.core.objects.player.*;

public interface Region extends GameObject{

	public void onHover();
	public void interact(Player player);
	
}
