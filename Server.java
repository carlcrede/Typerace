
/*
 *  Server for handling 
 *  info shared between
 *  clients
 *
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Server extends JPanel implements Runnable {

	Main parent;
	JTextArea txtarea;
	ArrayList<String> wordsInFile;

	// Do we need this??
	public Server(Main parent) {
		this.parent = parent;
		this.txtarea = parent.txtarea;
	}

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

		// creating arraylist to put all words from file into
		ArrayList<String> wordsInFile = new ArrayList<String>();

		// using scanner for reading the file, which has been chosen by random
		Scanner s = null;
		try {
			// shows name of file in console
			//System.out.println(file.getName());
			s = new Scanner(file, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (s == null)
			return;

		// System.out.println(s.toString());

		// adding each word to the arraylist as long as there still is a line in the
		// file
		
		// printing the path for the file in console
		//System.out.println(file.getAbsolutePath());
		String w;
		while (s.hasNext()) {
			w = s.next();
			// printing words in file to console
			// System.out.print(w+" ");
			wordsInFile.add(w);
		}
		// printing number of words in the file
		// System.out.println(wordsInFile.size());


		// basically printing each word from the arraylist
		// not entirely sure how we are going to use this. (Just a test)

		// printing how many words are in the file.
		// System.out.println(wordsInFile.size());

		for (int i = 0; i < wordsInFile.size(); i++) {
			this.txtarea.setText(this.txtarea.getText() + wordsInFile.get(i) + " ");

			//System.out.println(wordsInFile.get(i) + " ");

		}
	}

	// testing out if we can print a specific word: SUCCESS
	// System.out.println(wordsInFile.get(5));	



	// Trying to make server, don't need thread. Just yet..
	public void run() {


		getFile();


	}

}