	import java.net.Socket;
	import java.net.UnknownHostException;
	import java.net.ServerSocket;
	import java.io.*;
	import java.util.Scanner;
	
public class ClientDummy2 {

	public static void main (String [] args) {
		String adress = "localhost";
		int port = 9001;
		Scanner in = new Scanner(System.in);
		String s;
		//Input
		try {
			Socket sock = new Socket(adress,port);
			BufferedReader bir = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			PrintWriter pw = new PrintWriter(sock.getOutputStream());
			String input;
			do  {
				input = in.nextLine();
				pw.print(input+"\r\n");
				pw.flush();
				
				
				
			} while (!(input.equals("close")));
	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
