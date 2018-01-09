import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Main extends JFrame implements ActionListener {
	
	JButton start, quit;
	JTextArea txtarea;
	JTextField txtfield;
	
	int DEFAULT_HEIGHT = 1000;
	int DEFAILT_HEIGHT = 1000;
	

	//Client testrun;	

	public Main() {
				
		getContentPane().setLayout(new GridLayout(5,1));
		
		// the animation / progressbar needs to go in the top
		/*
		 * ANIMATION ADD HERE
		 */
		//
		
		// JLabel for the .txt file
		txtarea = new JTextArea("Let's get ready to rumble!");
		txtarea.setLineWrap(true);
		getContentPane().add(txtarea);
		
		// JTextField for user input
		txtfield = new JTextField(100);
		getContentPane().add(txtfield);
		
		// scrollpane
		
		JScrollPane scrollPane = new JScrollPane(txtfield);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scrollPane);
		
		
		// start button
		start = new JButton ("Start");
		start.addActionListener(this);
		getContentPane().add(start);
		
		// quit button
		quit = new JButton ("Quit");
		quit.addActionListener(this);
		getContentPane().add(quit);
		
		
		// gotta make this work!
		/*getContentPane().setLayout(new GridLayout(2, 1));

		testrun = new Client(this);
		getContentPane().add(testrun);

		Thread test = new Thread(testrun);
		test.start();*/
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == quit) {
			JOptionPane.showMessageDialog(null, "Thanks for using DTUeven Type?", "Goodbye", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
		else if (e.getSource() == start) {
			start.setText("GO!");
			
			// makes a request to start the game to the server
			// need a countdown, TODO
			
		}
			
	}
		
	

	public static void main(String args[]) {

		Main doIt = new Main();
		
		JOptionPane.showMessageDialog(null,
				"Welcome to the single most important program in all of Java history.\n" + "Sit back, relax, and enjoy.",
				"Prepare to have your mind blown!", JOptionPane.INFORMATION_MESSAGE);
		doIt.setTitle("TypeRacer 1.0"); // Set title on window
		doIt.setSize(800, 600); // Set size
		doIt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		doIt.setVisible(true);
		doIt.setLocationRelativeTo(null);
		doIt.setResizable(true);
	}		
}
  
		
	
