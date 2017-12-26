import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class Board {
    // create a new game board with all the pieces on the slider puzzle

    Board(boolean shuffle) {
        for (int i = 0; i < totalPieces(); i++) {
            _orderOfNumbers.add(i);
        }
        if (shuffle) {
            Collections.shuffle(_orderOfNumbers);
        }
        addToBoard();
    }
    void addToBoard() {
        for (int k = 0; k < totalPieces(); k++) {
            int newIndex = wrapIndex(k, sideLength());

            int pieceToAdd = _orderOfNumbers.get(k);

            if (k <= 2) {
                top()[newIndex] = pieceToAdd;
            } else if (k <= 5) {
                middle()[newIndex] = pieceToAdd;
            } else {
                bottom()[newIndex] = pieceToAdd;
            }
            // potentially could replace 0 with x (this is the place that is blank)
        }
        gameBoard()[0] = top();
        gameBoard()[1] = middle();
        gameBoard()[2] = bottom();
        //return gameBoard();
    }
    int[][] goalBoard() {
        _goalboard = new Board(false);
        return _goalboard.gameBoard();
    }
    // get the instance var order of numbers
    ArrayList<Integer> orderOfNumbers() {
        return _orderOfNumbers;
    }
    int[][] gameBoard() {
        return _gameBoard;
    }
    int[] top() {
        return _top;
    }
    int[] middle() {
        return _middle;
    }
    int[] bottom() {
        return _bottom;
    }
    int sideLength() {
        return _sideLength;
    }
    int wrapIndex(int currentInt, int dimension) {
        return currentInt % dimension;
    }
    int totalPieces() {
        return sideLength() * sideLength();
    }
    public void shuffle() {
        // shuffles the current board, which is equivalent to creating a new board
        new Board(true);
    }
    // instance vars
    private ArrayList<Integer> _orderOfNumbers = new ArrayList<>();
    private int[][] _gameBoard = new int[3][3];
    private int [] _top = new int[3];
    private int [] _middle = new int[3];
    private int [] _bottom = new int[3];
    private int _sideLength = 3;
    private Board _goalboard; // TODO: fix this

}
