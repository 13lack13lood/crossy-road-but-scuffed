package game.entities;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Entity {
	//VARIABLES
	private int width, x;
	protected int height, y; //child classes can access the height and y values
	private boolean canKill; //boolean to know if the entity can kill the player
	protected ImageIcon image;

	public Entity(ImageIcon image, int height, int width, int x, int y, boolean canKill) {
		this.image = image;
		this.height = height;
		this.width = width;
		this.x = x;
		this.y = y;
		this.canKill = canKill;
	}

	//method to draw the entity
	public void draw(Graphics g) {
		g.drawImage(image.getImage(), x, y, width, height, null);
	}

	//GETTERS AND SETTERS
	
	//GETTERS
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

	//SETTERS
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	protected void setWidth(int width) { //only child classes can change the width
		this.width = width;
	}

}
