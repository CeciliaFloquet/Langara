import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.time.LocalTime;
import java.util.ArrayList;
import java.awt.*;
import java.awt.FontMetrics;


/**
  * A DigitalClock shape that can be positioned in middle on the screen.
  */
public class DigitalClock
{
  
	private LocalTime time;
	private int width;
	private int height;
	/**
	 * Constructs a DigitalClock with parameter
	 * @param time the time that  is type of LocalTime
	 * set this time in the varible time
	 */
	public DigitalClock(LocalTime time )
	{
		this.time = time;
			
	}
	/**
     * Draws the reclangle with the time inside of it.
     * @param g2 the graphics context
	 * @param width that is the width of box
	 * @param height that is the height of box
     */
    public void drawMe(Graphics2D g2, int width, int height)
	{
		int x, y;
		this.width = width;
		this.height = height;  
		int sideX = (int)((width * 0.4) * 0.25 );
		int sideY = (int)((height * 0.4) * 0.1);
		double diagonal = (Math.sqrt(2) * sideY) / 2;
		x = (int) ((width/2 ) + ((diagonal) * Math.cos((225) * (Math.PI / 180))));
        y = (int) ((height/2+(sideX) ) + ((diagonal) * Math.sin((225) * (Math.PI / 180))));
		//designer, draw rectancle and put the time in this rectancle
		g2.setPaint(Color.blue);
		g2.drawRect(x-10, y, sideX, sideY);
		String i= "" + time.getHour() + ":" + time.getMinute();
		Font plainFont = new Font("Serif", Font.PLAIN, 24);        
		g2.setFont(plainFont);
		
		g2.drawString(i+"",x+20, y +25);
   
	}
   
   
}