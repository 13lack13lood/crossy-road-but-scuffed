/* Harry Zhu and Justin Lee
 * ICS3U7 Ms. Strelkovska
 * November 14, 2020
 * Final project
 * This is the class for the player
 */

package game.entities;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import main.Frame;
import tools.Tools;

public class Player extends Entity {
	//VARIABLES
	private int dy; //speed of the player
	private boolean isMoving; //boolean for the move animation
	private int moveDirection; //int for the direction the player is moving in
	private boolean canMoveUp; //boolean to see if the player collided with anything above it
	private boolean canMoveDown; //boolean to see if the player collided with anything below it
	private boolean canMoveForward; //boolean to see if the player collided with anything in front of it
	private boolean isDead; //boolean to know if the player is dead
	private boolean isEaten; //boolean to know if the player is eaten (not moving for 10 seconds)
	private long afkTime; //long to store the system time
	private boolean onLog; //boolean to know if the player is on a log
	private boolean requestMoveDown; //boolean to know if the player requests to move down while on a log
	private boolean requestMoveUp; //boolean to know if the player requests to move up while on a log

	public Player(ImageIcon playerIcon, int y, int dy) {
		super(playerIcon, Frame.SQUARE, Frame.SQUARE, Frame.SQUARE * 3, y, false); //call parent constructor
		this.y = y;
		this.dy = dy;
		canMoveUp = true;
		canMoveDown = true;
		canMoveForward = true;
		onLog = false;
		requestMoveUp = false;
		requestMoveDown = false;
	}
	
	//move the player up
	public void moveUp() {
		moveDirection = Tools.UP;
		y -= (y <= 0) ? 0 : dy; //move the player only if they are within the frame
	}

	//move the player down
	public void moveDown() {
		moveDirection = Tools.DOWN;
		y += (y >= Frame.HEIGHT - Frame.SQUARE) ? 0 : dy; //move the player only if they are within the frame
	}

	//check if the move animation is done
	public boolean playerDoneMoving() {
		return y % Frame.SQUARE == 0;
	}
	
	/* method to check if the player has not moved forward for 10 seconds
	 *  - gets the current system time
	 *  - returns whether the afkTime (the time stamp of when the player moved forward) is greater than 10 seconds (10,000 milliseconds)
	 */
	public boolean isAfk() {
		long currentTime = System.currentTimeMillis();
		return currentTime - afkTime >= 10000 && currentTime - afkTime < 100000;
	}
	
	//method to start/restart the timer to see if the player is not moving
	public void setAfkTime() { 
		afkTime = System.currentTimeMillis();
	}
	
	/* Method to allow the player to move on a log
	 * - Takes in an ArrayList of entities from the terrain it is currently on 
	 * - Checks if the player intersects the log
	 * - Player moves with the log if they intersect
	 * - Player dies if they do not intersect
	 */
	public void moveOnLog(ArrayList<Entity> objects) {
		for(Entity e : objects) { //go through every object from the ArrayList
			//create the rectangles
			Rectangle entityHitbox = new Rectangle(e.getX(), e.getY() + 1, e.getWidth(), e.getHeight() - 1); //rectangle for entity
			Rectangle playerHitbox = new Rectangle(getX(), getY(), getWidth(), getHeight()); //rectangle for player
			
			//check if the player is on a log
			if(playerHitbox.intersects(entityHitbox)) {
				if(!onLog) { //check if the player is on the same log
					onLog = true; //the player is now on a new log
					
					//put the player on the appropriate position on the log
					//there are three positions on the log
					if(y >= e.getY() && y < e.getY() + Frame.SQUARE) { //check for the first position
						y = e.getY(); //set the player's y value
					} else if(y >= e.getY() + 2 * Frame.SQUARE && y < e.getY() + e.getHeight()) { //checks for third position
						y = e.getY() + 2 * Frame.SQUARE; //set the player's y value
					} else { //default is second position
						y = e.getY() + Frame.SQUARE; //set the player's y value
					}
					
				} else { //the player is already on the log
					//checks if the player is on one of the squares of the log
					if(y != e.getY() || y != e.getY() + Frame.SQUARE || y != e.getY() + 2 * Frame.SQUARE) {
						if(y >= e.getY() && y < e.getY() + Frame.SQUARE) { //checks if it is on first square
							y = e.getY();
						} else if(y >= e.getY() + 2 * Frame.SQUARE && y < e.getY() + e.getHeight()) { //check it is on the third square
							y = e.getY() + 2 * Frame.SQUARE; 
						} else { //default position is second square
							y = e.getY() + Frame.SQUARE;
						}
					}
					
					if(((Log) e).getDirection() == Tools.UP) { //move the player according to the direction of where the log is moving to
						y -= ((Log) e).getSpeed(); //move the player up
					} else {
						y += ((Log) e).getSpeed(); //move the player down
					}
					
					moveDirection = ((Log) e).getDirection(); //set the player's move direction to the same direction as the log's
					
					//player's movement on the log
					if(requestMoveDown) { //check if the player requests to move down on the log
						y += Frame.SQUARE; //move the player down 1 square
						requestMoveDown = false;
					} else if(requestMoveUp) { //check if the player requests to move up on the log
						y -= Frame.SQUARE; //move the player up 1 square
						requestMoveUp = false;
					}
					
					//check if the player is still on the log
					if(!playerHitbox.intersects(entityHitbox)) {
						isDead = true; //player is dead if they are not on the log
					}
				}
			} else { //player is dead if they are not on the log but are on water terrain
				isDead = true;
				return;
			}
		}
	}

	/* Collision detection method
	 * - Takes in an ArrayList of entities from the terrain
	 * - Takes in a boolean value to know if the ArrayList is from the terrain the player is currently on or the next terrain
	 * - Takes in another boolean value to know if the next terrain is water
	 * - Creates a rectangle around the player and for each entity
	 * - Checks if the rectangles intersect each other
	 * - If the two rectangles intersect
	 * 		- return 3 if the entity is in front and will not kill the player
	 * 		- return 2 if the entity is below
	 * 		- return 1 if the entity is above
	 * 		- default return is 0
	 * 			- either the player is dead since the entity killed the player
	 * 			- or something broke
	 */
	public int hasCollided(ArrayList<Entity> objects, boolean isNextTerrain, boolean isNextTerrainWater) {
		for (Entity entity : objects) { //go through every object from the ArrayList
			//the rectangles
			Rectangle entityHitbox = new Rectangle(entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight()); //entity rectangle
			Rectangle playerHitbox = new Rectangle(getX(), getY(), getWidth(), getHeight()); //player rectangle
			
			//check if the terrain given is the next terrain
			if(isNextTerrain) { //shift all the entities one square to the right in order to see if the player collides with it
				entityHitbox = new Rectangle(entity.getX() - Frame.SQUARE, entity.getY(), entity.getWidth(), entity.getHeight());
			}
			
			//allows the player to go between trees after moving on a log
			if(onLog) {
				playerHitbox = new Rectangle(getX(), getY() - 15, getWidth(), getHeight() - 15); //makes the player rectangle smaller so it is easier for the player to move to the next terrain between trees
			}
			
			//checks for collision
			if(entityHitbox.intersects(playerHitbox)) {
				if(isNextTerrain && !entity.isCanKill() && !isNextTerrainWater) {
					return 3; //returns 3 if the entity does not kill the player and is the next terrain but not on water
				} else {
					if(!isNextTerrain && entity.isCanKill()) { //player collided with an entity that can kill it
						isDead = true; //player is dead
						return 0; //default return value
					} else {
						if(entity.getY() < getY()) { //check if the player collided with an entity above
							return 1; //entity is above
						}

						if(entity.getY() > getY()) { //check if the player collided with an entity below
							return 2; //entity is below
						}
					}
				}

			}
		}

		return 0; //default return value if something goes wrong
	}
	
	//ALL GETTERS AND SETTERS

	//GETTERS
	public boolean isCanMoveForward() {
		return canMoveForward;
	}
	
	public int getMoveDirection() {
		return moveDirection;
	}
	
	public boolean canMoveUp() {
		return canMoveUp;
	}
	
	public boolean isMoving() {
		return isMoving;
	}
	
	public boolean isDead() {
		return isDead;
	}
	
	public boolean isOnLog() {
		return onLog;
	}
	
	public boolean isEaten() {
		return isEaten;
	}
	
	public boolean canMoveDown() {
		return canMoveDown;
	}
	
	public boolean canMove() { //check if the player can move up or down
		return canMoveUp || canMoveDown;
	}

	//SETTERS
	public void setCanMoveForward(boolean canMoveForward) {
		this.canMoveForward = canMoveForward;
	}
	
	public void setRequestMoveUp(boolean requestMoveUp) {
		this.requestMoveUp = requestMoveUp;
	}

	public void setRequestMoveDown(boolean requestMoveDown) {
		this.requestMoveDown = requestMoveDown;
	}

	public void setCanMoveUp(boolean canMoveUp) {
		this.canMoveUp = canMoveUp;
	}

	public void setCanMoveDown(boolean canMoveDown) {
		this.canMoveDown = canMoveDown;
	}

	public void setIsMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}

	public void setIsDead(boolean isDead) {
		this.isDead = isDead;
	}
	
	public void setIsOnLog(boolean onLog) {
		this.onLog = onLog;
	}

	public void setEaten(boolean isEaten) {
		this.isEaten = isEaten;
	}
}
