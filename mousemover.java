import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//*computer takes over control of users mouse */

public class mousemover extends JFrame {
	JLabel label1, label2, label3, label4, errorLabel;
	JTextField tf1, tf2, tf3, tf4;
	JButton button;
	
	
	//Constructor
	public mousemover() {
		setLayout(new GridLayout(5, 2, 5, 5)); //5 rows, 2 columns + padding (extra space - horizontal and vertical

		label1 = new JLabel("Enter number of movements:"); //labels in first column
		add(label1);
		
		tf1 = new JTextField();
		add(tf1);
		
		label2 = new JLabel("Enter delay between movements:"); //textfields in second column
		add(label2);
		
		tf2 = new JTextField();
		add(tf2);
		
		label3 = new JLabel("Enter screen width in pixels:");
		add(label3);
		
		tf3 = new JTextField();
		add(tf3);
		
		label4 = new JLabel("Enter screen height in pixels:");
		add(label4);
		
		tf4 = new JTextField();
		add(tf4);
		
		button = new JButton("Start");
		add(button);
		
		errorLabel = new JLabel("");
		add(errorLabel);
		
		event e = new event();
		button.addActionListener(e);
	}
	
	public class event implements ActionListener {
		public void actionPerformed(ActionEvent e){ //2 try catch blocks
			try { //if so. enters a letter into the textfield, it'll say "Please enter numbers only"
				int num = (int)(Double.parseDouble(tf1.getText())); //number of movements
				int delay = (int)(Double.parseDouble(tf2.getText())); //delay in milliseconds
				int width = (int)(Double.parseDouble(tf3.getText())); //screen width
				int height = (int)(Double.parseDouble(tf4.getText())); //screen height
				
				//check if entered numbers are positive
				if (num <= 0 || delay <= 0 || width <= 0 || height <= 0) {
					errorLabel.setText("Please enter only positive numbers.");
				} else {
					errorLabel.setText(""); //set errorLabel back to empty
					
					try {
						Robot robot = new Robot();
						for(int x=0; x<=num; x++) { //executes until it reached entered number of times
							robot.mouseMove((int)(Math.random()*width), (int)(Math.random()*height)); //moves mouse in random 
																									//directions in entered 
																									//screen width & height
							robot.delay(delay); //delays entered milliseconds after each movement
						}
					} catch (AWTException ex) { //if exception is thrown, program closes
						System.exit(0);
					}
				}
			} catch (Exception ex2) { //if anything other than numbers or letters was entered, etc. was entered
				errorLabel.setText("Please numbers only!");
			}
		}
	}
	
	public static void main (String[] args) {
		mousemover frame = new mousemover();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("Robot Mouse Mover");
		frame.pack();
	}
}
