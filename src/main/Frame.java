package main;

import java.awt.*;

import javax.swing.*;

public class Frame extends JFrame {

	public static final int WIDTH = 600, HEIGHT = 600;
	
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
		this.setSize(WIDTH, HEIGHT);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	
}
