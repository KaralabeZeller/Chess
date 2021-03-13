import model.Grid;
import view.ChessFrame;

public class Chess {

    public static void main(String args[]) {
        Grid grid = Grid.getInstance("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");

        new Thread(new ChessFrame(grid)).run();
    }
}
