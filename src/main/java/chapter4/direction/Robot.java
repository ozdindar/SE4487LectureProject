package chapter4.direction;

public class Robot {
    int x;
    int y;

    public Robot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    void move(Direction d)
    {
        x += d.getDx();
        y += d.getDy();
    }

    public static void main(String[] args) {
        Direction d = Direction.Up;

        if ( d.isHorizontal())
            System.out.println(d + "is horizontal");
    }
}
