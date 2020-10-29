package menu;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.Game;

public class InstructionMenu extends JPanel implements ActionListener {
	private JButton goMenu; // variables: button

	public InstructionMenu(){  // constructor
        goMenu=new JButton("         Go to menu panel     ");
        goMenu.addActionListener(this);
        this.setLayout(new FlowLayout());
        this.add(goMenu);
		this.setBackground(Color.BLUE);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == goMenu)
			Game.cardLayout.next(Game.container);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 18)); // set a new font
		g.drawString("---Game panel---", 200, 300); // display the string starting at the coordinate (100, 200)
	}// end of paint


}
