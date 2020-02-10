import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.Serializable;
/**
  * A card that is the card that show on screen.
  */
public class Card extends JButton implements Serializable {

	private boolean looser;
	private boolean cardSelected;
	/**
	 * Constructs a Card with parameter
	 * @param img the img that  is show on screen
	 * call setImage with this img
	 * set looser false
	 * set cardSelected false
	 */
	public Card(String img){
		cardSelected = false;
		setImage(img);
		looser = false;
	}
	/**
	 * set the image of card
	 * @param imagePath the imagePath that is show on screen
	 */
	public void setImage(String imagePath){
		try {
			Image img = ImageIO.read(getClass().getResource(imagePath));
			setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	/**
	 * set the setSelected card
	 * @param selected the selected that boolean which you will know if the card is selected
	 */
	public void setSelected(boolean selected) {
		cardSelected = selected;
	}
	/**
	 * set the setLooser of card
	 * @param looser the looser that boolean which you will know if the card is the looser
	 */
	public void setLooser(boolean looser) {
		this.looser= looser;
	}
	/**
	 * @return looser card
	 */
	public boolean isLooser() {
		return looser;
	}
	/**
	 * @return cardSelected 
	 */
	public boolean isSelected() {
		return cardSelected;
	}
}