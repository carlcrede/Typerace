
/*
 * Handles info from client to the server
 */

import java.io.BufferedReader;
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
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class OutputFromClient implements Runnable {
	
	PrintWriter pw;
	
	String clientOutput;
	
	public static boolean textRecived = false;
	
	public static boolean iWin = false;
	
	Socket sock;
	
	// main skal indeholde
	
	/*
	try {
	Socket sock = new Socket (OutputFromClient.adress, OutputFromClient.port);
	BufferedReader bir = new BufferedReader(new InputStreamReader(sock.getInputStream));
	PrintWriter pw = new PrintWriter(sock.getOutputStream());
	*/
	 
	
	public OutputFromClient (Socket sock) {
			// this.hvor main ligger.sock = new Socket(OutputFromClient.adress, OutputFromClient.port)
			this.sock  = sock;

	}
	
	public void run() {
		System.out.println("Client output run åbner");
		// Send to Server
				while (true) {
					// Send responds
					parseClientOutput();
				}

		}//run end
	
	public void parseClientOutput() {
		
		//send text
		// textRecived == true when InputToClient recives textfile
		if (textRecived) {
			pw.println("Ready");
			pw.flush();
			textRecived = false;
			System.out.println("jeg er klar");
			
		}
		
		else if (iWin) {
			pw.println("wins");
			pw.flush();
		}
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			System.out.println("ClientConnection can't sleep");
		}
		
	}
	
}
