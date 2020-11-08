package game.terrain;

import java.awt.Color;
import java.awt.Graphics;

import game.entities.Car;
import game.entities.Entity;
import main.Frame;

public class Road extends Terrain {

	public Road(Color color, int pos) {
		super(color, pos);
		Car car = new Car(getPos()*Frame.SQUARE);
		objects.add(car);
	}
	
	public void draw(Graphics g) {
		super.draw(g);
		updateEntityPos();
		for(Entity e : objects) {
			((Car) e).move();
            e.draw(g);
            if(e.getY() > Frame.HEIGHT || e.getY()+e.getHeight()< 0 ) {      
            	objects.remove(0);
            	objects.add(new Car(getPos()*Frame.SQUARE));
            }
        }
	}
}