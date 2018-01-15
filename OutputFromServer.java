import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.net.ServerSocket;
import java.io.*;


public class OutputFromServer implements Runnable {
	
	// String der sendes fra server til client
	public String msgForClient;
	
	String chosenText;
	
	PrintWriter pw;
	
	public boolean timeToAnswer = false;
	
	// modtager input fra klient
	//Scanner clientInput = new Scanner(socket.getInputStream());


	public void run() {
		
		while (timeToAnswer == true) {
			
			// Send responds
			if (false) {
				InputToServer.listenToClient = true;
			}
			
			// else if (countervalue == 2)
			else if (true) {
				// Pick a text
				ServerTextPicker.getFile();
				
				// send text
				pw.println(ServerTextPicker.chosenText);
				pw.flush();
				
				// Ask for ready request
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				System.out.println("OutputFromServer-thread can't sleep");
			}
			
			
			}
	}
		
	
}
