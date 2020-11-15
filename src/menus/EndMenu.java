/* Harry Zhu and Justin Lee
 * ICS3U7 Ms. Strelkovska
 * November 14, 2020
 * Final project
 * This is the class for the end menu
 */

package menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Frame;
import tools.Tools;

public class EndMenu extends JPanel implements ActionListener {
	private JButton again, exit, main;
	private ImageIcon gameover;
	private JLabel score;

	public EndMenu(ImageIcon gameover, Font font) {

		this.setBackground(Tools.WATER);
		this.gameover = gameover;
		again = new JButton();
		exit = new JButton();
		main = new JButton();
		score = new JLabel();

		// Set score location
		score.setLocation(175, 240);
		score.setSize(500, 100);
		score.setFont(font.deriveFont(40f));
		score.setForeground(Color.black);

		// Play again button
		again.setBounds(10, 350, 150, 75);
		again.addActionListener(this);
		again.setText("PLAY AGAIN");
		again.setFont(font);
		again.setBorder(BorderFactory.createLineBorder(Color.black));
		again.setBackground(Color.white);

		// Starter menu button
		main.setBounds(180, 350, 150, 75);
		main.addActionListener(this);
		main.setText("MAIN MENU");
		main.setFont(font);
		main.setBorder(BorderFactory.createLineBorder(Color.black));
		main.setBackground(Color.white);

		// Exits button
		exit.setBounds(350, 350, 150, 75);
		exit.addActionListener(this);
		exit.setText("EXIT");
		exit.setFont(font);
		exit.setBorder(BorderFactory.createLineBorder(Color.black));
		exit.setBackground(Color.white);
		
		//add all the components
		this.add(again);
		this.add(exit);
		this.add(main);
		this.add(score);
		
		this.setLayout(null);
		
		repaint();
		
		this.setVisible(true);
	}

	public void setScore(int intScore) {
		score.setText("Score: " + intScore);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == again) { // Restarts game
			Frame.layout.show(Frame.container, "gamepanel");
		} else if (e.getSource() == main) { // Goes to starter menu 
			Frame.layout.show(Frame.container, "startmenu");
		} else if (e.getSource() == exit) { // Exits program
			System.exit(0);
		}
	}
	// Paints game over logo
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(gameover.getImage(), 50, -50, 400, 400, null);
	}
}
