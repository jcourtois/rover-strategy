
public class Rover implements GridObject {
    private Direction heading;

    public Rover(Direction heading){
        this.heading = heading;
    }

    public Direction getHeading() {
        return heading;
    }

    public void turnLeft() {
        heading = heading.turnLeft();
    }


}
