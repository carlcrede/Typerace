import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.net.ServerSocket;
import java.io.*;

public class Server {
	
	public static ServerSocket serverSock = null;
	
	public static int noOfClients = 0;
	public static int noOfReadyClients = 0;
	
	public static ClientConnection[] playerOutputs = new ClientConnection[2]; // output to players
	public static InputToServer[] playerInputs = new InputToServer[2]; // input from players
	
	public static boolean itIsTimeToAnswer = false;
	public static boolean winnerFound = false;
	public static boolean listenToClient = false;
	public static boolean clientsAreReady = false;
	
	
	public static void main (String[] args) {
		
		try {
			serverSock = new ServerSocket(1234);
			System.out.println("Server start");
		} catch (Exception ex) {
			System.out.println("can't start server");
		}
		
		// Starter server
		while (true) {
			// Tillader to clients
			while (noOfClients < 2) {
				Socket socket = null;
				// Wait for client to connect
				try { socket = serverSock.accept();
				} catch (IOException e1) {
					System.out.println("can't connect to client");
				}
				// make input object
				InputToServer newInput = new InputToServer(socket);
				// add to array of inputs
				playerInputs[noOfClients] = newInput;
				// make and start thread
				Thread inT = new Thread(newInput);
				inT.start();
				
				ClientConnection newOutput =  new ClientConnection(socket);
				playerOutputs[noOfClients] = newOutput;
				Thread outT = new Thread(newOutput);
				outT.start();

				noOfClients++;
				System.out.println("Client connected to server");
				}
			// opens for communication
			if ((!itIsTimeToAnswer) && (!itIsTimeToAnswer)) {
			itIsTimeToAnswer = true;
			listenToClient = true;
			
			// virker
			System.out.println("der åbnes for in og out");
			System.out.println(noOfClients);
			}
			
			if (noOfReadyClients == 2) {
				clientsAreReady = true;
			}
			
			// while game is running
			if (winnerFound) {
				ClientConnection.pw.println("Game Over");
			} else {
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					System.out.println("Server couldn't sleep");
				}
			}
		}
	}
	

}