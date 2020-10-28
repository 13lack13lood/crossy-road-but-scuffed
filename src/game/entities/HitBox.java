package game.entities;

public class HitBox {
	
	private int top;
	private int bottom;
	private int left;
	private int right;
	
	public HitBox(int width, int height) {
		top = height;
		bottom = 0;
		left = 0;
		right = width;
	}
	
	public int getTop() {
		return top;
	}

	public int getBottom() {
		return bottom;
	}

	public int getLeft() {
		return left;
	}

	public int getRight() {
		return right;
	}
}
