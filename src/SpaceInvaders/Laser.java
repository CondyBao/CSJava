package SpaceInvaders;

import java.awt.*;

public class Laser {
    private int x, y;

    public void move(int speed) {
        y -= speed;
    }

    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 5, 10);
    }

    public Laser(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
