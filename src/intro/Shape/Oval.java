package intro.Shape;

import java.awt.*;

public class Oval extends Shape {
    private int width, height;

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.drawOval(getX(), getY(), width, height);
    }

    public Oval(int startx, int starty, int width, int height) {
        super(startx, starty);
        this.width = width;
        this.height = height;
    }
}
