package enarmadbandit;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class EnArmadBandit extends JFrame  {
	private Color[]				colorArray = {	Color.blue,				// 0
			Color.green,			// 1
			Color.pink,				// 2
			new Color(200, 50, 200),// 3
			new Color(100, 149, 237),// 4
			new Color(222, 49, 99),				// 5	
			new Color(100, 0, 100),	// 6
			Color.cyan,				// 7
			new Color(100, 149, 237) //8
			
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
	
	public EnArmadBandit() {
		
		for (int i = 0; i < colorArray.length; i++) {
			colors.add(colorArray[i]);
		}
		setTitle("Enaramd bandit");	// The title of our frame.

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// upperPanel
		upperPanel.setBackground(Color.white);
		upperPanel.setPreferredSize(new Dimension(500, 400));
		//upperPanel.setLayout(new GridLayout(1, 3));
				
		//leftPanel
		leftPanel.setBackground(Color.white);
		leftPanel.setPreferredSize(new Dimension(75, 400));
		colorSequenceLeft = new ShowColorSequence(this);
		leftPanel.add(colorSequenceLeft);
		
		//rightPanel
		rightPanel.setBackground(Color.white);
		rightPanel.setPreferredSize(new Dimension(75, 400));
		colorSequenceRight = new ShowColorSequence(this);
		rightPanel.add(colorSequenceRight);
		
		// resultPanel
		resultPanel.setBackground(Color.white);
		resultPanel.setPreferredSize(new Dimension(300, 200));
		resultPanel.setLayout(new GridLayout(1, 3));
		
		columns = new Column[3];	// Panel of rows
		for (int i = 0; i < columns.length; i++)  {
			columns[i] = new Column(this, i);
			resultPanel.add(columns[i]);
		}
		
		
		//playPanel
		playPanel.setBackground(Color.white);
		playPanel.setPreferredSize(new Dimension(500, 200));
		stopButton = new JButton();
		stopButton.setBackground(Color.green);
		stopButton.setPreferredSize(new Dimension(300, 80));
		stopButton.setText("Stop");
		//stopButton.addActionListener(this);
		stopButton.setEnabled(false);
		stopButton.setToolTipText("Click this button to get a code");
		playPanel.add(stopButton);
		
		//add panels to frame
		this.add(upperPanel, BorderLayout.NORTH);
		upperPanel.add(leftPanel);
		upperPanel.add(resultPanel);
		upperPanel.add(rightPanel);
		this.add(playPanel,	BorderLayout.SOUTH);
		
		this.pack();
		this.setLocationRelativeTo(null); // Center frame.
		this.setResizable(false);
		this.setVisible(true);
		///////////////////////////////////////////////////////////////////////////////
		// <--- End of GUI stuff													 //
		///////////////////////////////////////////////////////////////////////////////
		
		// Allow keyboard input
		//this.addKeyListener(kl);
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
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new EnArmadBandit();	// Start the game.
	}
		
	}


