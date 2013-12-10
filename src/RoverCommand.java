public abstract class RoverCommand {
    protected final Rover rover;

    protected RoverCommand(Rover rover) {
        this.rover = rover;
    }

    public abstract void execute();
}

class TurnLeft extends RoverCommand {
    TurnLeft(Rover rover) {
        super(rover);
    }

    public void execute() {
        System.out.println("turning left");
        rover.turnLeft();
    }
}

class TurnRight extends RoverCommand {
    TurnRight(Rover rover) {
        super(rover);
    }

    public void execute() {
        System.out.println("turning right");
        rover.turnRight();
    }
}

class Forward extends RoverCommand {
    Forward(Rover rover) {
        super(rover);
    }

    public void execute() {
        System.out.println("going forward");
        rover.forward();
    }
}