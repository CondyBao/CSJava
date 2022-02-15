package intro.Ball;

import java.awt.*;
import java.util.Random;

public class ColorBall extends BouncingBall{
    public void move() {
        super.move();
        Random rand = new Random();
        if (rand.nextInt(3) == 0) changeColor();
    }

    public void changeColor() {
        Random rand = new Random();
        int new_r = rand.nextInt(255);
        int new_g = rand.nextInt(255);
        int new_b = rand.nextInt(255);
        setColor(new Color(new_r, new_g, new_b));
    }

    public ColorBall(int startx, int starty, int startrad, int startxspeed, int startyspeed) {
        super(startx, starty, startrad, startxspeed, startyspeed, new Color(0, 0, 0));
    }
}
