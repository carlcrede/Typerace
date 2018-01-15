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
		
		// Send to client
				while (Server.itIsTimeToAnswer == true) {
					// Send responds
					parseServerOutput(serverOutput);
				}

		}//run end
	
	public void parseServerOutput(String output) {
		
		//send text
		if (textPicked == false) {
			ServerTextPicker.getFile();
			pw.println(ServerTextPicker.chosenText);
			pw.flush();
			textPicked = true;
			
		}
		
		else if (Server.clientsAreReady == true) {
			pw.println("Start game");
			pw.flush();
		}
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			System.out.println("ClientConnection can't sleep");
		}
		
	}
	
}