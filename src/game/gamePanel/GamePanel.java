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
import main.Frame;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	
	private Timer timer;
	private Player player;
	
	public GamePanel(Player player) {
		this.setBackground(new Color(181, 236, 95));
		this.player = player;
		
		addKeyListener(this);
		
		timer = new Timer(12, this);
		timer.start();
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {

		if(e.getKeyCode() == 87) {
			System.out.println("w");
			player.moveUp();
		} 
		
		if(e.getKeyCode() == 83) {
			System.out.println("s");
			player.moveDown();
		}
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == timer) {
			repaint();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(player.getPlayerIcon().getImage(), Frame.SQUARE, player.getY(), Frame.SQUARE, Frame.SQUARE, null);

	}
	
}
