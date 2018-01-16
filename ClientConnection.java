import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientConnection implements Runnable {
	
	Socket socket;
	
	public static PrintWriter pw;
	
	public static String serverOutput;
	
	public static boolean textPicked = false;
	
	public ClientConnection (Socket clientSocket) {
		this.socket = clientSocket;
	}
	
	public void run() {
		
		try {
			pw = new PrintWriter(socket.getOutputStream());
			System.out.println("PrintWriter åbnet");
		} catch (IOException e) {
			System.out.println("PrintWriter pw kunne ikke åbnes");
		}
		// Send to client
			while (true) {	
				if (Server.itIsTimeToAnswer) {
					// Send responds
					parseServerOutput(serverOutput);
				}
			} // loop
		}//run end
	
	public void parseServerOutput(String output) {
		
		//send text
		if (!textPicked) {
			ServerTextPicker.getFile();
			System.out.println("INFO: Text got - sending to client");
			pw.print(ServerTextPicker.chosenText);
			pw.flush();
			textPicked = true;
		}
		
		else if (Server.clientsAreReady) {
			pw.println("Start Game");
			pw.flush();
		}
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			System.out.println("ClientConnection can't sleep");
		}
		
	}
	
}