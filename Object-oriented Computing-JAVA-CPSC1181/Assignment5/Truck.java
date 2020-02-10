import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
   A truck shape that can be positioned anywhere on the screen.
*/
public class Truck extends Vehicle
{
	private static final int  WIDTH=120;
	private static  final int  HEIGHT= 60;

   /**
      Constructs a truck with a given top left corner.
      @param x the x coordinate of the top left corner
      @param y the y coordinate of the top left corner
   */
   public Truck(int x, int y)
   {  
	   super(x, y, WIDTH, HEIGHT);
   }

   /**
      Draws the truck.
      @param g2 the graphics context
   */
   @Override
   public void draw(Graphics2D g2)
   {
		Rectangle body1 = new Rectangle(getPx() + 20, getPy() + 10, 80, 50);  
		Rectangle body2 = new Rectangle(getPx(), getPy() +20, 20, 40);

		Ellipse2D.Double frontTire = new Ellipse2D.Double(getPx() + 80, getPy() +60, 10, 10);
		Ellipse2D.Double rearTire = new Ellipse2D.Double(getPx() + 70, getPy() +60, 10, 10);
		Ellipse2D.Double frontTire1 = new Ellipse2D.Double(getPx() + 20, getPy() +60, 10, 10);
		Ellipse2D.Double rearTire1 = new Ellipse2D.Double(getPx() + 30, getPy() +60, 10, 10);
		Ellipse2D.Double rearTire2 = new Ellipse2D.Double(getPx() , getPy() +60, 10, 10);

		//draw truck and paint
		g2.draw(body1);
		g2.draw(body2);
		g2.draw(frontTire);
		g2.draw(rearTire);
		g2.draw(frontTire1);
		g2.draw(rearTire1);
		g2.draw(rearTire2);
		g2.fill(body1);
		g2.fill(body2);
          
   }
}
