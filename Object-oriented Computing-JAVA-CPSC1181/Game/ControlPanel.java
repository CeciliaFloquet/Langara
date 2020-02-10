import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * controle of Panel that show on screen.
 */
public class ControlPanel extends JPanel {

	private JLabel labelMessages;
	private BorderLayout borderLayout;
	private JRadioButton radioButton1;
	private JButton button1;
	private JButton buttonQuit1;

	private boolean player1;

	/**
	 * Constructs a ControlPanel with parameter
	 * @param button that action button of listener
	 * @param buttonListenerQuit that action button quit of listener    
	 * @param currentTurn that show which player play
	 */
	public ControlPanel(ActionListener button, ActionListener buttonListenerQuit, String playerName,boolean currentTurn) {
		this.player1 = currentTurn;
		borderLayout = new BorderLayout();
		setLayout(borderLayout);
		labelMessages = new JLabel();

		JPanel styleGroupPanel = createPlayers(button, buttonListenerQuit, playerName);

		labelMessages.setText(" ");
		labelMessages.setBackground(Color.BLUE);
		labelMessages.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 2, Color.black));

		add(styleGroupPanel);
		add(labelMessages);

		borderLayout.addLayoutComponent(styleGroupPanel, BorderLayout.WEST);

		borderLayout.addLayoutComponent(labelMessages, BorderLayout.CENTER);

	}

	/**
	 * create the players and the players buttons
	 * @param button that action button of listener
	 * @param buttonListenerQuit that action button quit of listener
	 * @param playerName that is player name   
	 * @return the Jpanel
	 */
	public JPanel createPlayers(ActionListener button, ActionListener buttonListenerQuit, String playerName) {

		radioButton1 = new JRadioButton(playerName);
		radioButton1.addActionListener(button);
		radioButton1.setSelected(true);
		radioButton1.setEnabled(player1);

		button1 = new JButton("ok");
		button1.addActionListener(button);
		button1.setEnabled(player1);

		buttonQuit1 = new JButton("Quit");
		buttonQuit1.addActionListener(buttonListenerQuit);
		buttonQuit1.setEnabled(player1);

		ButtonGroup group = new ButtonGroup();
		group.add(radioButton1);
		group.add(button1);
		group.add(buttonQuit1);

		JPanel panel = new JPanel();
		panel.add(radioButton1);
		panel.add(button1);
		panel.add(buttonQuit1);

		panel.setBorder(new TitledBorder(new EtchedBorder(), "PLAYERS"));

		return panel;
	}

	/**
	 * show the message on screen
	 * @param message that show the correct message on screen
	 */
	public void showMessage(String message) {
		labelMessages.setText(message);
	}

	/**
	 * @return button1
	 */
	public JButton getButton1() {
		return button1;
	}

	/**
	 * change the enable of players when the player finish their turn
	 */
	public void disableButton() {
		button1.setEnabled(player1);
		radioButton1.setEnabled(player1);
		buttonQuit1.setEnabled(player1);
	}

	/**
	 * @return player1
	 */
	public boolean isPlayer1() {
		return player1;
	}
	/**
	 * @param player1 that is boolean
	 */
	public void setPlayer1(boolean player1) {
		this.player1 = player1;
		disableButton();
	}

}