public interface Direction {
    public Direction turnLeft();
    public Direction turnRight();
    public Coordinate forward();
    public Character toChar();
}

class North implements Direction {
    public Direction turnLeft() {
        return new West();
    }

    public Direction turnRight() {
        return new East();
    }

    public Coordinate forward() {
        return new Coordinate(0,-1);
    }

    public Character toChar() {
        return '^';
    }
}

class East implements Direction {
    public Direction turnLeft() {
        return new North();
    }

    public Direction turnRight() {
        return new South();
    }

    public Coordinate forward() {
        return new Coordinate(1,0);
    }

    public Character toChar() {
        return '>';
    }
}

class South implements Direction {
    public Direction turnLeft() {
        return new East();
    }

    public Direction turnRight() {
        return new West();
    }

    public Coordinate forward() {
        return new Coordinate(0,1);
    }

    public Character toChar() {
        return 'v';
    }
}

class West implements Direction {
    public Direction turnLeft() {
        return new South();
    }

    public Direction turnRight() {
        return new North();
    }

    public Coordinate forward() {
        return new Coordinate(-1,0);
    }

    public Character toChar() {
        return '<';
    }
}

