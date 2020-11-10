package game.entities;

import javax.swing.ImageIcon;

import main.Frame;
import tools.Tools;

public class Vehicle extends Entity {
	private int speed;
	private int direction;

	public Vehicle(ImageIcon image, int x, int y, int speed, int height, int direction) {
		super(image, height, Frame.SQUARE, x, y, true);
		this.speed = speed;
		this.direction = direction;
	}

	public void move() {
		if (direction == Tools.UP) {
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
