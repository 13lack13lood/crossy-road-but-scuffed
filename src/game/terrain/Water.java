package game.terrain;

import java.awt.Color;
import java.awt.Graphics;

import game.entities.Entity;
import game.entities.Log;
import main.Frame;
import tools.Tools;

public class Water extends Terrain {

	public Water(Color color, int pos) {
		super(color, pos); //call parent constructor
		objects.add(new Log(getPos() * Frame.SQUARE, Tools.generateRandomNumber(0, 1) * Frame.HEIGHT)); //add a log to the terrain
	}

	//method to draw the terrain and all the objects
	public void draw(Graphics g) {
		super.draw(g);
		updateEntityPos();

		//draw all the objects
		for (Entity e : objects) {
			//move and draw the log
			((Log) e).move();
			e.draw(g);
			
			//remove the log if it is off the screen
			if (e.getY() > Frame.HEIGHT || e.getY() + e.getHeight() + 10 < 0) {
				objects.remove(0);
				objects.add(new Log(getPos() * Frame.SQUARE, Tools.generateRandomNumber(0, 1) * Frame.HEIGHT));
			}
		}
	}

}
