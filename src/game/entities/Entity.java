package game.entities;

import javax.swing.ImageIcon;

public class Entity {
	private HitBox hitBox;
	private ImageIcon image;
	
	public Entity(HitBox hitBox, ImageIcon image) {
		this.hitBox = hitBox;
		this.image = image;
	}
}
