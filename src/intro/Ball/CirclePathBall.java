package intro.Ball;

import java.awt.*;

public class CirclePathBall extends BouncingBall{
    private int originalX = 0, originalY = 0, timer = 0;

    public void move() {
        setX((int)(Math.cos(timer * Math.PI / 180) * 20 * getXSpeed() + originalX));
        setY((int)(Math.sin(timer * Math.PI / 180) * 20 * getYSpeed() + originalY));
        timer++;
        checkBoundary();
    }

    public CirclePathBall(int startx, int starty, int startrad, int startxspeed, int startyspeed, Color startcolor) {
        super(startx, starty, startrad, startxspeed, startyspeed, startcolor);
        originalX = startx;
        originalY = starty;
    }
}
