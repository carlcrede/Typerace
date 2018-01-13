import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class OliversServerlegerum {
	
	System.out.println("thread 1");
	ClientConnection C1 = new ClientConnection("Thread-1");
	C1.start();
	String j = C1.chosenText;
	System.out.println(j);
	Thread.sleep(50);
	
	
	System.out.println("thread 2");
	ClientConnection C2 = new ClientConnection("Thread-2");
	C2.start();
	
	String l = C2.chosenText;
	System.out.println(l);
	Thread.sleep(50);
	
	
	public static void main (String[] args) {

Socket klientSocket;
		
		ServerSocket serverSock;
		
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
}