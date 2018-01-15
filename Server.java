import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.net.ServerSocket;
import java.io.*;

public class Server {
	
	public static Socket socket = null;
	public static ServerSocket serverSock = null;
	
	public static void main (String[] args) {
		
		try {
			serverSock = new ServerSocket(1234);
		} catch (Exception ex) {
			System.out.println("can't start server");
		
		}
		while (true) {
			try {
			socket = serverSock.accept();
			
			} catch (IOException e1) {
				System.out.println("can't connect to client");
			}
			new ClientConnection(socket).start();
		
		}
		
		// tråde
		
		
	}
}