package pt.brunojesus.puzzle;

/**
 * Interface to be used for the {@link GameWindow}
 * 
 * @author Bruno Jesus
 * @since 1.0
 * @version 1.0
 */
public interface IBoard {

	/**
	 * Gets the size of the board
	 *
	 * @return the board size
	 */
	int getSize();

	/**
	 * Executes a play and the desired position relative to the empty slot
	 *
	 * @throws Exception if play is invalid
	 */
	void play(PlayDirection direction) throws Exception;

	/**
	 * Gets the item in position.
	 *
	 * @param x the x coordinate, from 0 to {@link this.getSize()}
	 * @param y the y coordinate, from 0 to {@link this.getSize()}
	 * @return the item in position: "1"..."N" or <b>""</b> if it doesn't exist.
	 */
	String getItemInPosition(int x, int y);
}
