import javax.swing.JOptionPane;
public class TestCircle{

   public static void main(String[] args){
   
      
      do{
      
         String radius1 = JOptionPane.showInputDialog( null, "Enter a radius:", " Demo", JOptionPane.QUESTION_MESSAGE);
              
         double radius= Double.parseDouble(radius1);
         
         while(radius<0){
            JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.INFORMATION_MESSAGE);
            radius1 = JOptionPane.showInputDialog( null, "Enter a radius:", " Demo", JOptionPane.QUESTION_MESSAGE);
            radius= Double.parseDouble(radius1);
         }
         if(radius==0){
             //new circle default
            Circle c1= new Circle();
            double radius_1 =c1.getRadius();
            double area1 = c1.getArea();
            double perimeter1 = c1.getPerimeter();
            String str = String.format("Radius: %10.2f \nArea: %10.2f \nPerimeter %10.2f", radius_1, area1, perimeter1);
            System.out.println(str);
           
         }
         else{
            //new circle
            Circle c2 = new Circle(radius);
            double radius2=c2.getRadius();
            double area2=c2.getArea();
            double perimeter2= c2.getPerimeter();
            String str = String.format("Radius: %10.2f \nArea: %10.2f \nPerimeter %10.2f", radius2, area2, perimeter2);
            System.out.println(str);
         }
      }while(answer());
   }
   
   //method to ask continue the program
   public static boolean answer(){
      String[] question = {"Yes", "No"};
      
      int answer1 = JOptionPane.showOptionDialog(null, "Would you like to continue?",
          "Question?",JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
         question, question[1]); 
      
      if (answer1 == 0)
         return true;
      
      else
         return false;
   }

}