package game.terrain;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import main.Frame;

public class Terrain extends JPanel {
	private Color color;
	private int width, height;
	private int pos;
	
	public Terrain(Color color, int pos) {
		this.color = color;
		this.pos = pos;
		width = Frame.SQUARE;
		height = Frame.HEIGHT;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillRect(pos * Frame.SQUARE, 0, width, height);
	}
	
}
