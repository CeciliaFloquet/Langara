import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
	public static void main(String[] args) throws IOException {
		final int SBAP_PORT = 8888;
		ServerSocket server = new ServerSocket(SBAP_PORT);
		System.out.println("Waiting for client to connect . . . ");

		while (true) {
			Socket socket = server.accept();
			System.out.println("Client connected.");

			Player player1 = new Player("Player->1", socket);

			socket = server.accept();

			Player player2 = new Player("Player->2", socket);

			GameService service = new GameService(player1, player2);
			Thread thread = new Thread(service);
			thread.start();
			System.out.println("GameService created!");
		}
	}
}