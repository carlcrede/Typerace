import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/*
 * This class is suppose to take care of the game
 * mecanic itself.
 * 
 */

public class Client extends JPanel implements Runnable, CaretListener {

	Main parent;
	String s1;
	String s2;


	public Client(Main parent) {

		this.parent = parent;
		
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
		
		if (s2.length() != s1.length()) {
		
			if (s1.substring(0,s2.length()).equals(s2)) {
				// make user know that what has been typed is right
				parent.progress.setText("<html><b color=#228B22>ALL GOOD, KEEP GOING!</b></html>");
				parent.right.setVisible(true);
				
			}
			else {
				// make user know that there has been made a mistake
				parent.progress.setText("<html><b color=#FF0000>YOU MADE A MISTAKE! YOU NEED TO CORRECT IT!</b></html>");
				parent.right.setVisible(false);
				parent.wrong.setVisible(true);
			}
		}
		// the player will now recieve a message that the game is over if all is typed in correctly.
		else {
			if (s1.substring(0,s2.length()).equals(s2) && !parent.txtArea.getText().isEmpty()) {
				parent.progress.setText("<html><b color=#228B22>YOU ARE VICTORIOUS!</b></html>");
				JOptionPane.showMessageDialog(null, "Congratz, you made it! Play again to improve your typing skills.", "Race Completed", JOptionPane.INFORMATION_MESSAGE);
				
			}
		}
		
	} // caretUpdate
	
} // class
