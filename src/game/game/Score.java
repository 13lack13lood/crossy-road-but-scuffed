package game.game;

import java.awt.Color;
import java.awt.Graphics;

import main.Frame;
import tools.Tools;

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
		g.setFont(Tools.font.deriveFont(40f));
		g.setColor(Color.orange);
		String str = Integer.toString(score);
		g.drawString(str, Frame.WIDTH - (str.length() * 40), 50);
	}
}