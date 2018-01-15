
/*
 *  
 *
 */
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JPanel;

public class TxtPicker extends JPanel implements Runnable {

	Main parent;
	ArrayList<String> wordsInFile;

	public TxtPicker(Main parent) {
		this.parent = parent;
	
	} // constructor

	public void getFile() {

		// the file path for the game's textfiles.
		File dir = new File("Textfiles");

		// putting all files in the folder into an array
		File[] textFiles = dir.listFiles();

		// instance of random needed to get random .txt file
		Random random = new Random();

		// instance of File needed for choosing a random file in the folder
		File file;
		do {
			file = textFiles[random.nextInt(textFiles.length)];
		} while (file.getName().equals(".DS_Store"));

		// using scanner for reading the file, which has been chosen by random
		Scanner s = null;
		try {
			// shows name of file in console
			s = new Scanner(file, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (s == null)
			return;

		// adding each word to the arraylist as long as there still is a line in the
		// file
		// creating arraylist to put all words from file into
		ArrayList<String> wordsInFile = new ArrayList<String>();
		
		String w;
		while (s.hasNext()) {
			w = s.next();
			wordsInFile.add(w);
		}
		
		// printing each word from the arraylist + a space between every word to the textarea.

		for (int i = 0; i < wordsInFile.size(); i++) {
			parent.txtArea.setText(parent.txtArea.getText() + wordsInFile.get(i) + " ");
		}
		
	} // getFile method

	public void run() {

		getFile();


	} // run

} // class