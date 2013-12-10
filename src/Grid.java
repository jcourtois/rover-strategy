import java.util.Arrays;

public class Grid {
    private GridObject[][] coordinatePlane;

    public Grid(int xBound, int yBound) {
        coordinatePlane = new GridObject[xBound][yBound];
        for(GridObject[] row : coordinatePlane) {
            Arrays.fill(row, new EmptySpace());
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

    public boolean moveRover(Rover rover, Coordinate displacement) {
        Coordinate currentPosition = findRover(rover);
        Coordinate targetPosition = displacement.plus(currentPosition);

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
            return false;
        }
    }

    public String toString() {
        String output = "";
        for (int j=0; j<coordinatePlane.length; j++) {
            for (int i=0; i<coordinatePlane[j].length; i++) {
                output += coordinatePlane[i][j].toChar().toString();
            }
            output += "\n";
        }
        return output;
    }
}