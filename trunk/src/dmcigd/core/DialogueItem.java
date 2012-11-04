package dmcigd.core;

public class DialogueItem implements Comparable<DialogueItem> {
	private final String avatarImageCode, name;
	private final String[] text;
	private final int lines;
	public static final int maxLines = 3;
	public static final int maxWidth = 42;

	public DialogueItem(String avatarImageCode, String name, String[] text) {
		if(avatarImageCode == null || name == null || text == null)
			throw new NullPointerException();
			if(text.length == 0)
				throw new IllegalArgumentException("empty array for text");
		if(text.length > maxLines)
			throw new IllegalArgumentException("array size out of bounds for text");
		for(int i = 0; i < text.length; i++) {
			if(text[i].length() > maxWidth)
				throw new IllegalArgumentException("string length out of bounds for text at index " + i);
			if(text[i].length() == 0)
				throw new IllegalArgumentException("empty string in text at index " + i);
		}
		this.avatarImageCode = avatarImageCode;
		this.name = name;
		this.text = text;
		this.lines = text.length;
	}

	public String line(int l) {
		if(l == 0 || l > lines) 
			throw new IllegalArgumentException("line number out of bounds");
		return text[l];
	}

	public String avatarImageCode() {
		return avatarImageCode;
	}
	public String name() {
		return name;
	}
	public String[] text() {
		return text;
	}
	public int lines() {
		return lines;
	}

	public boolean equals(Object o) {
		if(!(o instanceof DialogueItem))
			return false;
		if(o == this)
			return true;
		DialogueItem other = (DialogueItem) o;
		return other.avatarImageCode.equals(avatarImageCode) && other.name.equals(name) && other.text.equals(text);
	}

	public int hashCode() {
		return 31 * avatarImageCode.hashCode() + 17 * name.hashCode() + text.hashCode();
	}

	public String toString() {
		String out = name + ": ";
		for(String l : text)
			out += l + " ";
		return out;
	}

	public int compareTo(DialogueItem other) {
	    int nameComparison, textComparison, avatarComparison;
		nameComparison = name.compareTo(other.name());
		if(nameComparison != 0)
			return nameComparison;
		// this doesn't work in a for because
		// the condition is evaluated first, and
		// if it's false on the first loop,
		// textComparison won't be initialized.
		int l = 1;
		do {
			textComparison = line(l).compareTo(other.line(l));
			l++;
			if(textComparison != 0)
				break;
		} while(l <= lines && l <= other.lines());
		if(textComparison != 0)
			return textComparison;
		if(lines != other.lines())
			return ( lines < other.lines() ? -1 : 1 );
		avatarComparison = avatarImageCode.compareTo(other.avatarImageCode());
		return avatarComparison;
	}
}
