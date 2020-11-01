package game.entities;

import javax.swing.ImageIcon;

import main.Frame;
import tools.HitBox;

public class Tree extends Entity {

	public Tree(ImageIcon image, int x, int y) {
		super(image, new HitBox(x, y, Frame.SQUARE, Frame.SQUARE), Frame.SQUARE, x, y, false);
		
	}

}
