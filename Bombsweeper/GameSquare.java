import javax.swing.*;

/**
 * This class provides a representation of a single game square. The class is
 * abstract, and should be extended to provide domain specific functionality.
 * 
 * @author joe finney
 */
public abstract class GameSquare extends JButton {
	/** The x co-ordinate of this square. **/
	private int xLocation;

	/** The y co-ordinate of this square. **/
	private int yLocation;

	/**
	 * Create a new GameSquare, which can be placed on a GameBoard.
	 * 
	 * @param x        the x co-ordinate of this square on the game board.
	 * @param y        the y co-ordinate of this square on the game board.
	 * @param filename the filename of an image to display on this square.
	 */
	public GameSquare(int x, int y, String filename) {
		super(new ImageIcon(filename));

		xLocation = x;
		yLocation = y;
	}

	/**
	 * Change the image displayed by this square to the given bitmap.
	 * 
	 * @param filename the filename of the image to display.
	 */
	public void setImage(String filename) {
		this.setIcon(new ImageIcon(filename));
	}

	/**
	 * Determines the location of this square on the board
	 * 
	 * @return the x coordinate of this square.s
	 */
	public int getXLocation() {
		return xLocation;
	}

	/**
	 * Determines the location of this square on the board
	 * 
	 * @return the x coordinate of this square.
	 */
	public int getYLocation() {
		return yLocation;
	}

	/**
	 * A method that is invoked when a user clicks on this square.
	 * 
	 */
	public abstract void leftClicked();

	/**
	 * A method that is invoked when a user clicks on this square.
	 * 
	 */
	public abstract void rightClicked();
}
