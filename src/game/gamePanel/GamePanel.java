package game.gamePanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import game.terrain.Terrain;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	
	private ArrayList<Terrain> terrainRows;
	
	public GamePanel() {
		this.setBackground(Color.red);
	}

	
	
	
	
	
	//code to add later

	public void keyTyped(KeyEvent e) {

		this.setBackground(Color.black);
		
	}

	public void keyPressed(KeyEvent e) {

		this.setBackground(Color.black);
	}

	public void keyReleased(KeyEvent e) {

		
	}

	public void actionPerformed(ActionEvent e) {


	}
	
}
