package main;

import game.gamePanel.GamePanel;

public class Main {

	public static void main(String[] args) {
		Frame frame = new Frame();
		
		GamePanel gamePanel = new GamePanel();
		
		frame.container.add(gamePanel);
	}
	
}
