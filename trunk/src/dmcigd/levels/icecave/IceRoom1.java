package dmcigd.levels.icecave;

import java.net.URL;

import dmcigd.core.objects.regions.*;
import dmcigd.core.room.*;

public class IceRoom1 extends Room implements Runnable{
	public IceRoom1(URL codeBase) {
		super(codeBase, "icecave", "IceRoom1", "icy");
	}
	public void initializeRoom(){
		IcicleProjectile icicle1 = new IcicleProjectile(42 * 32, 30 * 32, getBlockMap(), getSolidObjects());
		addSolidObject(icicle1);
		addRegion(new IcicleTrigger(42 * 32, 31 * 32, 1, 3, icicle1));
		
		IcicleProjectile icicle2 = new IcicleProjectile(50 * 32, 30 * 32, getBlockMap(), getSolidObjects());
		addSolidObject(icicle2);
		addRegion(new IcicleTrigger(50 * 32 - 16, 31 * 32, 1, 3, icicle2));
		
		addRegion(new WendigoNpc(18 * 32 + 6, 31 * 32, "Mysterious Figure",
				"FNORD", getDialogueHandler()));
		
		addRegion(new RoomPassage(66 * 32, 33 * 32, "icecave.IceRoom2"));
	}
}
