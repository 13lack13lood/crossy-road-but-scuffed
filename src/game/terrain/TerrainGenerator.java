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
	
	public void move() {
		
	}
	
	private Terrain generateNewTerrain() {
		Terrain lastTerrain = terrains.get(terrains.size() - 1);
		int oddsOfSame;
		int randomNumber = Tools.generateRandomNumber(1, 100);
		
		if(lastTerrain instanceof Grass) {
			oddsOfSame = 56;
		} else if(lastTerrain instanceof Water) {
			oddsOfSame = 40;
		} else if(lastTerrain instanceof Road) {
			oddsOfSame = 49;
		} else {
			oddsOfSame = 19;
		}
		
		if(randomNumber <= oddsOfSame) {
			if(lastTerrain instanceof Grass) {
				return new Grass(Tools.GRASS, terrains.size() - 1, ((Grass) lastTerrain).getPrevMovingSquares());
			} else if(lastTerrain instanceof Water) {
				oddsOfSame = 40;
			} else if(lastTerrain instanceof Road) {
				oddsOfSame = 49;
			} else {
				oddsOfSame = 19;
			}
		}
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
