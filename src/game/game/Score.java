package game.game;

import java.awt.Graphics;

public class Score {
	private static int score = 0;
	
	public static void updateScore() {
		score++;
	}
	
	public static int getScore() {
		return score;
	}
	
	public static void resetScore() {
		score = 0;
	}
	
	public static void drawScore(Graphics g) {
		g.drawString(Integer.toString(score), 400, 0);
	}
}
