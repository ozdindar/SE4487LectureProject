package chapter4.direction;

import java.util.EnumSet;

public enum Direction {
    Up(0,-1){ String toCode() {return "U";}},
    Down(0,1){ String toCode() {return "U";}},
    Left(-1,0){ String toCode() {return "U";}},
    Right(1,0) { String toCode() {return "U";}},
    UpLeft(-1,-1){String toCode() {return "U";}},
    UpRight(1,-1){String toCode() {return "U";}},
    DownLeft(-1,1){String toCode() {return "U";}},
    DownRight(1,1){String toCode() {return "U";}},
    JumpUp(0,-2){String toCode() {return "U";}};


    final int dx;
    final int dy;


    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    // Bad programming practice
    public String toShortString()
    {
        switch (this)
        {
            case Up: return "U";
            case Down: return "D";
            case Left: return "L";
            case Right: return "R";
            case UpLeft: return "UL";
            case UpRight: return "UR";
            case DownLeft: return "DL";
            case DownRight: return "DR";
        }
        throw new AssertionError("Invalid Error");
    }

    static EnumSet<Direction> horizontal()
    {
        return EnumSet.of(Left,Right);
    }

    static EnumSet<Direction> vertical()
    {
        return EnumSet.of(Up,Down,JumpUp);
    }

    boolean isHorizontal()
    {
        return horizontal().contains(this);
    }

    abstract String toCode();
}
