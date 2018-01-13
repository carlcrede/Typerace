import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/*
 * 
 * ** INSERT INFORMATIONAL TEXT THAT 
 * ** THAT GENERALLY DESCRIBES THE 
 * ** PURPOSE OF THIS CLASS
 * 
 */

public class Client extends JPanel implements Runnable, CaretListener {

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
	
	public void run() {


	}

	// get the char that is pressed on the keyboard.
	public void caretUpdate(CaretEvent e) {
		
		
		
		s1 = parent.txtArea.getText();
		s2 = parent.inputField.getText();
		
		System.out.println("PTEXT:" + s2);
		
		if (s1.substring(0,s2.length()).equals(s2)) {
			// make user know that what has been typed is right
			
			System.out.println("You're doing fine!");
			System.out.println(s2.length());
		}
		
		else {
			// make user know that there has been made a mistak
			System.out.println("You made a mistake");
		}
	}

}
