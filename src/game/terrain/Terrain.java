package game.terrain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import game.entities.Entity;
import main.Frame;

public class Terrain extends Rectangle {
	protected ArrayList<Entity> objects;
	private Color color;
	private int width, height;
	private int pos;

	public Terrain(Color color, int pos) {
		this.color = color;
		this.pos = pos;
		width = Frame.SQUARE;
		height = Frame.HEIGHT;
		objects = new ArrayList<Entity>();
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public ArrayList<Entity> getObjects() {
		return objects;
	}

	protected void updateEntityPos() {
		for (Entity e : objects) {
			e.setX(pos * Frame.SQUARE);
		}
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(pos * Frame.SQUARE, 0, width, height);
	}
}
