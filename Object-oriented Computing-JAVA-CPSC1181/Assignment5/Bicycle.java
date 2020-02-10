import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
   A bicycle shape that can be positioned anywhere on the screen.
*/
public class Bicycle extends Vehicle
{
 private static final int WIDTH=80;
	private  static final int HEIGHT=60;
   /**
      Constructs a bicycle with a given top left corner.
      @param x the x coordinate of the top left corner
      @param y the y coordinate of the top left corner
   */
   public Bicycle(int x, int y)
   {
	  
      super(x, y, WIDTH, HEIGHT);
   }

   /**
      Draws the bicycle.
      @param g2 the graphics context
   */
   @Override
   public void draw(Graphics2D g2)
   {
		Ellipse2D.Double frontTire = new Ellipse2D.Double(getPx() + 80, getPy() +60, 10, 10);
		Ellipse2D.Double rearTire = new Ellipse2D.Double(getPx() + 50, getPy() +60, 10, 10);
		// The bottom of the front 
		Point2D.Double r1 = new Point2D.Double(getPx() + 80, getPy() + 60);
		// The front of the roof
		Point2D.Double r2 = new Point2D.Double(getPx() + 50, getPy() +60);
		// The rear of the roof
		Point2D.Double r3 = new Point2D.Double(getPx() + 50, getPy()+ 30);
		// The bottom of the rear windshield
		Point2D.Double r4 = new Point2D.Double(getPx() + 60, getPy() + 20);
		Point2D.Double r5 = new Point2D.Double(getPx() + 60, getPy() + 40);

		Line2D.Double lineDown = new Line2D.Double(r1, r2);
		Line2D.Double handlebar = new Line2D.Double(r2, r3);
		Line2D.Double arco = new Line2D.Double(r3, r4);
		Line2D.Double arco2 = new Line2D.Double(r3, r5);

		//draw bicycle and paint
		g2.draw(frontTire);
		g2.draw(rearTire);
		g2.draw(lineDown);
		g2.draw(handlebar);
		g2.draw(arco);
		g2.draw(arco2);   
		g2.fill(frontTire);	
		g2.fill(rearTire);	
          
   }
}
