import java.util.ArrayList;

public class RoverCommandParser {
    public ArrayList<RoverCommand> parseMessageIntoListOfCommandsFor(Rover rover, String message) {
        ArrayList<RoverCommand> commandList = new ArrayList<RoverCommand>();
        for(Character character : message.toCharArray()) {
            commandList.add(roverCommandFor(rover, character));
        }
        return commandList;
    }

    private RoverCommand roverCommandFor(Rover rover, Character character) {
        switch (character) {
            case 'L': return new TurnLeft(rover);
            case 'R': return new TurnRight(rover);
            case 'M': return new Forward(rover);
            default: throw new IllegalArgumentException();
        }
    }
}
