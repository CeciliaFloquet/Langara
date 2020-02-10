import javax.swing.*;

public class CalculateViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new CalculateFrame();
	  frame.setSize(550, 350);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}