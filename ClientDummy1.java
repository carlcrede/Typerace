	import java.net.Socket;
	import java.net.UnknownHostException;
	import java.net.ServerSocket;
	import java.io.*;
	import java.util.Scanner;
	
public class ClientDummy1 {

	public static void main (String [] args) {
		String adress = "localhost";
		int port = 9001;
		Scanner in = new Scanner(System.in);
		//Input
		try {
			Socket sock = new Socket(adress,port);
			BufferedReader bir = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			PrintWriter pw = new PrintWriter(sock.getOutputStream());
			String input;
			String responds = null;
			do  {
				input = in.nextLine();
				pw.print(input+"\r\n");
				pw.flush();
				
				while (!(responds.equals("end"))) {
				responds = bir.readLine();
				System.out.println(responds);
				}
				
				
			} while (!(input.equals("close")));
	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
