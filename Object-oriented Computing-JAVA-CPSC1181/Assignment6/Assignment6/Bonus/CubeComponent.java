import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JComponent;
import java.lang.Math;
import java.awt.*;
import java.awt.geom.Line2D;
//https://www.youtube.com/watch?v=s_rH3w9aZwQ
/**
  * This component draws cube
  */
public class CubeComponent extends JComponent
{
    
    Cube cube;
	Point firstPosition;
	Point closestPosition;
	boolean press= false;
	/**
	 * Constructs a CubeComponent without parameter.
	 */
	public CubeComponent() {
        cube = new Cube(70, 70, 300, 60);	
    }
	/**
	  * call the method draw for this objects
	  * @param g the g that is type of Graphics
	  * draw the line between the closest point and the point that you click
	  */
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		 Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3.0f));
        cube.draw(g);
		if(firstPosition != null && closestPosition != null) {
            g.drawLine(firstPosition.x, firstPosition.y, closestPosition.x, closestPosition.y);		
		}
    }
	/**
	  * call the method rebuild to change the x and y value
	  * @param x the x that is the new position of mouse
	  * @param y the y that is the new position of mouse
	  */    
	public void moveTo(int x, int y){
		//cube.findClosestPoint(x,y);
		//press=false;
		firstPosition= null;
		closestPosition= null;
		cube.rebuild(x, y);
		repaint();	
	}
	/**
	  * create new point and insert this in the variable firstPosition.Use this part in bonus question 
	  * call the function findClosestPoint and save the input in the variavle closestPosition. Use this part in bonus question 
	  * @param x the x that is the new position of mouse
	  * @param y the y that is the new position of mouse
	  * repaint the cube
	  */
	public void findClosestPoint(int x, int y){
		firstPosition = new Point(x, y);
		closestPosition=cube.findClosestPoint(x,y);	
		repaint();
	}
	/**
	  * call the function moveCube of the cube to change the direction of cube
	  */
	public void moveCube(){
		cube.moveCube();
	}
	/**
	 * class cube.
	 */
    public class Cube {
        int x, y, width, plus, cubeGetDirection=4;
        Point[] pointOne;
        Point[] pointTwo;
		Point closestPoint;
		int index=0, element=0;
        /**
		 * Constructs a Cube
		 * @param x the x that is the position x of mouse	
		 * @param y the y that is the position y of mouse	
		 * @param width the width that is width of mouse
		 * @param plus the plus that is distance between each rectangle of cube
		 */
		public Cube(int x, int y, int width, int plus) {
            this.width = width;
            this.plus = plus;
			build(x,y);
        }
		/**
		 * get the diretion to move cube
		 * return integer
		 */
		public int getDirection(){
			return (int)((Math.random() * 4) + 1);	
		}
		/**
		 * method moveCube that change the position of x and y and call method build to draw cube with new position
		 */
		public void moveCube(){
			switch(cubeGetDirection){
				case 1:
					//right
					if(this.x <= 669){
						this.x =x+20; 
						build(x,y);
					}
					else{
						cubeGetDirection= getDirection(); 
					}
					break;
				case 2:
					//left
					if(this.x >= 71){
						this.x =x-20;
						build(x,y);				
					}
					else{
						cubeGetDirection= getDirection(); 
					}
					break;
				case 3:
					//up
					if(this.y >= 30) {
						this.y = y-20; 
						build(x,y);
					}
					else{
						cubeGetDirection= getDirection();
					}
					break;
				case 4:
					//down
					if(this.y <= 570){
						this.y = y+20; 
						build(x,y);
					}
					else{
						cubeGetDirection= getDirection(); 
					}
					break;
			}
		}
		/**
		 * find the point that is closest the new x and y
		 * @param x the x that is the new position of mouse
		 * @param y the y that is the new position of mouse
		 * return the closestPoint
		 */	
		public Point findClosestPoint(int x, int y) {			
			double distance = Integer.MAX_VALUE;
			for (int i = 0; i < pointOne.length; i++) {
				double temp = Math.sqrt(Math.pow((x - pointOne[i].getX()),2) + Math.pow((y - pointOne[i].getY()),2));				
				if (temp < distance) {
					distance = temp;
					closestPoint = pointOne[i];
					index=i;
					element=1;
				}
			}
			for (int i = 0; i < pointTwo.length; i++) {
				double temp = Math.sqrt(Math.pow((x - pointTwo[i].getX()),2) + Math.pow((y - pointTwo[i].getY()),2));
				
				if (temp < distance) {
					distance = temp;
					closestPoint = pointTwo[i];
					index=i;
					element=2;
				}
			}			
			return closestPoint;
		}
		/**
		 * change the value of new x and y to draw the cube in the correct position
		 * @param x the x that is the new position of mouse
		 * @param y the y that is the new position of mouse
		 */
		public void rebuild(int x, int y){
			if (index == 0 && element ==1){
				this.x= x;
				this.y=y;
			}
			if (index == 1 && element ==1){
				this.x= x-300;
				this.y=y;
			}
			if (index == 2 && element == 1){
				this.x= x-300;
				this.y= y-300;
			}
			if (index == 3 && element == 1){
				this.y=y-300;
				this.x=x;
			}
			if (index == 0 && element == 2){
				this.x=x + 60;
				this.y=y-60;
			}
			if (index == 1 && element == 2){
				this.x=x -240;
				this.y = y - 60;
			}
			if (index == 2 && element == 2){
				this.x = x - 240;
				this.y = y - 360;
			}
			if (index == 3 && element == 2){
				this.x = x + 60;
				this.y = y - 360;
			}
			build(this.x, this.y);	
		}
		/**
		 * build the point of the cube
		 * @param x the x that is the position of mouse
		 * @param y the y that is the position of mouse
		 * return the closestPoint
		 */
		public void build(int x, int y){
			this.x=x;
			this.y=y;
			pointOne = getPointOne();
            pointTwo = getPointTwo();			
		}
		/**
		 * draw the object cube and the point of cube objects
		 * @param g the g that is type of Graphics
		 */
		public void draw(Graphics g) {
            g.drawRect(x, y, width, width);
            g.drawRect(x - plus, y + plus, width, width);
            for (int i = 0; i < 4; i++) {
                g.drawLine(pointOne[i].x, pointOne[i].y, pointTwo[i].x, pointTwo[i].y);
            }
		}
        /**
		 * build the first point of the cube
		 * return points
		 */		
        private Point[] getPointOne() {
            Point[] points = new Point[4];
            points[0] = new Point(x, y);
            points[1] = new Point(x + width, y);
            points[2] = new Point(x + width, y + width);
            points[3] = new Point(x, y + width);
            return points;
        }
		/**
		 * build the second point of the cube
		 * return points
		 */
        private Point[] getPointTwo() {
            int x1 = x - plus;
            int y1 = y + plus;
            Point[] points = new Point[4];
            points[0] = new Point(x1, y1);
            points[1] = new Point(x1 + width, y1);
            points[2] = new Point(x1 + width, y1 + width);
            points[3] = new Point(x1, y1 + width);
            return points;
        }
        
    } 
}