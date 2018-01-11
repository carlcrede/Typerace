import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.sun.prism.paint.Color;

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
	
	// txtarea from main
	JTextArea txtarea;

	public Client(Main parent) {

		this.parent = parent;
		this.rand = new Random();
		this.wordsInFile = test.wordsInFile;
		this.userInput = userInput;
		this.txtarea = parent.txtarea;
	}
	
	// change the char into a String and store it.
	public void getInput() {
		
		keyInputString = Character.toString(keyInputChar);
		
	}
	// taking out each individual word from the file, and 
	// storing it it currentWord.
	public void getWord() {
		
		for (int i = 0; i < this.wordsInFile.size(); i++) {
			currentWord = this.wordsInFile.get(i);
			wordToCharacters(currentWord);
			
		}
	}
	// splitting up a word into each individual character
	// , and storing it in an array.
	public void wordToCharacters(String currentWord) {
		
		wordCharactersArray = currentWord.split("");
			
	}
	// compares input chars to the text chars.
	public void compareInputToText() {	
	
		for (int i = 0; i < wordCharactersArray.length; i++) {
			if (wordCharactersArray[i].equals(keyInputString)) {
				
			}
			
		}
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
		keyInputChar = e.getKeyChar();
	}

}