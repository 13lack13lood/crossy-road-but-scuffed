package game.entities;

import main.Frame;
import tools.Tools;

public class Train extends Vehicle {

	public Train(int x) {
		super(null, x, 0, 16, Tools.generateRandomNumber(1, 2), Tools.generateRandomNumber(1, 2));

		image = Tools.generateTrain();
		height = image.getImage().getHeight(null);

		if (getDirection() == 1) {
			y = Frame.HEIGHT;
		} else {
			y = -getHeight();
		}
	}
}
