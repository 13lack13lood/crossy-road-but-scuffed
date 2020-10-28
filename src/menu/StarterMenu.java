package menu;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class StarterMenu {
	
	StarterMenu(){
		ImageIcon icon= new ImageIcon("res/marioicon.png");
		ImageIcon back= new ImageIcon("res/mariobackground.jpg");
		
		
		Border border = BorderFactory.createLineBorder(Color.black, 50);
		JLabel label = new JLabel();
		label.setIcon(back);
		label.setText("POGGERS");
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.BLUE);
		panel1.setBounds(0,0,500,500);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.GREEN);
		panel2.setBounds(250,0,250,250);
		
		JFrame frame = new JFrame();
		Container container = frame.getContentPane();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1600,800);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setIconImage(icon.getImage());
		
		container.setBackground(Color.RED);
		panel1.setBorder(border);
		panel1.add(label);
		frame.add(panel1);
		frame.add(panel2);
	}
}
