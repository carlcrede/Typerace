import java.net.Socket;
import java.util.Scanner;
import java.net.ServerSocket;
import java.io.*;

//bytearray eller printwriter
//tråd for at kunne sende til flere på samme tid
//Countdown for spillet

public class ClientConnection {
	
	BufferedInputStream inputListener = null;
	static Socket klientSocket;
	public static ServerSocket serverSock;
	public static void main (String[] args) {
		try {
			serverSock = new ServerSocket(9001);
		} catch (Exception ex) {
			System.out.println("can't start server");
		}
			// Server in and out
			//BufferedOutputStream output = null;
			//BufferedInputStream input = null;
			
			openKlientSocket();
	}
	
	public static void openKlientSocket() {
		
		try {
				// Server starts
				// Loop can't be closed
				while (true) {
					klientSocket = serverSock.accept();
					
					// next methode newGameRequest
					newGameRequest();
					
					
				} // Server ends
			} catch (Exception ex) {
				System.out.println("Can't connect to client");
			}
	}
	public static void newGameRequest() {
		boolean requestListener = false;
		do {
			try {
				Scanner input = new Scanner(klientSocket.getInputStream());
				String yolo = input.nextLine();
				System.out.println(yolo);
				
			} catch (IOException e) {
				System.out.println("Can't open scanner");
			}
			
		} while (requestListener = false);
	}
	
}