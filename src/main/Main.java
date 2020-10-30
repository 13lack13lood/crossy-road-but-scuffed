package main;

import java.awt.BorderLayout;

import game.gamePanel.GamePanel;
import menus.StartMenu;

public class Main {

	public static void main(String[] args) {
		Frame frame = new Frame();
		
		StartMenu startMenu = new StartMenu();
		
		GamePanel gamePanel = new GamePanel();

		Frame.container.add(startMenu, BorderLayout.CENTER);
		Frame.container.add(gamePanel, BorderLayout.CENTER);
		Frame.layout.addLayoutComponent("startmenu", startMenu);
	}
}
