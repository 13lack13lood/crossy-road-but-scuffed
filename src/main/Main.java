package main;

import game.entities.Player;
import game.game.GamePanel;
import game.terrain.TerrainGenerator;
import menus.EatenMenu;
import menus.EndMenu;
import menus.InstructionMenu1;
import menus.InstructionMenu2;
import menus.StartMenu;
import tools.Tools;

public class Main {

	public static EndMenu endMenu = new EndMenu(Tools.gameOver, Tools.font);

	public static void main(String[] args) {
		Frame frame = new Frame();

		StartMenu startMenu = new StartMenu(Tools.chicken, Tools.font);
		InstructionMenu1 instructionMenu1 = new InstructionMenu1(Tools.W, Tools.S, Tools.D, Tools.font.deriveFont(25f));
		InstructionMenu2 instructionMenu2 = new InstructionMenu2(Tools.filmore, Tools.wideMcqueen,
				Tools.font.deriveFont(25f));
		EatenMenu eatenMenu = new EatenMenu(Tools.eaten, Tools.filmore);

		Player player = new Player(Tools.chicken, Frame.SQUARE * 3, 8);
		TerrainGenerator terrainGenerator = new TerrainGenerator();
		GamePanel gamePanel = new GamePanel(player, terrainGenerator);

		Frame.container.add(startMenu, "startmenu");
		Frame.container.add(instructionMenu1, "instructionmenu1");
		Frame.container.add(instructionMenu2, "instructionmenu2");
		Frame.container.add(gamePanel, "gamepanel");
		Frame.container.add(eatenMenu, "eatenmenu");
		Frame.container.add(endMenu, "endmenu");

		frame.setVisible(true);
	}
}
