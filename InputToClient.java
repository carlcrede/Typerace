
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
	
	Socket sock = Server.socket;
	
	BufferedReader br;
	
	InputToClient(Socket sock) {
		try {
			br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		} catch (IOException e) {
			System.out.println("Can't open inputstream to client");
		}
	} // inputToClient
	
	public void run() {
		while (listenToServer == true) {
			try {
				serverOutput = br.readLine();
			} catch (IOException e) {
				System.out.println("Can't read input from server");
			}
			
			if (serverOutput.equals("Ready for new game")) {
				
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				System.out.println("OutputFromServer-thread can't sleep");
			}
		}
	} // run
} // class
