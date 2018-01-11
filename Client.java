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

public class Client extends JPanel implements Runnable {

	Main parent;
	Random rand;
	ArrayList<String> wordsInFile;
	ArrayList<String> userInput;
	Server test;
	
	// used in getWord
	String currentWord;
	BufferedReader keyboard;
	InputStreamReader reader;
	
	// keylistener

	public Client(Main parent) {

		this.parent = parent;
		this.rand = new Random();
		this.wordsInFile = test.wordsInFile;
		this.userInput = userInput;
	}
	
	public void getWord() {
		
		for (int i = 0; i < this.wordsInFile.size(); i++) {
			currentWord = this.wordsInFile.get(i);
			compareWord();
		}
			
		}
	
	public void getInput() {
		
		
	}
		
	public void compareWord() {	
	
		
		
	}

	public void run() {

			
		

	}

}