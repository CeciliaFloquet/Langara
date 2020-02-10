import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.Random;
import static java.lang.String.valueOf;

public class ButtonsPanel extends JPanel {

	private static final int NUMBER_OF_ROWS = 5;
	private static final int NUMBER_OF_COLUMNS = 4;
	private static final int HORIZONTAL_GAP = 5;
	private static final int VERTICAL_GAP = 5;
	private static final int BORDER = 20;

	private Card[][] cards = null;

	int countPlay = 0;
	
	/**
	 * Constructs a buttonsPanel with parameter
	 * @param action the action that  action listener
	 * call setCards with this param action
	 * create card object
	 */
	public ButtonsPanel(ActionListener action){
		

		GridLayout layout = new GridLayout(NUMBER_OF_ROWS, NUMBER_OF_COLUMNS, HORIZONTAL_GAP, VERTICAL_GAP);
		setLayout(layout);

		setBorder(BorderFactory.createEmptyBorder(BORDER,BORDER,BORDER,BORDER));

		cards = new Card[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
	
		setCards(action);

	}
	/**
	 * setCards on the screen with the image
	 * @param action the action that  action listener
	 * set random number that will choose the position of looser card
	 */
	public void setCards(ActionListener action) {
		int a = 0;
		int randomOne = (int)(Math.random() * 4);
		int randomTwo = (int)(Math.random() * 3);
		for (int row = 0; row < cards.length; row++) {
			for (int column = 0; column < cards[0].length; column++) {
					cards[row][column] = new Card("smile.png");
					add(cards[row][column]);
					cards[row][column].addActionListener(action);
					a++;
			}
		}
		cards[randomOne][randomTwo].setImage("gameover.png");
		cards[randomOne][randomTwo].setLooser(true);
	}
	


   
}