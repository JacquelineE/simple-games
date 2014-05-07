package enarmadbandit;

import java.awt.*;
import java.util.*;

import javax.swing.*;

public class Column extends JPanel {

	private EnArmadBandit gameFrame;
	private ArrayList<Color> code = new ArrayList<Color>();
	
	
	public Column() {
		this.setBackground(Color.white);
	}
	
	public Column(EnArmadBandit bandit, int num) {
		this();
		gameFrame = bandit;
		this.setPreferredSize(new Dimension(50, 300));
		for (int i = 0; i < 3; i++) {
			code.add(Color.gray);
		}
		
	}

	/**
	 * setCode(code) sets the code that this Row will contain.
	 * @param gameCode is the code to be showed in this Row.
	 */
	public void setCode(ArrayList<Color> gameCode) {
		code = new ArrayList<Color>(gameCode);
		this.repaint();
	}
	/**
	 * paint() draws this Column onto the JPanel "canvas".
	 */
	public void paint(Graphics g) {
		super.paint(g);
		
		// Draw the code:
		for (int i = 0; i < 3; i++) {
			g.setColor(code.get(i));// ska istället ta index från en array som skapas 
			//i den arrayen lagrar man de färger som ska printas ut 
			//de kommer i sin tur från en annan array 
			//se till att fgärgerna här är lagade i rätt ordning 
			g.fillOval(30 , (11 + 70 * i), 40, 40);	
		}
		
	}
	
}
