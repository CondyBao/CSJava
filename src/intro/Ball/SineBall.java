package intro.Ball;

import java.awt.*;

public class SineBall extends BouncingBall{
    private int originalY;

    public void move() {
        setY((int)(originalY + Math.sin(getX() * Math.PI / 180) * getYSpeed() * 10));
        setX(getX() + getXSpeed());
        checkBoundary();
    }

    public SineBall(int startx, int starty, int startrad, int startxspeed, int startyspeed, Color startcolor) {
        super(startx, starty, startrad, startxspeed, startyspeed, startcolor);
        originalY = starty;
    }
}
