package dmcigd.core.room;

public class DialogueItem {
	
	private final String name, text;

	public DialogueItem(String name, String text) {
		if(name == null || text == null)
			throw new NullPointerException();
		this.name = name;
		this.text = text;
	}

	//Public Getters
	public String getName() {
		return name;
	}
	public String getText() {
		return text;
	}
	
}
