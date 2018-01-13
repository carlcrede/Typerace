import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ServerTest {
	
	public void main (String[] args) {
		ClientConnection C1 = new ClientConnection("Thread-1");
		C1.start();
		
		ClientConnection C2 = new ClientConnection("Thread-2");
		C2.start();
	}
	
}