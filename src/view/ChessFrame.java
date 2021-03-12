package view;


import model.Grid;
import model.pieces.Piece;
import utils.IconFactory;
import utils.Utils;

import javax.swing.*;
import java.awt.*;

public class ChessFrame implements Runnable {


    JFrame frame;
    public ChessFrame(Grid grid) {
        frame = new JFrame("Chess");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = frame.getContentPane();
        cp.setLayout(new GridLayout(8, 8));
        int runningIndex = 0;

        for(int y = 0; y < grid.getSize(); y++) {
            runningIndex = y;

            for(int x = 0; x < grid.getSize(); x++) {
                Piece p = grid.getPiece(y,x);
                String label = p != null ? p.getType().name(): "    ";
                
                JButton l = p == null ? new JButton(label) : new JButton(IconFactory.getIcon(p));
                l.setBackground(runningIndex % 2 != 0 ? Color.DARK_GRAY : Color.LIGHT_GRAY);
                l.setPreferredSize(new Dimension(80,80));
                l.setBorderPainted(false);
                cp.add(l);
                runningIndex++;
            }
        }
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void run() {

    }
}
