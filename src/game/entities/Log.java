package game.entities;


import main.Frame;
import tools.Tools;

public class Log extends Entity {

	private int direction;
	private int speed;
	
	public Log(int x, int y) {
		super(Tools.log, 3 * Frame.SQUARE, Frame.SQUARE, x, y, false);	
		direction = (y == 0) ? Tools.DOWN : Tools.UP;
		speed = 2;
	}
	
	public void move() {
		if(direction == Tools.UP) {
			y -= speed;
		} else {
			y += speed;
		}
	}

}
