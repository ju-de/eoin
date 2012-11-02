package dmcigd.core.objects.interfaces;

import dmcigd.core.objects.player.*;

public interface Region extends GameObject{

	public void onHover(Player player);
	public void interact(Player player);
	
}
