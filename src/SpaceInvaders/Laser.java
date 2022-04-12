package SpaceInvaders;

import java.awt.*;

public class Laser {
    private int x, y, speed;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move() {
        y += speed;
    }

    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 5, 10);
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Laser(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
