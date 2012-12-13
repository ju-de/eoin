package dmcigd.levels.faerie;

import java.net.URL;

import dmcigd.core.objects.blocks.*;
import dmcigd.core.room.*;


public class One extends Room implements Runnable {
	
	public One(URL codeBase) {
		super(codeBase, "faerie", "One", "foresty");
	}
        
	public void initializeRoom() {
		
		
		addSolidObject(new CrumblingBlock(63 * 32, 49 * 32, 0.2f, 500));
		addSolidObject(new CrumblingBlock(66 * 32, 48 * 32, 0.2f, 500));
		addSolidObject(new CrumblingBlock(70 * 32, 47 * 32, 0.2f, 500));
		addSolidObject(new CrumblingBlock(73 * 32, 47 * 32, 0.2f, 500));
		addSolidObject(new CrumblingBlock(79 * 32, 49 * 32, 0.2f, 500));
		addSolidObject(new CrumblingBlock(82 * 32, 48 * 32, 0.2f, 500));
		
		addSolidObject(new CrumblingBlock(98 * 32, 49 * 32, 0.2f, 500));
		addSolidObject(new CrumblingBlock(99 * 32, 49 * 32, 0.2f, 500));
		addSolidObject(new CrumblingBlock(100 * 32, 49 * 32, 0.2f, 500));
		addSolidObject(new CrumblingBlock(101 * 32, 49 * 32, 0.2f, 500));
		addSolidObject(new CrumblingBlock(102 * 32, 49 * 32, 0.2f, 500));
		
		addSolidObject(new CrumblingBlock(117 * 32, 50 * 32, 0.2f, 500));
		addSolidObject(new CrumblingBlock(117 * 32, 51 * 32, 0.2f, 500));
		addSolidObject(new CrumblingBlock(117 * 32, 52 * 32, 0.2f, 500));
		addSolidObject(new CrumblingBlock(122 * 32, 52 * 32, 0.2f, 500));
		addSolidObject(new CrumblingBlock(122 * 32, 53 * 32, 0.2f, 500));
		addSolidObject(new CrumblingBlock(5127 * 32, 52 * 32, 0.2f, 500));
		
		addSolidObject(new CrumblingBlock(50 * 32, 146 * 32, 0.2f, 500));
		addSolidObject(new CrumblingBlock(41 * 32, 148 * 32, 0.2f, 500));
		addSolidObject(new CrumblingBlock(53 * 32, 151 * 32, 0.2f, 500));
		addSolidObject(new CrumblingBlock(55 * 32, 154 * 32, 0.2f, 500));
		addSolidObject(new CrumblingBlock(56 * 32, 161 * 32, 0.2f, 500));
		addSolidObject(new CrumblingBlock(56 * 32, 162 * 32, 0.2f, 500));
		addSolidObject(new CrumblingBlock(57 * 32, 163 * 32, 0.2f, 500));
		
	}
}
