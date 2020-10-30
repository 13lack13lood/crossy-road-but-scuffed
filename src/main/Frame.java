package main;

import java.awt.*;

import javax.swing.*;

public class Frame extends JFrame {

	public static final int WIDTH = 720, HEIGHT = 720;
	public static CardLayout layout;
	public static Container container;
	
	private ImageIcon icon;
	
	public Frame() {
		container = getContentPane();
		layout = new CardLayout();
		container.setLayout(layout);
		
		icon = new ImageIcon("res/icon.png");
		setIconImage(icon.getImage());
		
		setTitle("Crossy Road");
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
}
