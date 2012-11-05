package dmcigd.core;

import dmcigd.core.DialogueItem;
import java.util.regex.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

public class DialogueHandler {
	// the internal ArrayList of DialogueItem elements
	private List<DialogueItem> dialogueItems;
	private ListIterator<DialogueItem> dialogueItemIterator;
	private DialogueItem currentDialogueItem;
		private ArrayList<String> currentScreen;
	private List<String> currentView;
	private boolean inDialogue;
	private int linePosition;
	public static final int maxWidth = 42;
	public static final int maxLines = 3;

	public boolean inDialogue() {
		return inDialogue();
	}
	public int lines() {
		return currentView.size();
	}
	public String line(int l) {
		if(l < 1 || l > currentView.size())
			throw new IllegalArgumentException("line number out of bounds");
		return currentView.get(l-1);
	}

	public DialogueHandler() {
		dialogueItems = Collections.synchronizedList(new ArrayList<DialogueItem>());
		dialogueItemIterator = dialogueItems.listIterator();
		inDialogue = false;
	}

// clears current dialogue and adds new dialogue
	public boolean setDialogueItems(ArrayList<DialogueItem> dialogueItems) {
		this.dialogueItems.clear();
		this.dialogueItems.addAll(dialogueItems);
		return startDialogue();
	}
	// overloaded methods to deal with more intuitive parameters
	public boolean setDialogue(ArrayList<String[]> dialogueItems) {
		this.dialogueItems.clear();
		for(String[] dialogueItem : dialogueItems)
			add(dialogueItem);
		return startDialogue();
	}
	public boolean setDialogue(String[][] dialogueItems) {
		this.dialogueItems.clear();
		for(String[] dialogueItem : dialogueItems)
			add(dialogueItem);
		return startDialogue();
	}

	public boolean startDialogue() {
		if(dialogueItems.isEmpty())
			return false;
		inDialogue = true;
		updateScreen();
		return true;
	}
	public void closeDialogue() {
		inDialogue = false;
	}

// add a new dialogue element
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

// takes a text string and separates it into
// a list of strings no more than maxWidth in length
	public ArrayList<String> prepareDialogueText(String text) {
		// the list of dialogue parts
		ArrayList<String> preparedText = new ArrayList<String>();
		// regex for splitting a line into chunks of at most maxWidth length
		String lineRegex = ".{0," + maxWidth + "}\\s";
		preparedText.addAll(Arrays.asList(Pattern.compile(lineRegex).split(text)));
		return preparedText;
	}

	public void updateScreen() {
		if(!dialogueItemIterator.hasNext()) {
			closeDialogue();
			return;
		}
		currentScreen = prepareDialogueText(dialogueItemIterator.next().text());
		updateView(0);
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
	public void advance() {
		updateView(linePosition + 1);
	}
}
