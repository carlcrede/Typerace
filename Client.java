import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
	// ArrayList<String> wordsInFile;
	// arraylist for each character in the word
	// String[] wordCharactersArray;
	//ArrayList<String> userInput;
	Server test;
	// variable holding the key that is pressed
	// char keyInputChar;
	// variable holding the key that is pressed converted to a string.
	// String keyInputString;
	// used in getWord
	// String currentWord;
	
	String s1;
	String s2;
	
	//boolean pressingSpacebar;
	
	// txtarea from main
	JTextArea clientTxtArea;
	JTextField txtField;


	public Client(Main parent) {

		this.parent = parent;
		this.rand = new Random();
	
		// nullpointerexception if this is used. y?
		//this.wordsInFile = test.wordsInFile;
		
		//this.userInput = userInput;
		this.clientTxtArea = parent.txtArea;
		this.txtField = parent.inputField;
		this.s1 = parent.txtArea.getText();
		this.s2 = parent.inputField.getText();
		//this.wordsInFile = test.wordsInFile;
	}
	
	/*  Saving this code for later, found another way to do all this using the provided methods in keylistener.
	// change the char into a String and store it.
	public void getInput() {
		
		keyInputString = Character.toString(keyInputChar);
		
	}
	
	public void getWord() {
		
		for (int i = 0; i < this.wordsInFile.size(); i++) {
			currentWord = this.wordsInFile.get(i);
			wordToCharacters(currentWord);
			compareInputToText();
			
			
		}
	}
			
	public void wordToCharacters(String currentWord) {
		
		wordCharactersArray = currentWord.split("");
			
	}
		
		for (int i = 0; i < wordCharactersArray.length; i++) {
			if (wordCharactersArray[i].equals(keyInputString)) {
				
				System.out.println(wordCharactersArray[i]);
			}
			
		}
	} */

		//compareInputToText();
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
		
		if (s1.substring(0,s2.length()).equals(s2)) {
			// make user know that what has been typed is right
			
		}
		else {
			// make user know that there has been made a mistak
		}
	}

}