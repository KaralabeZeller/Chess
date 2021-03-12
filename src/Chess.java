import model.Grid;
import view.ChessFrame;

public class Chess {

    public static void main(String args[]) {
        Grid grid = new Grid("rnbqkbnr/pp1ppppp/8/2p5/4P3/5N2/PPPP1PPP/RNBQKB1R");

        new Thread(new ChessFrame(grid)).run();
    }
}
