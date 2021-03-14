import model.Grid;
import view.ChessFrame;

public class Chess {

    public static void main(String args[]) {
        Grid grid = Grid.getInstance("3k4/1Rp1b1pn/1p4P1/2PB4/P7/2P3KP/1q6/4r3");

        new Thread(new ChessFrame(grid)).run();
    }
}
