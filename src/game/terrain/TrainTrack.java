/* Harry Zhu and Justin Lee
 * ICS3U7 Ms. Strelkovska
 * November 14, 2020
 * Final project
 * This is the class for the train track terrain
 */

package game.terrain;

import java.awt.Color;
import java.awt.Graphics;

import game.entities.Entity;
import game.entities.Train;
import main.Frame;
import tools.Tools;

public class TrainTrack extends Terrain {

	public TrainTrack(Color color, int pos) {
		super(color, pos); //call parent class
		Train train = new Train(getPos() * Frame.SQUARE);  //create a new train when a train track is created
		objects.add(train);
	}
	
	//method to draw the train and the train track
	public void draw(Graphics g) {
		super.draw(g);
		
		//draw the train tracks
		for (int i = 0; i < Frame.HEIGHT; i += Frame.SQUARE) {
			g.drawImage(Tools.traintrack.getImage(), getPos() * Frame.SQUARE, i, null);
		}

		updateEntityPos();

		// Draws train
		for (Entity e : objects) {
			//move and draw the train
			((Train) e).move();
			e.draw(g);
			
			//checks if train is out of the frame
			if (e.getY() - Tools.generateRandomNumber(e.getHeight() * 3, Frame.HEIGHT) > Frame.HEIGHT || e.getY() + e.getHeight() + Tools.generateRandomNumber(e.getHeight() * 3, Frame.HEIGHT) < 0) {
				objects.remove(0); //removes the train from the ArrayList
				objects.add(new Train(getPos() * Frame.SQUARE)); //creates a new train
			}
		}
	}
}
