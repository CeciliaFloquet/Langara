import java.net.Socket;

public class Player {

	private String playerName;
	private Socket socket;
	/**
	 * Constructs Player with parameter
	 * @param playerName that is player name
	 * @socket that is the socket of player
	 */
	public Player(String playerName, Socket socket) {
		this.playerName = playerName;
		this.socket = socket;
	}
	/**
	 * @return playerName
	 */
	public String getPlayerName() {
		return playerName;
	}
	/**
	 * set the name of player
	 * @param playerName that is the player name
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	/**
	 * @return socket
	 */
	public Socket getSocket() {
		return socket;
	}
	/**
	 * set socket
	 * @param socket that is the socket of player
	 */
	public void setSocket(Socket socket) {
		this.socket = socket;
	}

}