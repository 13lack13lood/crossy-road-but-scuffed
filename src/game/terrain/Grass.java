package game.terrain;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;

import game.entities.Tree;
import main.Frame;
import tools.Tools;

public class Grass extends Terrain {
	
	private ArrayList<Tree> trees;
	private ArrayList<Integer> prevMovingSquares;
	
	public Grass(Color color, int pos, ArrayList<Integer> prevMovingSquares) {
		super(color, pos);	
		
		this.prevMovingSquares = prevMovingSquares;
		
		trees = new ArrayList<Tree>();
		
		ArrayList<Integer> treePos = generateTreePositions();
		for(int i : treePos) {
			trees.add(new Tree(new ImageIcon("res/tree.png"), getPos() * Frame.SQUARE, i * Frame.SQUARE));
		}
	}
	
	public Grass(Color color, int pos) {
		super(color, pos);
		
		trees = new ArrayList<Tree>();
		
		for(int i = 0; i < Frame.HEIGHT / Frame.SQUARE; i++) {
			trees.add(new Tree(new ImageIcon("res/tree.png"), getPos() * Frame.SQUARE, i * Frame.SQUARE));
		}
	}
	
	public Grass(ArrayList<Integer> treePos, Color color, int pos) {
		super(color, pos);
		trees = new ArrayList<Tree>();
		
		for(int i : treePos) {
			trees.add(new Tree(new ImageIcon("res/tree.png"), getPos() * Frame.SQUARE, i * Frame.SQUARE));
		}
	}

	public void draw(Graphics g) {
		super.draw(g);
		
		for(Tree tree : trees) {
			tree.draw(g);
		}
	}
	
	private ArrayList<Integer> generateTreePositions() {
		ArrayList<Integer> treePositions = new ArrayList<Integer>();
		
		
		for(int i = 0; i < prevMovingSquares.size(); i++) {
			int pos = prevMovingSquares.get(i);
			
			ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(pos));
			
			if(pos == 0) {
				if(!treePositions.contains(pos + 1)) {
					list.add(pos + 1);
				}
			} else if(pos == Frame.HEIGHT / Frame.SQUARE) {
				if(!treePositions.contains(pos - 1)) {
					list.add(pos - 1);
				}
			} else {
				if(!treePositions.contains(pos - 1)) {
					list.add(pos - 1);
				}
				
				if(!treePositions.contains(pos + 1)) {
					list.add(pos + 1);
				}
			}
			
			treePositions.add(list.get(Tools.generateRandomNumber(0, list.size() - 1)));
		}

		return treePositions;
	}

}
