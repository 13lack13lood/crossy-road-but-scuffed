package game.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import game.entities.Entity;
import game.entities.Player;
import game.terrain.Terrain;
import game.terrain.TerrainGenerator;
import game.terrain.Water;
import main.Frame;
import main.Main;
import tools.Tools;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	//VARIABLES
	private Timer timer;
	private Player player;
	private TerrainGenerator terrainGenerator;

	public GamePanel(Player player, TerrainGenerator terrainGenerator) {
		setBackground(Color.white); //set the background to white
		this.player = player;
		this.terrainGenerator = terrainGenerator;

		addKeyListener(this); //allow this panel to listen for keys
		setFocusable(true); //allow this panel to be focused
		this.requestFocusInWindow(); //request focus

		timer = new Timer(5, this); //create a new timer and start it
		timer.start();
	}

	public void keyTyped(KeyEvent e) {} //unused methods from KeyListener interface

	public void keyPressed(KeyEvent e) {} //unused methods from KeyListener interface

	public void keyReleased(KeyEvent e) {
		//check if the W key is pressed		
		if(e.getKeyCode() == 87) {
			if(player.isOnLog()) { //check if the player is on a log
				player.setRequestMoveUp(true); //move the player differently if they are on a log
			} else if(player.canMoveUp()) {
				player.moveUp(); //move up 8 pixels
				player.setIsMoving(true); //start the moving animation
			}
		}

		//check if S key is pressed
		if(e.getKeyCode() == 83) {
			if(player.isOnLog()) { //check if player is on a log
				player.setRequestMoveDown(true); //move the player differently if they are on a log
			} else if (player.canMoveDown()) { //otherwise move normally
				player.moveDown(); //move down 8 pixels
				player.setIsMoving(true); //start the moving animation
			}
		}

		//check if D key is pressed
		if (e.getKeyCode() == 68) {
			if (player.isCanMoveForward()) {
				player.setIsOnLog(false); //reset the onLog boolean every time the player moves forward
				player.setAfkTime(); //reset the timer to check if the player is not moving

				Score.updateScore(); //update the score
				terrainGenerator.setIsMoving(true); //move the terrain 1 time
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == timer) {
			// collision detection
			Terrain playerTerrain = terrainGenerator.getTerrains().get(3);
			Terrain nextTerrain = terrainGenerator.getTerrains().get(4);
			
			//check if the player is on water
			if(playerTerrain instanceof Water) {
				player.moveOnLog(playerTerrain.getObjects()); //move the player differently if they are on a log
			} else {
				player.setIsOnLog(false); //reset the onLog boolean
				
				//make sure the player is on a square and not a random y value
				if(!player.isMoving()) {
					for(Entity entity : playerTerrain.getObjects()) {
						//set the player position to the nearest square
						if(Tools.getClosestSquare(player.getY(), false) == entity.getY()) { //check if that square has an object on it
							player.setY(Tools.getClosestSquare(player.getY(), true)); //set the player to that square if there is no object on it
						} else {
							player.setY(Tools.getClosestSquare(player.getY(), false)); //set the player to another square
						}
					}
				}
				
				//checks if the player collides with something above it
				if (player.hasCollided(playerTerrain.getObjects(), false, nextTerrain instanceof Water) == 1) {
					player.moveDown(); // undo the movement
					player.setCanMoveUp(false); //don't allow the player to move if it collides with something
				} else {
					player.setCanMoveUp(true);
				}

				//check if player collides with something below it
				if (player.hasCollided(playerTerrain.getObjects(), false, nextTerrain instanceof Water) == 2) {
					player.moveUp(); // undo the movement
					player.setCanMoveDown(false); //don't allow the player to move if it collides with something
				} else {
					player.setCanMoveDown(true);
				}
			}
			
			//check if the player collides with an object in front 
			if (player.hasCollided(nextTerrain.getObjects(), true, nextTerrain instanceof Water) == 3) {
				player.setCanMoveForward(false); //player can't move forward it will collide with something
			} else {
				player.setCanMoveForward(true);
			}


			// check if the player has died
			if (player.isDead()) {
				Main.endMenu.setScore(Score.getScore());

				//check if the player got eaten and open the appropriate menu
				if(player.isEaten()) {
					Frame.layout.show(Frame.container, "eatenmenu"); //open the eaten menu if the player got eaten
				} else {
					Frame.layout.show(Frame.container, "endmenu"); //open the end menu otherwise
				}

				player = new Player(Tools.chicken, Frame.SQUARE * 3, 8); //reset the player
				terrainGenerator = new TerrainGenerator(); //reset the terrains
				Score.resetScore(); //reset the score

			}
			
			//check if afk
			if(player.isAfk()) {
				player.setEaten(true);
				player.setIsDead(true);
			}
			
			//check if player is off the screen
			if(player.getY() < 0 || player.getY() + Frame.SQUARE/ 2 > Frame.HEIGHT) {
				player.setIsDead(true);
			}

			// move player
			if (player.canMove()) {
				if (player.playerDoneMoving()) //ckeck if the player is in the moving animation
					player.setIsMoving(false);

				if (player.isMoving()) //move the player only if it is supposed to move
					if (player.getMoveDirection() == Tools.UP) //move the player up
						player.moveUp();
					else if (player.getMoveDirection() == Tools.DOWN) //move the player down
						player.moveDown();
			}

			repaint(); //redraw screen
			requestFocusInWindow(); //make sure keyboard and mouse input still work
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		//move the terrain only if the player moves forward
		if (terrainGenerator.isMoving()) {
			terrainGenerator.move();
		}

		terrainGenerator.setIsMoving(false); //make sure terrain only moves once at a time
		terrainGenerator.draw(g); //draw the terrain

		player.draw(g); //draw the player

		Score.drawScore(g); //draw the score
	}

}
