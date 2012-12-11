package dmcigd.levels.deer;

import dmcigd.core.enums.EntityType;
import dmcigd.core.objects.Entity;
import dmcigd.core.objects.ObjectCollision;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.player.Player;
import dmcigd.core.room.*;

public class WitchDoctor extends ObjectCollision implements Region {

	private BossRoom room;
	private DialogueHandler dialogueHandler;
	private int questState = 0;
	
	public WitchDoctor(int x, int y, BossRoom room) {
		
		setX(x);
		setY(y-10);
		
		setWidth(26);
		setHeight(42);
		setImageWidth(26);
		setImageHeight(44);
		
		setSequence(0);
		setFrame(0);
		
		setFrameLimits(new int[] {4});
		setAnimationLoops(new boolean[] {true});
		setFrameSpeed(0.02f);
		
		setImagePath("objects/deer/witchdoctor.gif");
		
		this.room = room;
		this.dialogueHandler = room.getDialogueHandler();
		
	}

	public void step() {
		if(questState == 2) {
			questState = 3;
			room.getPlayer().heldItem = null;
			room.getPlayer().interact();
		} else if (questState == 4) {
			questState = 5;
			room.getPlayer().interact();
		}
		animate();
	}

	public void onHover(Player player) {}

	public void interact(Player player) {
		if(player.heldItem != null &&  player.heldItem.getEntityType() == EntityType.QUESTITEM1 && questState < 2) {
			dialogueHandler.setDialogue(new String[][] {
					{"Witch Doctor","You've brought the curing herb! Our village will forever be indebted to you, young one."}
			});
			((Entity) player.heldItem).isDestroyed = true;
			Medicine medicine = new Medicine((int) room.getPlayer().getX(), (int) room.getPlayer().getY() + 14, room.getPhysicsHandler());
			room.addItem(medicine);
			room.em.lockTo(medicine);
			questState = 2;
		} else {
			switch(questState) {
				case 5:
					dialogueHandler.setDialogue(new String[][] {
							{"Witch Doctor", "You are brave, young one, but beware, for The Guardian does not "
								+ "protect the cave from us, but protects us from the cave. Great evil emerges from the caves, young one."}
					});
					break;
				case 3:
					dialogueHandler.setDialogue(new String[][] {
							{"Witch Doctor","Wait, before you go, take some of this medicine. It is a small gift but it is all I can give."
									+ "\nThe path has been rather dangerous as of late, for the illness "
									+ "has fallen not just us, but on the wolves as well." }
					});
					questState = 4;
					break;
				case 1:
					dialogueHandler.setDialogue(new String[][] {
							{"Witch Doctor","Please help, young one, our people are dying as we speak."}
					});
					break;
				case 0:
					dialogueHandler.setDialogue(new String[][] {
							{"Witch Doctor","Young one, our village is in dire need of your help! "
								+ "An illness has fallen upon us, and I am too frail to reach "
								+ "the curing herb, for the path is treacherous and I am old and weak."}
					});
					questState = 1;
					break;
				default:
					break;
			}
		}
	}
}
