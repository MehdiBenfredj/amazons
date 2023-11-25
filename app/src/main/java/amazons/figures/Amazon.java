package amazons.figures;

import amazons.board.Board;
import amazons.board.CardinalDirection;
import amazons.board.Position;
import amazons.player.PlayerID;
import javafx.geometry.Pos;

import java.util.List;

public class Amazon extends MovableFigure implements Figure{

    private Position currentPosition;

    public Amazon(Position position) {
        this.currentPosition = position;
    }

    @Override
    public boolean canMoveTo(Position position, Board board) {
        // 1 -> Empty figure
        // 2 -> Not the same position
        // 3 -> Not out of bounds
        // 4 -> Either same column, same row, same diagonal
        if( !board.isEmpty(position) || currentPosition.equals(position) || board.isOutOfBoard(position) || !isValidDirection(position)){
            return false;
        }
        // 5 -> Empty route
        return isValidRoute(position, board);
    }

    private boolean isValidDirection(Position position) {
        // Same column, row
        if( position.getX() != this.currentPosition.getX() && position.getY() != this.currentPosition.getY() ) {
            //test diagonal
            return Math.abs(this.currentPosition.getX() - position.getX()) == Math.abs(this.currentPosition.getY() - position.getY());
        }
        return true;
    }

    private boolean isValidRoute(Position destinationPosition, Board board) {
        // Get direction
        CardinalDirection direction  = currentPosition.getDirection(destinationPosition);

        // Loop through route and check if not empty
        for(Position position = currentPosition.next(direction); position.equals(destinationPosition); position =  position.next(direction)) {
            if (!board.isEmpty(position)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void moveTo(Position position, Board board) {

    }

    @Override
    public void setPosition(Position position) {

    }

    @Override
    public PlayerID getPlayerID() {
        return null;
    }

    @Override
    public List<Position> getAccessiblePositions(Board board) {
        return null;
    }
}
