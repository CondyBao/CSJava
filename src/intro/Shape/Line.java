package intro.Shape;

import java.awt.*;

public class Line extends Shape{
    private int width, height;

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(getX(), getY(), getX() + width, getY() + height);
    }

    public Line(int startx, int starty, int width, int height) {
        super(startx, starty);
        this.width = width;
        this.height = height;
    }
}
