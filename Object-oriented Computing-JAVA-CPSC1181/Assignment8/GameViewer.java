import javax.swing.*;

public class GameViewer
{
	
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 1000;
	
   public static void main(String[] args)
   {
      JFrame frame = new GameFrame();
	  frame.setSize(WIDTH, HEIGHT);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.setTitle("My Game");
      frame.setVisible(true);
	  
   }
}