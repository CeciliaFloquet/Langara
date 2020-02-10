import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
   This component draws one house shapes.
*/
public class HouseComponent extends JComponent
{  
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;

      House house1 = new House(100, 150);
      

      house1.drawMe(g2);
          
   }
}
