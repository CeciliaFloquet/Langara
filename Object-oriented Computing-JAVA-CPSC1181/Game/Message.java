import java.io.Serializable;

public class Message implements Serializable {

	public static final String TYPE_START_GAME = "TYPE_LOOSE_POSITION";
	public static final String TYPE_CHOOSE_CARD = "TYPE_CHOOSE_CARD";
	public static final String TYPE_CARD_SELECTED = "TYPE_CARD_SELECTED";
	public static final String TYPE_LOOSE_SELECTED = "TYPE_LOOSE_SELECTED";
	public static final String TYPE_TURN_OVER = "TYPE_TURN_OVER";
	public static final String TYPE_TURN_START = "TYPE_TURN_START";

	private String type;
	private Object message;
	/**
	 * Constructs Message with parameter
	 * @param type set the type 
	 * @param message set the message
	 */
	public Message(String type, Object message) {
		this.type = type;
		this.message = message;
	}
	/**
	 * @return type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @return message
	 */
	public Object getMessage() {
		return message;
	}
}
