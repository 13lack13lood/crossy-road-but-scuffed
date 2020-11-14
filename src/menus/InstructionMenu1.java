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

public class InstructionMenu1 extends JPanel implements ActionListener {
	private JLabel title, wText, sText, dText;
	private JButton back, next;
	private ImageIcon w, s, d;

	public InstructionMenu1(ImageIcon w, ImageIcon s, ImageIcon d, Font font) {

		this.w = w;
		this.s = s;
		this.d = d;

		title = new JLabel();
		wText = new JLabel();
		sText = new JLabel();
		dText = new JLabel();

		this.setBackground(Tools.WATER);

		// Set button text
		wText.setText("Press W to move up");
		sText.setText("Press S to move down");
		dText.setText("Press D to move right");

		// Set button locations
		wText.setLocation(175, 100);
		wText.setSize(500, 100);
		wText.setFont(font);

		sText.setLocation(175, 200);
		sText.setSize(500, 100);
		sText.setFont(font);

		dText.setLocation(175, 300);
		dText.setSize(500, 100);
		dText.setFont(font);

		// Set title
		title.setText("Crossy Road Instructions");
		title.setLocation(20, 10);
		title.setSize(500, 100);
		title.setFont(font.deriveFont(38f));

		// Starter menu button
		back = new JButton();
		back.setBounds(110, 421, 120, 50);
		back.addActionListener(this);
		back.setText("MENU");
		back.setFont(font);
		back.setBorder(BorderFactory.createLineBorder(Color.black));
		back.setBackground(Color.white);

		// Page 2 button
		next = new JButton();
		next.setBounds(280, 421, 120, 50);
		next.addActionListener(this);
		next.setText("PAGE 2");
		next.setFont(font);
		next.setBorder(BorderFactory.createLineBorder(Color.black));
		next.setBackground(Color.white);

		//add all the components
		this.add(wText);
		this.add(sText);
		this.add(dText);
		this.add(back);
		this.add(next);
		this.add(title);
		
		this.setLayout(null);
		
		repaint();
		
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == back) { // Goes to starter menu
			Frame.layout.show(Frame.container, "startmenu");
		} else if (e.getSource() == next) { // Goes to instruction menu 2
			Frame.layout.show(Frame.container, "instructionmenu2");
		}
	}
	
	// Paints button icons
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(w.getImage(), 60, 120, 75, 75, null); //draws W image
		g.drawImage(s.getImage(), 60, 220, 75, 75, null); //draws S image
		g.drawImage(d.getImage(), 60, 320, 75, 75, null); //draws D image
	}
}
