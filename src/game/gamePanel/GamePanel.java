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
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		this.setBackground(Color.black);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		this.setBackground(Color.black);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	
}
