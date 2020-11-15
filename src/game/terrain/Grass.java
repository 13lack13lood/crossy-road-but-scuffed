/* Harry Zhu and Justin Lee
 * ICS3U7 Ms. Strelkovska
 * November 14, 2020
 * Final project
 * This is the class for the grass terrain
 */

package game.terrain;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import game.entities.Entity;
import game.entities.Tree;
import main.Frame;
import tools.Tools;

public class Grass extends Terrain {

	//VARIABLES
	private static int maxNumOfTrees = 3;

	//Constructor used to generate grass with random tree positions
	public Grass(Color color, int pos) {
		super(color, pos); //call parent constructor

		//ArrayList for all the positions of the trees
		ArrayList<Integer> treePos = generateTreePositions();
		
		//add trees for each tree position
		for (int i : treePos) {
			objects.add(new Tree(new ImageIcon("res/tree.png"), getPos() * Frame.SQUARE, i * Frame.SQUARE));
		}
	}

	//Constructor used to generate grass with specified tree positions
	public Grass(ArrayList<Integer> treePos, Color color, int pos) {
		super(color, pos); //call parent constructor

		//create and all the trees to the objects ArrayList
		for (int i : treePos) {
			objects.add(new Tree(new ImageIcon("res/tree.png"), getPos() * Frame.SQUARE, i * Frame.SQUARE));
		}
	}

	//draw the terrain
	public void draw(Graphics g) {
		super.draw(g);
		updateEntityPos();
		
		//draw the trees
		for (Entity e : objects) {
			e.draw(g);
		}
	}

	//method to generate random tree positions
	private ArrayList<Integer> generateTreePositions() {
		return Tools.generateRandomNumbers(0, Frame.HEIGHT / Frame.SQUARE, Tools.generateRandomNumber(1, maxNumOfTrees));
	}
}
