package control;

import model.pieces.*;
import utils.Printer;
import utils.Utils;
import view.Square;

import java.util.Arrays;

public class FENParser {

    public static Square[][] parse(String fen) {
        Square[][] grid = new Square[8][8];

        String[] rows = fen.split("/");

        int currColumn = 0;
        int currRow = 0;

        for(String row : rows) {
            currColumn = 0;

            char[] chars = row.toCharArray();
            for(int i = 0; i < chars.length; i++) {

                Piece piece = null;
                int charInt = Character.getNumericValue(chars[i]);

                if( charInt > 0 && charInt < 9) {
                    for(int j = 0; j < charInt; j++) {
                        currColumn++;
                        piece = new Empty(Utils.Color.NONE);
                        grid[currRow][currColumn-1] = new Square(piece, currRow, currColumn-1);
                    }
                } else {

                    switch (chars[i]) {
                        case 'p':
                            piece = new Pawn(Utils.Color.BLACK);
                            currColumn++;
                            break;
                        case 'r':
                            piece = new Rook(Utils.Color.BLACK);
                            currColumn++;
                            break;
                        case 'n':
                            piece = new Knight(Utils.Color.BLACK);
                            currColumn++;
                            break;
                        case 'q':
                            piece = new Queen(Utils.Color.BLACK);
                            currColumn++;
                            break;
                        case 'k':
                            piece = new King(Utils.Color.BLACK);
                            currColumn++;
                            break;
                        case 'b':
                            piece = new Bishop(Utils.Color.BLACK);
                            currColumn++;
                            break;
                        case 'P':
                            piece = new Pawn(Utils.Color.WHITE);
                            currColumn++;
                            break;
                        case 'R':
                            piece = new Rook(Utils.Color.WHITE);
                            currColumn++;
                            break;
                        case 'N':
                            piece = new Knight(Utils.Color.WHITE);
                            currColumn++;
                            break;
                        case 'Q':
                            piece = new Queen(Utils.Color.WHITE);
                            currColumn++;
                            break;
                        case 'K':
                            piece = new King(Utils.Color.WHITE);
                            currColumn++;
                            break;
                        case 'B':
                            piece = new Bishop(Utils.Color.WHITE);
                            currColumn++;
                            break;

                    }
                    grid[currRow][currColumn - 1] = new Square(piece, currRow, currColumn - 1);
                }
            }

            currRow++;
        }

        //Printer.printGrid(Arrays.stream(grid).map(x->x.));
        return grid;
    }
}
