package game.entities;

import javax.swing.ImageIcon;

import tools.Tools;

public class Car extends Vehicle {
	
	public Car(int x) {
		super(null, x, 0, 2, Tools.generateRandomNumber(1, 2), Tools.generateRandomNumber(1, 2));
		super.image = Tools.generateCar(getHeight(), getDirection());
		super.height = super.image.getImage().getHeight(null);
		
	
	}
}
