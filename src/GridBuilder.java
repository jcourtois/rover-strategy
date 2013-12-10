public class GridBuilder {
    private Grid grid;

    public GridBuilder(Grid grid) {
        this.grid = grid;
    }

    private Rover createRoverAt(Coordinate location, Direction heading) throws ArrayStoreException {
        return grid.addRover(new Rover(grid, heading), location);
    }

    public Rover createNorthFacingRoverAt(int x, int y) {
        return createRoverAt(new Coordinate(x,y), new North());
    }

    public Rover createSouthFacingRoverAt(int x, int y) {
        return createRoverAt(new Coordinate(x,y), new South());
    }

    public Rover createEastFacingRoverAt(int x, int y) {
        return createRoverAt(new Coordinate(x,y), new East());
    }

    public Rover createWestFacingRoverAt(int x, int y) {
        return createRoverAt(new Coordinate(x,y), new West());
    }

}
