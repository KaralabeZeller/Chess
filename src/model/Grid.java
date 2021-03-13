package model;

import control.FENParser;
import model.pieces.Piece;
import utils.MoveCalculator;
import utils.Position;
import view.Square;

import java.awt.*;
import java.util.Arrays;

public class Grid {

    final static int size = 8;
    private static Square[][] grid;
    private static Position selected;
    private static Grid instance = null;
    
    private Grid(String fen) {
        selected = new Position(-1, -1);
        grid = FENParser.parse(fen);
    }

    public static Grid getInstance(String fen) {
        if( instance == null) {
            instance = new Grid(fen);
        }
        return instance;
    }

    public Piece getPiece(int x, int y) {
        return grid[x][y].getPiece();
    }

    public Square[][] getGrid() {
        return grid;
    }

    public int getSize() {
        return size;
    }


    public Square getSquare(int y, int x) {
        return grid[y][x];
    }

    public static void select(Position pos) {
        // Deselect the square
        if(pos.equals(selected)) {
            deselectAll();
            selected = new Position(-1,-1);
            return;
        }

        // Select a square
        if(selected.isEmpty()) {
            selected = pos;
            selectSquare(pos, Color.orange);
            Position[] moves = MoveCalculator.calculate(grid[pos.row][pos.col]);
            if(moves != null ) {
                for (Position move : moves) {
                    selectSquare(move, Color.GREEN);
                }
            }
        }
    }


    private static void selectSquare(Position pos, Color color) {
        grid[pos.row][pos.col].setColor(color);
    }

    // Deselects all squares. Restores the original color
    private static void deselectAll() {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                grid[y][x].setDefaultColor();
            }
        }
    }
}
