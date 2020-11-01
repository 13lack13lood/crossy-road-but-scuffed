package game.terrain;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;

import game.entities.Tree;
import main.Frame;

public class Grass extends Terrain {
	
	private int numOfTrees;
	
	public Grass(Color color, int pos) {
		super(color, pos);	
		numOfTrees = (int) (Math.random() * (Frame.HEIGHT / Frame.SQUARE));
	}
	
	public void draw(Graphics g) {
		super.draw(g);

	}

}
