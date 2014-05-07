package enarmadbandit;

import java.awt.*;
import java.util.*;

import javax.swing.*;

public class ShowColorSequence extends JPanel {

	private EnArmadBandit gameFrame;
	private ArrayList<Color> colorSequence;
	
	public ShowColorSequence() {
		this.setBackground(Color.white);
		
	}
		
	public ShowColorSequence(EnArmadBandit bandit) {
		this();
		gameFrame = bandit;
		this.setPreferredSize(new Dimension(60, 400));
		colorSequence = new ArrayList<Color>(bandit.getColorSequence());
	}

	/**
	 * paint() draws this Column onto the JPanel "canvas".
	 */
	public void paint(Graphics g) {
		super.paint(g);
		
		// Draw the code:
		for (int i = 0; i < colorSequence.size(); i++) {
			g.setColor(colorSequence.get(i));
			g.fillOval(25 , (11 + 40 * i), 15, 15);	
		}
		
	}
	
}
