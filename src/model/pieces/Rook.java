package model.pieces;

import utils.Utils;

public class Rook extends AbstractPiece {
    public Rook(Utils.Color color) {
        super(color);
        setType(Utils.PieceType.ROOK);
    }
}
