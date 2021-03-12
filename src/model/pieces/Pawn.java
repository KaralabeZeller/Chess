package model.pieces;

import utils.Utils;

public class Pawn extends AbstractPiece{

    public Pawn(Utils.Color color) {
        super(color);
        setType(Utils.PieceType.PAWN);
    }
}
