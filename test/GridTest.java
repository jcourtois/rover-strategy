import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class GridTest {

    private GridBuilder gridBuilder;
    private Coordinate location;
    private Grid grid;
    private Rover rover;

    @Before
    public void setUp(){
        grid = new Grid(10, 10);
        gridBuilder = new GridBuilder(grid);
        location = new Coordinate(4,3);
        rover = gridBuilder.createNorthFacingRoverAt(location.x, location.y);
    }

    @Test
    public void gridShouldBeAbleToTellUsIfItDoesNotHaveOurRover(){
        assertThat(grid.findRover(new Rover(null, new North())),is(nullValue()));
    }

    @Test
    public void gridShouldBeAbleToTellUsIfItHasOurRover(){
        assertThat(grid.findRover(rover),is(location));
    }

    @Test
    public void gridCanMoveRoverIfTheTargetSpaceIsValid(){
        Coordinate displacement = new Coordinate(1,0);
        grid.moveRover(rover, displacement);
        assertThat(grid.findRover(rover), is(new Coordinate(5,3)));
    }

    @Test
    public void gridCanTellUsIfCoordinateIsOpen(){
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
        Rover rover1 = gridBuilder.createEastFacingRoverAt(3,4);
        Rover rover2 = gridBuilder.createEastFacingRoverAt(2,4);
        Coordinate displacement = new Coordinate(1,0);
        assertThat(grid.moveRover(rover2, displacement), is(false));
        assertThat(grid.findRover(rover2), is(new Coordinate(2,4)));
    }
}
