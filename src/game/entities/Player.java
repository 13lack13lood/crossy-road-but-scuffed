package game.entities;

import javax.swing.ImageIcon;

import main.Frame;
import tools.HitBox;

public class Player extends Entity {
	private ImageIcon playerIcon;
	private HitBox hitBox;
	private int y;
	private int dy;

	public Player(ImageIcon playerIcon, int y, int dy) {
		this.playerIcon = playerIcon;
		this.y = y;
		this.dy = y;
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
	
	public void moveUp() {
		y -= (y <= 0) ? 0 : dy;
	}
	
	public void moveDown() { //change later
		y += (y >= Frame.HEIGHT - Frame.SQUARE) ? 0 : dy;
	}
}
