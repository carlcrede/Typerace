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
	
	public ClientConnection (Socket clientSocket) {
		this.socket = clientSocket;
	}
	
	public void run() {
		System.out.println("virker ikke");
		
		// while game is running
		while (true) {
			// Set input til at lytte om clint 1 / 2 har vundet
			
			// hvis client x vinder sendes en besked til client y om at de har tabt.
		}
		
	}
	
}