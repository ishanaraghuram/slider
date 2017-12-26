import java.lang.reflect.Array;
import java.util.*;
import org.w3c.dom.Node;
import java.util.LinkedList;


public class Traverse {
    // run A* with the correct heuristic
    Traverse(Board currentBoard) {
        Board _board = currentBoard;
    }
    void aStar(Board board) {

        //_start = board.gameBoard();
        _startState = board.gameBoard();
        _goalState = _goal.gameBoard();
        open().add(_startState);
        int startG = 0;
        int startH = heuristic(board);
        int startF = startG + startH;
        while (!open().isEmpty()) {
            int[][] process = open().get(0); //fixme: need to get the one with lowest F
            if (process == _goalState) {
                return path(process);
            }
            open().remove(process);
            closed().add(process);
            for (int i = 0; i <= nextNodes(process).size(); i++) {
                if (!closed().contains(nextNodes(process).get(i))) {
                    continue;
                }
                if (open().contains(nextNodes(process).get(i))) {
                    open().add(nextNodes(process).get(i));
                }
                else {
                    int[][] actualNode; // actualNode = open.find(node)
                }
            }
        }



        // fill in with aStar
        // each configuration of the board is a node
        // prune the nodes using the heuristic to make this manageable
        //


    }
    int heuristic(Board currBoard) {
        // TODO: use linear conflicts in addition to Manhattan Distance to get h: h = Manhattan + 2*linear_conflicts
        // TODO: each node structure is a 2D array that point's to a parent node
        int minMoves = 0;
        int linearConflict = 0;
        // TODO: to figure out linear conflict; you know the correct position within a row is the
        // TODO: mod of the piece number (minus one) by the sidelength. you know which row (or exact position) a piece
        // TODO: belongs in by taking the mod of the piece number (minus one) by the total number of pieces in the puzzle
        ArrayList<Integer> currOrder = currBoard.orderOfNumbers();
        for (int i = 1; i <= currOrder.size(); i++) {
            int piece = currOrder.get(i);
            if (piece != i) {
                minMoves += Math.abs(currOrder.get(i) - i); // abs of the number of space to get from one place to another
            }
            // if they're right next to each other or if they're on top of each other
            if (piece == (i - 1)  ||
                    piece == (i + 1) ||
                    (piece % currBoard.sideLength() == i % currBoard.sideLength() &&
                            Math.abs(piece-i) == currBoard.sideLength())) {
                linearConflict += 1;
            }
        }
        int h = minMoves + 2 * linearConflict;
        return h;
    }
    ArrayList<int[][]> path(int[][] process) {
        return new ArrayList<>(); // fixme: figure out path function to return correct path
    }
    ArrayList<int[][]> nextNodes(int[][] node) {
        // fixme: return list of all possible next nodes from node
        return ArrayList;
    }

    // instance variables
    private LinkedList<int[][]> _closed = new LinkedList<>();
    private LinkedList<int[][]> _open = new LinkedList<>();
    private int[][] _startState = new int[3][];
    private int[][] _goalState = new int[3][];
    private Board _goal = new Board(false);
    // methods to get private vars
    LinkedList<int[][]> closed() {
        return _closed;
    }
    LinkedList<int[][]> open() {
        return _open;
    }


}
