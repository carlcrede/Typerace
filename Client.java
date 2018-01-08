import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

/*
 * 
 * ** INSERT INFORMATIONAL TEXT THAT 
 * ** THAT GENERALLY DESCRIBES THE 
 * ** PURPOSE OF THIS CLASS
 * 
 */

public class Client extends JPanel implements Runnable {

	Main parent;
	Random rand;
	BufferedReader test;
	ArrayList<String> words = new ArrayList<String>();

	public Client(Main parent) {

		this.parent = parent;
		rand = new Random();
	}

	public void readFile() {

		try {
			test = new BufferedReader(new FileReader("Test.txt"));
		} 
		catch (FileNotFoundException ex) {
			System.out.println("File not found.");
			
		}

	}

	public void run() {

			
		

	}

}