import java.io.*;
import java.net.*;


public class GameServer
{
	public static void main(String[] args) throws IOException
	{
		//final int ACCOUNTS_LENGTH = 10;
		///Bank bank = new Bank(ACCOUNTS_LENGTH);

		final int SBAP_PORT = 8888;
		ServerSocket server = new ServerSocket(SBAP_PORT);
		System.out.println("Waiting for client to connect . . . ");
		Player player1 = null;
		Player player2 = null;
		int count = 1;
		while(count < 3)
		{
			Socket socket = server.accept();
			System.out.println("Client connected.");
			
			try {
				if (player1 == null) {
					player1 = new Player("Player->" + count, socket);
				} else if (player2 == null) {
					player2 = new Player("Player->" + count, socket);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			count++;
		}
		GameService service = new GameService(player1, player2);
		Thread t = new Thread(service);
		t.start();		
	}
}