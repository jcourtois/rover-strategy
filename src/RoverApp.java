import java.util.ArrayList;

public class RoverApp {
    public static void main(String[] args) {
        RoverCommandParser parser = new RoverCommandParser();

        Grid grid = new Grid(10, 10);
        GridBuilder gridBuilder = new GridBuilder(grid);

        Rover rover1 = gridBuilder.createEastFacingRoverAt(0,0);

        ArrayList<RoverCommand> rover1CommandList = parser.parseMessageIntoListOfCommandsFor(rover1, "MMMMRMMM");

        for(RoverCommand command : rover1CommandList) {
            command.execute();
            String gst = grid.toString();
            System.out.println(gst);
        }

    }
}
