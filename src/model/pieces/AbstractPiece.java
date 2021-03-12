package model.pieces;

import utils.Utils;

public abstract class AbstractPiece implements Piece {

    private Utils.Color color;
    private Utils.PieceType type;

    public AbstractPiece(Utils.Color color) {
        this.color = color;
    }

    @Override
    public Utils.Color getColor() {
        return color;
    }

    @Override
    public Utils.PieceType getType() {
        return type;
    }

    @Override
    public void setType(Utils.PieceType type) {
        this.type = type;
    }
}
