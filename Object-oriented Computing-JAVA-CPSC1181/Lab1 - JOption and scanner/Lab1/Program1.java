import java.util.*;
public class Program1{

   public static void main(String[] args){
      double radius, area, perimeter;
      String answer;
      
     
     do{
        
          Scanner in = new Scanner(System.in);
         System.out.println("Please enter the radius");
         radius = in.nextDouble();
         
         area = CalculateArea(radius);
         perimeter = CalculateCircumference(radius);
          String str = String.format("Radius: %10.2f \nArea: %10.2f \nPerimeter %10.2f", radius, area, perimeter);
       System.out.println(str);
         Scanner input = new Scanner(System.in);
         System.out.println("Would you like to continue?");
         answer = input.nextLine();
         
         }while(answer.equalsIgnoreCase("yes"));
         
     
      
   }
   public static double CalculateArea(double radius){
      
      double area1 = Math.PI * radius * radius;   
         
      return area1;
         
   }
   public static double CalculateCircumference(double radius){
      
      double perimeter1 = 2 * Math.PI * radius;  
         
      return perimeter1;
         
   }
   
}