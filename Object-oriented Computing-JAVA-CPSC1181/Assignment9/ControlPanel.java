import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
  * controle of Panel that show on screen.
  */
public class ControlPanel extends JPanel {

	private JLabel labelMessages;
	private BorderLayout borderLayout;
	private JRadioButton radioButton1;
	private JRadioButton radioButton2;
	private JButton button1;
	private JButton button2;
	private JButton buttonQuit1;
	private JButton buttonQuit2;
	private boolean player1;
	int score = 0;
	/**
	 * Constructs a ControlPanel with parameter
	 * @param button the button that action button of listener
	 * @param buttonListenerQuit the buttonListenerQuit that action button quit of listener
	 */
	public ControlPanel(ActionListener button, ActionListener buttonListenerQuit){

		borderLayout = new BorderLayout();
		setLayout(borderLayout);
		labelMessages = new JLabel();
	   

		JPanel styleGroupPanel =createPlayers(button, buttonListenerQuit);

		labelMessages.setText(" ");
		labelMessages.setBackground(Color.BLUE);
		labelMessages.setBorder(BorderFactory.createMatteBorder(0,2,0,2,Color.black));
		
		add(styleGroupPanel);
		add(labelMessages);
		add(labelMessages);

		borderLayout.addLayoutComponent(styleGroupPanel, BorderLayout.WEST);
	  
		borderLayout.addLayoutComponent(labelMessages,BorderLayout.CENTER);
	   
	}
	/**
	 * create the players and the players buttons
	 * @param button the button that action button of listener
	 * @param buttonListenerQuit the buttonListenerQuit that action button quit of listener
	 * @return the Jpanel
	 */
	public JPanel createPlayers(ActionListener button, ActionListener buttonListenerQuit) {
		
		radioButton1 = new JRadioButton("Player1");
		radioButton1.addActionListener(button);
		radioButton1.setSelected(true);
		player1= true;
		button1 = new JButton("ok");
		button1.addActionListener(button);
		
		buttonQuit1 = new JButton("Quit");
		buttonQuit1.addActionListener(buttonListenerQuit);
		
		radioButton2 = new JRadioButton("Player2");
		radioButton2.addActionListener(button);
		radioButton2.setEnabled(false);
		
		button2 = new JButton("ok");
		button2.setEnabled(false);
		button2 .addActionListener(button);
		
		buttonQuit2 = new JButton("Quit");
		buttonQuit2.addActionListener(buttonListenerQuit);
		buttonQuit2.setEnabled(false);
		
		
		ButtonGroup group = new ButtonGroup();
		group.add(radioButton1);
		group.add(button1);
		group.add(buttonQuit1);
		group.add(radioButton2);
		group.add(button2);
		group.add(buttonQuit2);
		 
		JPanel panel = new JPanel();
		panel.add(radioButton1);
		panel.add(button1);
		panel.add(buttonQuit1);
		panel.add(radioButton2);
		panel.add(button2);
		panel.add(buttonQuit2);
		
		
		panel.setBorder(new TitledBorder(new EtchedBorder(), "PLAYERS"));

		return panel;
	}
	/**
	 * show the message on screen
	 * @param message the message that show the correct message on screen
	 */
	public void showMessage(String message) {
		labelMessages.setText(message);
	}
	
	/**
	 * @return button1 
	 */
	public JButton getButton1(){
		return button1;
	}
	/**
	 * @return button2 
	 */
	public JButton getButton2(){
		return button2;
	}
	/**
	 * change the enable of players when the player finish their turn
	 * @param buttonClicked the buttonClicked that action listener of button
	 */
	public void disableButton(JButton buttonClicked){
		if(buttonClicked.equals(button1)){
			button2.setEnabled(true);
			button1.setEnabled(false);
			radioButton2.setEnabled(true);
			radioButton2.setSelected(true);
			radioButton1.setEnabled(false);
			buttonQuit1.setEnabled(false);
			buttonQuit2.setEnabled(true);
			buttonQuit2.setSelected(true);
			player1= false;
		}
		else{
			button2.setEnabled(false);
			button1.setEnabled(true);
			radioButton2.setEnabled(false);
			radioButton1.setEnabled(true);
			radioButton1.setSelected(true);
			buttonQuit1.setEnabled(true);
			buttonQuit1.setSelected(true);
			buttonQuit2.setEnabled(false);
			
				player1= true;
		}
	}
	/**
	 * @return  player1 
	 */
	public boolean isPlayer1(){
		return player1;
	}
	
}