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

public class ServerTest extends Thread {
	Socket socket;
	String threadName;
	
	public ServerTest (Socket clientSocket) {
		this.socket = clientSocket;
	}
	
	public void run() {
		// String der sendes fra server til client
		String msgForClient;
		
		// Output i form af msgForClient
		PrintWriter output = null;
		
		// Connection to client loop
		while (true) {
			try {
				output = new PrintWriter(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			while (true) {
				try {
					// modtager input fra klient
					Scanner clientInput = new Scanner(socket.getInputStream());
					// laver input til string
					String clientInputString = clientInput.nextLine();
			
					// lukker scanneren
					clientInput.close();
					
// mangler traade		// goer noget, hvis string er lig med "start" Boer laves som "hvis client1.equals(client2) -> start countdown"
					
					if (clientInputString.equals("Start")) {
						
						ClientConnection.getFile();
						
						output.println(ClientConnection.chosenText);
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
						e.printStackTrace();
						
				}
			}
		}
	}
}
			