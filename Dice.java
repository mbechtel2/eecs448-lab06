import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Dice
{
	public static JTextField text;
	public static JLabel label;
	
	private static void createDiceDisplayGUI()
	{
		//Initialize the frame
		JFrame frame = new JFrame("Dice Roll");
		
		///Initialize the button, text field and label
		JButton button = new JButton("Roll");
		text = new JTextField(2);
		label = new JLabel("Enter a max number to roll");
		
		//Create the Panel
		JPanel content = new JPanel();
		
		//Add an action listener to the button
		button.addActionListener(buttonListener());
		
		//Add all of components to the panel
		content.add(text);
		content.add(button);
		content.add(label);
		
		//Add the panel to the frame
		frame.getContentPane().add(content);
		
		//Make sure that all parts of the frame are visible
		frame.pack();
		frame.setVisible(true);
	}
	
	private static ActionListener buttonListener()
	{
		//Create a new action listener
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//Get the value from the text field and change it to a double
				String input = text.getText();
				double temp = Double.parseDouble(input);
				
				//Roll a random number of 1 to the user given number
				int number = (int)(Math.random() * temp) + 1;
				
				//Change the random number into a string
				String newText = Integer.toString(number);
				
				//Have the label print out the random value
				label.setText(newText);
			}
		};
		
		//Return the listener
		return listener;
	}

	public static void main(String[] args)
	{
		//Start and run the dice program
		createDiceDisplayGUI();
	}

}
