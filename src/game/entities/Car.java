/* Harry Zhu and Justin Lee
 * ICS3U7 Ms. Strelkovska
 * November 14, 2020
 * Final project
 * This is the car class
 */

package game.entities;

import main.Frame;
import tools.Tools;

public class Car extends Vehicle {

	public Car(int x) {
		super(null, x, 0, Tools.generateRandomNumber(2, 4), Tools.generateRandomNumber(1, 2), Tools.generateRandomNumber(Tools.UP, Tools.DOWN)); //call parent constructor
		image = Tools.generateCar(getHeight(), getDirection()); // Set image depending on height and direction
		height = image.getImage().getHeight(null); // Set height based on image

		//set the direction based on the starting position
		if (getDirection() == Tools.UP) {
			y = Frame.HEIGHT;
		} else {
			y = -getHeight();
		}
	}
}
