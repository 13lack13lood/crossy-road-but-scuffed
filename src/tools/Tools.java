package tools;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class Tools {
	public static final Color GRASS = new Color(181, 236, 95);
	public static final Color WATER = new Color(105, 206, 236);
	public static final Color ROAD = new Color(73, 79, 95);

	public static final int UP = 1;
	public static final int DOWN = 2;
	public static final int FORWARD = 3;

	public static final Font font = new Font("Comic Sans MS", Font.BOLD, 20);

	public static final ImageIcon icon = new ImageIcon("res/icon.png");
	public static final ImageIcon chicken = new ImageIcon("res/chicken.png");
	public static final ImageIcon W = new ImageIcon("res/W.png");
	public static final ImageIcon S = new ImageIcon("res/S.png");
	public static final ImageIcon D = new ImageIcon("res/D.png");
	public static final ImageIcon filmore = new ImageIcon("res/filmore.png");
	public static final ImageIcon wideMcqueen = new ImageIcon("res/widemcqueen.png");
	public static final ImageIcon eaten = new ImageIcon("res/eaten.png");
	public static final ImageIcon gameOver = new ImageIcon("res/gameover.png");

	public static final ImageIcon tree = new ImageIcon("res/tree.png");
	public static final ImageIcon traintrack = new ImageIcon("res/traintrack.png");
	public static final ImageIcon log = new ImageIcon("res/log.png");
	public static final ImageIcon[] mcqueenCarsUp = { 
			new ImageIcon("res/mcqueen_blue_up.png"),
			new ImageIcon("res/mcqueen_lime_up.png"), 
			new ImageIcon("res/mcqueen_pink_up.png"),
			new ImageIcon("res/mcqueen_red_up.png") 
	};
	public static final ImageIcon[] mcqueenCarsDown = { 
			new ImageIcon("res/mcqueen_blue_down.png"),
			new ImageIcon("res/mcqueen_lime_down.png"), 
			new ImageIcon("res/mcqueen_pink_down.png"),
			new ImageIcon("res/mcqueen_red_down.png") 
	};
	public static final ImageIcon[] carsUp = { 
			new ImageIcon("res/blue_car_up.png"),
			new ImageIcon("res/orange_car_up.png"), 
			new ImageIcon("res/purple_car_up.png") 
	};
	public static final ImageIcon[] carsDown = { 
			new ImageIcon("res/blue_car_down.png"),
			new ImageIcon("res/orange_car_down.png"), 
			new ImageIcon("res/purple_car_down.png") 
	};
	public static final ImageIcon[] trains = { new ImageIcon("res/train.png") };

	public static int generateRandomNumber(int low, int high) {
		Random random = new Random();
		return random.nextInt(high + 1) + low;
	}

	public static ArrayList<Integer> generateRandomNumbers(int low, int high, int size) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < size; i++) {
			list.add(generateRandomNumber(low, high));
		}

		return list;
	}

	public static boolean oddsOfSame(int odds) {
		int number = generateRandomNumber(0, 100);

		return number <= odds;
	}

	public static ImageIcon generateCar(int height, int direction) {
		if (height == 1) {
			if (direction == UP) {
				int rand = Tools.generateRandomNumber(0, Tools.mcqueenCarsUp.length - 1);
				return Tools.mcqueenCarsUp[rand];
			} else {
				int rand = Tools.generateRandomNumber(0, Tools.mcqueenCarsDown.length - 1);
				return Tools.mcqueenCarsDown[rand];
			}
		} else {
			if (direction == UP) {
				int rand = Tools.generateRandomNumber(0, Tools.carsUp.length - 1);
				return Tools.carsUp[rand];
			} else {
				int rand = Tools.generateRandomNumber(0, Tools.carsDown.length - 1);
				return Tools.carsDown[rand];
			}
		}
	}

	public static ImageIcon generateTrain() {
		return Tools.trains[0];
	}
}
