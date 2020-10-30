package menus;

import javax.swing.JPanel;

import main.Frame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class StartMenu extends JPanel implements ActionListener{
	

	private JButton play, info, exit;
	
	public StartMenu() {
		
		this.setBackground(new Color(105, 206, 236));
		
		play = new JButton();
		play.setBounds(5,350,120,75);
		play.addActionListener(this);
		play.setText("PLAY");
		play.setFont(new Font("Comic Sans",Font.BOLD,20));
		play.setBorder(BorderFactory.createLineBorder(Color.black));
		
		info = new JButton();
		info.setBounds(190,350,120,75);
		info.addActionListener(this);
		info.setText("INFO");
		info.setFont(new Font("Comic Sans",Font.BOLD,20));
		info.setBorder(BorderFactory.createLineBorder(Color.black));

		exit = new JButton();
		exit.setBounds(370,350,120,75);
		exit.addActionListener(this);
		exit.setText("EXIT");
		exit.setFont(new Font("Comic Sans",Font.BOLD,20));
		exit.setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.setLayout(null);
		this.setVisible(true);
		
		this.add(play);
		this.add(info);
		this.add(exit);
	
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == play) {
			Frame.layout.next(Frame.container);
		}
		else if(e.getSource() == info) {
			System.out.println("info");
		}
		else if(e.getSource() == exit) {
			System.exit(0);
		}
	}
}
