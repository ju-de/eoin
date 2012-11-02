package dmcigd.core.objects;

public class TextLabel {
	private boolean small;
	private int x,y;
	private String string;
	
	public boolean isSmall() {
		return small;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public String getString() {
		return string;
	}
	
	public TextLabel(int x, int y, String string, boolean small) {
		this.x = x;
		this.y = y;
		this.string = string;
		this.small = small;
	}
	
	public TextLabel(int x, int y, String string) {
		this(x,y,string,true);
	}
}
