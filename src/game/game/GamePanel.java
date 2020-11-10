package game.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import game.entities.Filmore;
import game.entities.Player;
import game.terrain.Terrain;
import game.terrain.TerrainGenerator;
import game.terrain.Water;
import main.Frame;
import main.Main;
import tools.Tools;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	private Timer timer;
	private Player player;
	private TerrainGenerator terrainGenerator;
	private Filmore filmore;

	public GamePanel(Player player, TerrainGenerator terrainGenerator, Filmore filmore) {
		this.setBackground(Color.white);
		this.player = player;
		this.terrainGenerator = terrainGenerator;
		this.filmore = filmore;

		addKeyListener(this);
		setFocusable(true);
		this.requestFocusInWindow();

		timer = new Timer(5, this);
		timer.start();
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == 87) {
			if (player.canMoveUp()) {
				player.moveUp();
				player.setIsMoving(true);
			}
		}

		if (e.getKeyCode() == 83) {
			if (player.canMoveDown()) {
				player.moveDown();
				player.setIsMoving(true);
			}
		}

		if (e.getKeyCode() == 68) {
			if (player.isCanMoveForward()) {
				player.setAfkTime();
				
				Score.updateScore();
				terrainGenerator.setIsMoving(true);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == timer) {
			
			// collision detection
			Terrain playerTerrain = terrainGenerator.getTerrains().get(3);
			Terrain nextTerrain = terrainGenerator.getTerrains().get(4);
			
			if (player.hasCollided(playerTerrain.getObjects(), false) == 1) {
				player.moveDown(); // undo the movement
				player.setCanMoveUp(false);
			} else {
				player.setCanMoveUp(true);
			}

			if (player.hasCollided(playerTerrain.getObjects(), false) == 2) {
				player.moveUp(); // undo the movement
				player.setCanMoveDown(false);
			} else {
				player.setCanMoveDown(true);
			}

			if (player.hasCollided(nextTerrain.getObjects(), true) == 3) {
				player.setCanMoveForward(false);
			} else {
				player.setCanMoveForward(true);
			}
			
//			if(player.hasCollided(playerTerrain.getObjects(), false) != 4 && playerTerrain instanceof Water) {
//				player.setIsDead(true);
//			}

			// check if the player has died
			if (player.isDead()) {
				Main.endMenu.setScore(Score.getScore());


				if(player.isEaten()) {
					Frame.layout.show(Frame.container, "eatenmenu");
					
				} else {
					Frame.layout.show(Frame.container, "endmenu");
				}
				
				player = new Player(Tools.chicken, Frame.SQUARE * 3, 8);
				terrainGenerator = new TerrainGenerator();
				Score.resetScore();

			}
			
			//check if afk
			// Checks if player has moved 
			if(player.isAfk()) {
				player.setEaten(true);
				player.setIsDead(true);
			}
			
//			if(player.getY() < 0 || player.getY() > Frame.HEIGHT) {
//				player.setIsDead(true);
//			}


			// move player
			if (player.canMove()) {
				if (player.playerDoneMoving())
					player.setIsMoving(false);

				if (player.isMoving())
					if (player.getMoveDirection() == Tools.UP)
						player.moveUp();
					else if (player.getMoveDirection() == Tools.DOWN)
						player.moveDown();
			}
			
			repaint();
			requestFocusInWindow();
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (terrainGenerator.isMoving()) {
			terrainGenerator.move();
		}

		terrainGenerator.setIsMoving(false);

		terrainGenerator.draw(g);

//		if(player.isFilmoreIsMove()) {
//			filmore.draw(g);
//			
//			if(player.getY() <= filmore.getY()) {
//				player.draw(g);
//			}
//			
//			filmore.move();
//		} else {
//			player.draw(g);
//		}
		
		player.draw(g);
		
		Score.drawScore(g);
		

	}

}
