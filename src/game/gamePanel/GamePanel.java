package game.gamePanel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import game.entities.Player;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	
	private Timer timer;
	private Player player;
	
	public GamePanel() {
		this.setBackground(Color.red);
		
		player = new Player(new ImageIcon("res/icon.png"), 288, 72);
		
		timer = new Timer(1000, this);
		timer.start();
	}

	public void keyTyped(KeyEvent e) {

		
	}

	public void keyPressed(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {

		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == timer) {
			player.setX(player.getX() + player.getDx());
			repaint();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(player.getPlayerIcon().getImage(),player.getX(), player.getY(), 72, 72, null);
	}
	
}
