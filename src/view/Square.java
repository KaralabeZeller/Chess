package view;

import model.Grid;
import model.pieces.Piece;
import utils.IconFactory;
import utils.Position;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Square extends JButton{

    Piece piece;
    int row;
    int col;
    Color color;

    public Square(Piece piece, int row, int col) {
        this.piece = piece;
        this.row = row;
        this.col = col;
        initSquare();
        addListener();
    }


    private void initSquare() {
        String label = piece != null ? piece.getType().name(): "    ";
        color = (row * 7 + col) % 2 != 0 ? Color.DARK_GRAY : Color.LIGHT_GRAY;
        if(piece == null )
            this.setText(label);
        else
            setIcon(IconFactory.getIcon(piece));

        setBackground(color);
        setPreferredSize(new Dimension(80,80));
        setBorderPainted(false);
    }

    public Piece getPiece() {
        return piece;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return col;
    }

    public Position getPosition() {
        return new Position(row, col);
    }

    public void setPlace(int row, int col) {
        this.row = row;
        this.col = col;
    }

    private void addListener() {
        addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent evt) {
                if (getModel().isPressed()) {
                        Grid.select(new Position(row, col));

                    }
                }
            }
        );
    }

    public void setDefaultColor() {
        setBackground(color);
    }

    public void setColor(Color color) {
        setBackground(color);
    }

    public void setPiece(Piece piece) {
        this.piece = piece;

        setIcon(IconFactory.getIcon(piece));
    }
}
