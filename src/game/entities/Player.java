package game.entities;

import javax.swing.ImageIcon;

import tools.HitBox;

public class Player extends Entity {
	private ImageIcon playerIcon;
	private HitBox hitBox;
	private int y;
	private int dy;
	private int x; //remove later
	private int dx; //remove later
	
	public Player(ImageIcon playerIcon, int y, int dy) {
		this.playerIcon = playerIcon;
		this.y = y;
		this.dy = y;
		x = 0; //remove later
		dx = 72; //remove later
	}

	public ImageIcon getPlayerIcon() {
		return playerIcon;
	}

	public HitBox getHitBox() {
		return hitBox;
	}

	public int getY() {
		return y;
	}

	public int getDy() {
		return dy;
	}

	public int getX() { //remove later
		return x;
	}

	public int getDx() { //remove later
		return dx;
	}
	
	public void setY(int y) {
		this.y = y;
	}


	public void setX(int x) {
		this.x = x;
	}
}
