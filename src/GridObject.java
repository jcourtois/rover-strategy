public interface GridObject {
    Character toChar();
}

class EmptySpace implements GridObject {
    public Character toChar() {
        return '.';
    }
}

class Rover implements GridObject {
    private Direction heading;
    private final Grid grid;

    public Rover(Grid grid, Direction heading){
        this.grid = grid;
        this.heading = heading;
    }

    public Direction getHeading() {
        return heading;
    }

    public void turnLeft() {
        heading = heading.turnLeft();
    }

    public void turnRight() {
        heading = heading.turnRight();
    }

    public boolean forward(){
        return grid.moveRover(this, heading.forward());
    }

    public Character toChar(){
        return heading.toChar();
    }
}
