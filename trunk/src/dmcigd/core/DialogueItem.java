package dmcigd.core;

public class DialogueItem implements Comparable<DialogueItem> {
	private final String avatarImageCode, name, text;

	public DialogueItem(String avatarImageCode, String name, String text) {
		if(avatarImageCode == null || name == null || text == null)
			throw new NullPointerException();
		this.avatarImageCode = avatarImageCode;
		this.name = name;
		this.text = text;
	}

	public String avatarImageCode() {
		return avatarImageCode;
	}
	public String name() {
		return name;
	}
	public String text() {
		return text;
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
		return "[" + avatarImageCode + "] " + name + ": " + text;
	}

	public int compareTo(DialogueItem other) {
	    int nameComparison, textComparison, avatarComparison;
		nameComparison = name.compareTo(other.name());
		if(nameComparison != 0)
			return nameComparison;
			textComparison = text.compareTo(other.text());
		if(textComparison != 0)
			return textComparison;
		avatarComparison = avatarImageCode.compareTo(other.avatarImageCode());
		return avatarComparison;
	}
}
