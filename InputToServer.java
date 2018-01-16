import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.net.ServerSocket;
import java.io.*;

public class InputToServer implements Runnable{
	
	public String clientOutput;
	
	// might be the wrong socket
	Socket sock = Server.socket;
	
	BufferedReader bir;
	
	InputToServer(Socket sock) {
		try {
			bir = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		} catch (IOException e) {
			System.out.println("Can't open inputstream to server");
		}
	}
	

	public void run() {
		while (true) {
			if (Server.listenToClient) { // vil det virke?
				// Scan for clientInput
				try {
					clientOutput = bir.readLine();
				} catch (IOException e) {
					System.out.println("Can't read input from client");
				}
				parseClientOutput(clientOutput);
			}
			else {
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					System.out.println("InputToServer can't sleep");
				}
			}
		}
	} // run
	
	private void parseClientOutput(String input) {
		if (input.equals("close")) {
		}
		
		else if (input.equals("Ready")) {
		Server.noOfReadyClients++;	
		}
		
		else if (input.equals("wins")) {
			Server.winnerFound = true;
		}
	
	} // parser
	
}