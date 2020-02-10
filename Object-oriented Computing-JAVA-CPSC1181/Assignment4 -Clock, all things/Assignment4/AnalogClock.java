import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.time.LocalTime;
import java.util.ArrayList;
import java.awt.BasicStroke;

/**
  * A AnalogClock shape that can be positioned in middle on the screen.
  */
public class AnalogClock
{
	private int xLeft;
	private int yTop;
	private int width;
	private int height;
	private int diam;
	private LocalTime time;
 
	/**
	 * Constructs a AnalogClock with parameter
	 * @param time the time that  is type of LocalTime
	 * set this time in the varible time
	 */
	public AnalogClock(LocalTime time)
	{
		this.time = time;
		
	}

	/**
     * Draws the circle of clock, draws inside circle and draw the rectancle.
     * @param g2 the graphics context
	 * @param width that is the width of box
	 * @param height that is the height of box
     */
	public void drawMe(Graphics2D g2, int width, int height)
	{
		this.width = width;
		this.height = height;
	   	this.diam = (int)(width * 0.4);
		double diagonal = (Math.sqrt(2) * diam) / 2;
		xLeft = (int) ((width/2) + ((diagonal) * Math.cos((225) * (Math.PI / 180))));
        yTop = (int) ((height/2) + ((diagonal) * Math.sin((225) * (Math.PI / 180))));
		Rectangle body = new Rectangle(xLeft, yTop, diam, diam);      
		Ellipse2D.Double circle = new Ellipse2D.Double (xLeft, yTop, diam, diam);
		Ellipse2D.Double circleMid = new Ellipse2D.Double (width/2, height/2, 5, 5);
		//draw circle, rectancle, and cliclemid
		g2.setStroke(new BasicStroke(3.0f));
		drawLines(g2);
		drawPointer(g2);
		g2.draw(body);
		g2.draw(circle);
		g2.fill(circleMid);
		g2.draw(circleMid);	
	}
	/**
     * Draws the pointer for minutes and hours.
     * @param g2 the graphics context
     */
	public void drawPointer(Graphics2D g2)
	{
		double x, y;
		double a = (360 /60) * time.getMinute();
		double originX = width/2 ;
		double originY = height/2 ;
		//x and Y for pointer minutes
		x = (int) (Math.cos(time.getMinute() * Math.PI / 30 - Math.PI / 2) * (diam / 2 * 0.6) + originX);  
		y = (int) (Math.sin(time.getMinute() * Math.PI / 30 - Math.PI / 2) * (diam / 2 * 0.6) + originY); 
		//point1 for pointer minutes
		Point2D.Double p1 = new Point2D.Double(x, y);
		//point2 for pointer minutes
		Point2D.Double p2 = new Point2D.Double(originX, originY);
		//angle for hours
		a= (360 /12) * time.getHour();
		//x and Y for pointer hours
		x = (int) (Math.cos((time.getHour() * 30 + time.getMinute() / 2) * Math.PI / 180 - Math.PI / 2) * (diam / 2 * 0.3) + originX);  
		y = (int) (Math.sin((time.getHour() * 30 + time.getMinute() / 2) * Math.PI / 180 - Math.PI / 2) * (diam / 2 * 0.3) + originY);  
		//point3 for pointer hours
		 Point2D.Double p3 = new Point2D.Double(x, y);
		//point4 for pointer hours
		Point2D.Double p4 = new Point2D.Double(originX, originY);
		Line2D.Double pointHours = new Line2D.Double(p1, p2);
		Line2D.Double pointMinutes = new Line2D.Double(p3, p4);
		//draw pointer hours and pointer minutes 
		g2.draw(pointHours);
		g2.draw(pointMinutes);
	}
	/**
     * Draws the lines in the clock and numbers.
     * @param g2 the graphics context
     */
	private void drawLines(Graphics2D g2) {

		double x, y;
		double a = (360 / 12);
		double originX = width/2 ;
		double originY = height/2 ;
		//loop for draw lines and numbers in the clock
		for (int i = 0; i < 12; i++) {
			x = (int)(originX + ((diam / 2) * Math.cos((a * i) * (Math.PI / 180))));
			y = (int)(originY + ((diam / 2) * Math.sin((a * i) * (Math.PI / 180))));
			Point2D.Double p1 = new Point2D.Double(x, y);

			int tempX = (int)(x > originX ? x - 10 : (x < originX ? x + 10 : x));
			int tempY = (int)(y > originY ? y - 10 : (y < originY ? y + 10 : y));

			Point2D.Double p2 = new Point2D.Double(tempX,tempY);
			
			tempX = (int)(x > originX ? x - 20 : (x < originX ? x + 20 : x));
			tempY = (int)(y > originY ? y - 20 : (y < originY ? y + 20 : y));			
			if(i<=9){
			g2.drawString( i + 3 + " ", tempX, tempY);
			}
			else{
			g2.drawString( i-9 + " ", tempX, tempY);	
			}
			
			g2.draw(new Line2D.Double(p1, p2));
		}

		
	}
}
