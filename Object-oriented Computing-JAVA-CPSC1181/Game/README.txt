In the game there are 19 cards with smile(unselected card) and 1 card with the image game over that is the looser piece.
For this program works, you need to follow the order:
1)run the GameServer
2)run the MainClient - Player1
3)run the again MainClient - Player2

In the file Message you will see all the protocol that I use between players and server like:

TYPE_START_GAME = "TYPE_LOOSE_POSITION";
TYPE_CHOOSE_CARD = "TYPE_CHOOSE_CARD";
TYPE_CARD_SELECTED = "TYPE_CARD_SELECTED";
TYPE_LOOSE_SELECTED = "TYPE_LOOSE_SELECTED";
TYPE_TURN_OVER = "TYPE_TURN_OVER";
TYPE_TURN_START = "TYPE_TURN_START";
