package game.entities;

import main.Frame;
import tools.Tools;

public class Car extends Vehicle {

	public Car(int x) {
		super(null, x, 0, Tools.generateRandomNumber(2, 4), Tools.generateRandomNumber(1, 2), Tools.generateRandomNumber(Tools.UP, Tools.DOWN));
		image = Tools.generateCar(getHeight(), getDirection()); // Set image
		height = image.getImage().getHeight(null); // Set height 

		if (getDirection() == Tools.UP) {
			y = Frame.HEIGHT;
		} else {
			y = -getHeight();
		}
	}
}
