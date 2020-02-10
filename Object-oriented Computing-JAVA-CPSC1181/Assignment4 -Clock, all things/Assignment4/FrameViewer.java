import javax.swing.*;

public class FrameViewer 
{
	/**
	  * main class with no parameter
	  */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setSize(1000, 1000);
		frame.setTitle("Clock");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(getComponent());
		frame.setVisible(true);
	
	}
	
	/**
	  * create getComponent with signature clockcomponent but without parameter.
	  * ask the user for put the time that the user want to see.
	  * if the time is null or empty call clockComponent default-without parameter if not call clockComponent with hours and minutes
	  */
	public static ClockComponent getComponent(){
		String temp = JOptionPane.showInputDialog( null, "Enter the time 00:00", " Question", JOptionPane.QUESTION_MESSAGE); 
		//check if the format of time is correct
		if(temp == null || temp.length() == 0){
			return new ClockComponent();
		}
		else if(temp.length() == 5 && temp.indexOf(":") == 2){
			int hours= Integer.parseInt(temp.substring(0,2));
			int minutes = Integer.parseInt(temp.substring(3,5));
			return new ClockComponent(hours, minutes);
		}
		else {
			JOptionPane.showMessageDialog(null, "This format of time is not correct ", "Question",JOptionPane.INFORMATION_MESSAGE);
			return getComponent();	
		}
	}
}