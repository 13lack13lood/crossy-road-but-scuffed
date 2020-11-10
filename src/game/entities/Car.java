package game.entities;

import main.Frame;
import tools.Tools;

public class Car extends Vehicle {

	public Car(int x) {
		super(null, x, 0, Tools.generateRandomNumber(2, 4), Tools.generateRandomNumber(1, 2), Tools.generateRandomNumber(Tools.UP, Tools.DOWN));
		// Set image
		image = Tools.generateCar(getHeight(), getDirection());
		// Set height
		height = image.getImage().getHeight(null);

		if (getDirection() == Tools.UP) {
			y = Frame.HEIGHT;
		} else {
			y = -getHeight();
		}
	}
}
