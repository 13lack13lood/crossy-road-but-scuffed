package main;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;

import javax.swing.ImageIcon;

import game.entities.Player;
import game.gamePanel.GamePanel;
import game.terrain.TerrainGenerator;
import menus.StartMenu;

public class Main {

	public static void main(String[] args) {
		Frame frame = new Frame();
		
		StartMenu startMenu = new StartMenu(new ImageIcon("res/chicken.png"),new Font("Comic Sans MS",Font.BOLD,20));
		
		Player player = new Player(new ImageIcon("res/chicken.png"), Frame.SQUARE * 3, 8);
		TerrainGenerator terrainGenerator = new TerrainGenerator(Frame.HEIGHT / frame.SQUARE);
		GamePanel gamePanel = new GamePanel(player, terrainGenerator);

		
		Frame.container.add(startMenu, BorderLayout.CENTER);
		Frame.container.add(gamePanel, BorderLayout.CENTER);
		
		
		frame.setVisible(true);
	}
}
