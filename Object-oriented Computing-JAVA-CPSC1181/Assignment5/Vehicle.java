import java.awt.*;
import java.awt.Rectangle;
public abstract class Vehicle
{
	private  int width;
	private  int height;
	private  int px;
	private  int py;
	public abstract void draw(Graphics2D g2);
	/**
      * Constructs a vehicle with a given top left corner.
      * @param x the x coordinate of the top left corner
      * @param y the y coordinate of the top left corner
	  * @param width the width of the vehicle
	  * @param height the height of the vehicle
	  */
	public Vehicle(int x, int y, int width, int height)
	{
		this.px = x;
		this.py = y;
		this.width= width;
		this.height=height;
	}
	/**
     * calculate bunding.
     * @return true if collision and false if not
	 * @param pX the pX of the vehicle that you can check
	 * @param pY the pY of the vehicle that you can check
	 * @param width the width of the vehicle that you can check
	 * @param height the height of the vehicle that you can check
     */
	public boolean calculateBounding(int pX, int pY, int width, int height)
	{
		Rectangle r1 = new Rectangle(this.px,this.py,this.width,this.height);
		Rectangle r2 = new Rectangle(pX,pY,width,height);
		if(r1.intersects(r2))
		{
		   return true; 
		}
		return false;		
	}
	/**
	 * Gets the px.
	 * @return the px
	 */
	public int getPx(){
		return px;
	}
	/**
	 * Gets the py.
	 * @return the py
	 */
	public int getPy(){
		return py;
	}
	/**
	 * Gets the width.
	 * @return the width
	 */
	public int getWidth(){
		return width;
	}
	/**
	 * Gets the height.
	 * @return the height
	 */
	public int getHeight(){
		return height;
	}
	
   
  
}