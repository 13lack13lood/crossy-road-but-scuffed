package game.entities;

import main.Frame;
import tools.Tools;

public class Train extends Vehicle {

	public Train(int x) {
		super(null, x, 0, 10, Tools.generateRandomNumber(1, 2), Tools.generateRandomNumber(1, 2)); //call parent constructor
		image = Tools.generateTrain(); // Sets image
		height = image.getImage().getHeight(null); // Sets height

		//set the direction according to the y value
		if (getDirection() == 1) {
			y = Frame.HEIGHT;
		} else {
			y = -getHeight();
		}
	}
}
