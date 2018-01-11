import java.net.Socket;
import java.net.ServerSocket;
import java.io.*;

//bytearray eller printwriter
//tråd for at kunne sende til flere på samme tid
//Countdown for spillet


public class ClientConnection {
	public static ServerSocket serverSock;
	public static void main (String[] args) {
		try {
			serverSock = new ServerSocket(9001);
		} catch (Exception ex) {
			System.out.println("can't start server");
		}
			// Server in and out
			BufferedOutputStream output = null;
			BufferedInputStream input = null;
			
			openKlientSocket();
	}
	
	public static void openKlientSocket() {
		
		try {
				// Server starts
				// Loop can't be closed
				while (true) {
					Socket klientSocket = serverSock.accept();
					
					
					
				} // Server ends
			} catch (Exception ex) {
				System.out.println("Can't connect to client");
			}
	}
	
}