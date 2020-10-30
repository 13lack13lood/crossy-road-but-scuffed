package tools;

import java.awt.Rectangle;

public class HitBox {
	private Rectangle hitBox;
	private int width, height;
	
	public HitBox(int x, int y, int width, int height) {
		this.width = width;
		this.height = height;
		hitBox = new Rectangle(x, y, width, height);
	}
	
	public void updateHitBox(int x, int y) {
		hitBox = new Rectangle(x, y, width, height);
	}
	
	public Rectangle getHitBox() {
		return hitBox;
	}
	
	public boolean hasHit(HitBox other) {
		return hitBox.intersects(other.getHitBox());
	}
}
