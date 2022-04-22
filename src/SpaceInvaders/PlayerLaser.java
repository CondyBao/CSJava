package SpaceInvaders;

import java.awt.*;
import java.util.Random;

public class PlayerLaser extends Laser{
    private final int playerLaserSpeed = -5, playerLaserWidth = 7, playerLaserHeight = 30; // parameters for player lasers

    public void draw(Graphics g) { // draw player laser
        Random rand = new Random();
        int newR = rand.nextInt(256), newG = rand.nextInt(256), newB = rand.nextInt(256);
        Color newColor = new Color(newR, newG, newB); // iridescent laser that changes color through time
        g.setColor(newColor);
        g.fillRect(getX(), getY(), getWidth(), getHeight()); // draw the rectangular laser
    }

    public PlayerLaser(int x, int y){ // inheritance constructor
        super(x, y);
        setSpeed(playerLaserSpeed);
        setWidth(playerLaserWidth);
        setHeight(playerLaserHeight);
    }
}
