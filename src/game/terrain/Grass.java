package game.terrain;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;

import game.entities.Entity;
import game.entities.Tree;
import main.Frame;
import tools.Tools;

public class Grass extends Terrain {
	
	private static int maxNumOfTrees = 3;
	
	public Grass(Color color, int pos) {
		super(color, pos);	
		
		ArrayList<Integer> treePos = generateTreePositions();
		for(int i : treePos) {
			objects.add(new Tree(new ImageIcon("res/tree.png"), getPos() * Frame.SQUARE, i * Frame.SQUARE));
		}
	}
	
	public Grass(ArrayList<Integer> treePos, Color color, int pos) {
		super(color, pos);
		
		for(int i : treePos) {
			objects.add(new Tree(new ImageIcon("res/tree.png"), getPos() * Frame.SQUARE, i * Frame.SQUARE));
		}
	}

	public void draw(Graphics g) {
		super.draw(g);
		updateEntityPos();
		for(Entity e : objects) {
			e.draw(g);
		}
	}
	
	private ArrayList<Integer> generateTreePositions() {
		return Tools.generateRandomNumbers(0, Frame.HEIGHT / Frame.SQUARE, Tools.generateRandomNumber(1, maxNumOfTrees));
	}
}
