import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

/*
 * 
 * ** INSERT INFORMATIONAL TEXT THAT 
 * ** THAT GENERALLY DESCRIBES THE 
 * ** PURPOSE OF THIS CLASS
 * 
 */

public class Client extends JPanel implements Runnable, KeyListener {

	Main parent;
	Random rand;
	ArrayList<String> wordsInFile;
	ArrayList<String> userInput;
	Server test;
	
	BufferedReader keyboard;
	InputStreamReader reader;
	String inputText = "";
	
	// keylistener

	public Client(Main parent) {

		this.parent = parent;
		this.rand = new Random();
		this.wordsInFile = test.wordsInFile;
		this.userInput = userInput;
	}
	
	public void compareInputToText () {
		
		
		
		
	}

	public void run() {

			
		

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}