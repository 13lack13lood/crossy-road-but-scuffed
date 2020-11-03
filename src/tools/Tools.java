package tools;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Tools {
	public static final Color GRASS = new Color(181, 236, 95);
	public static final Color WATER = new Color(105, 206, 236);
	
	public static final int UP = 1;
	public static final int DOWN = 2;
	public static final int FORWARD = 3;
	
	public static int generateRandomNumber(int low, int high) {
		Random random = new Random();
		return random.nextInt(high + 1) + low;
	}
	
	public static ArrayList<Integer> fillArrayListIncreasing(int size){
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < size; i++) {
			list.add(i);
		}
		
		return list;
	}
}
