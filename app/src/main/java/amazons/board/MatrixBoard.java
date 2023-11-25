package amazons.board;

import amazons.figures.EmptyFigure;
import amazons.figures.Figure;

public class MatrixBoard implements Board {

    private Figure [][] board;

    private final int numberOfColumns;
    private final int numberOfRows;

    public MatrixBoard(int numberOfColumns, int numberOfRows) {
        this.numberOfColumns = numberOfColumns;
        this.numberOfRows = numberOfRows;
        for(int column = 0; column < numberOfColumns; column++) {
            for(int row = 0; row < numberOfRows; row++ ) {
                // Static field
                board[column][row] = EmptyFigure.EMPTY_FIGURE;
            }
        }
    }

    @Override
    public void setFigure(Position position, Figure figure) {
        board[position.getX()][position.getY()] = figure;
    }

    @Override
    public Figure getFigure(Position position) {
        return board[position.getX()][position.getY()];
    }

    @Override
    public boolean isEmpty(Position position) {
        return board[position.getX()][position.getY()].equals(EmptyFigure.EMPTY_FIGURE);
    }

    @Override
    public boolean isOutOfBoard(Position position) {
        return position.isOutOfBounds(numberOfColumns, numberOfRows);
    }
}
