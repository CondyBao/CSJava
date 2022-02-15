package intro.Ball;

import java.awt.*;
import java.util.ArrayList;

public class CollisionBall extends BouncingBall{
    private ArrayList<Ball> ball_list;

    public void move() {
        super.move();
        int thisx = getX();
        int thisy = getY();
        int thisrad = getRad();
        for (Ball i : ball_list) {
            int newx = i.getX();
            int newy = i.getY();
            int newrad = i.getRad();
            if ((thisx + getRad() * 2 >= newx) && (thisx <= newx)) {
                if ((thisy + getRad() * 2 >= newy) && (thisy <= newy)) {
                    setXSpeed(-getXSpeed());
                    setYSpeed(-getYSpeed());
                }
            }
        }
    }

    public CollisionBall(int startx, int starty, int startrad, int startxspeed, int startyspeed, ArrayList<Ball> ball_list, Color startcolor) {
        super(startx, starty, startrad, startxspeed, startyspeed, startcolor);
        this.ball_list = ball_list;
    }
}
