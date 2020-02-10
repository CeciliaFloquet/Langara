import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.*;

/**
   A car shape that can be positioned anywhere on the screen.
*/
public class Car extends Vehicle
{
	private static final int WIDTH=80;
	private static final int HEIGHT=40;
	private float r;
	private float g;
	private float b;

   /**
      Constructs a car with a given top left corner.
      @param x the x coordinate of the top left corner
      @param y the y coordinate of the top left corner
	  @param r the r red color
	  @param g the g green color
	  @param b the b  blue color
   */
   public Car(int x, int y, float r, float g, float b)
   {
	   
	  super(x, y, WIDTH, HEIGHT);
	  this.r= r;
	  this.g =g;
	  this.b=b;
   }

   /**
      Draws the car.
      @param g2 the graphics context
   */
   @Override
   public void draw(Graphics2D g2)
   {
		Rectangle body = new Rectangle(getPx(), getPy() + 10, 60, 10);      
		Ellipse2D.Double frontTire = new Ellipse2D.Double(getPx() + 10, getPy() + 20, 10, 10);
		Ellipse2D.Double rearTire = new Ellipse2D.Double(getPx() + 40, getPy() + 20, 10, 10);

		// The bottom of the front windshield
		Point2D.Double r1 = new Point2D.Double(getPx() + 10, getPy() + 10);
		// The front of the roof
		Point2D.Double r2 = new Point2D.Double(getPx() + 20, getPy());
		// The rear of the roof
		Point2D.Double r3 = new Point2D.Double(getPx() + 40, getPy());
		// The bottom of the rear windshield
		Point2D.Double r4 = new Point2D.Double(getPx() + 50, getPy() + 10);

		Line2D.Double frontWindshield = new Line2D.Double(r1, r2);
		Line2D.Double roofTop = new Line2D.Double(r2, r3);
		Line2D.Double rearWindshield = new Line2D.Double(r3, r4);
		
		//draw car and paint
		g2.setPaint(new Color(r, g, b));
		g2.draw(body);
		g2.draw(frontTire);
		g2.draw(rearTire);
		g2.draw(frontWindshield);      
		g2.draw(roofTop);      
		g2.draw(rearWindshield);    
		g2.fill(body);	  
   }
}
