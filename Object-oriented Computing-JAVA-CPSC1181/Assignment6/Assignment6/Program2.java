import java.awt.event.*;
import javax.swing.*;

public class Program2
{
	/**
	  * main class with no parameter
	  */
	public static void main(String[] args)
	{
    final CubeComponent component = new CubeComponent();

		class MousePressListener implements MouseListener
		{
			/**
			 * override the method
			 */
			public void mousePressed (MouseEvent event)
			{
				int x = event.getX();
				int y = event.getY();
				component.findClosestPoint(x, y);
			}
			/**
			 * override the method
			 */
			public void mouseReleased(MouseEvent event) {
				int x = event.getX();
				int y = event.getY();
				component.moveTo(x, y);
			}
			public void mouseClicked(MouseEvent event) {}
			public void mouseEntered(MouseEvent event) {}
			public void mouseExited(MouseEvent event) {}
		}

		MouseListener listener = new MousePressListener();
		component.addMouseListener(listener);
		JFrame frame = new JFrame();
		frame.add(component);
		frame.setSize(1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
    }
}