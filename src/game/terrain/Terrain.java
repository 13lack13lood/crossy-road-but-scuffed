package game.terrain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import game.entities.Entity;
import main.Frame;

public class Terrain extends Rectangle {
	//VARIABLES
	protected ArrayList<Entity> objects; //child classes can access the ArrayList
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

	//method to update the position of the entities
	protected void updateEntityPos() { //only child classes have access to this method
		for (Entity e : objects) { //go through each entity
			e.setX(pos * Frame.SQUARE);
		}
	}

	//method to draw the terrain
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(pos * Frame.SQUARE, 0, width, height);
	}
	
	//GETTERS AND SETTERS
	
	//GETTERS
	public ArrayList<Entity> getObjects() {
		return objects;
	}
	
	public int getPos() {
		return pos;
	}
	
	//SETTERS
	public void setPos(int pos) {
		this.pos = pos;
	}
}
