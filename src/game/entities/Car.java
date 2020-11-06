package game.entities;

import main.Frame;
import tools.Tools;

public class Car extends Vehicle {
	
	public Car(int x) {
		super(null, x, 0, 2, Tools.generateRandomNumber(1, 2), Tools.generateRandomNumber(1, 2));
		image = Tools.generateCar(getHeight(), getDirection());
		height = image.getImage().getHeight(null);
		if(getDirection()==1) {
			y = Frame.HEIGHT;
		}
		else {
			y = -getHeight();
		}
	}
}
