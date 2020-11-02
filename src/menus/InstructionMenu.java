package menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Frame;

public class InstructionMenu extends JPanel implements ActionListener{
	JLabel title, wText, sText, dText;
	JButton back;
	ImageIcon W, S, D;
	public InstructionMenu() {
	
		title = new JLabel();
		wText = new JLabel();
		sText = new JLabel();
		dText = new JLabel();
		W = new ImageIcon("res/W.png");
		S = new ImageIcon("res/S.png");
		D = new ImageIcon("res/D.png");
		this.setBackground(new Color(105, 206, 236));
		
		wText.setText("Press W to move up");
		sText.setText("Press S to move down");
		dText.setText("Press D to move right");
		
		wText.setLocation(175,100);
		wText.setSize(500, 100);
		wText.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		
		sText.setLocation(175,200);
		sText.setSize(500, 100);
		sText.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		
		dText.setLocation(175,300);
		dText.setSize(500, 100);
		dText.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		
		title.setText("Crossy Road Instructions");
		title.setLocation(20,10);
		title.setSize(500, 100);
		title.setFont(new Font("Comic Sans MS",Font.BOLD,38));
		
		back = new JButton();
		back.setBounds(190,421,120,50);
		back.addActionListener(this);
		back.setText("BACK");
		back.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		back.setBorder(BorderFactory.createLineBorder(Color.black));
		back.setBackground(Color.white);
		
		this.add(wText);
		this.add(sText);
		this.add(dText);
		this.add(back);
		this.add(title);
		this.setLayout(null);
		this.setVisible(true);
		repaint();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back) {
			Frame.layout.show(Frame.container,"startmenu");
		}
		
	}
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(W.getImage(),60 , 120, 75, 75, null);
        g.drawImage(S.getImage(),60 , 220, 75, 75, null);
        g.drawImage(D.getImage(),60 , 320, 75, 75, null);
	}
}
