import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.net.Socket;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main extends JFrame implements ActionListener, FocusListener {
	
	JButton start, quit;
	public static JTextArea txtArea;
	public static JTextField inputField;
	JPanel btnpanel;
	public static JLabel logo, progress, right, wrong;
	ImageIcon image, checkImg, wrongImg;
	GridBagConstraints c;
	
	Client caret;
	static InputToClient inputToClient;
	static OutputFromClient outputFromClient;
	
	public static Socket sock;
	
	final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
	    
	public Main() {
				
		if (RIGHT_TO_LEFT) {
			setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			
		}
		getContentPane().setLayout(new GridBagLayout());
		getContentPane().setBackground(Color.WHITE);
		
		image = new ImageIcon("Images/logo.png");
		checkImg = new ImageIcon("CheckImg/right.png");
		wrongImg = new ImageIcon("CheckImg/wrong.png");
		
		caret = new Client(this);
		
		c = new GridBagConstraints();
		
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
		c.weightx = 1;
		c.weighty = 0.1;
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
        c.insets = new Insets(0,20,0,0);
        c.weightx = 0.9;
        c.weighty = 0.4;
        c.gridx = 0;
        c.gridy = 1;
        getContentPane().add(txtArea, c);
        
        // add something that can change colours from green to red, so the
        // player knows if he has made a mistake
        
        progress = new JLabel("This will change if you make mistakes");
        progress.setFont(progress.getFont().deriveFont(20f));
        progress.setBackground(Color.GRAY);
        c.insets = new Insets(10,20,20,0);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.9;
        c.weighty = 0.1;
        c.gridx = 0;
        c.gridy = 2;
        getContentPane().add(progress, c);
        
    
        // textfield where user writes the text
        // not focusable. The client class uses this area to 
        inputField = new JTextField();
        inputField.addCaretListener(caret);
        c.insets = new Insets(0,20,20,0);
        inputField.setFocusable(true);
        inputField.addFocusListener(this);
        inputField.setBackground(getBackground());
        inputField.setHighlighter(null);
        inputField.setFont((inputField.getFont().deriveFont(16f)));
        inputField.setText("Click here to start typing!");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 0.4;
        c.weightx = 0.9;
        c.gridx = 0;
        c.gridy = 3;
        getContentPane().add(inputField, c);
        
        
        // start btn that makes a request to the server or 
        // something like that. Then a timer, and a game is started
        // when the other player(s) is/are ready.
        
        start = new JButton("New Game");
        start.addActionListener(this);
        start.setMaximumSize(new Dimension(1000,800));
        
        // quit btn that quits the game.
        quit = new JButton("Quit");
        quit.addActionListener(this);
        quit.setMaximumSize(new Dimension(1000,800));
        
        // panel holding btns
        btnpanel = new JPanel();
        btnpanel.setLayout(new BoxLayout(btnpanel, BoxLayout.PAGE_AXIS));
        btnpanel.add(start);
        btnpanel.add(Box.createRigidArea(new Dimension (110,20)));
        btnpanel.add(quit);
        btnpanel.setBackground(Color.white);
        c.insets = new Insets(0,0,0,40);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.1;
        c.gridx = 1;
        c.gridy = 1;
        getContentPane().add(btnpanel, c);
        
        // labels for image showing if you've made a mistake. Quite messy setup, just an experiment.
        
        right = new JLabel(checkImg);
        right.setVisible(false);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0,20,0,0);
		c.weightx = 0.1;
		c.weighty = 0.0;
		c.gridx = 1;
		c.gridy = 2;
		getContentPane().add(right, c);
		
		wrong = new JLabel(wrongImg);
        wrong.setVisible(false);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0,20,0,0);
		c.weightx = 0.1;
		c.weighty = 0.0;
		c.gridx = 1;
		c.gridy = 2;
		getContentPane().add(wrong, c);
		
		

	    
        } // constructor
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		// game quits if quit btn is pressed.
		if (e.getSource() == quit) {
			JOptionPane.showMessageDialog(null, "Thanks for using DTUeven Type?", "Goodbye", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
		// if start button is pressed, right now it clears the inputfield, and creates a new thread from the server class,
		// which puts a new txtfile in the textarea. Off course this is suppose to send info to the server, when we get that running.
		else if (e.getSource() == start) {	
			txtArea.setText("");
			inputField.setText("");
			inputField.requestFocus();
			right.setVisible(false);
			wrong.setVisible(false);
			
			// makes a request to start the game to the server
			// need a countdown, TODO
			
		}
			
	} // actionPerformed
	
	public void focusGained(FocusEvent e) {
		
		// first time the inputField is in focus, the text in it is cleared.
		String test = "Click here to start typing!";
		if (inputField.getText().equals(test)) {
			inputField.setText("");
		}
	}

	// not used right now.
	public void focusLost(FocusEvent e) {
	
	}
	
	public static void main(String args[]) {

		Main doIt = new Main();
		
		JOptionPane.showMessageDialog(null,
		"Welcome to the DTUeven Type?\n" + "Our take on the classic online typing game.\n" + "Have fun!",
		"Welcome to DTUeven Type?", JOptionPane.INFORMATION_MESSAGE);
 
		 // Connection to server
		 String adress = "";
			
			int port = 1234;
			
			try {
				// skal indlaeses i main
				sock = new Socket(adress,port);
			} catch (IOException e) {
				System.out.println("Can't connect to server");
			} //
			
			// client communication threads
			// client listens for server output
			inputToClient = new InputToClient(sock);
			Thread itc = new Thread(inputToClient);
			itc.start();
			
			// client output
			outputFromClient = new OutputFromClient(sock);
			Thread ofc = new Thread(outputFromClient);
			ofc.start();
			
		
		doIt.setTitle("DTUeven Type? 1.0"); // Set title on window
		doIt.setSize(800, 600); // Set size
		doIt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		doIt.setVisible(true);
		doIt.setLocationRelativeTo(null);
		doIt.setResizable(false);
		
	} // main

	
	
} // class
  
		
	
