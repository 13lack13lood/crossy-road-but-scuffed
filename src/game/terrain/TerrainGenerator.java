package game.terrain;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;

import main.Frame;
import tools.Tools;

public class TerrainGenerator {
	
	private ArrayList<Terrain> terrains;
	private int columns;
	
	public TerrainGenerator(int columns) {
		this.columns = columns;
		terrains = generateFreshTerrain();
	}
	
	private ArrayList<Terrain> generateFreshTerrain() {
		ArrayList<Terrain> list = new ArrayList<Terrain>();
		list.add(new Grass(Tools.GRASS, 0, new ArrayList<Integer>(), Frame.HEIGHT / Frame.SQUARE));
		list.add(new Grass(Tools.GRASS, 1, new ArrayList<Integer>(), Frame.HEIGHT / Frame.SQUARE));
		list.add(new Grass(Tools.GRASS, 2, new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)), 2));
		list.add(new Grass(Tools.GRASS, 2, new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)), 2));
		
		return list;
	}
	
	public void draw(Graphics g) {
		for(Terrain terrain : terrains) {
			terrain.draw(g);
		}
	}
}
