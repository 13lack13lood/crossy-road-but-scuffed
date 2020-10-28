package main;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Game extends JFrame{
	
	private Dimension screenDimension;
	
	public Game(int WIDTH, int HEIGHT) {
		this.screenDimension = new Dimension(WIDTH, HEIGHT);
		this.setTitle("Mario But Scuffed");
		this.setResizable(false);
		this.setSize(screenDimension);
		this.setVisible(true);
	}
}
