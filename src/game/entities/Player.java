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
	private boolean onLog;
	private boolean requestMoveDown;
	private boolean requestMoveUp;

	public Player(ImageIcon playerIcon, int y, int dy) {
		super(playerIcon, Frame.SQUARE, Frame.SQUARE, Frame.SQUARE * 3, y, false);
		this.y = y;
		this.dy = dy;
		canMoveUp = true;
		canMoveDown = true;
		canMoveForward = true;
		hasMoved = false;
		onLog = false;
		requestMoveUp = false;
		requestMoveDown = false;
	}
	
	public void setRequestMoveUp(boolean b) {
		requestMoveUp = b;
	}

	public void setRequestMoveDown(boolean b) {
		requestMoveDown = b;
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
	
	public boolean isOnLog() {
		return onLog;
	}
	
	public void setIsOnLog(boolean isOnLog) {
		onLog = isOnLog;
	}
	
	public void moveOnLog(ArrayList<Entity> objects) {
		for(Entity e : objects) {
			Rectangle entityHitbox = new Rectangle(e.getX(), e.getY() + 1, e.getWidth(), e.getHeight() - 1);
			Rectangle playerHitbox = new Rectangle(getX(), getY(), getWidth(), getHeight());
			
			if(playerHitbox.intersects(entityHitbox)) {
				if(!onLog) {
					onLog = true;
					
					if(y > e.getY() && y < e.getY() + Frame.SQUARE) {
						y = e.getY();
					} else if(y > e.getY() + 2 * Frame.SQUARE && y < e.getY() + e.getHeight()) {
						y = e.getY() + 2 * Frame.SQUARE;
					} else {
						y = e.getY() + Frame.SQUARE;
					}
					
				} else {
					if(((Log) e).getDirection() == Tools.UP) {
						y -= ((Log) e).getSpeed();
					} else {
						y += ((Log) e).getSpeed();
					}
					
					moveDirection = ((Log) e).getDirection();
					
					if(requestMoveDown) {
						y += Frame.SQUARE;
						requestMoveDown = false;
					} else if(requestMoveUp) {
						y -= Frame.SQUARE;
						requestMoveUp = false;
					}
					
					if(!playerHitbox.intersects(entityHitbox)) {
						isDead = true;
					}
				}
			} else {
				isDead = true;
				return;
			}
		}
	}

	public int hasCollided(ArrayList<Entity> objects, boolean isNextTerrain, boolean isNextTerrainWater) {
		for (Entity entity : objects) {
			Rectangle entityHitbox = new Rectangle(entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight());

			if (isNextTerrain)
				entityHitbox = new Rectangle(entity.getX() - Frame.SQUARE, entity.getY(), entity.getWidth(), entity.getHeight());

			Rectangle playerHitbox = new Rectangle(getX(), getY(), getWidth(), getHeight());

//			if(isNextTerrainWater) {
//				playerHitbox = new Rectangle(getX(), getY() + 1 , getWidth(), getHeight() - 1);
//			}
			
			if (entityHitbox.intersects(playerHitbox)) {
				if (isNextTerrain && !entity.isCanKill() && !isNextTerrainWater) {
					return 3;
				} else {
					if (!isNextTerrain && entity.isCanKill()) {
						isDead = true;
						return 0;
					} else {
						if (entity.getY() < getY()) {
							return 1;
						}

						if (entity.getY() > getY()) {
							return 2;
						}
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
		return false; //change this later
//		return currentTime - afkTime >= 5000 && currentTime - afkTime < 100000;
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

//	public boolean isFilmoreIsMove() {
//		long currentTime = System.currentTimeMillis();
//		return currentTime - afkTime >= 5000 && currentTime - afkTime < 10000;
//	}
}
