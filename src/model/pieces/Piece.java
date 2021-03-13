package model.pieces;

import utils.Utils;
import view.Square;

public interface Piece {
    public Utils.Color getColor();
    public Utils.PieceType getType();
    public void setType(Utils.PieceType type);

}
