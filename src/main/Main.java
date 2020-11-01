package main;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;

import game.entities.Player;
import game.gamePanel.GamePanel;

public class Main {

	public static void main(String[] args) {
		Frame frame = new Frame();
		
		Player player = new Player(new ImageIcon("res/chicken.png"), Frame.SQUARE, 8);
		
		GamePanel gamePanel = new GamePanel(player);
		gamePanel.setFocusable(true);
		
		frame.container.add(gamePanel, BorderLayout.CENTER);
		frame.setVisible(true);
	}
	
}
