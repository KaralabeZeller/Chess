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
            default: return null;
        }
    }
}
