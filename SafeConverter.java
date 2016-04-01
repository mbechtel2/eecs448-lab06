import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class SafeConverter 
{
	private static JFrame frame;
	private static JPanel content;
	private static JButton convert;
	private static JLabel label;
	private static JTextField temp;
	private static ButtonGroup b1;
	private static ButtonGroup b2;
	private static JRadioButton fah;
	private static JRadioButton cel;
	private static JRadioButton kev;
	private static JRadioButton fah2;
	private static JRadioButton cel2;
	private static JRadioButton kev2;
	
	public static void createAndDisplayGUI()
	{
		//Create the frame and panel
		frame = new JFrame();
		content = new JPanel();
		
		//Initialize all necessary components
		convert = new JButton("Convert");
		temp = new JTextField(3);
		label = new JLabel("Enter a temperature to convert");
		JLabel to = new JLabel(" to ");
		
		//Create the button groups that will house the Initial and Convert To values
		b1 = new ButtonGroup();
		b2 = new ButtonGroup();
		
		//Initialize the first three radio buttons and set their action command to return their text
		fah = new JRadioButton("F");
		fah.setActionCommand(fah.getText());
		cel = new JRadioButton("C");
		cel.setActionCommand(cel.getText());
		kev = new JRadioButton("K");
		kev.setActionCommand(kev.getText());
		
		//Add the first three radio buttons to the first button group
		b1.add(fah);
		b1.add(cel);
		b1.add(kev);
		
		//Initialize the second three radio buttons and set their action command to return their text
		fah2 = new JRadioButton("F");
		fah2.setActionCommand(fah2.getText());
		cel2 = new JRadioButton("C");
		cel2.setActionCommand(cel2.getText());
		kev2 = new JRadioButton("K");
		kev2.setActionCommand(kev2.getText());
		
		//Add the second three radio buttons to the second button group
		b2.add(fah2);
		b2.add(cel2);
		b2.add(kev2);
		
		//Add an action listener to the button
		convert.addActionListener(buttonListener());
		
		//Add all components to the panel
		content.add(fah);
		content.add(cel);
		content.add(kev);
		content.add(to);
		content.add(fah2);
		content.add(cel2);
		content.add(kev2);
		content.add(temp);
		content.add(convert);
		content.add(label);
		
		//Add the panel to the frame and enure that the frame is visible
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
				try //If getText() throws an empty string exception
				{
					//Get the temperature to convert
					String number = temp.getText();
					
					try //If the input is blank or not a number
					{
						//Change the input to a double
						double tempToConvert = Double.parseDouble(number);
						
						//Initialize the variable that will store the converted temperature
						double newTemp = 0;
						
						//Get the Initial and Convert To values from the button groups
						String init = b1.getSelection().getActionCommand();
						String fina = b2.getSelection().getActionCommand();
						
						//Initialize the string that will print the converted temperature to the user 
						String newText = "";
						
						//If Initial is Fahrenheit
						if(init == "F")
						{			
							//If Convert To is Fahrenheit
							if(fina == "F")
							{
								newText = "Temp in F: " + String.format("%.2f",tempToConvert);
							}
							//If Convert To is Celsius
							else if(fina == "C")
							{
								newTemp = (tempToConvert-32)*(5.0/9.0);
								newText = "Temp in C: " + String.format("%.2f",newTemp);
							}
							//If Convert To is Kelvin
							else if(fina == "K")
							{
								newTemp = (tempToConvert-32)*(5.0/9.0) + 273;
								newText = "Temp in K: " + String.format("%.2f",newTemp);
							}
						}
						//If Initial is Celsius
						else if(init == "C")
						{
							//If Convert To is Fahrenheit
							if(fina == "F")
							{
								newTemp = (tempToConvert+32)*(9.0/5.0);
								newText = "Temp in F: " + String.format("%.2f",newTemp);
							}
							//If Convert To is Celsius
							else if(fina == "C")
							{
								newText = "Temp in C: " + String.format("%.2f",tempToConvert);
							}
							//If Convert To is Kelvin
							else if(fina == "K")
							{
								newTemp = tempToConvert + 273.15;
								newText = "Temp in K: " + String.format("%.2f",newTemp);
							}
						}
						//If Initial is Kelvin
						else if(init == "K")
						{
							//If Convert To is Fahrenheit
							if(fina == "F")
							{
								newTemp = (tempToConvert-32)*(5.0/9.0);
								newText = "Temp in F: " + String.format("%.2f",newTemp);
							}
							//If Convert To is Celsius
							else if(fina == "C")
							{
								newTemp = tempToConvert - 273.15;
								newText = "Temp in K: " + String.format("%.2f",newTemp);
							}
							//If Convert To is Kelvin
							else if(fina == "K")
							{
								newText = "Temp in K: " + String.format("%.2f",tempToConvert);
							}
						}
						
						//Print the converted temperature to the user
						label.setText(newText);
					}
					catch (Exception error)
					{
						//If the input was blank
						if(number.length() == 0)
						{
							System.out.println("Input may not be blank");
						}
						else //Assume that the input was not a number
						{
							System.out.println("Input must be a number");
						}
					}
					
				}
				catch (Exception err)
				{
					//If the input was blank
					System.out.println("Input may not be blank");
				}				
			}
		};
		
		//Return the action listener
		return listener;
	}
	
	public static void main(String[] args) 
	{
		//Create and run the safe converter program
		createAndDisplayGUI();
	}

}
