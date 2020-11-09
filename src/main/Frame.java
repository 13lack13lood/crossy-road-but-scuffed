package main;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import tools.Tools;

public class Frame extends JFrame {

	public static final int WIDTH = 512, HEIGHT = 512, SQUARE = 64;

	public static CardLayout layout;
	public static Container container;
	private ImageIcon icon;

	public Frame() {
		container = getContentPane();
		layout = new CardLayout();
		container.setLayout(layout);

		icon = Tools.icon;
		this.setIconImage(icon.getImage());

		this.setTitle("Crossy Road But Scuffed");
		this.setSize(WIDTH + 14, HEIGHT + 30 + 7);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}

}
