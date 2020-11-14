package game.terrain;

import java.awt.Color;
import java.awt.Graphics;

import game.entities.Car;
import game.entities.Entity;
import main.Frame;
import tools.Tools;

public class Road extends Terrain {

	public Road(Color color, int pos) {
		super(color, pos); //call parent constructor
		Car car = new Car(getPos() * Frame.SQUARE); //create a car when the road is created
		objects.add(car);
	}

	//method to draw the road
	public void draw(Graphics g) {
		super.draw(g);
		updateEntityPos();

		// Draws Car
		for (Entity e : objects) {
			((Car) e).move();
			e.draw(g);

			//checks if the car is outside the frame
			if (e.getY() - Tools.generateRandomNumber(e.getHeight() * 3, Frame.HEIGHT) > Frame.HEIGHT || e.getY() + e.getHeight() + Tools.generateRandomNumber(e.getHeight() * 3, Frame.HEIGHT) < 0) {
				objects.remove(0); //removes the car
				objects.add(new Car(getPos() * Frame.SQUARE)); //creates a new car
			}
		}
	}
}