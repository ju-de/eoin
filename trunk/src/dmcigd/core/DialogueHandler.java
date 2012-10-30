package dmcigd.core;

import java.util.*;

public class DialogueHandler {
	
	//Sorry, this code is still really messy
	//Somebody remind me to go back and clean this up later
	//In a nutshell, it takes a list of lines of dialogue
	//Chunks it off into pages
	//And progresses through it line by line
	
	public boolean inDialogue = false;

	public ArrayList<String[]> dialogueList = new ArrayList<String[]>();
	public int dialoguePosition = -1;
	
	public String avatarImageCode, name, line1, line2, line3;
	
	//Full method for consecutive items of dialogue
	public void setDialogue(ArrayList<String[]> dialogue) {
		//Reset variables
		avatarImageCode = null;
		name = null;
		line1 = null;
		line2 = null;
		line3 = null;
		dialogueList = new ArrayList<String[]>();
		dialoguePosition = 0;
		
		//Loop through pieces of dialogue
		for(String[] i : dialogue) {
			
			//Word wrap dialogue text
			StringBuilder sb = new StringBuilder(i[2]);
			
			int j = 0;
			while((j = sb.indexOf(" ", j + 42)) != -1) {
				sb.replace(j, j + 1, "\n");
			}
			
			String[] textBlock = sb.toString().split("\n");
			
			//Create multiple entries if the dialogue is more than 3 lines long
			//Allows for scrolling through dialogue line by line
			if(textBlock.length >= 3) {
				
				j = 0;
				do {
					String[] dialogueItem = {i[0], i[1], textBlock[j], textBlock[j+1], textBlock[j+2]};
					j++;
					dialogueList.add(dialogueItem);
				} while ( j + 2 < textBlock.length);
				
			} else {
				//Create single entry if dialogue is less than 3 lines long
				String[] dialogueItem = new String[5];
				dialogueItem[0] = i[0];
				dialogueItem[1] = i[1];
				
				dialogueItem[2] = textBlock[0];
				if(textBlock.length > 1) {
					dialogueItem[3] = textBlock[1];
				} else {
					dialogueItem[3] = null;
				}
				dialogueItem[4] = null;
				dialogueList.add(dialogueItem);
			}
		}
		
		progressDialogue();
		inDialogue = true;
	}
	
	//Shorthand method for single items of dialogue
	public void setDialogue(String avatarImageCode, String name, String message) {
		
		//Create a single line of dialogue
		String[] dialogueItem = {avatarImageCode,name,message};
		ArrayList<String[]> dialogue = new ArrayList<String[]>();
		dialogue.add(dialogueItem);
		
		//Run dialogue initialization as usual
		setDialogue(dialogue);
	}
	
	public void progressDialogue() {
		
		//Checks if current page of dialogue exists
		if(dialoguePosition < dialogueList.size()) {
			
			//Retrieve current lines of dialogue
			String[] dialogueItem = dialogueList.get(dialoguePosition);
			
			//Passes off values into bite-sized chunks
			avatarImageCode = dialogueItem[0];
			name = dialogueItem[1];
			line1 = dialogueItem[2];
			line2 = dialogueItem[3];
			line3 = dialogueItem[4];
			
			//Marks line as read (pushes counter up by one)
			dialoguePosition++;
		} else {
			
			//Close window and resume game loop
			exitDialogue();
			
		}
	}
	
	public void exitDialogue() {
		inDialogue = false;
	}
}
