import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;

public class Main extends JFrame implements ActionListener {

	int DEFAULT_HEIGHT = 1000;
	int DEFAILT_HEIGHT = 1000;

	Client testrun;

	public Main() {

		// gotta make this work!
		/*getContentPane().setLayout(new GridLayout(2, 1));

		testrun = new Client(this);
		getContentPane().add(testrun);

		Thread test = new Thread(testrun);
		test.start();*/
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
	

	public static void main(String args[]) {

		Main main = new Main();

		main.setTitle("TypeRacer 1.0"); // Set title on window
		main.setSize(800, 600); // Set size
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setVisible(true);
		main.setResizable(true);
	}
}
	
