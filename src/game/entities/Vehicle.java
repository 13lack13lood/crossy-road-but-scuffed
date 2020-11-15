/* Harry Zhu and Justin Lee
 * ICS3U7 Ms. Strelkovska
 * November 14, 2020
 * Final project
 * This is the class for all the vehicles
 */

package game.entities;

import javax.swing.ImageIcon;

import main.Frame;
import tools.Tools;

public class Vehicle extends Entity {
	//VARIABLES
	private int speed;
	private int direction;

	public Vehicle(ImageIcon image, int x, int y, int speed, int height, int direction) {
		super(image, height, Frame.SQUARE, x, y, true); //call parent constructor
		this.speed = speed;
		this.direction = direction;
	}

	//method to move the vehicle
	public void move() {
		if (direction == Tools.UP) {
			super.y -= speed;
		} else {
			super.y += speed;
		}
	}

	//GETTERS AND SETTERS
	
	//GETTERS
	public int getSpeed() {
		return speed;
	}

	public int getDirection() {
		return direction;
	}

	//SETTERS
	public void setDirection(int direction) {
		this.direction = direction;
	}

	public void setImage(ImageIcon image) {
		super.image = image;
	}
}
