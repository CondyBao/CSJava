package SpaceInvaders;

import java.awt.*;

public class AlienLaser extends Laser{
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(getX(), getY(), 5, 10);
    }

    public AlienLaser(int x, int y){
        super(x, y);
        setSpeed(7);
    }
}
