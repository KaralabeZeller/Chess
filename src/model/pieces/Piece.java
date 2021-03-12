package model.pieces;

import utils.Utils;

public interface Piece {
    public Utils.Color getColor();
    public Utils.PieceType getType();
    public void setType(Utils.PieceType type);
}
