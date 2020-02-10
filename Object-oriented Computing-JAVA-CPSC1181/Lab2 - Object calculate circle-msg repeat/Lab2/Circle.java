public class Circle{

   public Circle(){
    radius=0;
   
   }
   public Circle(double rad){
      radius=rad;
   
   }
   public double  getArea(){
      double area = Math.PI * radius * radius;  
      return area;
   }
   public double getPerimeter(){
      double perimeter = 2 * Math.PI * radius;  
         
      return perimeter;
   }
   public double getRadius(){
   
      return radius;
   }
   private double radius;
}