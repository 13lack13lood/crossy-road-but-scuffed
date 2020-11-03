package game.terrain;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import main.Frame;

public class Terrain extends Rectangle {
	private Color color;
	private int width, height;
	private int pos;
	
	public Terrain(Color color, int pos) {
		this.color = color;
		this.pos = pos;
		width = Frame.SQUARE;
		height = Frame.HEIGHT;
	}
	
	public int getPos() {
		return pos;
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(pos * Frame.SQUARE, 0, width, height);
	}
}
