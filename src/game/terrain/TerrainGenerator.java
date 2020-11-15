/* Harry Zhu and Justin Lee
 * ICS3U7 Ms. Strelkovska
 * November 14, 2020
 * Final project
 * This is the class for generating the terrain
 */

package game.terrain;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import main.Frame;
import tools.Tools;

public class TerrainGenerator {
	//VARIABLES
	//terrains are stored in an ArrayList so the first terrain can be removed and a new terrain can be added at the end
	private ArrayList<Terrain> terrains; 
	private boolean isMoving; //variable to know if the terrains will be shift

	public TerrainGenerator() {
		terrains = generateFreshTerrain(); //generate the starting terrain when the game starts
		isMoving = false;
	}

	//method for generating the terrain when the game starts
	private ArrayList<Terrain> generateFreshTerrain() {
		ArrayList<Terrain> list = new ArrayList<Terrain>();

		//add 3 rows of grass where it is covered with trees
		for (int i = 0; i < 3; i++) {
			list.add(new Grass(new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7)), Tools.GRASS, i));
		}

		//add 5 rows or grass where there is a tree on the top and bottom
		for (int i = 3; i < Frame.HEIGHT / Frame.SQUARE; i++) {
			list.add(new Grass(new ArrayList<Integer>(Arrays.asList(0, 7)), Tools.GRASS, i));
		}

		return list;
	}

	/* Method to move the terrains
	 * remove the leftmost one
	 * shift all the terrain positions
	 * add a new terrain based on the previous terrain
	 */
	public void move() {
		terrains.remove(0);
		shiftTerrainPos();
		terrains.add(generateNewTerrain());
	}

	// Shifts terrain position
	private void shiftTerrainPos() {
		for (Terrain terrain : terrains) {
			terrain.setPos(terrain.getPos() - 1);
		}
	}

	/* Method that generates new terrain based on what the previous terrain was
	 * Has an equal chance of returning the other types of terrains if the previous terrain is not chosen
	 * If the previous terrain was grass
	 * 		there is a 50% chance of the next terrain being grass
	 * If the previous terrain was water
	 * 		there is a 30% chance of the next terrain being water
	 * If the previous terrain was road
	 * 		there is a 50% chance of the next terrain being road
	 * If the previous terrain was train track
	 * 	 	there is a 10% chance of the next terrain being train track
	 * 
	 * If something broke
	 * 		it would return a grass terrain by default
	 */
	private Terrain generateNewTerrain() {
		Terrain lastTerrain = terrains.get(terrains.size() - 1);

		//ArrayList of all the types of terrains
		ArrayList<Terrain> terrains = new ArrayList<Terrain>(
				Arrays.asList(
						new Grass(Tools.GRASS, Frame.WIDTH / Frame.SQUARE - 1),
						new Water(Tools.WATER, Frame.WIDTH / Frame.SQUARE - 1)//,
//						new Road(Tools.ROAD, Frame.WIDTH / Frame.SQUARE - 1),
//						new TrainTrack(Tools.ROAD, Frame.WIDTH / Frame.SQUARE - 1)
				)
		);

		//CHECKS THE TYPE OF TERRAIN THE LAST ONE WAS
		
		//checks if the terrain was grass
		if (lastTerrain instanceof Grass) {
			if (Tools.oddsOfSame(50)) { //50% chance of the next terrain being grass
				return new Grass(Tools.GRASS, Frame.WIDTH / Frame.SQUARE - 1);
			} else {
				terrains.remove(0); //remove the grass terrain from the ArrayList
				Collections.shuffle(terrains); //shuffle all the terrains
				return terrains.get(0); 
			}
		}

		//checks if the terrain was water
		if (lastTerrain instanceof Water) {
			if (Tools.oddsOfSame(30)) { //30% chance of the next terrain being water
				return new Water(Tools.WATER, Frame.WIDTH / Frame.SQUARE - 1);
			} else {
				terrains.remove(1); //remove the water terrain from the ArrayList
				Collections.shuffle(terrains); //shuffle all the terrains
				return terrains.get(0);
			}
		}

		//checks if the terrain was road
		if (lastTerrain instanceof Road) {
			if (Tools.oddsOfSame(50)) { //50% chance of the next terrain being water
				return new Road(Tools.ROAD, Frame.WIDTH / Frame.SQUARE - 1);
			} else {
				terrains.remove(2); //remove the road terrain from the ArrayList
				Collections.shuffle(terrains); //shuffle all the terrains
				return terrains.get(0);
			}
		}

		//checks if the terrain was train track
		if (lastTerrain instanceof TrainTrack) {
			if (Tools.oddsOfSame(10)) { //10% chance of the next terrain being water
				return new TrainTrack(Tools.ROAD, Frame.WIDTH / Frame.SQUARE - 1);
			} else {
				terrains.remove(3); //remove the train track terrain from the ArrayList
				Collections.shuffle(terrains); //shuffle all the terrains
				return terrains.get(0); 
			}
		}

		//return grass terrain if none of the if statements were true
		return new Grass(Tools.GRASS, Frame.WIDTH / Frame.SQUARE - 1);
	}

	//draw all the terrains
	public void draw(Graphics g) {
		for (Terrain terrain : terrains) {
			terrain.draw(g);
		}
	}

	//GETTERS AND SETTERS
	
	//GETTERS
	public ArrayList<Terrain> getTerrains() {
		return terrains;
	}

	public boolean isMoving() {
		return isMoving;
	}

	//SETTERS
	public void setIsMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}
}
