package game.terrain;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import game.entities.Tree;
import main.Frame;
import tools.Tools;

public class TerrainGenerator {
	
	private ArrayList<Terrain> terrains;
	private int columns;
	
	public TerrainGenerator(int columns) {
		this.columns = columns;
	}
	
	private ArrayList<Terrain> generateFreshTerrain() {
		ArrayList<Terrain> list = new ArrayList<Terrain>();
		
		for(int i = 0; i < columns / 2; i++) {
			list.add(new Grass(Tools.GRASS, i));
		}
	}
}
