import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class GridTest {

    private Grid grid;
    private Rover rover;

    @Before
    public void setUp(){
        grid = new Grid(10,10);
        rover = new Rover(Direction.North);
    }

    @Test
    public void gridShouldBeAbleToTellUsIfItDoesNotHaveOurRover(){
        assertThat(grid.findRover(rover),is(nullValue()));
    }

    @Test
    public void gridShouldBeAbleToTellUsIfItHasOurRover(){
        Coordinate location = new Coordinate(3,2);
        grid.addRover(rover, location);
        assertThat(grid.findRover(rover),is(location));
    }

    @Test
    public void gridCanMoveRoverIfTheTargetSpaceIsValid(){
        grid.addRover(rover, new Coordinate(4,3));
        Coordinate displacement = new Coordinate(1,0);
        grid.moveRover(rover, displacement);
        assertThat(grid.findRover(rover), is(new Coordinate(5,3)));
    }

    @Test
    public void gridCanTellUsIfCoordinateIsOpen(){
        grid.addRover(rover, new Coordinate(4,3));
        assertThat(grid.hasOpenSpace(new Coordinate(4,3)),is(false));
        assertThat(grid.hasOpenSpace(new Coordinate(1,1)),is(true));
    }

    @Test
    public void gridShouldNotAllowRoverToMoveOffGrid(){
        Coordinate origin = new Coordinate(0,0);
        grid.addRover(rover, origin);
        Coordinate displacement = new Coordinate(-1,0);
        assertThat(grid.moveRover(rover, displacement), is(false));
        assertThat(grid.findRover(rover), is(origin));
    }

    @Test
    public void gridShouldNotAllowTwoRoversToOccupySameSpace(){
        Coordinate firstRoversPosition = new Coordinate(0,0);
        Coordinate secondRoversPosition = new Coordinate(1,0);
        Rover secondRover = new Rover(Direction.North);
        Coordinate displacement = new Coordinate(1,0);
        grid.addRover(rover, firstRoversPosition);
        grid.addRover(secondRover, secondRoversPosition);
        assertThat(grid.moveRover(rover, displacement), is(false));
        assertThat(grid.findRover(rover), is(firstRoversPosition));
    }
}
