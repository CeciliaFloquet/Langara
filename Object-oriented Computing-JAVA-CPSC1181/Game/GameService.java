import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GameService implements Runnable {

	private Card[][] cards = null;
	private static final int NUMBER_OF_ROWS = 5;
	private static final int NUMBER_OF_COLUMNS = 4;

	private Player player1;
	private Player player2;
	private ThreadPlayer threadPlayer1;
	private ThreadPlayer threadPlayer2;
	/**
	 * Constructs a GameService with parameter
	 * @param player1 that is the player 1
	 * @param player2 that is the player 2
	 */
	public GameService(Player player1, Player player2) {
		cards = new Card[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
		this.player1 = player1;
		this.player2 = player2;
		this.startThreadPlayer();
		this.start();
	}

	/**
	 * setCards on the screen with the image
	 */
	public void createCards() {
		int randomOne = (int) (Math.random() * 4);
		int randomTwo = (int) (Math.random() * 3);
		for (int row = 0; row < cards.length; row++) {
			for (int column = 0; column < cards[0].length; column++) {
				cards[row][column] = new Card("smile.png");
			}
		}
		cards[randomOne][randomTwo].setImage("gameover.png");
		cards[randomOne][randomTwo].setLooser(true);
		sendLoosePosition(randomOne, randomTwo);
	}

	public void run() {
		try {
			doService();
		} catch (IOException exception) {
			exception.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}
	
	public void doService() throws Exception {
		System.out.println("Do service.");
	}
	/**
	 * start the game call method createCards
	 */
	private void start() {
		createCards();
	}
	/**
	 * setCards on the screen with the image
	 * @param x that is the row of cards
	 * @param y that is the column of cards
	 */
	private void sendLoosePosition(int x, int y) {

		Message message = new Message(Message.TYPE_START_GAME,
				x + "_" + y + "_" + player1.getPlayerName() + "_" + true);
		threadPlayer1.writeToPlayer(message);
		Message message2 = new Message(Message.TYPE_START_GAME,
				x + "_" + y + "_" + player2.getPlayerName() + "_" + false);
		threadPlayer2.writeToPlayer(message2);
	}
	/**
	 * choseCard 
	 * @param row that is the row of card
	 * @param column that is the collumn of card
	 */
	private void chooseCard(int row, int column) {
		cards[row][column].setSelected(true);
		cards[row][column].setImage("check.png");
	}
	/**
	 * sendCardSelected 
	 * @param row that is the row of card selected
	 * @param column that is the collumn of card selected
	 */
	private void sendCardSelected(int row, int column) {
		Message message = new Message(Message.TYPE_CARD_SELECTED, row + "_" + column);

		threadPlayer1.writeToPlayer(message);
		threadPlayer2.writeToPlayer(message);
	}
	/**
	 * turnOver
	 * @param player that is the player you need to show message turn over
	 */
	private void turnOver(String player) {
		Message message = new Message(Message.TYPE_TURN_START, "true");

		if (player.equals(player1.getPlayerName())) {
			threadPlayer2.writeToPlayer(message);
		} else {
			threadPlayer1.writeToPlayer(message);
		}
	}
	/**
	 * end
	 * @param playerLooser that is the player you need to show message you won
	 */
	private void end(String playerLooser) {
		Message message = new Message(Message.TYPE_LOOSE_SELECTED, "You won!");

		if (playerLooser.equals(player1.getPlayerName())) {
			threadPlayer2.writeToPlayer(message);
		} else {
			threadPlayer1.writeToPlayer(message);
		}
	}
	/**
	 * end
	 * @param startThreadPlayer that 
	 */
	private void startThreadPlayer() {
		try {
			System.out.println("Starting player threads!!");
			threadPlayer1 = new ThreadPlayer(player1);
			threadPlayer2 = new ThreadPlayer(player2);
			threadPlayer1.start();
			threadPlayer2.start();
		} catch (Exception e) {
			System.out.println("Error starting thread players");
		}
	}
	/**
	 * class that read and send message to players
	 */
	class ThreadPlayer extends Thread {

		private ObjectInputStream input;
		private ObjectOutputStream output;
		private Player player;

		public ThreadPlayer(Player player) throws IOException {
			this.player = player;
			this.output = new ObjectOutputStream(this.player.getSocket().getOutputStream());
		}

		public void run() {
			try {
				System.out.println("Creating input output");
				this.input = new ObjectInputStream(this.player.getSocket().getInputStream());
				while (true) {
					listenFromPlayer();
				}
			} catch (InterruptedException e) {
				System.out.println("InterruptedException executing ThreadPlayer --> " + player.getPlayerName());
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("General error executing ThreadPlayer --> " + player.getPlayerName());
				e.printStackTrace();
			}
		}
		/**
		 * listenFromPlayer that read message from player
		 */
		public void listenFromPlayer() throws Exception {
			Object obj = this.input.readObject();
			if (obj != null && obj instanceof Message) {
				Message message = (Message) obj;
				String msg = (String) message.getMessage();
				switch (message.getType()) {
				case Message.TYPE_CHOOSE_CARD:
					chooseCard(Integer.valueOf(msg.split("_")[0]), Integer.valueOf(msg.split("_")[1]));
					sendCardSelected(Integer.valueOf(msg.split("_")[0]), Integer.valueOf(msg.split("_")[1]));
					break;
				case Message.TYPE_TURN_OVER:
					turnOver(msg);
					break;
				case Message.TYPE_LOOSE_SELECTED:
					end(msg);
				default:
					System.out.println("Message type not found.");
				}
			}
		}
		/**
		 * writeToPlayer send message  to players
		 * @param msg that is the message you nessd to send
		 */
		public void writeToPlayer(Message msg) {
			try {
				this.output.writeObject(msg);
				this.output.flush();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error sending message.");
			}
		}
	}

}