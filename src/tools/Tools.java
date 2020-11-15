/* Harry Zhu and Justin Lee
 * ICS3U7 Ms. Strelkovska
 * November 14, 2020
 * Final project
 * This is the tools class
 */

package tools;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

import main.Frame;

public class Tools {
	//Colors for the terrains and background
	public static final Color GRASS = new Color(181, 236, 95);
	public static final Color WATER = new Color(105, 206, 236);
	public static final Color ROAD = new Color(73, 79, 95);

	//Integers for direction
	public static final int UP = 1;
	public static final int DOWN = 2;
	public static final int FORWARD = 3;

	//font used throughout the game
	public static final Font font = new Font("Comic Sans MS", Font.BOLD, 20);

	//ImageIcons for the pictures in the menus
	public static final ImageIcon icon = new ImageIcon("res/icon.png");
	public static final ImageIcon chicken = new ImageIcon("res/chicken.png");
	public static final ImageIcon W = new ImageIcon("res/W.png");
	public static final ImageIcon S = new ImageIcon("res/S.png");
	public static final ImageIcon D = new ImageIcon("res/D.png");
	public static final ImageIcon filmore = new ImageIcon("res/filmore.png");
	public static final ImageIcon wideMcqueen = new ImageIcon("res/widemcqueen.png");
	public static final ImageIcon eaten = new ImageIcon("res/eaten.png");
	public static final ImageIcon gameOver = new ImageIcon("res/gameover.png");

	//ImageIcons for the entities
	public static final ImageIcon tree = new ImageIcon("res/tree.png");
	public static final ImageIcon traintrack = new ImageIcon("res/traintrack.png");
	public static final ImageIcon log = new ImageIcon("res/log.png");
	public static final ImageIcon[] mcqueenCarsUp = { //array of the mcqueen cars pointing down
			new ImageIcon("res/mcqueen_blue_up.png"),
			new ImageIcon("res/mcqueen_lime_up.png"), 
			new ImageIcon("res/mcqueen_pink_up.png"),
			new ImageIcon("res/mcqueen_red_up.png") 
	};
	public static final ImageIcon[] mcqueenCarsDown = { //array of the mcqueen cars pointing down
			new ImageIcon("res/mcqueen_blue_down.png"),
			new ImageIcon("res/mcqueen_lime_down.png"), 
			new ImageIcon("res/mcqueen_pink_down.png"),
			new ImageIcon("res/mcqueen_red_down.png") 
	};
	public static final ImageIcon[] carsUp = { //array of the normal cars pointing up
			new ImageIcon("res/blue_car_up.png"),
			new ImageIcon("res/orange_car_up.png"), 
			new ImageIcon("res/purple_car_up.png") 
	};
	public static final ImageIcon[] carsDown = { //array of the normal cars pointing down
			new ImageIcon("res/blue_car_down.png"),
			new ImageIcon("res/orange_car_down.png"), 
			new ImageIcon("res/purple_car_down.png") 
	};
	public static final ImageIcon[] trains = { new ImageIcon("res/train.png") };

	//method to generate a random number between 2 numbers inclusive
	public static int generateRandomNumber(int low, int high) {
		Random random = new Random();
		return random.nextInt(high + 1) + low;
	}
	
	//method to generate a list of random numbers between 2 numbers inclusive
	public static ArrayList<Integer> generateRandomNumbers(int low, int high, int size) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < size; i++) {
			list.add(generateRandomNumber(low, high));
		}

		return list;
	}

	//method that generates a random number and compares it to the inputed number
	public static boolean oddsOfSame(int odds) {
		int number = generateRandomNumber(0, 100);

		return number <= odds;
	}

	// Randomly generates mcqueen or normal car
	public static ImageIcon generateCar(int height, int direction) {
		if (height == 1) {
			// Returns mcqueen car based on direction
			if (direction == UP) { //get a mcqueen car from the array with all the images facing up
				int rand = Tools.generateRandomNumber(0, Tools.mcqueenCarsUp.length - 1);
				return Tools.mcqueenCarsUp[rand];
			} else { //get a mcqueen car from the array with all the images facing down
				int rand = Tools.generateRandomNumber(0, Tools.mcqueenCarsDown.length - 1);
				return Tools.mcqueenCarsDown[rand];
			}
		} else {
			// Returns normal car based on direction
			if (direction == UP) { //get a normal car from the array with all the images facing up
				int rand = Tools.generateRandomNumber(0, Tools.carsUp.length - 1);
				return Tools.carsUp[rand];
			} else { //get a normal car from the array with all the images facing down
				int rand = Tools.generateRandomNumber(0, Tools.carsDown.length - 1);
				return Tools.carsDown[rand];
			}
		}
	}

	//method to get the image of a train
	public static ImageIcon generateTrain() {
		return Tools.trains[0];
	}
	
	//method to get the y value of the closes square of the player
	public static int getClosestSquare(int y, boolean isOccupied) {
		int low = (y / Frame.SQUARE) * Frame.SQUARE; //the square above the y value
		int high = low + Frame.SQUARE; //square below the y value
		
		if(isOccupied) { //if the square is occupied, return the other square
			return high;
		}
		
		//checks which square is closer
		if(low + (Frame.SQUARE / 2) >= y) { 
			return low;
		} else {
			return high;
		}
	}
}
