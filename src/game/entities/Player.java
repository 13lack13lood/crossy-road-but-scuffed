package game.entities;

import java.awt.Rectangle;
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
	private boolean canMoveForward;
	private boolean isDead;
	private boolean isEaten;
	private long afkTime;
	private boolean hasMoved;

	public Player(ImageIcon playerIcon, int y, int dy) {
		super(playerIcon, Frame.SQUARE, Frame.SQUARE, Frame.SQUARE * 3, y, false);
		this.y = y;
		this.dy = dy;
		canMoveUp = true;
		canMoveDown = true;
		setCanMoveForward(true);
		hasMoved = false;
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

	public boolean isDead() {
		return isDead;
	}

	public void setIsDead(boolean isDead) {
		this.isDead = isDead;
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

	public int hasCollided(ArrayList<Entity> objects, boolean isNextTerrain) {
		for (Entity entity : objects) {
			Rectangle entityHitbox = new Rectangle(entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight());

			if (isNextTerrain)
				entityHitbox = new Rectangle(entity.getX() - Frame.SQUARE, entity.getY(), entity.getWidth(),
						entity.getHeight());

			Rectangle playerHitbox = new Rectangle(getX(), getY(), getWidth(), getHeight());

			if (entityHitbox.intersects(playerHitbox)) {
				if (isNextTerrain) {
					if (entity.getY() < getY()) {
						return 1;
					}

					if (entity.getY() > getY()) {
						return 2;
					}

					return 3;
				} else {
					if (entity.isCanKill()) {
						isDead = true;
						return 0;
					} else {
						if (entity.getY() < getY()) {
							return 1;
						}

						if (entity.getY() > getY()) {
							return 2;
						}

						return 3;
					}
				}

			}
		}

		return 0;
	}

	public boolean isCanMoveForward() {
		return canMoveForward;
	}

	public void setCanMoveForward(boolean canMoveForward) {
		this.canMoveForward = canMoveForward;
	}

	public boolean isAfk() {
		long currentTime = System.currentTimeMillis();
		return currentTime - afkTime >= 6000 && currentTime - afkTime < 100000;
	}

	public void setAfkTime() {
		afkTime = System.currentTimeMillis();
	}

	public boolean isHasMoved() {
		return hasMoved;
	}

	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}

	public boolean isEaten() {
		return isEaten;
	}

	public void setEaten(boolean isEaten) {
		this.isEaten = isEaten;
	}

	public boolean isFilmoreIsMove() {
		long currentTime = System.currentTimeMillis();
		return currentTime - afkTime >= 5000 && currentTime - afkTime < 10000;
	}
}
