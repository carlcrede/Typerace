import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/*
 * This class is suppose to take care of the game
 * mecanic itself.
 * 
 */

public class Client extends JPanel implements CaretListener {

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
	
	public void caretUpdate(CaretEvent e) {
		
		s1 = Main.txtArea.getText();
		s2 = Main.inputField.getText();
		
		
		if (s2.length() != s1.length()) {
		
			if (s1.substring(0,s2.length()).equals(s2)) {
				// make user know that what has been typed is right
				Main.progress.setText("<html><b color=#228B22>ALL GOOD, KEEP GOING!</b></html>");
				Main.right.setVisible(true);
				
			}
			else {
				// make user know that there has been made a mistake
				Main.progress.setText("<html><b color=#FF0000>YOU MADE A MISTAKE! YOU NEED TO CORRECT IT!</b></html>");
				Main.right.setVisible(false);
				Main.wrong.setVisible(true);
			}
		}
		// the player will now recieve a message that the game is over if all is typed in correctly.
		else {
			if (s1.substring(0,s2.length()).equals(s2) && !Main.txtArea.getText().isEmpty()) {
				Main.progress.setText("<html><b color=#228B22>YOU ARE VICTORIOUS!</b></html>");
				JOptionPane.showMessageDialog(null, "Congratz, you made it! Play again to improve your typing skills.", "Race Completed", JOptionPane.INFORMATION_MESSAGE);
				OutputFromClient.iWin = true;
				InputToClient.imTheWinner = true;
			}
		}
		
	} // caretUpdate
	
} // class
