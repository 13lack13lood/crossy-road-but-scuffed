package menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

import main.Game;

public class StarterMenu extends JPanel implements ActionListener{
	private ImageIcon background;
	private JLabel label1, label2;
	private JPanel panel1, panel2;
	private Border border;
	
	public StarterMenu(){
		this.setLayout(null);
		
		background = new ImageIcon("res/mario_background.png");
		
		border = BorderFactory.createLineBorder(Color.black, 50);
		label1 = new JLabel();
		label1.setIcon(background);
		label2 = new JLabel();
		label2.setIcon(background);
		
		panel1 = new JPanel();
		panel1.setBackground(Color.BLUE);
		panel1.setBounds(0,0,500,500);
		
		panel2 = new JPanel();
		panel2.setBackground(Color.GREEN);
		panel2.setBounds(250,0,250,250);
		
		panel1.add(label1);
		panel2.add(label2);
		this.add(panel1);
		this.add(panel2);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
