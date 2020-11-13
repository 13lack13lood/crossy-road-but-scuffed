package game.terrain;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import main.Frame;
import tools.Tools;

public class TerrainGenerator {

	private ArrayList<Terrain> terrains;
	private boolean isMoving;

	public TerrainGenerator() {
		terrains = generateFreshTerrain();
		isMoving = false;
	}

	private ArrayList<Terrain> generateFreshTerrain() {
		ArrayList<Terrain> list = new ArrayList<Terrain>();

		for (int i = 0; i < 3; i++) {
			list.add(new Grass(new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7)), Tools.GRASS, i));
		}

		for (int i = 3; i < Frame.HEIGHT / Frame.SQUARE; i++) {
			list.add(new Grass(new ArrayList<Integer>(Arrays.asList(0, 7)), Tools.GRASS, i));
		}

		return list;
	}

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

	// Generates new terrain
	private Terrain generateNewTerrain() {
		Terrain lastTerrain = terrains.get(terrains.size() - 1);

		ArrayList<Terrain> terrains = new ArrayList<Terrain>(
				Arrays.asList(new Grass(Tools.GRASS, Frame.WIDTH / Frame.SQUARE - 1),
						new Water(Tools.WATER, Frame.WIDTH / Frame.SQUARE - 1),
						new Road(Tools.ROAD, Frame.WIDTH / Frame.SQUARE - 1),
						new TrainTrack(Tools.ROAD, Frame.WIDTH / Frame.SQUARE - 1)));

		if (lastTerrain instanceof Grass) {
			if (Tools.oddsOfSame(50)) {
				return new Grass(Tools.GRASS, Frame.WIDTH / Frame.SQUARE - 1);
			} else {
				terrains.remove(0);
				Collections.shuffle(terrains);
				return terrains.get(0);
			}
		}

		if (lastTerrain instanceof Water) {
			if (Tools.oddsOfSame(30)) {
				return new Water(Tools.WATER, Frame.WIDTH / Frame.SQUARE - 1);
			} else {
				terrains.remove(1);
				Collections.shuffle(terrains);
				return terrains.get(0);
			}
		}

		if (lastTerrain instanceof Road) {
			if (Tools.oddsOfSame(50)) {
				return new Road(Tools.ROAD, Frame.WIDTH / Frame.SQUARE - 1);
			} else {
				terrains.remove(2);
				Collections.shuffle(terrains);
				return terrains.get(0);
			}
		}

		if (lastTerrain instanceof TrainTrack) {
			if (Tools.oddsOfSame(10)) {
				return new TrainTrack(Tools.ROAD, Frame.WIDTH / Frame.SQUARE - 1);
			} else {
				terrains.remove(3);
				Collections.shuffle(terrains);
				return terrains.get(0);
			}
		}

		return new Grass(Tools.GRASS, Frame.WIDTH / Frame.SQUARE - 1);
	}

	public void draw(Graphics g) {
		for (Terrain terrain : terrains) {
			terrain.draw(g);
		}
	}

	public ArrayList<Terrain> getTerrains() {
		return terrains;
	}

	public boolean isMoving() {
		return isMoving;
	}

	public void setIsMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}
}
