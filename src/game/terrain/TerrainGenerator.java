package game.terrain;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;

import main.Frame;
import tools.Tools;

public class TerrainGenerator {
	
	private ArrayList<Terrain> terrains;
	
	public TerrainGenerator() {
		terrains = generateFreshTerrain();
	}
	
	private ArrayList<Terrain> generateFreshTerrain() {
		ArrayList<Terrain> list = new ArrayList<Terrain>();
		
		for(int i = 0; i < 3; i++) {
			list.add(new Grass(Tools.GRASS, i));
		}
		
		for(int i = 3; i < Frame.HEIGHT / Frame.SQUARE; i++) {
			list.add(new Grass(new ArrayList<Integer>(Arrays.asList(0, 7)), Tools.GRASS, i));
		}
		
		return list;
	}
	
	public void draw(Graphics g) {
		for(Terrain terrain : terrains) {
			terrain.draw(g);
		}
	}
	
	public ArrayList<Terrain> getTerrains(){
		return terrains;
	}
}
