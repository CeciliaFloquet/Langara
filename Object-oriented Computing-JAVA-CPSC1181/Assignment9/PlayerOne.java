import java.net.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerOne extends JFrame 
{
   public static void main(String[] args) throws Exception
   {
	  
	  MyGame playre1 = new MyGame();
      final int SBAP_PORT = 8888;
      Socket socket = new Socket("localhost", SBAP_PORT);

		ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
		ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

      

      
      
      socket.close(); 
   }
}