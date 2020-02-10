import java.awt.event.*;
import javax.swing.*;

public class CubeComponentViewer
{
   public static void main(String[] args)
   {
    final CubeComponent component = new CubeComponent();

      class MousePressListener implements MouseListener
      {
         public void mousePressed (MouseEvent event)
         {
            int x = event.getX();
            int y = event.getY();
            component.moveTo(x, y);
         }
         
         public void mouseReleased(MouseEvent event) {}
         public void mouseClicked(MouseEvent event) {}
         public void mouseEntered(MouseEvent event) {}
         public void mouseExited(MouseEvent event) {}
      }

      MouseListener listener = new MousePressListener();
      component.addMouseListener(listener);

      JFrame frame = new JFrame();
	  //CubeComponent component = new CubeComponent(); 
      frame.add(component);

      frame.setSize(500, 500);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}