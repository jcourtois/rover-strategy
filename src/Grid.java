
public class Grid {
    private GridObject[][] coordinatePlane;

    public Grid(int xBound, int yBound) {
        coordinatePlane = new GridObject[xBound][yBound];
    }

    public void addRover(Rover rover, Coordinate location) {
        coordinatePlane[location.x][location.y] = rover;
    }

    public boolean hasRover(Rover rover){
        return findRover(rover) != null;
    }

    public boolean moveRover(Rover rover, Coordinate displacement) {
        Coordinate currentPosition = findRover(rover);
        Coordinate targetPosition = displacement.plus(currentPosition);

        if (this.hasRover(rover) && this.hasOpenSpace(targetPosition)){
            coordinatePlane[currentPosition.x][currentPosition.y] = null;
            coordinatePlane[targetPosition.x][targetPosition.y] = rover;
            return true;
        }

        return false;
    }

    public Coordinate findRover(Rover rover) {
        for (int row = 0; row < coordinatePlane.length; row++){
            for (int column = 0; column < coordinatePlane[row].length; column++ ){
                if (coordinatePlane[row][column] == rover){
                    return new Coordinate(row, column);
                }
            }
        }
        return null;
    }

    public Boolean hasOpenSpace(Coordinate coordinate) {
        try {
            return coordinatePlane[coordinate.x][coordinate.y] == null;
        } catch (ArrayIndexOutOfBoundsException exception) {
            return false;
        }
    }
}