import java.net.Socket;
import java.net.ServerSocket;
import java.io.*;

//bytearray eller printwriter
//tråd for at kunne sende til flere på samme tid
//Countdown for spillet


public class ClientConnection {
	
	public static void main (String[] args) {
		try {
			ServerSocket serverSock;
			serverSock = new ServerSocket(9001);
			
			
			// Server in and out
			BufferedOutputStream output = null;
			BufferedInputStream input = null;
			
			// Can't be closed :)
			// Server starts
			while (true) {
				Socket klientSocket = serverSock.accept();
				
				
			} // Server ends
			
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
}