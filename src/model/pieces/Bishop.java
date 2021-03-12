package model.pieces;

import utils.Utils;

public class Bishop extends AbstractPiece{
    public Bishop(Utils.Color color) {
        super(color);
        setType(Utils.PieceType.BISHOP);
    }
}
