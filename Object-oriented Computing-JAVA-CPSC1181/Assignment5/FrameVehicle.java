import javax.swing.*;

public class FrameVehicle
{
	/**
	  * main class with no parameter
	  */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setSize(1000, 1000);
		frame.setTitle("Trucks Cars Bicycles");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VehicleComponent component= new VehicleComponent();
		frame.add(component);
		frame.setVisible(true);
	
	}
	
	
	
}