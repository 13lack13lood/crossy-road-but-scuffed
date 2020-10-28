package main;

import menu.StarterMenu;

public class Main {

	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	
	public static void main(String[] args) {
		Game frame = new Game(WIDTH, HEIGHT);
		StarterMenu startermenu = new StarterMenu();
		frame.getContainer().add(startermenu);
	}

}
