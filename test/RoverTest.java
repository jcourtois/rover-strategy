import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RoverTest {

    @Test
    public void shouldTurnLeft(){
        Rover rover = new Rover(null, new North());
        rover.turnLeft();
        assertThat(rover.getHeading(), is(West.class));
        rover.turnLeft();
        assertThat(rover.getHeading(), is(South.class));
        rover.turnLeft();
        assertThat(rover.getHeading(), is(East.class));
        rover.turnLeft();
        assertThat(rover.getHeading(), is(North.class));
    }

    @Test
    public void shouldTurnRight(){
        Rover rover = new Rover(null, new North());
        rover.turnRight();
        assertThat(rover.getHeading(), is(East.class));
        rover.turnRight();
        assertThat(rover.getHeading(), is(South.class));
        rover.turnRight();
        assertThat(rover.getHeading(), is(West.class));
        rover.turnRight();
        assertThat(rover.getHeading(), is(North.class));
    }

}
