package view;


import model.Grid;
import model.pieces.Piece;
import utils.IconFactory;
import utils.Utils;

import javax.swing.*;
import java.awt.*;

public class ChessFrame implements Runnable {


    JFrame frame;
    Container cp;
    public ChessFrame(Grid grid) {
        frame = new JFrame("Chess");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cp = frame.getContentPane();
        cp.setLayout(new GridLayout(8, 8));

        for(int y = 0; y < grid.getSize(); y++) {
            for(int x = 0; x < grid.getSize(); x++) {
                Square s = grid.getSquare(y,x);

                cp.add(s);
            }
        }

    }

    @Override
    public void run() {
        frame.pack();
        frame.setVisible(true);

    }
}
