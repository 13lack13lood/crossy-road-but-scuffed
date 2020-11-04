package game.entities;

import javax.swing.ImageIcon;

import main.Frame;

public class Tree extends Entity {

	public Tree(ImageIcon image, int x, int y) {
		super(image, Frame.SQUARE, Frame.SQUARE, x, y, false);	
	}

}
