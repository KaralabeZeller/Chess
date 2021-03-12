package control;

import model.pieces.*;
import utils.Printer;
import utils.Utils;

public class FENParser {

    public static Piece[][] parse(String fen) {
        Piece[][] grid = new Piece[8][8];

        String[] rows = fen.split("/");

        int currColumn = 0;
        int currRow = 0;

        for(String row : rows) {
            currColumn = 0;

            char[] chars = row.toCharArray();
            for(int i = 0; i < chars.length; i++) {

                int charInt = Character.getNumericValue(chars[i]);
                if( charInt > 0 && charInt < 9)
                    currColumn += charInt;

                switch(chars[i]) {
                    case 'p' :
                        grid[currRow][currColumn] = new Pawn(Utils.Color.BLACK);
                        currColumn ++;
                        break;
                    case 'r' :
                        grid[currRow][currColumn] = new Rook(Utils.Color.BLACK);
                        currColumn ++;
                        break;
                    case 'n' :
                        grid[currRow][currColumn] = new Knight(Utils.Color.BLACK);
                        currColumn ++;
                        break;
                    case 'q' :
                        grid[currRow][currColumn] = new Queen(Utils.Color.BLACK);
                        currColumn ++;
                        break;
                    case 'k' :
                        grid[currRow][currColumn] = new King(Utils.Color.BLACK);
                        currColumn ++;
                        break;
                    case 'b' :
                        grid[currRow][currColumn] = new Bishop(Utils.Color.BLACK);
                        currColumn ++;
                        break;
                    case 'P' :
                        grid[currRow][currColumn] = new Pawn(Utils.Color.WHITE);
                        currColumn ++;
                        break;
                    case 'R' :
                        grid[currRow][currColumn] = new Rook(Utils.Color.WHITE);
                        currColumn ++;
                        break;
                    case 'N' :
                        grid[currRow][currColumn] = new Knight(Utils.Color.WHITE);
                        currColumn ++;
                        break;
                    case 'Q' :
                        grid[currRow][currColumn] = new Queen(Utils.Color.WHITE);
                        currColumn ++;
                        break;
                    case 'K' :
                        grid[currRow][currColumn] = new King(Utils.Color.WHITE);
                        currColumn ++;
                        break;
                    case 'B' :
                        grid[currRow][currColumn] = new Bishop(Utils.Color.WHITE);
                        currColumn ++;
                        break;

                }
            }

            currRow++;
        }

        Printer.printGrid(grid);
        return grid;
    }
}
