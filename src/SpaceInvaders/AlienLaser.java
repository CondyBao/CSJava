package SpaceInvaders;

import java.awt.*;

public class AlienLaser extends Laser{
    private final int alienLaserSpeed = 7, alienLaserWidth = 7, alienLaserHeight = 20; // parameters for alien lasers

    public void draw(Graphics g) {
        g.setColor(Color.GREEN); // green alien laser
        g.fillRect(getX(), getY(), getWidth(), getHeight()); // draw the laser
    }

    public AlienLaser(int x, int y){ // inheritance constructor
        super(x, y);
        setSpeed(alienLaserSpeed);
        setWidth(alienLaserWidth);
        setHeight(alienLaserHeight);
    }
}
