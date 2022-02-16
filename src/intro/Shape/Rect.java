package intro.Shape;

import java.awt.*;

import static java.awt.Color.blue;

public class Rect extends Shape {
    private int width, height;

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawRect(getX(), getY(), width, height);
    }

    public Rect(int startx, int starty, int width, int height) {
        super(startx, starty);
        this.width = width;
        this.height = height;
    }
}
