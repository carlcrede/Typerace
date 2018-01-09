
/*
*  Server for handling 
*  info shared between
*  clients
*
*/
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Server {

	public Server() {

	}

	public static void main(String args[]) throws IOException {

		// the file path for the game's textfiles.
		File dir = new File("C:\\Users\\Carl_\\Desktop\\DTU\\ingeniørarbejde\\3ugers\\Typerace\\Textfiles");

		// putting all files in the folder into an array
		File[] textFiles = dir.listFiles();

		// instance of random needed to get random .txt file
		Random random = new Random();

		// instance of File needed for choosing a random file in the folder
		File file = textFiles[random.nextInt(textFiles.length)];

		// creating arraylist to put all words from file into
		ArrayList<String> wordsInFile = new ArrayList<String>();

		// using scanner for reading the file, which has been chosen by random
		Scanner s = new Scanner(file);
		s.close();
		// adding each word to the arraylist as long as there still is a line in the
		// file
		while (s.hasNextLine())
			wordsInFile.add(s.next());

		// basically printing each word from the arraylist
		// not entirely sure how we are going to use this. (Just a test)

		// printing how many words are in the file.
		System.out.println(wordsInFile.size());

		for (int i = 0; i < wordsInFile.size(); i++) {

			System.out.println(wordsInFile.get(i) + " ");

		}

		// testing out if we can print a specific word: SUCCESS
		// System.out.println(wordsInFile.get(5));
	}

}