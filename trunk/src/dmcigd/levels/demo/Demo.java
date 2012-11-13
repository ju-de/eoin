package dmcigd.levels.demo;

import dmcigd.core.objects.blocks.*;
import dmcigd.core.objects.platforms.*;
import dmcigd.core.objects.items.*;
import dmcigd.core.objects.regions.*;
import dmcigd.core.objects.npc.*;
import dmcigd.core.room.*;

import java.net.*;

public class Demo extends Room implements Runnable {
	
	public Demo(URL codeBase) {
		super(codeBase, "demo", "Demo", "grassy");
	}
	
	public void initializeSolidObjects() {
				
		addSolidObject(new PushableBlock(832, 480, getBlockMap(), getSolidObjects()));

		addSolidObject(new LockedDoor(992, 480, 1));
		
		addSolidObject(new LockedDoor(1088, 480, 2));
		
		addSolidObject(new MovingPlatform(1920, 384, 1, 6, 1, 6));
		
		addSolidObject(new MovingPlatform(1952, 480, 0, 6, 1, 6));
		
		addSolidObject(new PushableBlock(2048, 416, getBlockMap(), getSolidObjects()));
		
		addSolidObject(new MovingPlatform(5184, 480, 1, 1, 1, 14));
		
		addSolidObject(new MovingPlatform(5760, 896, 0, 8, 1, 20));
		
		addSolidObject(new MovingPlatform(7200, 864, 0, 3, 1, 7));
		
		addSolidObject(new CrumblingBlock(960, 256, 0.15f, 500));
		
		addSolidObject(new TimedBlock(1312, 512, 1, 0, 100, 100));
		
		addSolidObject(new CrumblingBlock(2016, 544, 0.15f, 500));
		addSolidObject(new CrumblingBlock(2048, 544, 0.15f, 500));
		addSolidObject(new CrumblingBlock(2080, 544, 0.15f, 500));
		addSolidObject(new CrumblingBlock(2112, 544, 0.15f, 500));
		
		addSolidObject(new TimedBlock(5184, 736, 5, 0, 300, 100));
		
		addSolidObject(new CrumblingBlock(5792, 448, 0.15f, 500));
		
		addSolidObject(new CrumblingBlock(5952, 416, 0.15f, 500));
		
		addSolidObject(new TimedBlock(180 * 32, 704, 1, 17 * 16, 32, 288));
		addSolidObject(new TimedBlock(181 * 32, 704, 1, 16 * 16, 32, 288));
		addSolidObject(new TimedBlock(182 * 32, 704, 1, 15 * 16, 32, 288));
		addSolidObject(new TimedBlock(183 * 32, 704, 1, 14 * 16, 32, 288));
		addSolidObject(new TimedBlock(184 * 32, 704, 1, 13 * 16, 32, 288));
		addSolidObject(new TimedBlock(185 * 32, 704, 1, 12 * 16, 32, 288));
		addSolidObject(new TimedBlock(186 * 32, 704, 1, 11 * 16, 32, 288));
		addSolidObject(new TimedBlock(187 * 32, 704, 1, 10 * 16, 32, 288));
		addSolidObject(new TimedBlock(188 * 32, 704, 1, 9 * 16, 32, 288));
		addSolidObject(new TimedBlock(189 * 32, 704, 1, 8 * 16, 32, 288));
		addSolidObject(new TimedBlock(190 * 32, 704, 1, 7 * 16, 32, 288));
		addSolidObject(new TimedBlock(191 * 32, 704, 1, 6 * 16, 32, 288));
		addSolidObject(new TimedBlock(192 * 32, 704, 1, 5 * 16, 32, 288));
		addSolidObject(new TimedBlock(193 * 32, 704, 1, 4 * 16, 32, 288));
		addSolidObject(new TimedBlock(194 * 32, 704, 1, 3 * 16, 32, 288));
		addSolidObject(new TimedBlock(195 * 32, 704, 1, 2 * 16, 32, 288));
		addSolidObject(new TimedBlock(196 * 32, 704, 1, 16, 32, 288));
		addSolidObject(new TimedBlock(197 * 32, 704, 1, 0, 32, 288));
		
	}
	
	public void initializeNonsolidObjects() {
		
		addItem(new DoorKey(416, 416, 1, getBlockMap(), getSolidObjects()));
		addItem(new DoorKey(736, 416, 2, getBlockMap(), getSolidObjects()));
		
		addRegion(new Passage(416, 480, 2112, 320));
		addRegion(new Passage(2112, 320, 416, 480));
		addRegion(new Sign(416, 416, 8, "Who do you think you are?", "Just going around taking random keys. Maybe those keys belong to somebody. Maybe those keys have a family", getDialogueHandler()));
		addRegion(new Sign(512, 384, 6, "Long Test Sign. Heh.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam elit purus, ornare id facilisis sed, sodales id leo. Nam sit amet turpis vitae justo eleifend ornare ultricies eu est. Etiam enim eros, adipiscing quis congue id, malesuada vitae nisi. Mauris orci quam, posuere et adipiscing vulputate, adipiscing ac metus.Nullam odio nibh, consequat id porttitor vitae, sodales nec nisi. Fusce neque tellus, condimentum eu facilisis eu, dictum a eros. In nec est scelerisque arcu egestas sagittis. Etiam cursus justo at dui pellentesque quis molestie erat aliquam. Integer tincidunt urna at tellus luctus laoreet.", getDialogueHandler()));
		addRegion(new Sign(670, 352, 3, "Test Sign", "Please Ignore", getDialogueHandler()));
		addRegion(new Sign(800, 224, 6, "The truth is...", "Your mother is a very sultry individual with whom I have commited several acts of adultery.", getDialogueHandler()));
		addRegion(new Sign(896, 224, 9, "And in case you were wondering", "She is very gifted at her trade and a true craftsman. I must commend the quality and mastership she demonstrates at such a fine art.", getDialogueHandler()));
		addRegion(new Sign(2176, 320, 4, "STOP ASKING SO MANY QUESTIONS", "NO I DO NOT KNOW WHY THERE'S A RANDOM TUNNEL OPENING IN THE MIDDLE OF THE SKY.", getDialogueHandler()));
		addRegion(new Sign(6720, 512, 5, " ", "FNORD", getDialogueHandler()));
		
		addRegion(new RoomWarp(6720, 512, 32, 32, "demo", "DemoTwo"));
		
		addRegion(new DemoProjectileSpawner(400, 320, getProjectiles(), getBlockMap(), getSolidObjects()));
		
	}
}
