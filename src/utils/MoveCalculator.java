package utils;

import view.Square;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MoveCalculator {

    public static Position[] calculateKing(Square current) {
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

        moves = moveList.toArray(new Position[0]);
        return moves;
    }

    private static void addMove(List<Position> moves, int y, int x) {
        if((y >= 0 && y <= 7) && (x >= 0 && x <= 7)) moves.add(new Position(y,x)); // TODO replace with collision detection & stuff
    }

    public static Position[] calculate(Square piece) {
        switch(piece.getPiece().getType()) {
            case KING:
                return calculateKing(piece);
            case PAWN:
                return calculatePawn(piece);
            case ROOK:
                return calculateRook(piece);
            case BISHOP:
                return calculateBishop(piece);
            default: return null;
        }
    }

    private static Position[] calculatePawn(Square current) {
        Position[] moves;
        List<Position> moveList = new ArrayList<>();

        int y = current.getRow();
        int x = current.getColumn();

        if(current.getPiece().getColor() == Utils.Color.WHITE) {
            addMove(moveList, y - 1, x);
        } else {
            addMove(moveList, y + 1, x);

        }

        moves = moveList.toArray(new Position[0]);
        return moves;
    }

    private static Position[] calculateRook(Square current) {
        Position[] moves;
        List<Position> moveList = new ArrayList<>();

        int y = current.getRow();
        int x = current.getColumn();

        for(int i = 0; i < 8; i++) {
            if(i != y) addMove(moveList, i, x);
            if(i != x) addMove(moveList, y, i);
        }

        moves = moveList.toArray(new Position[0]);
        return moves;
    }

    private static Position[] calculateBishop(Square current) {
        Position[] moves;
        List<Position> moveList = new ArrayList<>();

        int y = current.getRow();
        int x = current.getColumn();

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                int first = i-y;
                int sec = (j-x);
                if((Math.abs(first) == Math.abs(sec)) && Math.abs(first) > 0) addMove(moveList, i, j );
            }
        }


        moves = moveList.toArray(new Position[0]);
        return moves;
    }
}
