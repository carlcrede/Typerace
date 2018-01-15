import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.net.ServerSocket;
import java.io.*;

public class InputToServer implements Runnable{
	
	public static boolean listenToClient = true;
	
	String clientOutput;
	
	public String clientInput;
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
		while (listenToClient == true) {
			// Scan for clientInput
			try {
				clientOutput = bir.readLine();
			} catch (IOException e) {
				System.out.println("Can't read input from client");
			}
			
			if (clientOutput.equals("Ready for new game")) {
				// set en countervalue til +1, hvis countervalue er 2 sendes
				// ready til clienterne
				
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				System.out.println("OutputFromClient-thread can't sleep");
			}
		}
		
	}


}