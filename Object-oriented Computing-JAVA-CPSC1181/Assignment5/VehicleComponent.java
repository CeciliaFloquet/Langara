import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;


public class VehicleComponent extends JComponent
{  
	private int vehicleNumber;
	private ArrayList<Vehicle> vehicles;
	/**
	  * Constructs a VehicleComponent  that create vehiles that is the array of vehicle and call the method createVehicles
	  * ask the user how many vehicle they should draw
	  */
	public VehicleComponent(){
		String temp = JOptionPane.showInputDialog( null, "How many vehicle should be dispayed(Give integer)?", " Question", JOptionPane.QUESTION_MESSAGE); 
		vehicleNumber= Integer.parseInt(temp);
		vehicles= new ArrayList<Vehicle>();
		createVehicles();
	}
	/**
	  * Constructs a clockComponent with minutes and hours.
	  * @param Graphics 
	  */
	public void paintComponent(Graphics g)
    {  
      Graphics2D g2 = (Graphics2D) g;
		
		displayVehicle(g2);
		
	}
	/**
	  * create Vehicles that chose which vehicles it should draw-truck, car or bicycle
	  */
	public void createVehicles(){
		
		for(int i=0; i< vehicleNumber; i++){
			Random rand = new Random();
			float r = rand.nextFloat();
			float g = rand.nextFloat();
			float b = rand.nextFloat();
			int x, y;
			
			int tempPosition= getRandomPosition(3, 1);
			if(tempPosition == 1){
				do{
					x=getRandomPosition(940, 1);
					y=getRandomPosition(920, 1);
					
				}while(checkCollision (x, y, 80, 40));
				vehicles.add(new Car(x,y, r, g, b));
			 }
			if(tempPosition == 2){
				do{
					x=getRandomPosition(940, 1);
					y=getRandomPosition(880, 1);
					
				}while(checkCollision (x, y, 120, 60));
				vehicles.add(new Truck(x, y));
			 }
			if(tempPosition == 3){
				do{
					x=getRandomPosition(940, 1);
					y=getRandomPosition(900, 1);
					
				}while(checkCollision (x, y, 100, 60));
				vehicles.add(new Bicycle(x, y));
			 }
			 
		}
	}
	/**
	  * checkCollision  check if there are collision between vehicles 
	  * @param px the x coordinate of the top left corner
      * @param py the y coordinate of the top left corner
	  * @param width the width of the vehicle
	  * @param height the height of the vehicle
	  */
    public boolean checkCollision(int pX, int pY, int width, int height){
		for(int i=0; i< vehicles.size(); i++){
			if(vehicles.get(i).calculateBounding(pX, pY, width,height)){
				return true;
			}
			
		}
		return false;
	}
	/**
	  * getRandomPosition get the random position
	  * @param max that is possible to random
	  * @param min that is possible to random
	  */
	public int getRandomPosition(int max, int min){
		
		return (int)(Math.random() * ((max - min) + 1)) + min;
	}  
	/**
	  * displayVehicle  display the array of vehicleget the random position
	  * @param g2 the graphics context
	  */ 
	public void displayVehicle(Graphics2D g2){
		for(int i=0; i< vehicles.size(); i++){
			vehicles.get(i).draw(g2);
		}
	}  
}