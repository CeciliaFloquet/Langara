import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyGame extends JFrame {
	
	private static final int WINDOW_WIDTH = 900;
    private static final int WINDOW_HEIGHT = 900;

    private MainPanel mainPanel;
	/**
	 * Constructs a MyGame without parameter
	 */
    public MyGame() {
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
		
        mainPanel = new MainPanel();
        add(mainPanel);
        setVisible(true);

		//revalidate();
		//repaint();		
	}
	/**
	 * call some function to resstat the game
	 */
	public void restart() {
		
		removeAll();
		start();
		revalidate();
		repaint();
		
	}
	/**
	 * class Main Panel that extends Jpanel
	 */
	class MainPanel extends JPanel {

		private BorderLayout borderLayout;
		private ControlPanel controlPanel;
		private ButtonsPanel buttonsPanel;
		private int countSelect;
		private String currentPlayer;
		/**
		 * Constructs a MainPanel without parameter
		 */
		public MainPanel(){

			this.initialization();
			
		}
		/**
		 * method to initialization of the MainPanel
		 * set countSelect equal 0 and currentPlayer equal player1
		 */
		public void initialization() {
			
			borderLayout = new BorderLayout(1,1);
			ActionPanel action = new ActionPanel();
			ButtonListener button= new ButtonListener();
			ButtonListenerQuit buttonListenerQuit = new ButtonListenerQuit();
			setLayout(borderLayout);

			buttonsPanel = new ButtonsPanel(action);
			controlPanel = new ControlPanel(button, buttonListenerQuit);
			
			add(controlPanel);
			add(buttonsPanel);

			borderLayout.addLayoutComponent(controlPanel, BorderLayout.NORTH);
			borderLayout.addLayoutComponent(buttonsPanel, BorderLayout.CENTER);
			
			countSelect = 0;
			currentPlayer= "player1";
		}
		/**
		 * class ActionPanel that implements ActionListener
		 */
		class ActionPanel implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Card selectedCard = (Card) e.getSource();
				if(selectedCard.isSelected()){
					controlPanel.showMessage("Piece already selected. Please, choose another piece.");
				} 
				else if(countSelect == 2){
					controlPanel.showMessage("Your turn is over. Please, press ok.");
					
				}
				else if(selectedCard.isLooser()){
					controlPanel.showMessage("You are a looser.");
					JOptionPane.showMessageDialog(null, "Game over");
					restart();
				}
				else {
					
					selectedCard.setSelected(true);
					selectedCard.setImage("check.png");
					countSelect ++;
					controlPanel.showMessage("");
					
				}
			}
		}
		/**
		 * class ButtonListener that implements ActionListener
		 */
		class ButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				if(countSelect == 0){
					controlPanel.showMessage("You can not skip your turn. Please, choose one or two piece.");
				}
				else{
					JButton buttonClicked = (JButton) event.getSource();
					controlPanel.disableButton(buttonClicked);
					countSelect=0;
					controlPanel.showMessage("");
				}

			}
		}
		/**
		 * class ButtonListenerQuit that implements ActionListener
		 */
		class ButtonListenerQuit implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				
				if(controlPanel.isPlayer1()){
					controlPanel.showMessage("Player 1 are a looser");
					JOptionPane.showMessageDialog(null, "Game over");
					restart();
				}
				else{
					controlPanel.showMessage("Player 2 are a looser");
					JOptionPane.showMessageDialog(null, "Game over");
					restart();
				}

			}
		}

	}
}