package model.pieces;

import utils.MoveCalculator;
import utils.Utils;
import view.Square;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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
