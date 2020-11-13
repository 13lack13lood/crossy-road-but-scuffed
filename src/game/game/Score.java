package game.game;

import java.awt.Color;
import java.awt.Graphics;

import main.Frame;
import tools.Tools;

public class Score {
	private static int score = 0;

	// Adds 1 score
	public static void updateScore() {
		score++;
	}

	public static int getScore() {
		return score;
	}

	// Sets score to 0
	public static void resetScore() {
		score = 0;
	}

	// Paints score in top right
	public static void drawScore(Graphics g) {
		g.setFont(Tools.font.deriveFont(40f));
		g.setColor(Color.orange);
		String str = Integer.toString(score);
		g.drawString(str, Frame.WIDTH - (str.length() * 40), 50);
	}
}
