package utils;

public class Position {
    public int row = - 1;
    public int col = - 1;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Position other = (Position) obj;
        return other.col == this.col && other.row == this.row;

    }

    public boolean isEmpty() {
        return this.col == -1 && this.row == -1;
    }
}
