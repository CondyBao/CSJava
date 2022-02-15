package intro.Ball;

import java.awt.*;

public class ShrinkingBall extends BouncingBall{
    private int radius;
    private int timer = 0;

    public void setRadius() {
        if (timer < 25) radius--;
        else radius++;
    }

    public void move() {
        if (timer == 50) timer = 0;
        setRadius();
        super.move();
        setRad(radius);
        timer++;
    }

    public ShrinkingBall(int startx, int starty, int startrad, int startxspeed, int startyspeed, Color startcolor) {
        super(startx, starty, startrad, startxspeed, startyspeed, startcolor);
        radius = startrad;
    }
}
