package game.terrain;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

import game.entities.Tree;
import main.Frame;
import tools.Tools;

public class Grass extends Terrain {
	
	private int numOfTrees;
	private ArrayList<Integer> prevMoveSquares;
	
	public Grass(Color color, int pos, ArrayList<Integer> prevMoveSquares) {
		super(color, pos);	
		this.prevMoveSquares = prevMoveSquares;
		numOfTrees = Tools.generateRandomNumber(0, Frame.HEIGHT / Frame.SQUARE);
	}
	
	public void draw(Graphics g) {
		super.draw(g);

	}

}
