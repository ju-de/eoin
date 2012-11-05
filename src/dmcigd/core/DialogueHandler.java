package dmcigd.core;

import dmcigd.core.DialogueItem;
import java.util.regex.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

public class DialogueHandler {
	
	//Dialogue handler constants
	public static final int maxWidth = 42;
	public static final int maxLines = 3;
	
	// the internal ArrayList of DialogueItem elements
	private List<DialogueItem> dialogueItems;
	private ListIterator<DialogueItem> dialogueItemIterator;
	private DialogueItem currentDialogueItem;
	
	//Determines current position in dialogue
	private ArrayList<String> currentScreen;
	private List<String> currentView;
	private int linePosition;
	
	//Dialogue Status (for determining the current gameState)
	private boolean inDialogue;

	public DialogueHandler() {
		dialogueItems = Collections.synchronizedList(new ArrayList<DialogueItem>());
		dialogueItemIterator = dialogueItems.listIterator();
		inDialogue = false;
	}
	
	//Methods to set Dialogue Status
	public boolean inDialogue() {
		return inDialogue;
	}
	public boolean startDialogue() {
		dialogueItemIterator = dialogueItems.listIterator();
		if(dialogueItems.isEmpty())
			return false;
		inDialogue = true;
		dialogueItemIterator = dialogueItems.listIterator();
		updateScreen();
		return true;
	}
	public void closeDialogue() {
		dialogueItems.clear();
		inDialogue = false;
	}
	
	//Public Getters
	public DialogueItem getCurrentDialogueItem() {
		return currentDialogueItem;
	}
	public int getLines() {
		return currentView.size();
	}
	public String getLine(int l) {
		if(l < 1 || l > currentView.size())
			return null;
		return currentView.get(l-1);
	}

	//Initiates current dialogue session
	// clears current dialogue and adds new dialogue
	public void setDialogueItems(ArrayList<DialogueItem> dialogueItems) {
		this.dialogueItems.clear();
		this.dialogueItems.addAll(dialogueItems);
	}
	// overloaded methods to deal with more intuitive parameters
	public void setDialogue(ArrayList<String[]> dialogueItems) {
		this.dialogueItems.clear();
		for(String[] dialogueItem : dialogueItems)
			add(dialogueItem);
	}
	public void setDialogue(String[][] dialogueItems) {
		this.dialogueItems.clear();
		for(String[] dialogueItem : dialogueItems)
			add(dialogueItem);
	}

	//Adds new dialogue elements
	public void add(String avatarImageCode, String name, String text) {
		dialogueItems.add(new DialogueItem(avatarImageCode, name, text));
	}
	// overloaded definitions for convenience
	public void add(ArrayList<String> dialogue) {
		if(dialogue.size() != 3)
			throw new IllegalArgumentException("illegal list length for dialogue");
		add(dialogue.get(0), dialogue.get(1), dialogue.get(2));
	}
	public void add(String[] dialogue) {
		add(new ArrayList<String>(Arrays.asList(dialogue)));
	}

//Parses dialogue input
// takes a text string and separates it into
// a list of strings no more than maxWidth in length
	public ArrayList<String> prepareDialogueText(String text) {
		
		// the list of dialogue parts
		ArrayList<String> preparedText = new ArrayList<String>();
		
		// regex for splitting a line into chunks of at most maxWidth length
		String lineRegex = ".{0," + maxWidth + "}(\\s|\\z)";
		
		// Creates new array based on regex groups.
		Matcher matcher = Pattern.compile(lineRegex).matcher(text);
		while(matcher.find())
			preparedText.add(matcher.group());
		
		return preparedText;
		
	}
	
	public void advance() {
		updateView(linePosition + 1);
	}
	
	public void updateView(int position) {
		if(position > currentScreen.size() || position < 0)
			throw new IllegalArgumentException("position out of bounds");
		int endPosition = position + maxLines;
		if(endPosition > currentScreen.size()) {
			if(position > 0) {
				updateScreen();
				return;
			}
			endPosition = currentScreen.size();
		}
		linePosition = position;
		currentView = currentScreen.subList(position, endPosition);
	}
	
	public void updateScreen() {
		if(!dialogueItemIterator.hasNext()) {
			closeDialogue();
			return;
		}
		currentDialogueItem = dialogueItemIterator.next();
		currentScreen = prepareDialogueText(currentDialogueItem.getText());
		updateView(0);
	}
}
