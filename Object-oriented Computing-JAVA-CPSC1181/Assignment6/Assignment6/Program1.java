import java.awt.event.*;
import javax.swing.*;
import java.lang.*;

public class Program1
{	/**
	  * main class with no parameter
	  */
	public static void main(String[] args)
	{
    final CubeComponent component = new CubeComponent();
      JFrame frame = new JFrame();
	  //CubeComponent component = new CubeComponent(); 
      frame.add(component);

      frame.setSize(1000, 1000);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true); 
	try {
		while(true){
			component.moveCube();
			component.repaint();
			Thread.sleep(100); 
		}
	} catch (Exception e) {
		System.out.println("Error");
	}
	
   }
}