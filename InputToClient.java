
/*
 * Listens for info from server
 */
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import java.net.ServerSocket;
import java.io.*;

public class InputToClient implements Runnable{

	public static boolean listenToServer = true;
	
	String serverOutput;
	
	public static boolean imTheWinner = false;
	
	public String serverInput;
	
	BufferedReader bir;
	
	public static String chosenText;
	
	public InputToClient(Socket sock) {
		try {
			bir = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			System.out.println("buffered reader for client åbnes");
		} catch (IOException e) {
			System.out.println("Can't open inputstream to client");
		}
	} // inputToClient
	
	
	public void run() {
		System.out.println("Client input run opens");
		
		while (true) {
			System.out.println("loooooop");
			try {
				System.out.println("lige inden bir");
				serverOutput = bir.readLine();
				if (serverOutput != null) {
					System.out.println("Line received!:");
					System.out.println(serverOutput);
				} else {
					System.out.println("Null line received");
				}
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
			if (clientInput.length() > 25) {
				System.out.println("linje 64 tekst modtaget");
				chosenText = clientInput;
				OutputFromClient.textRecived = true;
			}
			else if (clientInput.equals("Start Game")) {
				// game skal starte nu
				Main.txtArea.setText(chosenText);
			}
			
			else if (clientInput.equals("Game Over")) {
				if (!imTheWinner) {
					JOptionPane.showMessageDialog(null, "Du er stadig en fed taber i det her felt", "Du tabte stort", JOptionPane.INFORMATION_MESSAGE);
				}
				
				else if (imTheWinner) {
					
				}
				
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
