package game.entities;

import main.Frame;
import tools.Tools;

public class Log extends Entity {
	//VARIABLES
	private int direction;
	private int speed;

	public Log(int x, int y) {
		super(Tools.log, 3 * Frame.SQUARE, Frame.SQUARE, x, y, false); //call parent constructor
		
		//reposition the y value if it is 0
		if(getY() == 0) {
			setY(-getHeight());
		}
		
		direction = (y == Frame.HEIGHT) ? Tools.UP : Tools.DOWN; //set the direction based on where the log is generated
		speed = 2;
	}

	//method to move the log
	public void move() {
		if (direction == Tools.UP) {
			y -= speed; //move the log up
		} else {
			y += speed; //move the log down
		}
	}
	
	//GETTERS
	public int getDirection() {
		return direction;
	}

	public int getSpeed() {
		return speed;
	}
}
