import java.util.Arrays;

public class Grid {
    private GridObject[][] coordinatePlane;

    public Grid(int xBound, int yBound) {
        EmptySpace emptySpace = new EmptySpace();
        coordinatePlane = new GridObject[xBound][yBound];

        for(GridObject[] row : coordinatePlane) {
            Arrays.fill(row, emptySpace);
        }
    }

    public Rover addRover(Rover rover, Coordinate location) throws ArrayStoreException {
        if (! this.hasOpenSpace(location)) throw new ArrayStoreException();
        coordinatePlane[location.x][location.y] = rover;
        return rover;
    }

    public boolean hasRover(Rover rover){
        return findRover(rover) != null;
    }

    public boolean moveRover(Rover rover, Displacement displacement) {
        Coordinate currentPosition = findRover(rover);
        Coordinate targetPosition = currentPosition.plus(displacement);

        if (this.hasRover(rover) && this.hasOpenSpace(targetPosition)){
            coordinatePlane[currentPosition.x][currentPosition.y] = new EmptySpace();
            coordinatePlane[targetPosition.x][targetPosition.y] = rover;
            System.out.println("moved successfully from "+currentPosition.toString()+" to "+ targetPosition.toString());
            return true;
        }
        System.out.println("was not able to move from "+currentPosition.toString()+" to "+targetPosition.toString());
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
            return coordinatePlane[coordinate.x][coordinate.y] instanceof EmptySpace;
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Geez, this space is off the map!");
            return false;
        }
    }

    public String toString() {
        String output = "";
        for (int j=0; j<coordinatePlane[0].length; j++) {
            for (int i=0; i<coordinatePlane.length; i++) {
                output += coordinatePlane[i][j].toChar().toString();
            }
            output += "\n";
        }
        return output;
    }
}