package game.entities;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import main.Frame;
import tools.HitBox;
import tools.Tools;

public class Player extends Entity {
	private ImageIcon playerIcon;
	private int dy;
	private boolean isMoving;
	private int moveDirection;

	public Player(ImageIcon playerIcon, int y, int dy) {
		super(playerIcon, new HitBox(Frame.SQUARE, y, Frame.SQUARE, Frame.SQUARE), Frame.SQUARE, Frame.SQUARE, y, false);
		this.playerIcon = playerIcon;
		this.y = y;
		this.dy = dy;
	}
	
	public void draw(Graphics g) {
		g.drawImage(playerIcon.getImage(), super.getX(), super.gettY(), null);
	}
	
	public int getMoveDirection() {
		return moveDirection;
	}
	
	public void moveUp() {
		moveDirection = Tools.UP;
		y -= (y <= 0) ? 0 : dy;
	}
	
	public void moveDown() {
		moveDirection = Tools.DOWN;
		y += (y >= Frame.HEIGHT - Frame.SQUARE) ? 0 : dy;
	}

	
	public boolean isMoving() {
		return isMoving;
	}
	
	public void setIsMoving(boolean b) {
		isMoving = b;
	}
	
	public boolean playerDoneMoving() {
		return y % Frame.SQUARE == 0;
	}
}
