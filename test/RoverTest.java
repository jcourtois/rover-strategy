import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RoverTest {

    @Test
    public void shouldTurnLeft(){
        Rover rover = new Rover(Direction.North);
        rover.turnLeft();
        assertThat(rover.getHeading(), is(Direction.West));
        rover.turnLeft();
        assertThat(rover.getHeading(), is(Direction.South));
        rover.turnLeft();
        assertThat(rover.getHeading(), is(Direction.East));
        rover.turnLeft();
        assertThat(rover.getHeading(), is(Direction.North));
    }

}
