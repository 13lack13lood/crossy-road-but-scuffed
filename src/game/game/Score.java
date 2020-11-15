/* Harry Zhu and Justin Lee
 * ICS3U7 Ms. Strelkovska
 * November 14, 2020
 * Final project
 * This is the class for the score
 */

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

	// Gets the score
	public static int getScore() {
		return score;
	}

	// Resets the score
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
