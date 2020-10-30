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

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	
	private Timer timer;
	private Player player;
	private int x, y;
	
	public GamePanel() {
		this.setBackground(Color.red);
		
		player = new Player(new ImageIcon("res/icon.png"), 300, 1);
		
		x = 0;
		y = 0;
		
		timer = new Timer(0, this);
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
//			y += 1;
			repaint();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int j = 0; j < 10; j++)
			for(int i = 0; i < 10; i++)
				g.drawImage(player.getPlayerIcon().getImage(),x+64*i, y+60*j, 64, 64, null);

	}
	
}
