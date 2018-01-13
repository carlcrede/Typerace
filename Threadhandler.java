import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.net.ServerSocket;
import java.io.*;

public class Threadhandler {
	
	public static void main (String[] args) {
		//ArrayList<Integer> player = new ArrayList<Integer>();
		Socket socket = null;
		ServerSocket serverSock = null;
		
		try {
			serverSock = new ServerSocket(9001);
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
	}
}