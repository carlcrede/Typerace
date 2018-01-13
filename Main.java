import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Main extends JFrame implements ActionListener, FocusListener {
	
	JButton start, quit;
	JTextArea txtArea;
	JTextField inputField;
	Server txtFile;
	JLabel logo, progress;
	Client test;
	
	public int DEFAULT_HEIGHT = 800;
	public int DEFAULT_WIDTH = 600;
	
	final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
	    
	public Main() {
				
		if (RIGHT_TO_LEFT) {
			setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			
		}
		getContentPane().setLayout(new GridBagLayout());
		getContentPane().setBackground(Color.WHITE);
		
		ImageIcon image = new ImageIcon("Images\\logo.png");
		
		test = new Client(this);
		
		GridBagConstraints c = new GridBagConstraints();
		
		if (shouldFill) {
			c.fill = GridBagConstraints.HORIZONTAL;
		}
		
		 //
        /*
         * insert the animation here
         * 
         */
		
		
		// image on the top
		logo = new JLabel(image);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.gridx = 0;
		c.gridy = 0;
		getContentPane().add(logo, c);
		
		// the area where the .txt file is suppose to be
        txtArea = new JTextArea();
        txtArea.setFont((txtArea.getFont().deriveFont(16f)));
        txtArea.setWrapStyleWord(true);
		txtArea.setEditable(false);
		txtArea.setBackground(getBackground());
		txtArea.setHighlighter(null);
		txtArea.setLineWrap(true);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0,20,0,20);
        c.weightx = 0.7;
        c.weighty = 0.3;
      //  c.ipady = 100;
        c.gridx = 0;
        c.gridy = 1;
        getContentPane().add(txtArea, c);
        
        // add something that can change colours from green to red, so the
        // player knows if he has made a mistake
        
        progress = new JLabel("This will change if you make mistakes");
        progress.setFont(progress.getFont().deriveFont(20f));
        progress.setBackground(Color.GRAY);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.weighty = 0.0;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 2;
        getContentPane().add(progress, c);
        
    
        // textfield where user writes the text
        inputField = new JTextField();
        inputField.addCaretListener(test);
        c.insets = new Insets(0,20,20,20);
        inputField.setFocusable(true);
        inputField.addFocusListener(this);
        inputField.setBackground(getBackground());
        inputField.setHighlighter(null);
        inputField.setFont((inputField.getFont().deriveFont(16f)));
        inputField.setText("Click here to start typing!");
        c.fill = GridBagConstraints.HORIZONTAL;
      //  c.weightx = 0.7;
        c.weighty = 0.3;
        c.gridx = 0;
        c.gridy = 3;
        getContentPane().add(inputField, c);
        
        
        // start btn that makes a request to the server or 
        // something like that. Then a timer, and a game i started
        // when the other player(s) is/are ready.
        
        start = new JButton("New Game");
        start.addActionListener(this);
        c.fill = GridBagConstraints.HORIZONTAL;
     //   c.ipady = 0;
       // c.weightx = 0.3;
        c.gridx = 1;
        c.gridy = 1;
        getContentPane().add(start, c);
        
        // quit btn that quits the game.
        quit = new JButton("Quit");
        quit.addActionListener(this);
       // c.weightx = 0.3;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 3;
        getContentPane().add(quit, c);
        
        // thread
        txtFile = new Server(this);
        Thread tf = new Thread(txtFile);
        tf.start();
        
        
        } // constructor
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == quit) {
			JOptionPane.showMessageDialog(null, "Thanks for using DTUeven Type?", "Goodbye", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
		else if (e.getSource() == start) {	
			Server tst = new Server(this);
			Thread test = new Thread(tst);
			txtArea.setText("");
			inputField.setText("");
			inputField.requestFocus();
			test.start();
			
			
			// makes a request to start the game to the server
			// need a countdown, TODO
			
		}
			
	} // actionPerformed
	
	public void focusGained(FocusEvent e) {
		
		String test = "Click here to start typing!";
		if (inputField.getText().equals(test)) {
			inputField.setText("");
		}
	}

	public void focusLost(FocusEvent e) {
	
	}
	
	public static void main(String args[]) {

		Main doIt = new Main();
		
		JOptionPane.showMessageDialog(null,
		"Welcome to the DTUeven Type?\n" + "Our take on the classic online typing game.\n" + "Have fun!",
		"Welcome to DTUeven Type?", JOptionPane.INFORMATION_MESSAGE);
		
		doIt.setTitle("TypeRacer 1.0"); // Set title on window
		doIt.setSize(800, 600); // Set size
		doIt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		doIt.setVisible(true);
		doIt.setLocationRelativeTo(null);
		doIt.setResizable(false);
		
	} // main

} // class
  
		
	
