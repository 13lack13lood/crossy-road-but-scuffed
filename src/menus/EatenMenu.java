package menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import main.Frame;
import tools.Tools;

public class EatenMenu extends JPanel implements ActionListener{
	private JButton next;
	private ImageIcon eaten, filmore;
	
	public EatenMenu(ImageIcon eaten, ImageIcon filmore) {
		this.setBackground(Tools.WATER);
		this.eaten = eaten;
		this.filmore = filmore;
		next = new JButton();
		
		next.setBounds(190, 421, 120, 50);
		next.addActionListener(this);
		next.setText("NEXT");
		next.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		next.setBorder(BorderFactory.createLineBorder(Color.black));
		next.setBackground(Color.white);
		
		this.add(next);
		this.setLayout(null);
		repaint();
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == next) {
			Frame.layout.show(Frame.container, "endmenu");
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(eaten.getImage(), 30, -15, 450, 350, null);
		g.drawImage(filmore.getImage(), 150, 325, 192, 64, null);
	}
}
