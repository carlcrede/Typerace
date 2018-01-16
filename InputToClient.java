
/*
 * Listens for info from server
 */
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.net.ServerSocket;
import java.io.*;

public class InputToClient {

	public static boolean listenToServer = true;
	
	String serverOutput;
	
	public String serverInput;
	
	BufferedReader bir;
	
	public static String chosenText;
	
	InputToClient(Socket sock) {
		try {
			bir = new BufferedReader(new InputStreamReader(Main.sock.getInputStream()));
		} catch (IOException e) {
			System.out.println("Can't open inputstream to client");
		}
		
	} // inputToClient
	
	public void run() {
		while (true) {
			
			try {
				serverOutput = bir.readLine();
			} catch (IOException e) {
				System.out.println("Can't read input from server");
			}
			
			// Read responds
			parseClientInput(serverOutput);
			
		}
	} // run
	
	public void parseClientInput(String clientInput) {
		while (true) {
			
			// skal videre til main
			// boer goeres paa en bedre maade
			if (clientInput.length() >25) {
				chosenText = clientInput;
				OutputFromClient.textRecived = true;
			}
			else if (clientInput.equals("Start Game")) {
				// game skal starte nu
			}
			
			else if (clientInput.equals("Game Over")) {
				// lav popup der siger at du tabte / game over
			}
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				System.out.println("InputToClient can't sleep");
			}	
		}
	} // parseClientInput
} // class
