import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.net.ServerSocket;
import java.io.*;

//bytearray eller printwriter
//tr��d for at kunne sende til flere p�� samme tid
//Countdown for spillet


//PrintWriter til at sende
//BufferedReader til at modtage
//Lav to tr��de pr. connected klient.


public class ClientConnection implements Runnable {
	private Thread t;
	private String threadName;
	
	ClientConnection(String name) {
		threadName = name;
		
	}
	
	public void start() {
		if (t==null) {
			t = new Thread (this, threadName);
			t.start();
		}
	}
	
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

	static Socket klientSocket;
	
	public static ServerSocket serverSock;
	
	public void run() {
		try {
			serverSock = new ServerSocket(9001);
		} catch (Exception ex) {
			System.out.println("can't start server");
		}
			
		try {
			// Server starts
			// Loop can't be closed
			
			//holder do while loopet koerrende
			boolean requestListener = false;
			
			// String der sendes fra server til client
			String msgForClient;
			
			// Output i form af msgForClient
			PrintWriter output = null;
			
			// Connection to client loop
			while (true) {
				klientSocket = serverSock.accept();
				try {
					output = new PrintWriter(klientSocket.getOutputStream());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				
				do {
					try {
						// modtager input fra klient
						Scanner clientInput = new Scanner(klientSocket.getInputStream());
						// laver input til string
						String clientInputString = clientInput.nextLine();
				
						// lukker scanneren
						clientInput.close();
						
// mangler traade		// goer noget, hvis string er lig med "start" Boer laves som "hvis client1.equals(client2) -> start countdown"
						
						if (clientInputString.equals("Start")) {
							
							getFile();
							
							output.println(chosenText);
							output.flush();
							
							// Venter på accept fra begge clienter
							while (!(clientInputString.equals("Accept"))) {
								clientInputString = clientInput.nextLine();
							}
							
							msgForClient = "Start countdown";
							output.print(msgForClient+"\r\n");
							output.flush();
							
						}
						
					} catch (IOException e) {
						System.out.println("Can't open scanner");
					}
					
				} while (requestListener = false);
				
				
			} // Server ends
		} catch (Exception ex) {
			System.out.println("Can't connect to client");
		}	
		
	}

	// testing out if we can print a specific word: SUCCESS
	// System.out.println(wordsInFile.get(5));
}