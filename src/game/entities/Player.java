package game.entities;

import javax.swing.ImageIcon;

public class Player extends Entity {
	private String name;
	
	public Player(String name, ImageIcon image, HitBox hitBox) {
		super(hitBox, image);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
