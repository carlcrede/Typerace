import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;
<<<<<<< HEAD
import javax.swing.JTextArea;
import javax.swing.JTextField;
=======
>>>>>>> b2ec4095ad41c5a5d70c6f1de0130fb32a67c82f

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
<<<<<<< HEAD
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
=======
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
>>>>>>> b2ec4095ad41c5a5d70c6f1de0130fb32a67c82f

	public Client(Main parent) {

		this.parent = parent;
		this.rand = new Random();
<<<<<<< HEAD
	
		// nullpointerexception if this is used. y?
		//this.wordsInFile = test.wordsInFile;
		
		//this.userInput = userInput;
		this.clientTxtArea = parent.txtArea;
		this.txtField = parent.inputField;
		this.s1 = parent.txtArea.getText();
		this.s2 = parent.inputField.getText();
=======
		this.wordsInFile = test.wordsInFile;
		this.userInput = userInput;
>>>>>>> b2ec4095ad41c5a5d70c6f1de0130fb32a67c82f
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
<<<<<<< HEAD
			compareInputToText();
			
=======
>>>>>>> b2ec4095ad41c5a5d70c6f1de0130fb32a67c82f
			
		}
	}
			
	public void wordToCharacters(String currentWord) {
		
		wordCharactersArray = currentWord.split("");
			
	}
		
<<<<<<< HEAD
		for (int i = 0; i < wordCharactersArray.length; i++) {
			if (wordCharactersArray[i].equals(keyInputString)) {
				
				System.out.println(wordCharactersArray[i]);
			}
			
		}
	} */

	public void run() {

		//compareInputToText();
=======
	public void compareWord() {	
	
		
		
	}

	public void run() {

			
>>>>>>> b2ec4095ad41c5a5d70c6f1de0130fb32a67c82f
		

	}

	@Override
	public void keyPressed(KeyEvent e) {
<<<<<<< HEAD
			
=======
		// TODO Auto-generated method stub
		
>>>>>>> b2ec4095ad41c5a5d70c6f1de0130fb32a67c82f
	}
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	
	// get the char that is pressed on the keyboard.
	public void keyTyped(KeyEvent e) {
<<<<<<< HEAD
		
		if (s1.substring(0,s2.length()).equals(s2)) {
			// make user know that what has been typed is right
			
		}
		else {
			// make user know that there has been made a mistake
		}
=======
		// TODO Auto-generated method stub
		keyInputChar = e.getKeyChar();
>>>>>>> b2ec4095ad41c5a5d70c6f1de0130fb32a67c82f
	}

}