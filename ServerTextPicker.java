import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.net.ServerSocket;
import java.io.*;

//bytearray eller printwriter
//tr��d for at kunne sende til flere p�� samme tid
//Countdown for spillet

public class ServerTextPicker {

	// String med getFile()-teksten
	static String chosenText = "";
	
	// vælger en fil og skriver den som en string
	public static void getFile() {

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
		String w = null;
		while (s.hasNext()) {
			w = s.next();
			// printing words in file to console
			//System.out.print(w+" ");
			wordsInFile.add(w);
		}
				
		// printing number of words in the file
		// System.out.println(wordsInFile.size());


		// basically printing each word from the arraylist
		// not entirely sure how we are going to use this. (Just a test)
		
		// String to be send
		
		// wordsInFile getting put togehter in the String chosenText
		for (int i = 0; i < wordsInFile.size(); i++) {
			//this.txt.setText(this.txt.getText() + wordsInFile.get(i) + " ");

			//System.out.print(wordsInFile.get(i) + " ");
			chosenText = chosenText+wordsInFile.get(i) + " ";
		}
	}
	
	
}