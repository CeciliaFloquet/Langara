import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class ButtonsPanel extends JPanel {

	private static final int NUMBER_OF_ROWS = 5;
	private static final int NUMBER_OF_COLUMNS = 4;
	private static final int HORIZONTAL_GAP = 5;
	private static final int VERTICAL_GAP = 5;
	private static final int BORDER = 20;

	private Card[][] cards = null;

	/**
	 * Constructs a buttonsPanel with parameter
	 * @param action that action listener call setCards with this
	 * @param cards
	 */
	public ButtonsPanel(ActionListener action, Card cards[][]) {

		GridLayout layout = new GridLayout(NUMBER_OF_ROWS, NUMBER_OF_COLUMNS, HORIZONTAL_GAP, VERTICAL_GAP);
		setLayout(layout);

		setBorder(BorderFactory.createEmptyBorder(BORDER, BORDER, BORDER, BORDER));

		this.cards = cards;

		setCards(action);

	}

	/**
	 * setCards on the screen with the image
	 * @param action that action listener set cards
	 */
	public void setCards(ActionListener action) {

		for (int row = 0; row < cards.length; row++) {
			for (int column = 0; column < cards[0].length; column++) {
				add(cards[row][column]);
				cards[row][column].addActionListener(action);
			}
		}

	}

}