package main;

import java.awt.Font;

import javax.swing.ImageIcon;

import game.entities.Player;
import game.gamePanel.GamePanel;
import game.terrain.TerrainGenerator;
import menus.EatenMenu;
import menus.EndMenu;
import menus.InstructionMenu;
import menus.StartMenu;

public class Main {

	public static void main(String[] args) {
		Frame frame = new Frame();
		
		StartMenu startMenu = new StartMenu(new ImageIcon("res/chicken.png"), new Font("Comic Sans MS", Font.BOLD, 20));
		InstructionMenu instructionMenu = new InstructionMenu(new ImageIcon("res/W.png"), new ImageIcon("res/S.png"), new ImageIcon("res/D.png"), new Font("Comic Sans MS", Font.BOLD, 25));
		EndMenu endMenu = new EndMenu(new ImageIcon("res/gameover.png"),new Font("Comic Sans MS", Font.BOLD, 20));
		EatenMenu eatenMenu = new EatenMenu(new ImageIcon("res/eaten.png"),new ImageIcon("res/filmore.png"));
		
		Player player = new Player(new ImageIcon("res/chicken.png"), Frame.SQUARE * 3, 8);
		TerrainGenerator terrainGenerator = new TerrainGenerator(Frame.HEIGHT / Frame.SQUARE);
		GamePanel gamePanel = new GamePanel(player, terrainGenerator);

		Frame.container.add(startMenu, "startmenu");
		Frame.container.add(instructionMenu, "instructionmenu");
		Frame.container.add(gamePanel, "gamepanel");
		Frame.container.add(endMenu, "endmenu");
		Frame.container.add(eatenMenu,"eatenmenu");
		
		frame.setVisible(true);
	}
}
