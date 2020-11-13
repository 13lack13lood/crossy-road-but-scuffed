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

public class InstructionMenu2 extends JPanel implements ActionListener {
	private JLabel title, eatText, eatText2, mcqText, mcqText2;
	private JButton back, next;
	private ImageIcon mcqueen, filmore;

	public InstructionMenu2(ImageIcon filmore, ImageIcon mcqueen, Font font) {
		this.filmore = filmore;
		this.mcqueen = mcqueen;
		title = new JLabel();
		eatText = new JLabel();
		eatText2 = new JLabel();
		mcqText = new JLabel();
		mcqText2 = new JLabel();

		this.setBackground(Tools.WATER);

		// Set button text
		eatText.setText("No movement for 10s will");
		eatText2.setText("cause Filmore to munch you");
		mcqText.setText("Moving forward will");
		mcqText2.setText("grant you 1 point");

		// Set button locations
		eatText.setLocation(150, 95);
		eatText.setSize(500, 100);
		eatText.setFont(font);

		eatText2.setLocation(150, 125);
		eatText2.setSize(500, 100);
		eatText2.setFont(font);

		mcqText.setLocation(150, 195);
		mcqText.setSize(500, 100);
		mcqText.setFont(font);

		mcqText2.setLocation(150, 225);
		mcqText2.setSize(500, 100);
		mcqText2.setFont(font);

		title.setText("Crossy Road Interactions");
		title.setLocation(20, 10);
		title.setSize(500, 100);
		title.setFont(font.deriveFont(38f));

		// Page 1 button
		back = new JButton();
		back.setBounds(110, 421, 120, 50);
		back.addActionListener(this);
		back.setText("PAGE 1");
		back.setFont(font);
		back.setBorder(BorderFactory.createLineBorder(Color.black));
		back.setBackground(Color.white);

		// Starter menu button
		next = new JButton();
		next.setBounds(280, 421, 120, 50);
		next.addActionListener(this);
		next.setText("NEXT");
		next.setFont(font);
		next.setBorder(BorderFactory.createLineBorder(Color.black));
		next.setBackground(Color.white);

		this.add(eatText);
		this.add(eatText2);
		this.add(mcqText);
		this.add(mcqText2);
		this.add(back);
		this.add(title);
		this.add(next);
		this.setLayout(null);
		repaint();
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == back) { // Goes back to instruction menu1
			Frame.layout.show(Frame.container, "instructionmenu1");
		}
		if (e.getSource() == next) { // Goes to starter menu
			Frame.layout.show(Frame.container, "startmenu");
		}
	}

	public void paintComponent(Graphics g) {
		// Draws car icon images
		super.paintComponent(g);
		g.drawImage(filmore.getImage(), 45, 125, 65, 65, null);
		g.drawImage(mcqueen.getImage(), 45, 225, 65, 65, null);
	}
}
