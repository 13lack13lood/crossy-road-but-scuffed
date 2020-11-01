package game.entities;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import main.Frame;
import tools.HitBox;

public class Entity {
	
	private HitBox hitbox;
	private int height, x;
	protected int y;
	private boolean canKill;
	private ImageIcon image;
	
	public Entity(ImageIcon image, HitBox hitbox, int height, int x, int y, boolean canKill) {
		this.image = image;
		this.hitbox = hitbox;
		this.height = height;
		this.x = x;
		this.y = y;
		this.canKill = canKill;
	}
	
	public void draw(Graphics g) {
		g.drawImage(image.getImage(), x, y, Frame.SQUARE, height, null);
	}

	public HitBox getHitbox() {
		return hitbox;
	}

	public int getHeight() {
		return height;
	}

	public boolean isCanKill() {
		return canKill;
	}

	public ImageIcon getImage() {
		return image;
	}
	
	public int getX() {
		return x;
	}
	
	public int gettY() {
		return y;
	}
	
	protected void setX(int x) {
		this.x = x;
	}
	
	protected void setY(int y) {
		this.y = y;
	}
	
}
