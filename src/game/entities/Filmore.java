package game.entities;

import javax.swing.ImageIcon;

import main.Frame;
import tools.Tools;

public class Filmore extends Vehicle {

	public Filmore(ImageIcon image) {
		super(image, 2 * Frame.SQUARE, 0, 4, Frame.SQUARE, Tools.DOWN);
		setWidth(3 * Frame.SQUARE);
	}

}
