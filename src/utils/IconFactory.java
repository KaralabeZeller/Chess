package utils;

import model.pieces.Piece;

import javax.swing.*;
import java.awt.*;

public class IconFactory {

    public static ImageIcon getIcon(Piece p) {
        ImageIcon retIcon;
        switch (p.getType()) {
            case KNIGHT:
                retIcon =  p.getColor() == Utils.Color.WHITE ? new ImageIcon("resources/pieces/WhiteKnight.png") :  new ImageIcon("resources/pieces/BlackKnight.png");
                break;
            case PAWN:
                retIcon =  p.getColor() == Utils.Color.WHITE ? new ImageIcon("resources/pieces/WhitePawn.png") :  new ImageIcon("resources/pieces/BlackPawn.png");
                break;
            case ROOK:
                retIcon =  p.getColor() == Utils.Color.WHITE ? new ImageIcon("resources/pieces/WhiteRook.png") :  new ImageIcon("resources/pieces/BlackRook.png");
                break;
            case KING:
                retIcon =  p.getColor() == Utils.Color.WHITE ? new ImageIcon("resources/pieces/WhiteKing.png") :  new ImageIcon("resources/pieces/BlackKing.png");
                break;
            case QUEEN:
                retIcon =  p.getColor() == Utils.Color.WHITE ? new ImageIcon("resources/pieces/WhiteQueen.png") :  new ImageIcon("resources/pieces/BlackQueen.png");
                break;
            case BISHOP:
                retIcon =  p.getColor() == Utils.Color.WHITE ? new ImageIcon("resources/pieces/WhiteBishop.png") :  new ImageIcon("resources/pieces/BlackBishop.png");
                break;
            default: retIcon =  new ImageIcon("");
        }

        Image image = retIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(70, 70,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        retIcon = new ImageIcon(newimg);  // transform it back
        return retIcon;
    }
}
