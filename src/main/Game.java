package main;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Game extends JFrame{
	
	private Dimension screenDimension;
	private ImageIcon icon;
	private Container container;
	
	public Game(int WIDTH, int HEIGHT) {
		this.screenDimension = new Dimension(WIDTH, HEIGHT);
		this.setTitle("Mario But Scuffed");
		this.setResizable(false);
		this.setSize(screenDimension);
		this.setVisible(true);
		
		container = this.getContentPane();
		
		icon = new ImageIcon("res/marioicon.png");
		this.setIconImage(icon.getImage());
	}
	
	public Container getContainer() {
		return container;
	}
}
