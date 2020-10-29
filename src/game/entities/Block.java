package game.entities;

import javax.swing.ImageIcon;

public class Block extends Entity{

	private int size;
	
	public Block(HitBox hitBox, ImageIcon image, int size) {
		super(hitBox, image);
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}

}
