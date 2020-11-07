package game.entities;

import main.Frame;

import javax.swing.ImageIcon;

public class Vehicle extends Entity {
	private int speed;
	private int direction;

	public Vehicle(ImageIcon image, int x, int y, int speed, int height, int direction) {
		super(image, height, Frame.SQUARE, x, y, true);
		this.speed = speed;
		this.direction = direction;
	}

	public void move() {
		if (direction == 1) {
			super.y -= speed;
		} else {
			super.y += speed;
		}
	}

	public int getSpeed() {
		return speed;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public void setImage(ImageIcon image) {
		super.image = image;
	}
}
