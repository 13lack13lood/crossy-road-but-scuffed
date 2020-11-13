package game.terrain;

import java.awt.Color;
import java.awt.Graphics;

import game.entities.Entity;
import game.entities.Log;
import main.Frame;
import tools.Tools;

public class Water extends Terrain {

	public Water(Color color, int pos) {
		super(color, pos);
		objects.add(new Log(getPos() * Frame.SQUARE, Tools.generateRandomNumber(0, 1) * Frame.HEIGHT));
	}

	public void draw(Graphics g) {
		super.draw(g);
		updateEntityPos();

		for (Entity e : objects) {
			((Log) e).move();
			e.draw(g);

			if (e.getY() - Tools.generateRandomNumber(e.getHeight() * 3, Frame.HEIGHT) > Frame.HEIGHT
					|| e.getY() + e.getHeight() + Tools.generateRandomNumber(e.getHeight() * 3, Frame.HEIGHT) < 0) {
				objects.remove(0);
				objects.add(new Log(getPos() * Frame.SQUARE, Tools.generateRandomNumber(0, 1) * Frame.HEIGHT));
			}
		}
	}

}
