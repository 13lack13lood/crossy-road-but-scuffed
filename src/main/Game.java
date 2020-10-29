package main;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import menu.InstructionMenu;
import menu.StarterMenu;

public class Game extends JFrame{

	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	
	public static CardLayout cardLayout;
	public static Container container;
	
	private Dimension screenDimension;
	private ImageIcon icon;
	
	private StarterMenu starterMenu;
	private InstructionMenu instructionMenu;
	
	public Game() {
		screenDimension = new Dimension(WIDTH, HEIGHT);
		
		cardLayout = new CardLayout();
		container = getContentPane();
		container.setLayout(cardLayout);
		
		this.setSize(screenDimension);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Mario But Scuffed");


		icon = new ImageIcon("res/marioicon.png");
		this.setIconImage(icon.getImage());
		
		starterMenu = new StarterMenu();
		instructionMenu = new InstructionMenu();
		
		container.add("Starter Menu", starterMenu);
		container.add("Instruction Menu", instructionMenu);
	
		this.setVisible(true);
		
	}
}
