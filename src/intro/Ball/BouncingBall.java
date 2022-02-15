package intro.Ball;

import java.awt.*;

public class BouncingBall extends Ball{
    public void checkBoundary() {
        if (getX() < 0 || getX() + getRad() >= WIDTH) {
            setXSpeed(-getXSpeed());
        }
        if (getY() < 0 || getY() + getRad() >= HEIGHT) {
            setYSpeed(-getYSpeed());
        }
    }

    public void move() {
        super.move();
        checkBoundary();
    }

    public BouncingBall(int startx, int starty, int startrad, int startxspeed, int startyspeed, Color startcolor) {
        super(startx, starty, startrad, startxspeed, startyspeed, startcolor);
    }
}
