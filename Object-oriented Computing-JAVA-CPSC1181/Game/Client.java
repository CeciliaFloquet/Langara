import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Client extends JFrame {

	private static final int WINDOW_WIDTH = 900;
	private static final int WINDOW_HEIGHT = 900;
	private static final int NUMBER_OF_ROWS = 5;
	private static final int NUMBER_OF_COLUMNS = 4;

	private MainPanel mainPanel;
	private ThreadServer threadServer;

	/**
	 * Constructs a Client without parameter
	 */
	public Client() throws Exception {
		this.threadServer = new ThreadServer();
		this.threadServer.start();
		start();
	}

	/**
	 * start a method game create main panel object
	 */
	public void start() {

		setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(true);
		setTitle("My Game");
		// startJFrame();
	}
	/**
	 * start a method game create Jframe
	 * @param x that is the row of cards
	 * @param y that is the column of cards
	 * @param playerID the id of the player
	 * @param currentTurn that is show the current players play
	 */
	public void startJFrame(int x, int y, String playerID, boolean currentTurn) {
		mainPanel = new MainPanel(x, y, playerID, currentTurn);
		add(mainPanel);
		setVisible(true);
	}

	/**
	 * call some function to resstat the game
	 */
	public void restart() {

		removeAll();
		start();
	}

	/**
	 * class Main Panel that extends Jpanel
	 */
	class MainPanel extends JPanel {

		private BorderLayout borderLayout;
		private ControlPanel controlPanel;
		private ButtonsPanel buttonsPanel;
		private int countSelect;
		private Card[][] cards = null;
		private int x, y;
		private String playerName;
		private boolean currentTurn;

		/**
		 * Constructs a MainPanel without parameter
		 * @param x that is the row of cards
		 * @param y that is the column of cards
		 * @param playerName that is player name
		 * @param currentTurn that is the person who play
		 */
		public MainPanel(int x, int y, String playerName, boolean currentTurn) {
			this.x = x;
			this.y = y;
			this.playerName = playerName;
			this.currentTurn = currentTurn;
			this.createCards();
			this.initialization();
		}

		/**
		 * method to initialization of the MainPanel set countSelect equal 0 and
		 * currentPlayer equal player1
		 */
		public void initialization() {

			borderLayout = new BorderLayout(1, 1);
			ActionPanel action = new ActionPanel();
			ButtonListener button = new ButtonListener();
			ButtonListenerQuit buttonListenerQuit = new ButtonListenerQuit();
			setLayout(borderLayout);
			createCards();
			buttonsPanel = new ButtonsPanel(action, cards);
			controlPanel = new ControlPanel(button, buttonListenerQuit, this.playerName, currentTurn);

			add(controlPanel);
			add(buttonsPanel);

			borderLayout.addLayoutComponent(controlPanel, BorderLayout.NORTH);
			borderLayout.addLayoutComponent(buttonsPanel, BorderLayout.CENTER);

			countSelect = 0;
		}
		/**
		 * create a cards
		 */
		public void createCards() {

			cards = new Card[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];

			for (int row = 0; row < cards.length; row++) {
				for (int column = 0; column < cards[0].length; column++) {
					cards[row][column] = new Card("smile.png");
				}
			}
			setLooseCard();
		}
		/**
		 * set looser position
		 */
		public void setLooseCard() {
			cards[x][y].setImage("gameover.png");
			cards[x][y].setLooser(true);
		}

		/**
		 * class ActionPanel that implements ActionListener
		 */
		class ActionPanel implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {

				Card selectedCard = (Card) e.getSource();
				if (!currentTurn) {
					controlPanel.showMessage("It's not your turn.");
				} else if (selectedCard.isSelected()) {
					controlPanel.showMessage("Piece already selected. Please, choose another piece.");
				} else if (countSelect == 2) {
					controlPanel.showMessage("Your turn is over. Please, press ok.");
				} else if (selectedCard.isLooser()) {
					controlPanel.showMessage("You are the looser.");
					JOptionPane.showMessageDialog(null, "Game over!");
					sendLooserSelected();
					restart();
				} else {
					countSelect++;
					cardSelected(selectedCard);
					sendCardClicked(selectedCard);
				}
			}
		}
		/**
		 * send the card clicked
		 * @param selectedCard that is the card selected
		 */
		private void sendCardClicked(Card selectedCard) {
			for (int row = 0; row < cards.length; row++) {
				for (int column = 0; column < cards[0].length; column++) {
					if (cards[row][column].equals(selectedCard)) {
						Message message = new Message(Message.TYPE_CHOOSE_CARD, row + "_" + column);
						threadServer.writeToServer(message);
					}
				}
			}
		}
		/**
		 * when the turn of player start
		 */
		private void turnStart() {
			System.out.println("TurnStart!!!!!!!!!!!!!!");
			this.currentTurn = true;
			this.controlPanel.setPlayer1(true);
		}
		/**
		 * @param message that is the message you need to show
		 */
		private void end(String message) {
			controlPanel.showMessage(message);
			JOptionPane.showMessageDialog(null, message);
		}
		/**
		 * @param row that is the collumn of card selected
		 * @param collumn that is the collumn of card selected
		 */
		private void cardSelectedByOponent(int row, int column) {
			Card card = cards[row][column];
			cardSelected(card);
		}
		/**
		 * @param selectedCard that is the card selected change image
		 */
		private void cardSelected(Card selectedCard) {
			selectedCard.setSelected(true);
			selectedCard.setImage("check.png");
			controlPanel.showMessage("");
		}
		/**
		 * show when the turn is over
		 */
		private void sendTurnOver() {
			Message message = new Message(Message.TYPE_TURN_OVER, playerName);
			threadServer.writeToServer(message);
		}
		/**
		 * send message looser is selected
		 */
		private void sendLooserSelected() {
			Message message = new Message(Message.TYPE_LOOSE_SELECTED, playerName);
			threadServer.writeToServer(message);
		}

		/**
		 * class ButtonListener that implements ActionListener
		 */
		class ButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				if (countSelect == 0) {
					controlPanel.showMessage("You can not skip your turn. Please, choose one or two piece.");
				} else {
					countSelect = 0;
					controlPanel.setPlayer1(false);
					controlPanel.disableButton();
					controlPanel.showMessage("");
					mainPanel.currentTurn = false;
					mainPanel.sendTurnOver();
				}

			}
		}

		/**
		 * class ButtonListenerQuit that implements ActionListener
		 */
		class ButtonListenerQuit implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				controlPanel.showMessage("You are the looser.");
				JOptionPane.showMessageDialog(null, "Game over");
				sendLooserSelected();
				restart();
			}
		}

	}

	/**
	 * class ActionPanel that implements ActionListener
	 */
	class MainPanelListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Event triggered!!!!");
		}
	}
	/**
	 * class that read and send message to server
	 */
	class ThreadServer extends Thread {

		private ObjectInputStream input;
		private ObjectOutputStream output;
		private Socket socket;

		public ThreadServer() throws IOException {
			this.socket = new Socket("localhost", 8888);
			this.output = new ObjectOutputStream(socket.getOutputStream());
		}

		public void run() {
			try {
				this.input = new ObjectInputStream(socket.getInputStream());
				while (true) {
					listenFromServer();
				}
			} catch (Exception e) {
				System.out.println("Error executing ThreadServer.");
				e.printStackTrace();
			}
		}
		/**
		 * listenFromServer that read message from server
		 */
		public void listenFromServer() throws Exception {
			System.out.println("Waiting server!");
			Object obj = this.input.readObject();
			if (obj != null && obj instanceof Message) {
				System.out.println("Obj message received.");
				Message message = (Message) obj;
				String msg = (String) message.getMessage();
				switch (message.getType()) {
				case Message.TYPE_START_GAME:
					String positionX = msg.split("_")[0];
					String positionY = msg.split("_")[1];
					startJFrame(Integer.valueOf(positionX), Integer.valueOf(positionY), msg.split("_")[2],
							Boolean.valueOf(msg.split("_")[3]));
					break;
				case Message.TYPE_CARD_SELECTED:
					mainPanel.cardSelectedByOponent(Integer.valueOf(msg.split("_")[0]),
							Integer.valueOf(msg.split("_")[1]));
					break;
				case Message.TYPE_TURN_START:
					mainPanel.turnStart();
					break;
				case Message.TYPE_LOOSE_SELECTED:
					mainPanel.end(msg);
					break;
				default:
					System.out.println("Message type not found.");
				}
			} else {
				System.out.println("Oo");
			}
		}
		/**
		 * writeToServer send messa do server
		 * @param msg that is the message you nesse to send
		 */
		public void writeToServer(Message msg) {
			try {
				this.output.writeObject(msg);
				this.output.flush();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error sending message to server.");
			}
		}
	}
}