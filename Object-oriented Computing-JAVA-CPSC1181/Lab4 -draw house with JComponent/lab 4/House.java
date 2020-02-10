import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
   A  house shape that can be positioned anywhere on the screen.
*/
public class House
{
   private int xLeft;
   private int yTop;

   /**
      Constructs a house with a given top left corner.
      @param x the x coordinate of the top left corner
      @param y the y coordinate of the top left corner
   */
   public House(int x, int y)
   {
      xLeft = x;
      yTop = y;
   }

   /**
      Draws the house.
      @param g2 the graphics context
   */
   public void drawMe(Graphics2D g2)
   {
      //walls`house
      Rectangle body = new Rectangle(xLeft, yTop + 30, 130, 120);      
      //windowns right
      Rectangle widowns1 = new Rectangle(xLeft + 80, yTop + 50, 30, 30); 
      //windowns left
      Rectangle widowns2 = new Rectangle(xLeft + 20, yTop + 50, 30, 30);
      //door
      Rectangle door = new Rectangle(xLeft + 50, yTop + 100, 30, 50);       
      //roftopLeft
      Point2D.Double l1 = new Point2D.Double(xLeft , yTop + 30 );
      Point2D.Double l2 = new Point2D.Double(xLeft + 70, yTop );
      Line2D.Double roftopLeft = new Line2D.Double(l1, l2);      
       //roftopLeft
      Point2D.Double l3 = new Point2D.Double(xLeft+130, yTop+30);
      Point2D.Double l4 = new Point2D.Double(xLeft+70 , yTop );
      Line2D.Double roftopRight = new Line2D.Double(l3, l4);
      
      //draw 
      g2.draw(body);
      g2.draw(roftopLeft);
      g2.draw(roftopRight);
      g2.draw(widowns1);
      g2.draw(widowns2);
      g2.draw(door);
      
           
   }
}
