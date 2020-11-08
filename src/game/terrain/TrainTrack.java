package game.terrain;

import java.awt.Color;
import java.awt.Graphics;

import game.entities.Car;
import game.entities.Entity;
import game.entities.Train;
import main.Frame;
import tools.Tools;

public class TrainTrack extends Terrain {

	public TrainTrack(Color color, int pos) {
		super(color, pos);
		Train train = new Train(getPos()*Frame.SQUARE);
		objects.add(train);
	}
	
	public void draw(Graphics g) {
		super.draw(g);
		for(int i = 0; i < Frame.HEIGHT; i+= Frame.SQUARE) {
			g.drawImage(Tools.traintrack.getImage(), getPos() * Frame.SQUARE, i, null);
		}
		updateEntityPos();
		for(Entity e : objects) {
			((Train) e).move();
            e.draw(g);
            if(e.getY() > Frame.HEIGHT || e.getY()+e.getHeight()< 0 ) {      
            	objects.remove(0);
            	objects.add(new Train(getPos()*Frame.SQUARE));
            }
        }	
	}
}
