package model.pieces;

import utils.Utils;

public class King extends AbstractPiece {
    public King(Utils.Color color) {
        super(color);
        setType(Utils.PieceType.KING);
    }
}
