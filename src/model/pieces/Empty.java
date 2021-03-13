package model.pieces;

import utils.Utils;

public class Empty extends AbstractPiece{
        public Empty(Utils.Color color) {
            super(color);
            setType(Utils.PieceType.EMPTY);
        }


}
