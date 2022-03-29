package intro.FallingBlocks_Lists;

import java.awt.*;

public class Block {
    private int x, y, speed;
    private Color c;

    public int getY() {
        return y;
    }

    public void changeY() {
        y += speed;
    }

    public void draw(Graphics g) {
        g.setColor(c);
        g.fillRect(x, y, 20,20);
    }

    public Block(int x, int y, int speed, Color c) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.c = c;
    }
}
