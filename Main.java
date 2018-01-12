import java.awt.ComponentOrientation;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main extends JFrame implements ActionListener {
	
	JButton start, quit;
	JTextArea txtArea;
	JTextField inputField;
	Server txtFile;
	
	//Highlighter highlighter;
	//HighlightPainter painter;
	KeyListener input;
	
	Client test;
	
	public int DEFAULT_HEIGHT = 800;
	public int DEFAULT_WIDTH = 600;
	
	final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
	    
	public Main() {
		
		test = new Client(this);

		
		//  work = new Client(this);
		
		//highlighter = txtarea.getHighlighter();
		
		// painter = new DefaultHighlighter.DefaultHighlightPainter(Color.GREEN);
				
		if (RIGHT_TO_LEFT) {
			setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			
		}
		getContentPane().setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		if (shouldFill) {
			c.fill = GridBagConstraints.HORIZONTAL;
		}
		
		 //
        /*
         * insert the animation here
         * 
         */
		
		// the area where the .txt file is suppose to be
        txtArea = new JTextArea();
        txtArea.setFont((txtArea.getFont().deriveFont(16f)));
		txtArea.setEditable(false);
		txtArea.setHighlighter(null);
		txtArea.setLineWrap(true);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.7;
        c.weighty = 0.5;
        c.ipady = 100;
        c.gridx = 0;
        c.gridy = 0;
        getContentPane().add(txtArea, c);
        
        // textfield where user writes the text
        inputField = new JTextField();
        inputField.addKeyListener(test);
        inputField.setFocusable(true);
        inputField.setHighlighter(null);
        inputField.setFont((inputField.getFont().deriveFont(16f)));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.7;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        getContentPane().add(inputField, c);
        
        
        // start btn that makes a request to the server or 
        // something like that. Then a timer, and a game i started
        // when the other player(s) is/are ready.
        start = new JButton("New Game");
        start.addActionListener(this);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.3;
        c.gridx = 1;
        c.gridy = 0;
        getContentPane().add(start, c);
        
        // quit btn that quits the game.
        quit = new JButton("Quit");
        quit.addActionListener(this);
        c.weightx = 0.3;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        getContentPane().add(quit, c);
        
        // thread
        txtFile = new Server(this);
        Thread tf = new Thread(txtFile);
        tf.start();
        
        }
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == quit) {
			JOptionPane.showMessageDialog(null, "Thanks for using DTUeven Type?", "Goodbye", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
		else if (e.getSource() == start) {
			start.setText("3,2,1,GO!");
			
			// makes a request to start the game to the server
			// need a countdown, TODO
			
		}
			
	}

	public static void main(String args[]) {
		/*
		PrintWriter pw;
		try {
			pw = new PrintWriter("Textfiles/abcd.txt");
			pw.println("Test");
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		Main doIt = new Main();
		
		JOptionPane.showMessageDialog(null,
		"Welcome to the DTUeven Type?\n" + "Our take on the classic online typing game.\n" + "Have fun!",
		"Welcome to DTUeven Type?", JOptionPane.INFORMATION_MESSAGE);
		
		doIt.setTitle("TypeRacer 1.0"); // Set title on window
		doIt.setSize(800, 600); // Set size
		doIt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		doIt.setVisible(true);
		doIt.setLocationRelativeTo(null);
		doIt.setResizable(true);
		
	}

}
  
		
	
