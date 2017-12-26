import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Board b = new Board(true);
//        for (int i = 0; i < b.sideLength(); i++) {
//            for (int j = 0; j < b.sideLength(); j++) {
//                System.out.println(b.gameBoard()[i][j]);
//            }
//        }
        System.out.println(Arrays.deepToString(b.gameBoard()));
        Traverse t = new Traverse(b);
        System.out.println("Sample heuristic is: " + t.heuristic(b));

    }
}
