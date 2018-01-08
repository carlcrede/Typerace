import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Main extends JFrame implements ActionListener {

	final static boolean shouldFill = true;
	final static boolean shouldWeightX = true;
	final static boolean RIGHT_TO_LEFT = false;
	
	int DEFAULT_HEIGHT = 1000;
	int DEFAILT_HEIGHT = 1000;

	Client testrun;
	
	public static void addComponentsToPane (Container pane) {
		
		// testing out how to use GridBagLayout
		
		if (RIGHT_TO_LEFT) {
			pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		}
		
		JButton start, quit;
		JLabel label;
		JTextField txtfield;
		
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		if (shouldFill) {
			c.fill = GridBagConstraints.HORIZONTAL;
			
		}
		// adding start button
		start = new JButton ("Start");
		if (shouldWeightX) {
			c.weightx = 0.5;
		}
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		pane.add(start, c);
		
		// adding quit button
		quit = new JButton ("Quit");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		pane.add(quit, c);
		
		
		
	}
	
	private static void createAndShowGUI() {
		
		
		// creating and setting up window
		JFrame frame = new JFrame ("GridBagLayoutDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// setting up content pane
		addComponentsToPane(frame.getContentPane());
		
		// display window
		frame.pack();
		frame.setVisible(true);
	}
	

	public Main() {

		// gotta make this work!
		/*getContentPane().setLayout(new GridLayout(2, 1));

		testrun = new Client(this);
		getContentPane().add(testrun);

		Thread test = new Thread(testrun);
		test.start();*/
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
	

	public static void main(String args[]) {

		/*
		 * COMMENTED OUT WHILE TESTING GRIDBAG
		 */
		
		/*Main main = new Main();

		main.setTitle("TypeRacer 1.0"); // Set title on window
		main.setSize(800, 600); // Set size
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setVisible(true);
		main.setResizable(true);*/
	}
}
	
