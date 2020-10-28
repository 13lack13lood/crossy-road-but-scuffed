package menu;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class StarterMenu {
	
	public StarterMenu(){
		ImageIcon icon= new ImageIcon("res/marioicon.png");
		ImageIcon back= new ImageIcon("res/mario_background.png");
		
		Border border = BorderFactory.createLineBorder(Color.black, 50);
		JLabel label = new JLabel();
		label.setIcon(back);
		JLabel label2 = new JLabel();
		label2.setIcon(back);
		
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
		frame.setLayout(new FlowLayout());
		frame.setIconImage(icon.getImage());
		container.setBackground(Color.RED);
		frame.add(label);
		frame.add(label2);
	
		
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
