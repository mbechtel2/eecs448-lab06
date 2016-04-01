import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class VotingSystem 
{
	private static JFrame frame;
	private static JPanel content;
	private static JRadioButton c1;
	private static JRadioButton c2;
	private static JRadioButton c3;
	private static JRadioButton c4;
	private static ButtonGroup group;
	private static JTextField fname;
	private static JTextField lname;
	
	public static void createAndDisplayGUI()
	{
		//Create the frame and panel
		frame = new JFrame();
		content = new JPanel();
		
		//Create a necessary components
		fname = new JTextField(10);
		lname = new JTextField(10);
		JLabel first = new JLabel("First name:");
		JLabel last = new JLabel("Last name:");
		
		//Create the button group that will hold the 4 candidates
		group = new ButtonGroup();
		
		//Create the 4 candidate radio buttons and set the action command to return their text
		c1 = new JRadioButton("Candidate 1");
		c1.setActionCommand(c1.getText());
		c2 = new JRadioButton("Candidate 2");
		c2.setActionCommand(c2.getText());
		c3 = new JRadioButton("Candidate 3");
		c3.setActionCommand(c3.getText());
		c4 = new JRadioButton("Candidate 4");
		c4.setActionCommand(c4.getText());
		
		//Create the button
		JButton submit = new JButton("Submit");
		
		//Add an action listener to the button
		submit.addActionListener(buttonListener());
		
		//Add the candidate radio buttons to the button group
		group.add(c1);
		group.add(c2);
		group.add(c3);
		group.add(c4);
		
		//Add the components to the panel
		content.add(first);
		content.add(fname);
		content.add(last);
		content.add(lname);
		content.add(c1);
		content.add(c2);
		content.add(c3);
		content.add(c4);
		content.add(submit);
		
		//Add the panel to the frame and ensure that the frame is visible
		frame.getContentPane().add(content);		
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
				//Create the file name with the user's first and last names
				String fileName = lname.getText() + "_" + fname.getText() + "_ballot.txt";
				
				//Create the string that shows who the user voted for
				String newText = group.getSelection().getActionCommand();
				
				try
				{
					//Create a new file with the file name
					File f = new File(fileName);
					
					//Determine that another file with the same name doesn't exist
					if(!f.exists())
					{					
						//Create a file writer and buffered writer to write the user's choice to the file
						FileWriter fw = new FileWriter(f.getAbsoluteFile());
						BufferedWriter bw = new BufferedWriter(fw);
						
						//Write the user's choice in the file
						bw.write(fname.getText() + " " + lname.getText() + " has voted for " + newText);
						
						//Close the file
						bw.close();
					}
					else //Assume user has already voted
					{
						//Tell user that they are not allowed to vote again
						System.out.println("That person has already voted");
					}
				}
				catch (IOException e1) 
				{
					e1.printStackTrace();
				}
			}
		};
		
		//Return the action listener
		return listener;
	}
	
	public static void main(String[] args)
	{
		//Create and run the voting system program
		createAndDisplayGUI();
	}
}
