package utils;

import model.pieces.Piece;

import java.util.Arrays;

public class Printer {
    public static void printGrid(Piece[][] grid) {
        for(Piece[] x: grid) {
            Arrays.stream(x).map(y -> y == null ? "    " : y.getType()).forEach(System.out::print);
            System.out.println();
        }
    }
}
