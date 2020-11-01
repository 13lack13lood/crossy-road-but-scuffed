package game.terrain;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import game.entities.Tree;
import main.Frame;

public class Grass extends Terrain {
	
	private int numOfTrees;
	private Tree tree;
	
	public Grass(Color color, int pos) {
		super(color, pos);
		this.tree = tree;
		numOfTrees = (int) (Math.random() * (Frame.HEIGHT / Frame.SQUARE));
	}
	
	public void draw(Graphics g) {
		super.draw(g);
	}

}
