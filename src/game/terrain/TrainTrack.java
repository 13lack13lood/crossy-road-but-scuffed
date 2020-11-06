package game.terrain;

import java.awt.Color;
import java.awt.Graphics;

import main.Frame;
import tools.Tools;

public class TrainTrack extends Terrain {

	public TrainTrack(Color color, int pos) {
		super(color, pos);
	}
	
	public void draw(Graphics g) {
		super.draw(g);
		for(int i = 0; i < Frame.HEIGHT; i+= Frame.SQUARE) {
			g.drawImage(Tools.traintrack.getImage(), getPos() * Frame.SQUARE, i, null);
		}
		
	}

}
