public interface Direction {
    public Direction turnLeft();
    public Direction turnRight();
    public Coordinate forward();

    public static Direction North = null;
    public static Direction West = null;
    public static Direction East = null;
    public static Direction South = null;

    static class North implements Direction{
        @Override
        public Direction turnLeft() {
            return Direction.West;
        }

        @Override
        public Direction turnRight() {
            return Direction.East;
        }

        @Override
        public Coordinate forward() {
            return new Coordinate(0,1);
        }
    }

    static class West implements Direction {
        @Override
        public Direction turnLeft() {
            return Direction.South;
        }

        @Override
        public Direction turnRight() {
            return Direction.North;
        }

        @Override
        public Coordinate forward() {
            return new Coordinate(-1,0);
        }
    }

    static class East implements Direction {
        @Override
        public Direction turnLeft() {
            return Direction.North;
        }

        @Override
        public Direction turnRight() {
            return Direction.South;
        }

        @Override
        public Coordinate forward() {
            return new Coordinate(1,0);
        }
    }

    static class South implements Direction {
        @Override
        public Direction turnLeft() {
            return Direction.East;
        }

        @Override
        public Direction turnRight() {
            return Direction.West;
        }

        @Override
        public Coordinate forward() {
            return new Coordinate(0,-1);
        }
    }
}
