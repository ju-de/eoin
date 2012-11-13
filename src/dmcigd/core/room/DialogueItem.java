package dmcigd.core.room;

public class DialogueItem {
	
	private final String avatarImageCode, name, text;

	public DialogueItem(String avatarImageCode, String name, String text) {
		if(name == null || text == null)
			throw new NullPointerException();
		this.avatarImageCode = avatarImageCode;
		this.name = name;
		this.text = text;
	}

	//Public Getters
	public String getAvatarImageCode() {
		return avatarImageCode;
	}
	public String getName() {
		return name;
	}
	public String getText() {
		return text;
	}
	
}
