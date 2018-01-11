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
	
	// arraylist for all words in the file
	ArrayList<String> wordsInFile;
	
	// arraylist for each character in the word
	String[] wordCharactersArray;
	
	ArrayList<String> userInput;
	
	Server test;
	
	
	char keyInputChar;
	String keyInputString;
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
	
	// change the char into a String and store it.
	public void getInput() {
		
		keyInputString = Character.toString(keyInputChar);
		
	}
	
	public void getWord() {
		
		for (int i = 0; i < this.wordsInFile.size(); i++) {
			currentWord = this.wordsInFile.get(i);
			wordToCharacters(currentWord);
			
		}
	}
			
	public void wordToCharacters(String currentWord) {
		
		wordCharactersArray = currentWord.split("");
			
	}
		
	public void compareWord() {	
	
		
		
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
	
	// get the char that is pressed on the keyboard.
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		keyInputChar = e.getKeyChar();
	}

}