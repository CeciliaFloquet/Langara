import javax.swing.JOptionPane;
public class Program2{

   public static void main(String[] args){
   
      double radius, area, perimeter;
      String answer;
      
      do{
         String radius1 = JOptionPane.showInputDialog( null, "Enter a radius:", " Demo", JOptionPane.QUESTION_MESSAGE);
           
         radius= Double.parseDouble(radius1);
         
         if(Double.isNaN(radius)){
            JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.INFORMATION_MESSAGE);
         }
         else{
            area = CalculateArea(radius);
            
            perimeter = CalculateCircumference(radius);
           
            String str = String.format("Radius: %10.2f \nArea: %10.2f \nPerimeter %10.2f", radius, area, perimeter);
            
            JOptionPane.showMessageDialog(null, str);
           
            System.out.println("area" + str);
            System.out.println("perimeter" + perimeter);
         } 
      
      }while (getRespond());  
      
		
      
   }
   //I use your method
   public static boolean getRespond()
   {
      String[] levels = {"Yes", "No"};
      
      int answer = JOptionPane.showOptionDialog(null, "Would you like to continue?",
          "Question?",JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
         levels, levels[1]); 
      
      if (answer == 0)
         return true;
      
      else
         return false;
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