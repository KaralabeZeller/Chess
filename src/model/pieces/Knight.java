package model.pieces;

import utils.Utils;

public class Knight extends AbstractPiece {
    public Knight(Utils.Color color) {
        super(color);
        setType(Utils.PieceType.KNIGHT);
    }
}
