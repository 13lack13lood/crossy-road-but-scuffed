package game.entities;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Entity {

	private int width, x;
	protected int height;
	protected int y;
	private boolean canKill;
	protected ImageIcon image;

	public Entity(ImageIcon image, int height, int width, int x, int y, boolean canKill) {
		this.image = image;
		this.height = height;
		this.width = width;
		this.x = x;
		this.y = y;
		this.canKill = canKill;
	}

	public void draw(Graphics g) {
		g.drawImage(image.getImage(), x, y, width, height, null);
	}

	protected void setWidth(int width) {
		this.width = width;
	}

	public int getWidth() {
		return width;
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

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

}
