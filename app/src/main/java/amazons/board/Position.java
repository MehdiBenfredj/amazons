package amazons.board;

import javafx.scene.input.DataFormat;

import java.io.Serializable;
import java.util.Objects;

    //TODO complete the code this class and its documentation

public class Position implements Serializable {
    public static final DataFormat POSITION_FORMAT = new DataFormat("amazons.position");

   private int x;
   private int y;

   public Position(int x, int y) {
       this.x = x;
       this.y = y;
   }


    public int getX() {return x;}
    public int getY() {return y;}



    public boolean isOutOfBounds(int numberOfColumns, int numberOfRows){
        return this.getX() >= numberOfColumns || this.getX() < 0 || this.getY() >= numberOfRows || this.getY() < 0;
    }



    public Position next(CardinalDirection direction) {
        Position nextPosition = new Position(this.x + direction.deltaColumn, this.y + direction.deltaRow);

        return nextPosition;
    }
    public CardinalDirection getDirection(Position destPosition){
        return CardinalDirection.getDirection(x,y, destPosition.x, destPosition.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;

        Position position = (Position) o;

        if (getX() != position.getX()) return false;
        return getY() == position.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    @Override
    public String toString() {
        return "(" +
                x +
                "," + y +
                ')';
    }
}
