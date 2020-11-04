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

public class InstructionMenu extends JPanel implements ActionListener {
	private JLabel title, wText, sText, dText, eatText, eatText2;
	private JButton back;
	private ImageIcon w, s, d, filmore;
	
	public InstructionMenu(ImageIcon filmore, ImageIcon w, ImageIcon s, ImageIcon d, Font font) {

		this.w = w;
		this.s = s;
		this.d = d;
		this.filmore = filmore;
		
		title = new JLabel();
		wText = new JLabel();
		sText = new JLabel();
		dText = new JLabel();
		eatText = new JLabel();
		eatText2 = new JLabel();

		this.setBackground(Tools.WATER);

		wText.setText("Press W to move up");
		sText.setText("Press S to move down");
		dText.setText("Press D to move right");
		eatText.setText("No movement for 10s will");
		eatText2.setText("cause Filmore to munch you");

		wText.setLocation(150, 80);
		wText.setSize(500, 100);
		wText.setFont(font);

		sText.setLocation(150, 160);
		sText.setSize(500, 100);
		sText.setFont(font);

		dText.setLocation(150, 240);
		dText.setSize(500, 100);
		dText.setFont(font);
		
		eatText.setLocation(150, 305);
		eatText.setSize(500, 100);
		eatText.setFont(font);
		
		eatText2.setLocation(150, 335);
		eatText2.setSize(500, 100);
		eatText2.setFont(font);

		title.setText("Crossy Road Instructions");
		title.setLocation(20, -10);
		title.setSize(500, 100);
		title.setFont(font.deriveFont(38f));

		back = new JButton();
		back.setBounds(190, 440, 120, 50);
		back.addActionListener(this);
		back.setText("BACK");
		back.setFont(font);
		back.setBorder(BorderFactory.createLineBorder(Color.black));
		back.setBackground(Color.white);

		this.add(wText);
		this.add(sText);
		this.add(dText);
		this.add(eatText);
		this.add(eatText2);
		this.add(back);
		this.add(title);
		this.setLayout(null);
		repaint();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == back) {
			Frame.layout.show(Frame.container, "startmenu");
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(w.getImage(), 45, 100, 65, 65, null);
		g.drawImage(s.getImage(), 45, 180, 65, 65, null);
		g.drawImage(d.getImage(), 45, 260, 65, 65, null);
		g.drawImage(filmore.getImage(), 45, 340, 65, 65, null);
	}
}
