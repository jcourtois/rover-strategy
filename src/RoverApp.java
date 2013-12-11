import java.util.ArrayList;

public class RoverApp {
    public static void main(String[] args) throws InterruptedException {
        RoverCommandParser parser = new RoverCommandParser();

        Grid grid = new Grid(50, 30);
        GridBuilder gridBuilder = new GridBuilder(grid);

        Rover rover1 = gridBuilder.createEastFacingRoverAt(0, 0);

        ArrayList<RoverCommand> rover1CommandList = parser.parseMessageIntoListOfCommandsFor(rover1, "MMMMRMMMMMMMRMMMMMMMLLMMM");

        for(RoverCommand command : rover1CommandList) {
            command.execute();
        }
        System.out.println(grid.toString());
    }
}
