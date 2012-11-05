package dmcigd.core;

import java.util.ArrayList;
import dmcigd.core.DialogueItem;
import java.util.regex.*;
import java.util.Arrays;

public class DialogueHandler {
	// the internal ArrayList of DialogueItem elements
	private ArrayList<DialogueItem> dialogueItems;

	public void progressDialogue(ArrayList<DialogueItem> dialogueItems) {
		this.dialogueItems = new ArrayList<DialogueItem>(dialogueItems);
	}
	// overloaded constructors to deal with more intuitive parameters
	public void DialogueHandler(ArrayList<String[]> dialogueItems) {
		this.dialogueItems = dialogueItemsFromList(dialogueItems);
	}
	public void DialogueHandler(String[][] dialogueItems) {
		this.dialogueItems = dialogueItemsFromList(new ArrayList<String[]>(Arrays.asList(dialogueItems)));
	}

// generates an ArrayList of DialogueItem elements given
// an ArrayList of string arrays of the required fields
//
// string array elements are in the order 
// avatarImageCode, name, text
	public ArrayList<DialogueItem> dialogueItemsFromList(ArrayList<String[]> dialogueList) {
		ArrayList<DialogueItem> dialogueItems = new ArrayList<DialogueItem>();
		// holds the list of prepared dialogue text arrays for each iteration
ArrayList<String[]> itemText = new ArrayList<String[]>();
		for(String[] element : dialogueList) {
			// append the processed dialogue text
			itemText.addAll(prepareDialogueText(element[2]));
			// iterate through the list of dialogue text arrays,
			// generating a new DialogueItem with the same avatarImageCode and name for each
			for(String[] text : itemText) 
				dialogueItems.add(new DialogueItem(element[0], element[1], text));
			// clear the dialogue text list for the next iteration
			itemText.clear();
		}
		return dialogueItems;
	}

// add a new dialogue element
	public void add(String avatarImageCode, String name, String text) {
		// the list of processed dialogue text arrays
		ArrayList<String[]> preparedText = prepareDialogueText(text);
		// iterate through the dialogue text arrays,
		// generating a new DialogueItem with the same avatarImageCode and name for each
		for(String[] element : preparedText)
			dialogueItems.add(new DialogueItem(avatarImageCode, name, element));
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
// a list of text arrays (dialogue parts) with no more than DialogueItem.maxLines string elements,
// each string (line)  with no more than DialogueItem.maxWidth characters
	public ArrayList<String[]> prepareDialogueText(String text) {
		// the list of dialogue parts
		ArrayList<String[]> preparedText = new ArrayList<String[]>();
		// the initial array of dialogue parts
		String[] splitText;
		// if the parameter size is less than the max width, no need to separate it
		if(text.length() <= DialogueItem.maxWidth) {
			preparedText.add(new String[] {text});
			return preparedText;
		}
		// regex for splitting a dialogue part into lines of at most DialogueItem.maxWidth length
		String lineRegex = ".{1," + DialogueItem.maxWidth + "}\\s";
		// regex for splitting the text into dialogue parts of no more than DialogueItem.maxLines * DialogueItem.maxWidth length
		String partRegex = ".{" + DialogueItem.maxWidth + "," + DialogueItem.maxLines * DialogueItem.maxWidth + "}\\s";
		// split the text into an array of dialogue parts
		splitText = Pattern.compile(partRegex).split(text);
		// iterate through the dialogue parts, split each into an array of lines and append to the final variable
		for(String l : splitText)
			preparedText.add(Pattern.compile(lineRegex).split(l));
		return preparedText;
	}

	public ArrayList<DialogueItem> dialogueItems() {
		return dialogueItems;
	}
}
