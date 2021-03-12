package model.pieces;

import utils.Utils;

public class Queen extends AbstractPiece {
    public Queen(Utils.Color color) {
        super(color);
        setType(Utils.PieceType.QUEEN);
    }
}
