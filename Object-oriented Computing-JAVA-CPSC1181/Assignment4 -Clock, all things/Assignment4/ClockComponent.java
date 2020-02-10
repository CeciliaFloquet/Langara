import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.time.LocalTime;
import javax.swing.JOptionPane;
/**
  * This component draws two clocks shapes AnalogClock and DigitalClock.
  */
public class ClockComponent extends JComponent
{  
	private LocalTime time;
	/**
	 * Constructs a clockComponent without parameter and use the loca time.
	 */
	public ClockComponent(){
		time = LocalTime.now();
	}
	/**
	  * Constructs a clockComponent with minutes and hours.
	  * @param hours the hours that the user want to show in the clock
	  * @param minutes the minutes that the user want to show in the clock
	  */
	public ClockComponent( int hours, int minutes){
		time = LocalTime.of(hours, minutes);
	}	
	/**
	  * create two objects AnalogClock and DigitalClock 
	  * call the function drawMe for this objects
	  * @param g the g that is type of Graphics
	  */	
    public void paintComponent(Graphics g)
    {  
      Graphics2D g2 = (Graphics2D) g;
		

      AnalogClock clock1 = new AnalogClock(time);
      
		
      DigitalClock clock2 = new DigitalClock(time);

      clock1.drawMe(g2, getWidth(), getHeight());
      clock2.drawMe(g2, getWidth(), getHeight());      
    }
   
}
