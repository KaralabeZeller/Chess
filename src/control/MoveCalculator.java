package control;

import model.Grid;
import model.pieces.Empty;
import utils.Position;
import utils.Utils;
import view.Square;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class   MoveCalculator { // TODO refactor SERIOUSLY!!

    static Utils.PieceType actualType;
    static Utils.Color actualColor;

    public static List<Position> calculateKing(Square current) {
        Position[] moves;
        List<Position> moveList = new ArrayList<>();

        int y = current.getRow();
        int x = current.getColumn();

        addMove(moveList, y - 1, x);
        addMove(moveList, y + 1, x);
        addMove(moveList, y - 1, x + 1);
        addMove(moveList, y + 1, x + 1);
        addMove(moveList, y - 1, x - 1);
        addMove(moveList, y + 1, x - 1);
        addMove(moveList, y, x - 1);
        addMove(moveList, y ,x + 1);

        return moveList;
    }

    private static void addMove(List<Position> moves, int y, int x) {

        if((y >= 0 && y <= 7) && (x >= 0 && x <= 7)) {
            if(Grid.getSquare(y,x).getPiece().getColor() != actualColor)
                moves.add(new Position(y,x)); // TODO extend with collision detection & stuff
        }
    }

    public static Position[] calculate(Square piece) {
        List<Position> retPosition;
        actualType = piece.getPiece().getType();
        actualColor = piece.getPiece().getColor();

        switch(piece.getPiece().getType()) {
            case KING:
                retPosition = calculateKing(piece);
                break;
            case KNIGHT:
                retPosition = calculateKnight(piece);
                break;
            case PAWN:
                retPosition = calculatePawn(piece);
                break;
            case ROOK:
                retPosition = calculateRook(piece);
                break;
            case BISHOP:
                retPosition = calculateBishop(piece);
                break;
            case QUEEN:
                retPosition = calculateQueen(piece);
                break;
            default:  retPosition = null;
        }

        if(retPosition == null) return null;

        return  retPosition.toArray(new Position[0]);
    }



    private static List<Position> calculatePawn(Square current) {
        Position[] moves;
        List<Position> moveList = new ArrayList<>();

        int y = current.getRow();
        int x = current.getColumn();

        if(current.getPiece().getColor() == Utils.Color.WHITE) {
            if(Grid.getSquare(y-1, x).getPiece().getType() == Utils.PieceType.EMPTY) addMove(moveList, y - 1, x);
            if(Grid.getSquare(y-1, x-1).getPiece().getType() != Utils.PieceType.EMPTY) addMove(moveList, y - 1, x-1);
            if(Grid.getSquare(y-1, x+1).getPiece().getType() != Utils.PieceType.EMPTY) addMove(moveList, y - 1, x+1);
        } else {
            if(Grid.getSquare(y+1, x).getPiece().getType() == Utils.PieceType.EMPTY)  addMove(moveList, y + 1, x);
            if(Grid.getSquare(y+1, x-1).getPiece().getType() != Utils.PieceType.EMPTY) addMove(moveList, y + 1, x-1);
            if(Grid.getSquare(y+1, x+1).getPiece().getType() != Utils.PieceType.EMPTY) addMove(moveList, y + 1, x+1);

        }

        return moveList;
    }

    private static List<Position> calculateRook(Square current) {
        Position[] moves;
        List<Position> moveList = new ArrayList<>();

        int y = current.getRow();
        int x = current.getColumn();

        int blockX = -1;
        int blockX2 = -1;
        int blockY = -1;
        int blockY2 = -1;

        for (int i = 1; i < 8; i++) {
            if (y + i < 8) {
                if (blockY == -1 || y + i <= blockY) {
                    if (Grid.getSquare(y + i, x).getPiece().getType() != Utils.PieceType.EMPTY)
                        blockY = y + i;
                    addMove(moveList, y + i, x);
                }
            }

            if (y - i >= 0) {
                if (blockY2 == -1 || y - i > blockY2) {
                    if (Grid.getSquare(y - i, x).getPiece().getType() != Utils.PieceType.EMPTY)
                        blockY2 = y - i ;
                    addMove(moveList, y - i, x);
                }
            }

            if (x + i < 8) {
                if (blockX == -1 || x + i < blockX) {
                    if (Grid.getSquare(y, x + i).getPiece().getType() != Utils.PieceType.EMPTY)
                        blockX = x + i ;
                    addMove(moveList, y, x + i);
                }
            }

            if (x - i >= 0) {
                if (blockX2 == -1 || x - i > blockX2) {
                    if (Grid.getSquare(y, x - i).getPiece().getType() != Utils.PieceType.EMPTY)
                        blockX2 = x - i ;
                    addMove(moveList, y, x - i);
                }
            }

        }

        return moveList;
    }

    private static List<Position> calculateBishop(Square current) {
        Position[] moves;
        List<Position> moveList = new ArrayList<>();

        int y = current.getRow();
        int x = current.getColumn();

        // Down - right
        while(y >= 0 && x >= 0 && y < 8 && x < 8) {
            addMove(moveList, y, x);
            if(Grid.getSquare(y,x).getPiece().getType() != Utils.PieceType.EMPTY && !new Position(y, x).equals(current.getPosition()))
                break;
            y++;
            x--;
        }

        y = current.getRow();
        x = current.getColumn();

        // Down - left
        while(y >= 0 && x >= 0 && y < 8 && x < 8) {
            addMove(moveList, y, x);
            if(Grid.getSquare(y,x).getPiece().getType() != Utils.PieceType.EMPTY && !new Position(y, x).equals(current.getPosition()))
                break;
            y++;
            x++;
        }

        y = current.getRow();
        x = current.getColumn();

        // Top - left
        while(y >= 0 && x >= 0 && y < 8 && x < 8) {
            addMove(moveList, y, x);
            if(Grid.getSquare(y,x).getPiece().getType() != Utils.PieceType.EMPTY && !new Position(y, x).equals(current.getPosition()))
                break;
            y--;
            x++;
        }

        y = current.getRow();
        x = current.getColumn();

        // Top - right
        while(y >= 0 && x >= 0 && y < 8 && x < 8) {
            addMove(moveList, y, x);
            if(Grid.getSquare(y,x).getPiece().getType() != Utils.PieceType.EMPTY && !new Position(y, x).equals(current.getPosition()))
                break;
            y--;
            x--;
        }

        return moveList;
    }

    private static List<Position> calculateKnight(Square current) {

        Position[] moves;
        List<Position> moveList = new ArrayList<>();

        int y = current.getRow();
        int x = current.getColumn();

        addMove(moveList,y + 1, x + 2);
        addMove(moveList,y + 2, x + 1);
        addMove(moveList,y + 2, x - 1);
        addMove(moveList,y + 1, x - 2);
        addMove(moveList,y - 1, x - 2);
        addMove(moveList,y - 2, x - 1);
        addMove(moveList,y - 2, x + 1);
        addMove(moveList,y - 1, x + 2);

        return moveList;
    }

    private static List<Position> calculateQueen(Square current) {

        Position[] moves;
        List<Position> moveList = new ArrayList<>();

        //moveList.addAll(calculateKing(current));
        moveList.addAll(calculateRook(current));
        moveList.addAll(calculateBishop(current));

        return moveList;
    }
}
