import java.net.Socket;
import java.util.Scanner;
import java.net.ServerSocket;
import java.io.*;

//bytearray eller printwriter
//tråd for at kunne sende til flere på samme tid
//Countdown for spillet


//PrintWriter til at sende
//BufferedReader til at modtage
//Lav to tråde pr. connected klient.


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
		Scanner in = new Scanner(System.in);
		String ind;
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(klientSocket.getOutputStream());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		do {
			try {
				Scanner input = new Scanner(klientSocket.getInputStream());
				String yolo = input.nextLine();
				System.out.println(yolo);
				
				if (yolo.equals("start")) {
					System.out.println("Your turn to type:");
					ind = in.nextLine();
					pw.print(ind+"\r\n");
					pw.flush();
					
				}
				
			} catch (IOException e) {
				System.out.println("Can't open scanner");
			}
			
		} while (requestListener = false);
	}
	
}