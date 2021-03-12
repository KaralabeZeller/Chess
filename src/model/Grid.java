package model;

import control.FENParser;
import model.pieces.Piece;

import java.util.Arrays;

public class Grid {

    final int size = 8;
    private Piece[][] grid;
    
    public Grid(String fen) {

        grid = FENParser.parse(fen);
    }

    public Piece getPiece(int x, int y) {
        return grid[x][y];
    }

    public int getSize() {
        return size;
    }



}
