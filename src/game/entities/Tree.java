/* Harry Zhu and Justin Lee
 * ICS3U7 Ms. Strelkovska
 * November 14, 2020
 * Final project
 * This is the class for the trees
 */

package game.entities;

import javax.swing.ImageIcon;

import main.Frame;

public class Tree extends Entity {

	public Tree(ImageIcon image, int x, int y) {
		super(image, Frame.SQUARE, Frame.SQUARE, x, y, false); //parent class has everything for this class
	}

}
