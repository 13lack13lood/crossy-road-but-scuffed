package game.entities;

import javax.swing.ImageIcon;

import main.Frame;
import tools.Tools;

public class Filmore extends Vehicle {

	public Filmore(ImageIcon image) {
		super(image, 2*Frame.SQUARE, 0, 8, Frame.SQUARE, Tools.DOWN);
		super.setWidth(3*Frame.SQUARE);
	
	}
	
}
