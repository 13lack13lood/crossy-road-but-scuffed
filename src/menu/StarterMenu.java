package menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

import main.Game;

public class StarterMenu extends JPanel implements ActionListener{
	private JButton  goGame;    // variables: button
	
	public StarterMenu(){  // constructor
           goGame=new JButton("   Go to game panel   ");
           goGame.addActionListener(this);
           this.setLayout(new FlowLayout());
           this.add(goGame);     // add the button
		   this.setBackground(Color.GREEN);
	}	   
    public void actionPerformed(ActionEvent e) {
	      if(e.getSource()==goGame)
			      Game.cardLayout.next(Game.container);
    }

}
