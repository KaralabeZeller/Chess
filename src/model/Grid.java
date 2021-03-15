package model;

import control.FENParser;
import model.pieces.Empty;
import model.pieces.Piece;
import control.MoveCalculator;
import utils.Position;
import utils.Utils;
import view.Square;

import java.awt.*;

import static utils.Utils.PieceType.KING;

public class Grid {

    final static int size = 8;
    private static Square[][] grid;
    private static Position selected;
    private static Grid instance = null;
    private static Position[] moves;
    private static boolean check;
    
    private Grid(String fen) {
        selected = new Position(-1, -1);
        check = false;
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


    public static Square getSquare(int y, int x) {
        return grid[y][x];
    }

    public static Square getSquare(Position p) {
        return grid[p.row][p.col];
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
            moves = MoveCalculator.calculate(grid[pos.row][pos.col]);
            if(moves != null ) {
                for (Position move : moves) {
                    selectSquare(move, Color.GREEN);
                }
            }
            // Hit something
        } else {
            for(Position curr : moves) {
                if(curr.equals(pos)) {
                    getSquare(pos).setPiece(getSquare(selected).getPiece());
                    getSquare(selected).setPiece(new Empty(Utils.Color.NONE));
                    deselectAll();
                    moves = MoveCalculator.calculate(grid[pos.row][pos.col]);
                    checkCheck(pos, moves);
                }
            }
        }
    }

    private static void checkCheck(Position pos, Position[] moves) { // This is shit.. TODO refactor, and redo everything 
        for(Position move: moves) {
            if(getSquare(move.row, move.col).getPiece().getType() == KING) {
                System.out.println("Check");
                check = true;
                Position[] kingMoves = MoveCalculator.calculate(grid[move.row][move.col]);
                if(kingMoves == null) {
                    System.out.println("Check Mate");
                } else {
                    for(Position currMove: moves) {
                        for(Position kingMove: kingMoves) {
                            if(currMove.equals(kingMove)) {
                                System.out.println("Check Mate");
                                break;
                            }
                        }
                    }
                }
                break;
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
        selected = new Position(-1,-1);
    }
}
