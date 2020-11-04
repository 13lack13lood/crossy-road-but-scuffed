package main;

import java.awt.Font;

import javax.swing.ImageIcon;

import game.entities.Player;
import game.gamePanel.GamePanel;
import game.terrain.TerrainGenerator;
import menus.EatenMenu;
import menus.EndMenu;
import menus.InstructionMenu1;
import menus.InstructionMenu2;
import menus.StartMenu;

public class Main {

	public static void main(String[] args) {
		Frame frame = new Frame();
		
		StartMenu startMenu = new StartMenu(new ImageIcon("res/chicken.png"), new Font("Comic Sans MS", Font.BOLD, 20));
		InstructionMenu1 instructionMenu1 = new InstructionMenu1(new ImageIcon("res/W.png"), new ImageIcon("res/S.png"), new ImageIcon("res/D.png"), new Font("Comic Sans MS", Font.BOLD, 25));
		InstructionMenu2 instructionMenu2 = new InstructionMenu2(new ImageIcon("res/filmore.png"),new ImageIcon("res/widemcqueen.png"),new Font("Comic Sans MS", Font.BOLD, 25));
		EndMenu endMenu = new EndMenu(new ImageIcon("res/gameover.png"),new Font("Comic Sans MS", Font.BOLD, 20));
		EatenMenu eatenMenu = new EatenMenu(new ImageIcon("res/eaten.png"),new ImageIcon("res/filmore.png"));
		
		Player player = new Player(new ImageIcon("res/chicken.png"), Frame.SQUARE * 3, 8);
		TerrainGenerator terrainGenerator = new TerrainGenerator();
		GamePanel gamePanel = new GamePanel(player, terrainGenerator);

		Frame.container.add(startMenu, "startmenu");
		Frame.container.add(instructionMenu1, "instructionmenu1");
		Frame.container.add(instructionMenu2, "instructionmenu2");
		Frame.container.add(gamePanel, "gamepanel");
		Frame.container.add(endMenu, "endmenu");
		Frame.container.add(eatenMenu,"eatenmenu");
		
		frame.setVisible(true);
	}
}
