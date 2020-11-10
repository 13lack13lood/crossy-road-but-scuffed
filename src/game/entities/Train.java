package game.entities;

import main.Frame;
import tools.Tools;

public class Train extends Vehicle {

	public Train(int x) {
		super(null, x, 0, 10, Tools.generateRandomNumber(1, 2), Tools.generateRandomNumber(1, 2));
		// Sets image
		image = Tools.generateTrain();
		// Sets height
		height = image.getImage().getHeight(null);

		if (getDirection() == 1) {
			y = Frame.HEIGHT;
		} else {
			y = -getHeight();
		}
	}
}
