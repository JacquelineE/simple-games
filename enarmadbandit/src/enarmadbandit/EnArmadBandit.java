package enarmadbandit;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Random;

import javax.swing.*;

public class EnArmadBandit extends JFrame implements ActionListener {
	private Color[] colorArray = { Color.yellow, // 0
			Color.green, // 1
			Color.pink, // 2
			new Color(200, 50, 200),// 3
			new Color(100, 149, 237),// 4
			new Color(222, 49, 99), // 5
			new Color(100, 0, 100), // 6
			Color.cyan, // 7
			new Color(100, 149, 237) // 8

	};
	private JPanel resultPanel = new JPanel();
	private JPanel playPanel = new JPanel();
	private JPanel upperPanel = new JPanel();
	private JPanel leftPanel = new JPanel();
	private JPanel rightPanel = new JPanel();

	private JButton stopButton;
	private Column[] columns;
	private ShowColorSequence colorSequenceLeft;
	private ShowColorSequence colorSequenceRight;
	private ArrayList<Color> colors = new ArrayList<Color>();
	private ArrayList<Color> randomCode = new ArrayList<Color>();

	private Column columnObject = new Column();

	public EnArmadBandit() {

		for (int i = 0; i < colorArray.length; i++) {
			colors.add(colorArray[i]);
		}
		setTitle("Enarmad bandit"); // The title of our frame.

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// upperPanel
		upperPanel.setBackground(Color.white);
		upperPanel.setPreferredSize(new Dimension(500, 400));
		// upperPanel.setLayout(new GridLayout(1, 3));

		// leftPanel
		leftPanel.setBackground(Color.white);
		leftPanel.setPreferredSize(new Dimension(75, 400));
		colorSequenceLeft = new ShowColorSequence(this);
		leftPanel.add(colorSequenceLeft);

		// rightPanel
		rightPanel.setBackground(Color.white);
		rightPanel.setPreferredSize(new Dimension(75, 400));
		colorSequenceRight = new ShowColorSequence(this);
		rightPanel.add(colorSequenceRight);

		// resultPanel
		resultPanel.setBackground(Color.white);
		resultPanel.setPreferredSize(new Dimension(300, 200));
		resultPanel.setLayout(new GridLayout(1, 3));

		columns = new Column[3]; // Panel of rows
		for (int i = 0; i < columns.length; i++) {
			columns[i] = new Column(this, i);
			resultPanel.add(columns[i]);
		}

		// playPanel
		playPanel.setBackground(Color.white);
		playPanel.setPreferredSize(new Dimension(500, 200));
		stopButton = new JButton();
		stopButton.setBackground(Color.green);
		stopButton.setPreferredSize(new Dimension(300, 80));
		stopButton.setText("Stop");
		stopButton.addActionListener(this);
		stopButton.setEnabled(true);
		stopButton.setToolTipText("Click this button to get a code");
		playPanel.add(stopButton);

		// add panels to frame
		this.add(upperPanel, BorderLayout.NORTH);
		upperPanel.add(leftPanel);
		upperPanel.add(resultPanel);
		upperPanel.add(rightPanel);
		this.add(playPanel, BorderLayout.SOUTH);

		this.pack();
		this.setLocationRelativeTo(null); // Center frame.
		this.setResizable(false);
		this.setVisible(true);
		// /////////////////////////////////////////////////////////////////////////////
		// <--- End of GUI stuff //
		// /////////////////////////////////////////////////////////////////////////////

		// Allow keyboard input
		// this.addKeyListener(kl);
		this.requestFocus();

	}

	/**
	 * 
	 * @return an arraylist with the colors
	 */
	public ArrayList<Color> getColorSequence() {
		return colors;
	}

	/**
	 * Generates the colors that will appear in the colums.
	 */
	public void generateColor() {
		for (int j = 0; j < columns.length; j++) {
			randomCode.clear();
			Random random = new Random();
			int i = random.nextInt(colors.size());
			randomCode.add(colors.get(i));

			if (i == (colors.size() - 2)) {
				randomCode.add(colors.get(i + 1));
				randomCode.add(colors.get(0));
			} else if (i == (colors.size() - 1)) {
				randomCode.add(colors.get(0));
				randomCode.add(colors.get(1));

			} else {
				randomCode.add(colors.get(i + 1));
				randomCode.add(colors.get(i + 2));
			}
			columns[j].setCode(randomCode);
			for(int a = 0; a < randomCode.size(); a++) {
				System.out.println(randomCode.get(a));
			}
			System.out.println("");
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == stopButton) {
			generateColor();
			
		}
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new EnArmadBandit(); // Start the game.
	}

}
