import java.io.*;
import java.net.*;
import java.util.*;

public class GameService implements Runnable
{

	private Card[][] cards = null;
	private static final int NUMBER_OF_ROWS = 5;
	private static final int NUMBER_OF_COLUMNS = 4;
	private Socket socket;
	private Scanner in;
	private PrintWriter out;
  
	private ObjectInputStream input;
	private ObjectOutputStream output;
	
	private Player player1;
	private Player player2;
   
	public GameService(Player player1, Player player2)
	{
		cards = new Card[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
		createCards();	
		this.player1 = player1;
		this.player2 = player2;
	}

	/**
	 * setCards on the screen with the image
	 * @param action the action that  action listener
	 * set random number that will choose the position of looser card
	 */
	public void createCards() {
		int a = 0;
		int randomOne = (int)(Math.random() * 4);
		int randomTwo = (int)(Math.random() * 3);
		for (int row = 0; row < cards.length; row++) {
			for (int column = 0; column < cards[0].length; column++) {
					cards[row][column] = new Card("smile.png");
					a++;
			}
		}
		cards[randomOne][randomTwo].setImage("gameover.png");
		cards[randomOne][randomTwo].setLooser(true);
	}
	
   public void run() 
   {
		try
		{
			try
			{	
				System.out.println("Run method1");
				input = new ObjectInputStream(player1.getSocket().getInputStream());
				String value = null;
				if (input != null) {
					System.out.println("ObjectInputStream");
					System.out.println(input.readObject());
				}
				output = new ObjectOutputStream(player1.getSocket().getOutputStream());
				System.out.println("Run method2");
				doService();
			}
			finally
			{
				player1.getSocket().close();
			}
		}
		catch(IOException exception)
		{
			exception.printStackTrace();
		} catch(Exception exception)
		{
			exception.printStackTrace();
		}
	  
	}
	public void doService() throws Exception{
		while (true)
		{
			System.out.println("Do service.");
			listenSocket();
			Thread.sleep(100);	
		}
		
	}
	public void listenSocket() throws Exception{
	   String name = (String)input.readObject();
	   System.out.println(name);
	   if(name != null){
		  
		writeSocket();
		System.out.println(name);
	   } else {
	   System.out.println("do nothing");
	   
	   }
	}

	public void writeSocket() throws Exception{
	   output.writeObject(cards);
	}
 
}