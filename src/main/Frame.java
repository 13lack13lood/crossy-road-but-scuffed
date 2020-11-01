package main;

import java.awt.*;

import javax.swing.*;

public class Frame extends JFrame {

	public static final int WIDTH = 512, HEIGHT = 512, SQUARE = 64;
	
	public CardLayout layout;
	public Container container;
	private ImageIcon icon;
	
	public Frame() {
		container = getContentPane();
		layout = new CardLayout();
		container.setLayout(layout);
		
		icon = new ImageIcon("res/icon.png");
		this.setIconImage(icon.getImage());
		
		this.setTitle("Crossy Road But Scuffed");
		this.setSize(WIDTH + 14, HEIGHT + 30 + 7);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	
}
