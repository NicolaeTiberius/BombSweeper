import javax.swing.ImageIcon;

public class BombSquare extends GameSquare {
    private GameBoard board; // Object reference to the GameBoard this square is part of.
    private boolean hasBomb; // True if this squre contains a bomb. False otherwise.

    private boolean hasbeenRevealed;

    public static final int MINE_PROBABILITY = 10;

    private boolean flagCounter = false;
    private boolean numberCount = false;

    // main method to display Board and set the probability of bombs displaying
    public BombSquare(int x, int y, GameBoard board) {
        super(x, y, "images/blank.png");

        this.board = board;
        this.hasBomb = ((int) (Math.random() * MINE_PROBABILITY)) == 0;

    }

    // When the user left clicks on a square
    @Override
    public void leftClicked() {

        System.out.println("Left clicked");

        if (hasBomb) {
            this.setImage("images/bomb.png");
            System.out.println(hasBomb);
            System.out.println("BOMB!");

        } else {
            revealSquares();
        }

    }

    // When the user right clicks on a square

    public void rightClicked() {
        if (flagCounter == false && numberCount == false) {
            this.setImage("images/flag.png");
            flagCounter = true;
        }

        else if (flagCounter == true && numberCount == false) {
            this.setImage("images/blank.png");
            flagCounter = false;
        }

    }

    // Recursion for when they click

    public int squaresAround() {

        System.out.println("Squares around");
        int bombnumber = 0;
        int x = getXLocation(); // retrieves the exact number of x.
        int y = getYLocation(); // retrives y so it can be used as a variable just like x.

        BombSquare bs;

        // Loop through the 8 squares around the square that was clicked by double loop
        // to check x and y at the same time.
        for (int i = x - 1; i <= x + 1; i++) {
            for (int k = y - 1; k <= y + 1; k++) {
                bs = (BombSquare) board.getSquareAt(i, k); // makes bombsquare a object Gameboard so to that it can
                                                           // use the getSquare method of
                                                           // that square and check it

                if (bs != null && bs.hasBomb) { // if there is a bomb on that x,y then it increments the bomb counter to
                                                // display the right number of bombs when a user clicks on a square
                    bombnumber++;

                }
            }

        }

        return bombnumber;

    }

    public void revealSquares() {

        if (hasbeenRevealed) {
            return;
        } else {
            hasbeenRevealed = true;
        }

        int x = getXLocation();
        int y = getYLocation();
        BombSquare bs;
        int bombs = squaresAround();

        if (bombs == 0) {
            for (int i = x - 1; i <= x + 1; i++) {

                for (int k = y - 1; k <= y + 1; k++) {

                    bs = (BombSquare) board.getSquareAt(i, k);

                    if (bs != null) {
                        bs.revealSquares();
                    }

                }
            }
        }
        // Prints the bomb number using the counter after it has checked the squares
        // around
        int bombnumber = squaresAround();
        System.out.println(bombnumber);
        setImage("images/" + bombnumber + ".png");

    }

}
