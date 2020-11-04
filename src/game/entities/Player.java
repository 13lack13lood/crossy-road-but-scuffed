package game.entities;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import main.Frame;
import tools.Tools;

public class Player extends Entity {
	private int dy;
	private boolean isMoving;
	private int moveDirection;
	private boolean canMoveUp;
	private boolean canMoveDown;

	public Player(ImageIcon playerIcon, int y, int dy) {
		super(playerIcon, Frame.SQUARE, Frame.SQUARE, Frame.SQUARE * 3, y, false);
		this.y = y;
		this.dy = dy;
		canMoveUp = true;
		canMoveDown = true;
	}
	
	public int getMoveDirection() {
		return moveDirection;
	}
	
	public boolean canMoveUp() {
		return canMoveUp;
	}
	
	public boolean canMoveDown() {
		return canMoveDown;
	}
	
	public void setCanMoveUp(boolean b) {
		canMoveUp = b;
	}
	
	public void setCanMoveDown(boolean b) {
		canMoveDown = b;
	}

	public boolean canMove() {
		return canMoveUp || canMoveDown;
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
	
	public int hasCollided(ArrayList<Entity> objects) {
		for(Entity entity : objects) {
//			System.out.println(entity.getY());
			
			if(entity.getY() + entity.getHeight() >= y && entity.getY() <= y) {
				return 1;
			}
			
			if(y + getHeight() >= entity.getY() && y <= entity.getY()) {
				return 2;
			}

		}
		
		return 0;
	}
}
