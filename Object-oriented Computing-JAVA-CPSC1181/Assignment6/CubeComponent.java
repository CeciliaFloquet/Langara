import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JComponent;

public class CubeComponent  extends JComponent
{
   
    Cube cube;
    public CubeComponent() {
        cube = new Cube(70, 70, 100, 25);	
    }
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
        cube.drawCube(g);
    }    
	public void moveTo(int x, int y){
		cube.build(x,y);
		repaint();	
	}
    public class Cube {
        int x, y, width, plus;
        Point[] cubeOnePoints;
        Point[] cubeTwoPoints;
        public Cube(int x, int y, int width, int plus) {
            this.width = width;
            this.plus = plus;
			build(x,y);   
        }
		public void build(int x, int y){
			this.x=x;
			this.y=y;
			cubeOnePoints = getCubeOnePoints();
            cubeTwoPoints = getCubeTwoPoints();
			
		}
		public void drawCube(Graphics g) {
            g.drawRect(x, y, width, width);
            g.drawRect(x - plus, y + plus, width, width);
            for (int i = 0; i < 4; i++) {
                g.drawLine(cubeOnePoints[i].x, cubeOnePoints[i].y, 
                        cubeTwoPoints[i].x, cubeTwoPoints[i].y);
            }
        }
        private Point[] getCubeOnePoints() {
            Point[] points = new Point[4];
            points[0] = new Point(x, y);
            points[1] = new Point(x + width, y);
            points[2] = new Point(x + width, y + width);
            points[3] = new Point(x, y + width);
            return points;
        }
        private Point[] getCubeTwoPoints() {
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