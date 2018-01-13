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

public class ClientConnection extends Thread {
	Socket socket;
	String threadName;
	
	public ClientConnection (Socket clientSocket) {
		this.socket = clientSocket;
	}
	
	public void run() {
		
		PrintWriter test = null;
		try {	
			test = new PrintWriter(socket.getOutputStream());
			test.println("test 123 virker det?");
			test.flush();
			test.println("close");
			test.flush();
		} catch (IOException e) {
			System.out.println("kunne ikke sende test");
		}
		
		
		/*
		// String der sendes fra server til client
		String msgForClient;
		
		// Output i form af msgForClient
		PrintWriter output = null;
		
		// Connection to client loop
		while (true) {
			try {
				output = new PrintWriter(socket.getOutputStream());
			} catch (IOException e) {
				System.out.println("can't open PrintWriter");
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
						
						ServerTextPicker.getFile();
						
						output.println(ServerTextPicker.chosenText);
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
	*/}
}