package game.gamePanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import game.entities.Player;
import game.terrain.TerrainGenerator;
import main.Frame;
import tools.Tools;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	
	private Timer timer;
	private Player player;
	private TerrainGenerator terrainGenerator;
	
	public GamePanel(Player player, TerrainGenerator terrainGenerator) {
		this.setBackground(Color.white);
		this.player = player;
		this.terrainGenerator = terrainGenerator;
		
		addKeyListener(this);
		setFocusable(true);
		this.requestFocusInWindow();
		
		timer = new Timer(5, this);
		timer.start();
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {

		if(e.getKeyCode() == 87) {
			System.out.println("adf");
			player.moveUp();
			player.setIsMoving(true);
		} 
		
		if(e.getKeyCode() == 83) {
			player.moveDown();
			player.setIsMoving(true);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == timer) {
			//move player
			if(player.playerDoneMoving())
				player.setIsMoving(false);
			
			if(player.isMoving())
				if(player.getMoveDirection() == Tools.UP) 
					player.moveUp();
				else if(player.getMoveDirection() == Tools.DOWN)
					player.moveDown();
			
			
			
			repaint();
			requestFocusInWindow();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		player.draw(g);
		terrainGenerator.draw(g);
		
	}
	
}
